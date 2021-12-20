package com.example.praca_inz_api.service;

import com.example.praca_inz_api.dao.SnackDao;
import com.example.praca_inz_api.model.Snack;
import com.example.praca_inz_api.repository.SnackRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SnackService implements SnackRepo {
    @Autowired
    private SnackDao snackDao;

    @Override
    public List<Snack> getAllSnacks(){
        return snackDao.findAll();
    }

    @Override
    public Snack addSnack(Snack snack) {
        return snackDao.save(snack);
    }

}
