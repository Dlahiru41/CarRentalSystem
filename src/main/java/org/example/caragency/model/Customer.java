package org.example.caragency.model;

import jakarta.persistence.*;


@Entity
@PrimaryKeyJoinColumn(name = "user_id")
public class Customer extends User {

    private Integer customerNumber;

    public Customer() {
        this.setRole(UserRole.CUSTOMER);
    }

    public Integer getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(Integer customerNumber) {
        this.customerNumber = customerNumber;
    }
}
