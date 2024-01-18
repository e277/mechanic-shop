package dev.ungu.mechanicshop.repository;

import java.lang.Long;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.ungu.mechanicshop.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}