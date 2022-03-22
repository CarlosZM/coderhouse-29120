package com.coderhouse.session.eight.plain.objects;

public abstract class Animal {

    private final String name;

    private final String action;

    protected Animal(String name, String action) {
        this.name = name;
        this.action = action;
    }

    public String getName() {
        return name;
    }

    public String getAction() {
        return action;
    }
}
