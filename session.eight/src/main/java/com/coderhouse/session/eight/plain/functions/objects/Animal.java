package com.coderhouse.session.eight.plain.functions.objects;

public abstract class Animal {

    private String name;

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

    public void setName(String name) {
        this.name = name;
    }
}
