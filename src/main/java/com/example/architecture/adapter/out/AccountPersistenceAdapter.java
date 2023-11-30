package com.example.architecture.adapter.out;

import com.example.architecture.application.port.out.LoadAccountPort;
import com.example.architecture.application.port.out.UpdateAccountPort;
import com.example.architecture.domain.Account;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountPersistenceAdapter implements LoadAccountPort, UpdateAccountPort {

    private final AccountRepository repository;

    public AccountPersistenceAdapter(AccountRepository repository) {
        this.repository = repository;
    }

    @Override
    public Account load(Long id) {
        return Optional
                .of(repository.getReferenceById(id))
                .map(AccountMapper::entityToDto)
                .orElseThrow(RuntimeException::new);
    }

    @Override
    public void update(Account account) {
        repository.saveAndFlush(AccountMapper.dtoToEntity(account));
    }
}
