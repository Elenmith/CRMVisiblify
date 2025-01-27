package com.example.crm.crm_backend.mapper;

import com.example.crm.crm_backend.dto.ClientDto;
import com.example.crm.crm_backend.entity.Client;
import org.springframework.stereotype.Component;

@Component
public class ClientMapper {

    public static ClientDto toDto(Client client) {
        if (client == null) {
            return null;
        }

        return new ClientDto(
                client.getId(),
                client.getCompanyName(),
                client.getEmail(),
                client.getPhoneNumber(),
                client.getAddress()
        );
    }

    public static Client toEntity(ClientDto clientDto) {
        return new Client(
                clientDto.getId(),
                clientDto.getCompanyName(),
                clientDto.getEmail(),
                clientDto.getPhoneNumber(),
                clientDto.getAddress()
        );
    }
}
