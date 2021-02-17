package com.example.demo.dto;

import com.example.demo.entity.Payment;

public class PaymentDto {

    private String data;
    private String message;
    private int amount;
    private String recipientName;
    private String senderName;


    public static PaymentDto of (Payment payment) {

        PaymentDto paymentDto = new PaymentDto();
        paymentDto.setAmount(payment.getAmount());
        paymentDto.setData(payment.getData());
        paymentDto.setMessage(payment.getMessage());
        paymentDto.setRecipientName(payment.getRecipient().getName());
        paymentDto.setSenderName(payment.getSender().getName());
        return paymentDto;
    }


    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }


    public String getRecipientName() {
        return recipientName;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }



}
