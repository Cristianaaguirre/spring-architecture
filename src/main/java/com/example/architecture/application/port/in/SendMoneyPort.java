package com.example.architecture.application.port.in;

public interface SendMoneyPort {

    boolean send(SendMoneyIntermediate intermediate);
}
