package com.coderhouse.session.twelve.basic;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class CustomObjectMapper {


    public <T> T deserializeToJson(String text, Class<T> clasClass) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Map<String, String> fields = Arrays.stream(text.replace("{", "").replace("}", "").split(","))
                //"{.....}"
                //".....}"
                //"....."
                //"'sdasd':'asdad','asdasd':'asdsadsa'"
                //"[sdasd':'asdad','asdasd':'asdsadsa']"
                // [sdasd:asdad, asdasd:asdsadsa]
                .map(element -> element.replaceAll("\"", ""))
                .map(element -> new AbstractMap.SimpleEntry<>(element.split(":")[0], element.split(":")[1]))
                .collect(Collectors.toMap(AbstractMap.SimpleEntry::getKey, AbstractMap.SimpleEntry::getValue));

        Constructor<T> entityConstructor = clasClass.getConstructor();
        T entity = entityConstructor.newInstance();

        Arrays.stream(clasClass.getDeclaredFields())
                .filter(element -> element.isAnnotationPresent(FieldSerialization.class))
                .peek(element -> element.setAccessible(true))
                .forEach(element -> {
                    try {
                        if (element.getType().equals(String.class)) {
                            element.set(entity, fields.get(element.getAnnotation(FieldSerialization.class).jsonKey()));
                        }
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                });

        return entity;
    }

    public <T> String serializeToJson(T entity) throws InvocationTargetException, IllegalAccessException {
        this.executeFunction(entity, true);
        return this.getJson(entity);
    }

    private <T> String getJson(T entity) {

        return "{" + Arrays.stream(entity.getClass().getDeclaredFields())
                .filter(element -> !element.isAnnotationPresent(FieldIgnorable.class))
                .filter(element -> element.isAnnotationPresent(FieldSerialization.class))
                .peek(element -> element.setAccessible(true))
                .map(element -> {
                    try {
                        return new AbstractMap.SimpleEntry<>(element.getAnnotation(FieldSerialization.class).jsonKey(), String.valueOf(element.get(entity)));
                    } catch (IllegalAccessException e) {
                        return null;
                    }
                })
                .filter(Objects::nonNull)
                .map(element -> String.format("\"%s\":\"%s\"", element.getKey(), element.getValue()))
                .collect(Collectors.joining(",")) + "}";
    }

    private <T> void executeFunction(T entity, boolean onSerialization) throws InvocationTargetException, IllegalAccessException {
        Class<?> clazz = entity.getClass();

        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Initialization.class)) {
                Initialization annotation = method.getAnnotation(Initialization.class);
                if (annotation.onSerialization() == onSerialization) {
                    method.setAccessible(true);
                    method.invoke(entity);
                }
            }
        }
    }
}
