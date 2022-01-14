package com.example.praca_inz_api.service;

import com.example.praca_inz_api.dao.AllergiesDao;
import com.example.praca_inz_api.dao.ItemDayDao;
import com.example.praca_inz_api.dto.AllergiesContactDTO;
import com.example.praca_inz_api.dto.AllergiesFoodDTO;
import com.example.praca_inz_api.model.Allergies;
import com.example.praca_inz_api.repository.AllergiesRepo;
import com.example.praca_inz_api.repository.ContactRepo;
import com.example.praca_inz_api.repository.FoodRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class AllergiesService implements AllergiesRepo {
    @Autowired
    private AllergiesDao allergiesDao;

    @Autowired
    private FoodRepo foodRepo;

    @Autowired
    private ContactRepo contactRepo;

    @Override
    public Collection<Allergies> getAllAllergies() {
        return allergiesDao.findAll();
    }

    @Override
    public Allergies addFoodAllergies(AllergiesFoodDTO allergiesFoodDTO) {
       Allergies allergies = new Allergies();
       allergies.setNameAllergy(allergiesFoodDTO.getNameAllergy());
        allergies.setComment(allergiesFoodDTO.getComment());
       allergies.setFoodId(foodRepo.getFoodId(allergiesFoodDTO.getFoodId()));
        return allergiesDao.save(allergies);
    }

    @Override
    public Allergies addContactAllergies(AllergiesContactDTO allergiesContactDTO) {
        Allergies allergies = new Allergies();
        allergies.setNameAllergy(allergiesContactDTO.getNameAllergy());
        allergies.setComment(allergiesContactDTO.getComment());
        allergies.setContactId((contactRepo.getContactId(allergiesContactDTO.getContactId())));
        return allergiesDao.save(allergies);
    }


}
