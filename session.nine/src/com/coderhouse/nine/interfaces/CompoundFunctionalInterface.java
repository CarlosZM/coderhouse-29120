package com.coderhouse.nine.interfaces;

public interface CompoundFunctionalInterface {

    String name();

    default String toPrint() {
        return String.format("Your names is :%s", name());
    }
}
