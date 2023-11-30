package com.example.architecture.application.port.out;

import com.example.architecture.domain.Account;

public interface LoadAccountPort {

    Account load(Long id);
}
