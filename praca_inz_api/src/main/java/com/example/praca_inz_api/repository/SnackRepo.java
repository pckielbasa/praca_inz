package com.example.praca_inz_api.repository;

import com.example.praca_inz_api.model.Snack;

import java.util.Collection;

public interface SnackRepo {
    Collection<Snack> getAllSnacks();
    Snack addSnack(Snack snack);
}
