package com.coderhouse.session.eight.plain.functions.objects;

import com.coderhouse.session.eight.plain.functions.Behaviour;

public class Bus implements Behaviour<Bus> {

    private String name;

    public Bus(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Bus copy(Bus source) {
        this.setName(source.getName());
        return this;
    }
}
