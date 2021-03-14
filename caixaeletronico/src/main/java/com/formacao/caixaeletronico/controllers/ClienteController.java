package com.formacao.caixaeletronico.controllers;

import com.formacao.caixaeletronico.domain.dto.ClienteDto;
import com.formacao.caixaeletronico.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/caixa-eletronico/v1/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity<ClienteDto> cadastrarCliente(@Valid @RequestBody ClienteDto clienteDto) {
        return clienteService.cadastrarCliente(clienteDto);
    }
}
