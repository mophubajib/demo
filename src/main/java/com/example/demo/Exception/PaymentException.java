package com.example.demo.Exception;

import com.example.demo.entity.Payment;
import com.example.demo.repository.PaymentRepository;
import com.example.demo.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.context.annotation.Bean;

import java.util.List;

public class PaymentException extends Exception {
    @Autowired
    PaymentService paymentService;
    @Autowired
    PaymentRepository paymentRepository;
    private String messageErrorForPaymentList;


    public boolean test(int id) throws PaymentException {
        List<Payment> paymentListForCheckOnError = paymentRepository.findAll();
        for (int i = 0; i < paymentListForCheckOnError.size(); i++) {
            if (id != paymentListForCheckOnError.get(i).getId()) {
                return false;
                //throw new PaymentException("Ошибка: транзакций не было");
            }
        }
        return true;
    }

/*


    public void PayException(int paymentIdForCheckOnError) throws PaymentException {

        List<Payment> paymentListForCheckOnError = paymentService.loadSender(paymentIdForCheckOnError);

        if (paymentListForCheckOnError == null) {
            messageErrorForPaymentList = "Ошибка: переводов еще не было";
        } else
    }


    public String getMessageErrorForPaymentList() {
        return messageErrorForPaymentList;
    }

    public void setMessageErrorForPaymentList(String messageErrorForPaymentList) {
        this.messageErrorForPaymentList = messageErrorForPaymentList;
    }*/


    public PaymentException() {
        super();
    }

    public PaymentException(String message) {
        super(message);
    }

    public PaymentException(String message, Throwable cause) {
        super(message, cause);
    }

    public PaymentException(Throwable cause) {
        super(cause);
    }

    protected PaymentException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
