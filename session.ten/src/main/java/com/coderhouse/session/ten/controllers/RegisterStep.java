package com.coderhouse.session.ten.controllers;

import java.util.Collections;
import java.util.List;

public enum RegisterStep implements NextStep {

    NAMES {
        @Override
        public List<RegisterStep> getPrevious() {
            return Collections.singletonList(DOCUMENT);
        }
    },
    DOCUMENT {
        @Override
        public List<RegisterStep> getPrevious() {
            return Collections.singletonList(UBIGEO);
        }
    },
    UBIGEO;

}
