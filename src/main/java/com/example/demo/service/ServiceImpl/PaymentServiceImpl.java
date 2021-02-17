package com.example.demo.service.ServiceImpl;

import com.example.demo.Exception.PaymentException;
import com.example.demo.entity.Payment;
import com.example.demo.repository.PaymentRepository;
import com.example.demo.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    PaymentRepository paymentRepository;

    @Override
    public List<Payment> loadSender(int id) throws PaymentException {
        return paymentRepository.findBySender_Id(id);
    }

    @Override
    public List<Payment> loadRecipient(int id) {
        return paymentRepository.findByRecipient_Id(id);
    }
}
