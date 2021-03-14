package com.formacao.caixaeletronico.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.formacao.caixaeletronico.domain.dto.ClienteDto;
import com.formacao.caixaeletronico.services.ClienteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.json.JsonContent;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.List;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ClienteController.class)
class ClienteControllerTest {

    @MockBean
    private ClienteService clienteServiceMock;

    @Autowired
    private MockMvc mockMvc;

    private JacksonTester<ClienteDto> jsonClienteDto;

    @BeforeEach
    void setup() {
        JacksonTester.initFields(this, new ObjectMapper());
    }

    @Test
    void postCadastroClienteTest() throws Exception {
        final ClienteDto clienteDto = ClienteDto.builder()
                .nome("Mateus")
                .cpf("000.000.000-00")
                .email("mateus@macedo.com")
                .telefone("00 0 0000-0000")
                .saldo(BigDecimal.ZERO)
                .build();

        given(clienteServiceMock.cadastrarCliente(any())).willReturn(new ResponseEntity<>(clienteDto, HttpStatus.CREATED));

        MockHttpServletResponse response = mockMvc.perform(
                post("/caixa-eletronico/v1/clientes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonClienteDto.write(clienteDto).getJson()))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.CREATED.value());
        assertThat(response.getContentAsString()).isEqualTo(jsonClienteDto.write(clienteDto).getJson());
    }

    @Test
    void badRequestCadastroClienteComSaldoNegativoTest() throws Exception {
        final ClienteDto clienteDto = ClienteDto.builder()
                .nome("Mateus")
                .cpf("000.000.000-00")
                .email("mateus@macedo.com")
                .telefone("00 0 0000-0000")
                .saldo(BigDecimal.valueOf(-1))
                .build();

        MockHttpServletResponse response = mockMvc.perform(
                post("/caixa-eletronico/v1/clientes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonClienteDto.write(clienteDto).getJson()))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
    }
}