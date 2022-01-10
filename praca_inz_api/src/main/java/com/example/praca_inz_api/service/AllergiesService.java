package com.example.praca_inz_api.service;

import com.example.praca_inz_api.dao.AllergiesDao;
import com.example.praca_inz_api.dao.ItemDayDao;
import com.example.praca_inz_api.model.Allergies;
import com.example.praca_inz_api.repository.AllergiesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class AllergiesService implements AllergiesRepo {
    @Autowired
    private AllergiesDao allergiesDao;


    @Override
    public Collection<Allergies> getAllAllergies() {
        return allergiesDao.findAll();
    }

    @Override
    public Allergies addAllergies(Allergies allergies) {
        return allergiesDao.save(allergies);
    }
}
