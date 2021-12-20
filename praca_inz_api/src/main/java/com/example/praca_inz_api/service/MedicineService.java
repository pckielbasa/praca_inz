package com.example.praca_inz_api.service;

import com.example.praca_inz_api.dao.MedicineDao;
import com.example.praca_inz_api.model.Medicine;
import com.example.praca_inz_api.repository.MedicineRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class MedicineService implements MedicineRepo {

    @Autowired
    private MedicineDao medicineDao;

    @Override
    public Collection<Medicine> getAllMedicines() {
        return medicineDao.findAll();
    }

    @Override
    public Medicine addMedicine(Medicine medicine) {
        return medicineDao.save(medicine);
    }
}
