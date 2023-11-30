package com.example.architecture.adapter.out;

import com.example.architecture.domain.Account;

public class AccountMapper {

    public static Account entityToDto(AccountEntity entity) {
        Account account = new Account();
        account.setAmount(entity.getAmount());
        account.setId(entity.getId());
        return account;
    }

    public static AccountEntity dtoToEntity(Account dto) {
        AccountEntity entity = new AccountEntity();
        entity.setAmount(dto.getAmount());
        entity.setId(dto.getId());
        return entity;
    }
}
