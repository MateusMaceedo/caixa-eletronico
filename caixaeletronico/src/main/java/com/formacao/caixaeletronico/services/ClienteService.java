package com.formacao.caixaeletronico.services;

import com.formacao.caixaeletronico.domain.dto.ClienteDto;
import com.formacao.caixaeletronico.domain.entities.ClienteEntity;
import com.formacao.caixaeletronico.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public ResponseEntity<ClienteDto> cadastrarCliente(final ClienteDto clienteDto) {
        ClienteEntity clienteEntity = ClienteEntity.builder()
                .nome(clienteDto.getNome())
                .cpf(clienteDto.getCpf())
                .email(clienteDto.getEmail())
                .telefone(clienteDto.getTelefone())
                .saldo(clienteDto.getSaldo())
                .build();
        clienteRepository.save(clienteEntity);

        return new ResponseEntity<>(clienteDto, HttpStatus.CREATED);
    }
}
