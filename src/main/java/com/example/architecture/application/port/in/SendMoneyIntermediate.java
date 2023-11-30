package com.example.architecture.application.port.in;

public class SendMoneyIntermediate {

    private Long sourceId;
    private Long targetId;
    private Integer amount;

    public SendMoneyIntermediate() {
    }

    public SendMoneyIntermediate(Long sourceId, Long targetId, Integer amount) {
        this.sourceId = sourceId;
        this.targetId = targetId;
        this.amount = amount;
    }

    public Long getSourceId() {
        return sourceId;
    }

    public void setSourceId(Long sourceId) {
        this.sourceId = sourceId;
    }

    public Long getTargetId() {
        return targetId;
    }

    public void setTargetId(Long targetId) {
        this.targetId = targetId;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
