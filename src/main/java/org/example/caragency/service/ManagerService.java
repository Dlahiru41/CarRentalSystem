package org.example.caragency.service;

import org.example.caragency.model.Manager;
import org.example.caragency.repository.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManagerService {
    @Autowired
    private ManagerRepository managerRepository;

    public Manager createNewAccount(Manager manager) {
        return managerRepository.save(manager);
    }
}