package com.example.architecture.adapter.out;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class AccountEntity {

    @Id
    @GeneratedValue
    private Long id;
    private Integer amount;

    public AccountEntity() {}

    public AccountEntity(Long id, Integer amount) {
        this.amount = amount;
        this.id = id;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
