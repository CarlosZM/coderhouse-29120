package com.coderhouse.nine.supplier;

import java.util.function.Supplier;

public class MainSupplier {

    public static void main(String[] args) {

        String name = "Carlos";
        String last = "Zerga";

        Supplier<String> basicSupplier = () -> name;

        System.out.println(basicSupplier.get());


        FunctionFactory functionFactory = new FunctionFactory();
        functionFactory.setFirstName(() -> name);
        functionFactory.setLastName(() -> last);

        System.out.println(functionFactory.concat());

    }
}
