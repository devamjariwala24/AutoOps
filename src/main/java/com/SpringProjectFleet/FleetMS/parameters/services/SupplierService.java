package com.SpringProjectFleet.FleetMS.parameters.services;

import com.SpringProjectFleet.FleetMS.parameters.models.Supplier;
import com.SpringProjectFleet.FleetMS.parameters.repositories.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    public List<Supplier> findAll() {
        return supplierRepository.findAll();
    }

    public Supplier findById(int id) {
        return supplierRepository.findById(id).orElse(null);
    }

    public void deleteById(int id) {
        supplierRepository.deleteById(id);
    }

    public void save(Supplier supplier) {
        supplierRepository.save(supplier);
    }
}
