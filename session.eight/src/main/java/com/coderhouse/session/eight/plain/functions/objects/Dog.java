package com.coderhouse.session.eight.plain.functions.objects;

import com.coderhouse.session.eight.plain.functions.Behaviour;

public class Dog extends Animal implements Behaviour<Dog> {

    public Dog(String name) {
        super(name, "guau");
    }

    @Override
    public Dog copy(Dog source) {
        this.setName(source.getName());
        return this;
    }
}
