package com.coderhouse.session.eight.plain.functions.objects;

import com.coderhouse.session.eight.plain.functions.Behaviour;

public class Cat extends Animal implements Behaviour<Cat> {

    public Cat(String name) {
        super(name, "miau");
    }

    @Override
    public Cat copy(Cat source) {
        this.setName(source.getName());
        return this;
    }
}
