package com.example.demo.dto;

import com.example.demo.entity.Client;

import java.util.ArrayList;
import java.util.List;

public class ClientDto {


    private int id;
    private String numberPhone;
    private int balance;
    private String name;
    private List<PaymentDto> recipientPaymentsDto;
    private List<PaymentDto> senderPaymentsDto;

    public static ClientDto of (Client client){

        ClientDto clientDto = new ClientDto();
        clientDto.setName(client.getName());
        clientDto.setId(client.getId());
        clientDto.setBalance(client.getBalance());
        clientDto.setNumberPhone(client.getNumberPhone());

        PaymentDto paymentDto = new PaymentDto();
        List<PaymentDto> paymentDtoList = new ArrayList<>();
        //paymentDto.of(client.getRecipientPayments().get(client.getId()));
        for (int i=0; i<client.getRecipientPayments().size();i++){
            paymentDtoList.add(paymentDto.of(client.getRecipientPayments().get(i)));
            //paymentDtoList.add(new PaymentDto().of(client.getRecipientPayments().get(i)));
        }
        clientDto.setRecipientPaymentsDto(paymentDtoList);

        PaymentDto paymentDto1 = new PaymentDto();
        List<PaymentDto> paymentDtoList1 = new ArrayList<>();
        for (int i=0; i<client.getSenderPayments().size();i++){
            paymentDtoList1.add(paymentDto.of(client.getSenderPayments().get(i)));
        }
        clientDto.setSenderPaymentsDto(paymentDtoList1);
        return clientDto;
    }

    public List<PaymentDto> getRecipientPaymentsDto() {
        return recipientPaymentsDto;
    }

    public void setRecipientPaymentsDto(List<PaymentDto> recipientPaymentsDto) {
        this.recipientPaymentsDto = recipientPaymentsDto;
    }


    public List<PaymentDto> getSenderPaymentsDto() {
        return senderPaymentsDto;
    }

    public void setSenderPaymentsDto(List<PaymentDto> senderPaymentsDto) {
        this.senderPaymentsDto = senderPaymentsDto;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
