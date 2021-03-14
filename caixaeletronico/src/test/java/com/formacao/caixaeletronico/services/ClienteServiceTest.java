package com.formacao.caixaeletronico.services;

import com.formacao.caixaeletronico.domain.dto.ClienteDto;
import com.formacao.caixaeletronico.domain.entities.ClienteEntity;
import com.formacao.caixaeletronico.repositories.ClienteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class ClienteServiceTest {

    @InjectMocks
    private ClienteService clienteService;

    @Mock
    private ClienteRepository clienteRepositoryMock;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void deveCadastrarClienteTest() {
        ClienteEntity clienteEntity = ClienteEntity.builder()
                .nome("Mateus")
                .cpf("000.000.000-00")
                .email("mateus@macedo.com")
                .telefone("00 0 0000-0000")
                .saldo(BigDecimal.ZERO)
                .build();

        ClienteDto clienteDto = new ClienteDto(clienteEntity);

        when(clienteRepositoryMock.save(any(ClienteEntity.class))).thenReturn(clienteEntity);

        final ResponseEntity<ClienteDto> clienteDtoResponseEntity = clienteService.cadastrarCliente(clienteDto);

        assertThat(clienteDtoResponseEntity.getBody()).isEqualTo(clienteDto);
    }
}
