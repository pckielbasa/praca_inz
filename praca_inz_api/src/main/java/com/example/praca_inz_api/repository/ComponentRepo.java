package com.example.praca_inz_api.repository;

import com.example.praca_inz_api.model.Component;

import java.util.Collection;

public interface ComponentRepo {
    Collection<Component> getAllComponents();
    Component addComponent(Component component);
}
