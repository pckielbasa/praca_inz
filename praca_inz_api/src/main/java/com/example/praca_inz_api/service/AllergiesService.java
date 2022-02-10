package com.example.praca_inz_api.service;

import com.example.praca_inz_api.dao.AllergiesDao;
import com.example.praca_inz_api.dao.UserDao;
import com.example.praca_inz_api.dto.AllergiesDTO;
import com.example.praca_inz_api.model.Allergies;
import com.example.praca_inz_api.model.User;
import com.example.praca_inz_api.repository.AllergiesRepo;
import com.example.praca_inz_api.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AllergiesService implements AllergiesRepo {
    @Autowired
    private AllergiesDao allergiesDao;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private UserDao userDao;

    @Override
    public Allergies createAllergies(AllergiesDTO allergiesDTO) {
        Allergies allergies = new Allergies();
        List<Allergies> myList = userRepo.getMyAllergiesList(allergiesDTO.getType(), allergiesDTO.getUsername());
        allergies.setUsername(allergiesDTO.getUsername());
        allergies.setAllergenId(allergiesDTO.getAllergenId());
        allergies.setType(allergiesDTO.getType());
        allergies.setAllergenName(allergiesDTO.getAllergenName());
        allergies.setAllergiesName(allergiesDTO.getAllergiesName());
        allergies.setAfterTime(allergiesDTO.getAfterTime());
        allergies.setSymptoms(allergiesDTO.getSymptoms());
        allergies.setHelp(allergiesDTO.getHelp());
        boolean anyMatch = myList.stream().anyMatch(item->item.getAllergenId().equals(allergies.getAllergenId()));
        if (anyMatch){
            return null;
        }
        return allergiesDao.save(allergies);

    }

    @Override
    public Allergies addAllergiesToUser(AllergiesDTO allergiesDTO) {
        Allergies allergies = createAllergies(allergiesDTO);
        if (allergies == null){
            return null;
        }else{
            userRepo.addAllergiesToList(allergies,allergiesDTO.getUsername());
            return allergies;
        }
    }

    @Override
    public void deleteAllergiesById(String allergiesId, String username) {
        Allergies allergies = allergiesDao.findBy_id(allergiesId);
        User user = userRepo.getUserByUsername(username);
        user = userRepo.deleteAllergiesFromUser(user, allergies);
        userDao.save(user);
        allergiesDao.delete(allergies);
    }
}
