package com.coderhouse.nine.interfaces;

import com.coderhouse.nine.base.Data;

public class MainInterfaces {

    public static void main(String[] args) {

        String name = "Carlos";
        String last = "Zerga";

        System.out.println(name);

        SimpleFunctionalInterface simpleFunctionalInterface = () -> name;
        System.out.println(simpleFunctionalInterface.name());

        CompoundFunctionalInterface compoundFunctionalInterface = () -> name;

        System.out.println(compoundFunctionalInterface.name());
        System.out.println(compoundFunctionalInterface.toPrint());

        Data data = new Data(name, 19);

        compoundFunctionalInterface = data::getName;
        System.out.println(compoundFunctionalInterface.toPrint());

        ParametersFunctionalInterface parametersFunctionalInterface = (String::concat);
        System.out.println(parametersFunctionalInterface.name(name,last));
        parametersFunctionalInterface = ((firstName, lastName) -> String.format("%s : %s", firstName, lastName));
        System.out.println(parametersFunctionalInterface.name(name,last));
        parametersFunctionalInterface = ((first, second) -> String.format("%s : %s", first, second));
        System.out.println(parametersFunctionalInterface.name(name,last));
    }
}
