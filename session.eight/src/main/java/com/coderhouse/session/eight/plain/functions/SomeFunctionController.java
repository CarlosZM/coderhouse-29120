package com.coderhouse.session.eight.plain.functions;

import com.coderhouse.session.eight.plain.functions.objects.Cat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/functions")
public class SomeFunctionController {


    @Autowired
    private BehaviourImpl behaviour;

    @GetMapping("/copy")
    public void listPlain() {

        Cat source = new Cat("filomeno");
        Cat target = new Cat("osiris");

        Cat cat1 = source.copy(target);

        Cat cat2 = this.behaviour.copy(source, target);
    }
}
