package com.example.architecture.application.service;

import com.example.architecture.application.port.in.SendMoneyIntermediate;
import com.example.architecture.application.port.in.SendMoneyPort;
import com.example.architecture.application.port.out.LoadAccountPort;
import com.example.architecture.application.port.out.UpdateAccountPort;
import com.example.architecture.domain.Account;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class SendMoneyService implements SendMoneyPort {

    private final LoadAccountPort loadAccountPort;
    private final UpdateAccountPort updateAccountPort;


    public SendMoneyService(LoadAccountPort loadAccountPort, UpdateAccountPort updateAccountPort) {
        this.loadAccountPort = loadAccountPort;
        this.updateAccountPort = updateAccountPort;
    }

    @Override
    @Transactional
    public boolean send(SendMoneyIntermediate intermediate) {

        Account source = loadAccountPort.load(intermediate.getSourceId());
        Account target = loadAccountPort.load(intermediate.getTargetId());

        if(source.isBalanceLowerThan(target.getAmount()))
            throw  new RuntimeException("Don't have money");

        target.plus(intermediate.getAmount());
        source.subtract(intermediate.getAmount());

        updateAccountPort.update(source);
        updateAccountPort.update(target);

        return true;
    }
}
