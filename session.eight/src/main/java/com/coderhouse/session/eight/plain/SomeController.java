package com.coderhouse.session.eight.plain;

import com.coderhouse.session.eight.plain.objects.Animal;
import com.coderhouse.session.eight.plain.objects.Cat;
import com.coderhouse.session.eight.plain.objects.Dog;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/plain")
public class SomeController {


    @GetMapping("/simple")
    public Cat[] listPlain() {

        Cat[] cats = new Cat[]{
                new Cat("filomeno"),
                new Cat("osiris")
        };

        return cats;
    }

    @GetMapping("/cats")
    public List<Cat> listCats() {

        List<Cat> cats = new ArrayList<>();

        cats.add(
                new Cat("filomeno")
        );
        cats.add(
                new Cat("osiris")
        );

        return cats;
    }

    @GetMapping("/animals")
    public List<Animal> listAnimals() {

        List<Animal> animals = new ArrayList<>();

        animals.add(
                new Cat("filomeno")
        );
        animals.add(
                new Dog("naopleon")
        );

        return animals;
    }

    @GetMapping("/extend")
    public List<? extends Animal> listExtendAnimals() {

        List<Animal> animals = new ArrayList<>();

        animals.add(new Cat("filomeno"));
        animals.add(new Dog("naopleon"));

        return animals;
    }

    @GetMapping("/extend/v2")
    public List<? extends Animal> listExtendAnimalsV2() {

        List<Cat> cats = new ArrayList<>();

        cats.add(new Cat("filomeno"));
        cats.add(new Cat("naopleon"));

        return cats;
    }
}
