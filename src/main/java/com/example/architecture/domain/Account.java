package com.example.architecture.domain;


public class Account {

    private Long id;
    private Integer amount;

    public Account() {
    }

    public Account(Long id, Integer amount) {
        this.id = id;
        this.amount = amount;
    }

    public Boolean isBalanceLowerThan(Integer anotherMount) {
        return this.amount < anotherMount;
    }

    public void plus(Integer amount) {
        this.amount += amount;
    }

    public void subtract(Integer amount) {
        this.amount -= amount;
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
