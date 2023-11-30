package com.example.architecture.application.service;

import com.example.architecture.adapter.out.AccountEntity;
import com.example.architecture.adapter.out.AccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final AccountRepository repository;

    public DataInitializer(AccountRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {

        for(int i = 1; i <= 2; i++) {
            AccountEntity account = new AccountEntity();
            account.setId((long) i);
            account.setAmount(500);
            repository.saveAndFlush(account);
        }

        System.out.println("Datos insertados correctamente en la base de datos");

    }
}
