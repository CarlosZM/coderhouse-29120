package com.coderhouse.session.eight.plain.functions;

public interface BehaviourV2 {

    <T extends Behaviour<T>> T copy(T source,T destiny);
}
