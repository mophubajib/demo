package com.example.demo.service.ServiceImpl;

import com.example.demo.dto.ClientDto;
import com.example.demo.entity.Client;
import com.example.demo.repository.ClientRepository;
import com.example.demo.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    ClientRepository clientRepository;

    public List<ClientDto> findAll() {
        List<ClientDto> clientDtoList = new ArrayList<>();
        List<Client> clientList = clientRepository.findAll();
        for (int i =0; i<clientList.size();i++){
                clientDtoList.add(ClientDto.of(clientList.get(i)));
        }
        return clientDtoList;
    }

    public ClientDto findById(int id) {
        //ClientDto clientDto = ClientDto.of(clientRepository.findById(id).get());
        return ClientDto.of(clientRepository.findById(id).get());
    }

    public void deleteById(int id) {
        clientRepository.deleteById(id);
    }

    public void save(Client newClient) {
        clientRepository.save(newClient);
    }

    public void update(Client client) {
        clientRepository.save(client);
    }









/*
    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    public ClientDto findById(int id) {
        //ClientDto clientDto = ClientDto.of(clientRepository.findById(id).get());
        return ClientDto.of(clientRepository.findById(id).get());
    }

    public void deleteById(int id) {
        clientRepository.deleteById(id);
    }

    public void save(Client newClient) {
        clientRepository.save(newClient);
    }

    public void update(Client client) {
        clientRepository.save(client);
    }

    @Override
    public List<Payment> loadRec(int id) {
        //List<Payment> testRecipient = clientRepository.findById(id).get().getRecipientPayments();
        return clientRepository.findById(id).get().getRecipientPayments();
    }

*/

}


