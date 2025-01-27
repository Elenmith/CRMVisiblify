package com.example.crm.crm_backend.service.impl;

import com.example.crm.crm_backend.dto.ClientDto;
import com.example.crm.crm_backend.entity.Client;
import com.example.crm.crm_backend.mapper.ClientMapper;
import com.example.crm.crm_backend.repository.ClientRepository;
import com.example.crm.crm_backend.service.ClientService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository){
        this.clientRepository = clientRepository;
    }

    @Override
    public ClientDto createClient(ClientDto clientDto) {
        try {
            Client client = ClientMapper.toEntity(clientDto);
            Client savedClient = clientRepository.save(client);
            return ClientMapper.toDto(savedClient);
        } catch (Exception e){
            throw new RuntimeException("Failed to save client: " + e.getMessage(), e);
        }
    }

    @Override
    public List<ClientDto> getAllClients() {
        List<Client> clients = clientRepository.findAll();

        return clients.stream().map((client) -> ClientMapper.toDto(client))
                .collect(Collectors.toList());
    }

    @Override
    public ClientDto getClientById(Long id) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client not found"));
        return ClientMapper.toDto(client);                    // Mapowanie Entity -> DTO
    }

    @Override
    public ClientDto updateClient(Long id, ClientDto clientDto) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client not found"));

        // Aktualizacja pól z DTO
        client.setCompanyName(clientDto.getCompanyName());
        client.setEmail(clientDto.getEmail());
        client.setPhoneNumber(clientDto.getPhoneNumber());
        client.setAddress(clientDto.getAddress());

        Client updatedClient = clientRepository.save(client);
        return ClientMapper.toDto(updatedClient);             // Mapowanie Entity -> DTO
    }

    @Override
    public void deleteClient(Long id) {
        Client client = clientRepository.findById(id).orElseThrow(() -> new RuntimeException("Client is not exists with given id: " + id));
        clientRepository.deleteById(id);
    }

}