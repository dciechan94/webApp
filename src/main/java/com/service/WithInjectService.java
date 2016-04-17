package com.service;


import com.model.CustomInjectClass;

import javax.inject.Inject;

public class WithInjectService {

    @Inject
    private CustomInjectClass toBeInjected;


    public boolean injected() {
        if(toBeInjected != null) {
            return true;
        }
        return false;
    }
}
