package com.coderhouse.nine.consumer;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class MainConsumer {

    public static void main(String[] args) {

        Consumer<Integer> doConsumer = System.out::println;

        doConsumer.accept(0);
        doConsumer.accept(10);
        doConsumer.accept(20);

        Map<String, Integer> map = new HashMap<>();

        BiConsumer<String, Integer> doBiConsumer = map::put;

        doBiConsumer.accept("santiago", 30);
        doBiConsumer.accept("carlos", 27);

        System.out.println(map);

    }
}
