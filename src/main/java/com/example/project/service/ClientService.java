package com.example.project.service;

// import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.example.project.domain.entities.Client;
import com.example.project.exception.DataNotFoundException;
import com.example.project.repository.ClientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client createClient(Client model) {
        return clientRepository.save(model);
    }

    public List<Client> listClient() {
        return clientRepository.findAll();
    }

    public Client findById(Integer id) {
        Optional<Client> client = clientRepository.findById(id);
        return client.orElseThrow(() -> new DataNotFoundException("Client Not found"));
    }

    public Client updatClient(Client updateClient) throws DataNotFoundException {
        Client currentClient = findById(updateClient.getId());
        currentClient.setName(updateClient.getName());
        currentClient.setPhone(updateClient.getPhone());
        return clientRepository.save(updateClient);
    }

    public void deleteClient(Integer id) {
        findById(id);
        clientRepository.deleteById(id);
    }

    public List<String> listDistinct() {
        return clientRepository.listDistinct();
    }

    public List<Client> listByPhone(String phone) {
        return clientRepository.findByPhoneContainingOrderByName(phone);
    }

}