package com.example.customerheteoas.dao;

import com.example.customerheteoas.ds.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressDao extends CrudRepository<Address, Integer> {
}
