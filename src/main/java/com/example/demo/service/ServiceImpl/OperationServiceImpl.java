package com.example.demo.service.ServiceImpl;

import com.example.demo.entity.Client;
import com.example.demo.entity.Payment;
import com.example.demo.repository.ClientRepository;
import com.example.demo.repository.PaymentRepository;
import com.example.demo.service.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.util.Date;

@Service
public class OperationServiceImpl implements OperationService {

    @Autowired
    PaymentRepository paymentRepository;
    @Autowired
    ClientRepository clientRepository;

    public String transfer (int senderId, int recId, int pay, String message){
        Client sender = clientRepository.findById(senderId).get();
        Client rec = clientRepository.findById(recId).get();

        int senderScore = sender.getBalance();
        int recScore = rec.getBalance();

        if (pay<0||senderScore<pay||senderId==recId){
            return "error";
        }

        sender.setBalance(senderScore-pay);
        rec.setBalance(recScore+pay);

        Payment payment = new Payment();
        payment.setAmount(pay);
        payment.setData(new Date().toString());
        payment.setRecipient(rec);
        payment.setSender(sender);
        payment.setMessage(message);

        clientRepository.save(sender);
        clientRepository.save(rec);
        paymentRepository.save(payment);

        return "secsessful";
    }



/*        if (pay<0){
            return "error";
        }
        if (senderScore<pay){
            return "error";
        }
        if (senderId==recId){
            return "error";
        }*/

}
