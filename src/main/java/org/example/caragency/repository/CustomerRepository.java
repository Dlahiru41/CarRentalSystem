package org.example.caragency.repository;

import org.example.caragency.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    // Custom query methods if needed
}
