package com.coderhouse.session.eight.plain.functions;

import org.springframework.stereotype.Service;

@Service
public class BehaviourImpl implements BehaviourV2 {

    @Override
    public <T extends Behaviour<T>> T copy(T source, T destiny) {
        return source.copy(destiny);
    }
}
