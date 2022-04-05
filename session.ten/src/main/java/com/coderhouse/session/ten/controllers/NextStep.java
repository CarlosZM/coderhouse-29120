package com.coderhouse.session.ten.controllers;

import java.util.Collections;
import java.util.List;

public interface NextStep {

    default List<RegisterStep> getPrevious() {
        return Collections.emptyList();
    }

    default boolean isNext(RegisterStep registerStep) {
        return this.getPrevious().contains(registerStep);
    }

}
