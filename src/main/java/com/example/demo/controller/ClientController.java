package com.example.demo.controller;

import com.example.demo.Exception.PaymentException;
import com.example.demo.entity.Client;
import com.example.demo.entity.Payment;
import com.example.demo.service.ClientService;
import com.example.demo.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/client")
public class ClientController {

    @Autowired
    ClientService clientService;
    @Autowired
    PaymentService paymentService;


    @GetMapping
    public String index(Model model) {
        model.addAttribute("listClient", clientService.findAll());
        return "client/index";
    }

    @GetMapping
    @RequestMapping("/{id}")
    public String show(Model model, @PathVariable("id") int id) {
        model.addAttribute("client", clientService.findById(id));
        return "client/show";
    }

    @GetMapping
    @RequestMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id, @ModelAttribute("client") Client client) {
        model.addAttribute("client", clientService.findById(id));
        return "client/edit";
    }

    @GetMapping
    @RequestMapping("/new")
    public String newClient(@ModelAttribute("client") Client client) {
        return "client/new";
    }

    @PostMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        clientService.deleteById(id);
        return "redirect:/client";
    }

    @PostMapping()
    public String addClient(@ModelAttribute("client") @Validated Client client,
                            BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "client/new";
        clientService.save(client);
        return "redirect:/client";
    }

    @PostMapping("/{id}/edit")
    public String editClient(@ModelAttribute("client") @Validated Client client,
                             BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "client/edit";
        clientService.update(client);
        return "redirect:/client";
    }

    @GetMapping
    @RequestMapping("/{id}/recipient")
    public String indexRecepient(Model model, @PathVariable("id") int id) {
        model.addAttribute("loadRec", paymentService.loadRecipient(id));
        return "client/recipient";
    }

    @GetMapping
    @RequestMapping("/{id}/sender")
    public String indexSender(Model model, @PathVariable("id") int id) throws PaymentException {
        List<Payment> paymentList = paymentService.loadSender(id);
        //PaymentException paymentException = new PaymentException();
        if (paymentList.size() == 0) {
            model.addAttribute("loadSender", "Ошибка: транзакций еще не было");
            throw new PaymentException("Ошибка: транзакций не было");
        } else model.addAttribute("loadSender", paymentList);
        return "client/sender";
    }


}
