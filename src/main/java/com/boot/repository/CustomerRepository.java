package com.boot.repository;

import org.springframework.data.repository.CrudRepository;

import com.boot.model.Customer;


public interface CustomerRepository extends CrudRepository<Customer, Long> {

}
