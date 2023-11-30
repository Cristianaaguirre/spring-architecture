package com.example.architecture.adapter.in;

import com.example.architecture.application.port.in.SendMoneyIntermediate;
import com.example.architecture.application.port.in.SendMoneyPort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MoneyTransferController {

    private final SendMoneyPort sendMoneyPort;

    public MoneyTransferController(SendMoneyPort sendMoneyPort) {
        this.sendMoneyPort = sendMoneyPort;
    }

    @PostMapping(path = "/accounts/transfer/{sourceId}/{targetId}/{amount}")
    public ResponseEntity<Boolean> transfer(@PathVariable Long sourceId, @PathVariable Long targetId, @PathVariable Integer amount) {

        SendMoneyIntermediate intermediate = new SendMoneyIntermediate();
        intermediate.setSourceId(sourceId);
        intermediate.setTargetId(targetId);
        intermediate.setAmount(amount);

        return ResponseEntity.status(200).body(sendMoneyPort.send(intermediate));
    }
}

