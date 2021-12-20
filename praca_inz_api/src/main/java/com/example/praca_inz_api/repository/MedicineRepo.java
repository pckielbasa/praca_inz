package com.example.praca_inz_api.repository;

import com.example.praca_inz_api.model.Medicine;

import java.util.Collection;

public interface MedicineRepo {
    Collection<Medicine> getAllMedicines();
    Medicine addMedicine(Medicine medicine);
}
