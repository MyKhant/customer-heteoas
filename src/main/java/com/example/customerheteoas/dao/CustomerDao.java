package com.example.customerheteoas.dao;

import com.example.customerheteoas.ds.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerDao extends CrudRepository<Customer, Integer> {
}
