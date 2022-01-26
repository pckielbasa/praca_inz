package com.example.praca_inz_api.service;

import com.example.praca_inz_api.dao.AllergiesDao;
import com.example.praca_inz_api.dto.ContactAllergiesDTO;
import com.example.praca_inz_api.dto.FoodAllergiesDTO;
import com.example.praca_inz_api.model.Allergies;
import com.example.praca_inz_api.repository.AllergiesRepo;
import com.example.praca_inz_api.repository.ContactRepo;
import com.example.praca_inz_api.repository.FoodRepo;
import com.example.praca_inz_api.repository.UserRepo;
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

    @Autowired
    private UserRepo userRepo;

    @Override
    public Collection<Allergies> getAllAllergies() {
        return allergiesDao.findAll();
    }

    @Override
    public Allergies createFoodAllergies(FoodAllergiesDTO foodAllergiesDTO) {
        Allergies allergies = new Allergies();
        allergies.setAllergyName(foodAllergiesDTO.getAllergyName());
        allergies.setComment(foodAllergiesDTO.getComment());
        allergies.setType(foodAllergiesDTO.getType());
        allergies.setFoodIdList(foodRepo.getListOfFoodByIds(foodAllergiesDTO.getListOfFoodId()));
        return allergiesDao.save(allergies);
    }

    @Override
    public Allergies addFoodAllergiesToUser(FoodAllergiesDTO foodAllergiesDTO) {
        Allergies allergies = createFoodAllergies(foodAllergiesDTO);
        userRepo.addAllergiesToList(allergies,foodAllergiesDTO.getUsername());
        return allergies;
    }

    @Override
    public Allergies createContactAllergies(ContactAllergiesDTO contactAllergiesDTO) {
        Allergies allergies = new Allergies();
        allergies.setAllergyName(contactAllergiesDTO.getAllergyName());
        allergies.setComment(contactAllergiesDTO.getComment());
        allergies.setType(contactAllergiesDTO.getType());
        allergies.setContactIdList(contactRepo.getListOfContactsByIds(contactAllergiesDTO.getListOfContactId()));
        return allergiesDao.save(allergies);
    }

    @Override
    public Allergies addContactAllergiesToUser(ContactAllergiesDTO contactAllergiesDTO) {
        Allergies allergies = createContactAllergies(contactAllergiesDTO);
        userRepo.addAllergiesToList(allergies,contactAllergiesDTO.getUsername());
        return allergies;
    }


}
