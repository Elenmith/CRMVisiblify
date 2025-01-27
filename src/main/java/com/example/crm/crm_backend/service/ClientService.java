package com.example.crm.crm_backend.service;

import com.example.crm.crm_backend.dto.ClientDto;
import java.util.List;

public interface ClientService {
    ClientDto createClient(ClientDto clientDto);
    List<ClientDto> getAllClients();
    ClientDto getClientById(Long id);
    ClientDto updateClient(Long id, ClientDto clientDto);
    void deleteClient(Long id);
}