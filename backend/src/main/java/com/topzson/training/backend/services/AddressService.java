package com.topzson.training.backend.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.topzson.training.backend.entity.Address;
import com.topzson.training.backend.entity.User;
import com.topzson.training.backend.repository.AddressRepository;

@Service
public class AddressService {

    private final AddressRepository repository;

    public AddressService(AddressRepository repository) {
        this.repository = repository;
    }

    public List<Address> findByUser(User user) {
        return repository.findByUser(user);
    }

    public Address create(User user, String line1, String line2, String zipcode) {

        Address entity = new Address();

        entity.setUser(user);
        entity.setLine1(line1);
        entity.setLine2(line2);
        entity.setZipcode(zipcode);

        return repository.save(entity);
    }
}
