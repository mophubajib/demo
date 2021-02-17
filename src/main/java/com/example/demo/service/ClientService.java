package com.example.demo.service;

import com.example.demo.dto.ClientDto;
import com.example.demo.entity.Client;
import com.example.demo.entity.Payment;

import java.util.List;

public interface ClientService {

    List<ClientDto> findAll ();
    ClientDto findById(int id);
    void deleteById(int id);
    void save (Client client);
    void update (Client client);


/*    List<Client> findAll ();
    Client findById(int id);
    void deleteById(int id);
    void save (Client client);
    void update (Client client);
    List<Payment> loadRec (int id);*/

}
