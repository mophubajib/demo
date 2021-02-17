package com.example.demo.controller;

import com.example.demo.service.ClientService;
import com.example.demo.service.OperationService;
import com.example.demo.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/operations")
public class OperationController {

    @Autowired
    ClientService clientService;
    @Autowired
    PaymentService paymentService;
    @Autowired
    OperationService operationService;

    @GetMapping
    public String index(Model model){

        model.addAttribute("sender",clientService.findAll());
        model.addAttribute("rec", clientService.findAll());


        return "operation/index";
    }

    @PostMapping
    public String transfer (@RequestParam("pay")int pay,
                            @RequestParam("sender")int sendId,
                            @RequestParam("rec") int recId,
                            @RequestParam("message") String message,
                            Model model){
        model.addAttribute("result", operationService.transfer(sendId,recId,pay,message));
        return "operation/index";
    }



}
