package com.example.idempotencia.webconfig;

public class RequestTransaction {

    private String transactionId;

    private String canal;

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getCanal() {
        return canal;
    }

    public void setCanal(String canal) {
        this.canal = canal;
    }

    @Override
    public String toString() {
        return "RequestTransaction{" +
                "transactionId='" + transactionId + '\'' +
                ", canal='" + canal + '\'' +
                '}';
    }
}
