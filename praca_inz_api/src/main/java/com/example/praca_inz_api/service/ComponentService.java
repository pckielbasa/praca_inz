package com.example.praca_inz_api.service;

import com.example.praca_inz_api.dao.ComponentDao;
import com.example.praca_inz_api.model.Component;
import com.example.praca_inz_api.repository.ComponentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ComponentService implements ComponentRepo {
    @Autowired
    private ComponentDao componentDao;

    @Override
    public Collection<Component> getAllComponents() {
        return componentDao.findAll();
    }

    @Override
    public Component addComponent(Component component) {
        return componentDao.save(component);
    }
}
