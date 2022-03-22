package com.coderhouse.session.eight.plainv2.entities;

public interface BusinessBehaviour<T, ID> {

    ID getId();

    void doCreation();

    void voidUpdate();

    T copyFrom(T source);

    void updateFieldsForDelete();
}
