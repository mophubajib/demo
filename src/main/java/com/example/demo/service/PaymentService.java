package com.example.demo.service;

import com.example.demo.Exception.PaymentException;
import com.example.demo.entity.Payment;

import java.util.List;

public interface PaymentService {
    List<Payment> loadSender(int id) throws PaymentException;
    List<Payment> loadRecipient(int id);
}
