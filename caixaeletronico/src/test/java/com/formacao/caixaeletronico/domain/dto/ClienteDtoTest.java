package com.formacao.caixaeletronico.domain.dto;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.math.BigDecimal;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
class ClienteDtoTest {

    private Validator validator;

    @BeforeEach
    void setup() {
        System.out.println("** --------------------- TEST ---------------------- **");
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Test
    void clienteComDadosCorretosTest() {
        final ClienteDto clienteDto = ClienteDto.builder()
                .nome("Mateus")
                .cpf("000.000.000-00")
                .email("mateus@macedo.com")
                .telefone("00 0 0000-0000")
                .saldo(BigDecimal.TEN)
                .build();

        final Set<ConstraintViolation<ClienteDto>> validate = validator.validate(clienteDto);
        log.info("Valida cliente completo, mensagem = sem mensagem de erro");

        assertThat(validate.size()).isEqualTo(0);
    }

    @Test
    void clienteComEmailOpcionalTest() {
        final ClienteDto clienteDto = ClienteDto.builder()
                .nome("Mateus")
                .cpf("000.000.000-00")
                .email(null)
                .telefone("00 0 0000-0000")
                .saldo(BigDecimal.TEN)
                .build();

        final Set<ConstraintViolation<ClienteDto>> validate = validator.validate(clienteDto);
        log.info("Valida cliente com e-mail opcional, mensagem = sem mensagem de erro");

        assertThat(validate.size()).isEqualTo(0);
    }


    @Test
    void erroValidacaoClienteComSaldoNegativoTest() {
        final ClienteDto clienteDto = ClienteDto.builder()
                .nome("Mateus")
                .cpf("000.000.000-00")
                .email("mateus@macedo.com")
                .telefone("00 0 0000-0000")
                .saldo(BigDecimal.valueOf(-1))
                .build();

        final Set<ConstraintViolation<ClienteDto>> validate = validator.validate(clienteDto);
        log.info("Cliente com saldo negativo, mensagem = {}", validate.iterator().next().getMessageTemplate());
        System.err.println(validate.iterator().next().getMessageTemplate());

        assertThat(validate.size()).isNotEqualTo(0);
    }

    @Test
    void erroValidacaoClienteComNomeEmptyTest() {
        final ClienteDto clienteDto = ClienteDto.builder()
                .nome("")
                .cpf("000.000.000-00")
                .email("mateus@macedo.com")
                .telefone("00 0 0000-0000")
                .saldo(BigDecimal.TEN)
                .build();

        final Set<ConstraintViolation<ClienteDto>> validate = validator.validate(clienteDto);
        log.info("Cliente com nome empty, mensagem = {}", validate.iterator().next().getMessageTemplate());
        System.err.println(validate.iterator().next().getMessageTemplate());

        assertThat(validate.size()).isNotEqualTo(0);
    }

    @Test
    void erroValidacaoClienteComNomeNullTest() {
        final ClienteDto clienteDto = ClienteDto.builder()
                .cpf("000.000.000-00")
                .email("mateus@macedo.com")
                .telefone("00 0 0000-0000")
                .saldo(BigDecimal.TEN)
                .build();

        final Set<ConstraintViolation<ClienteDto>> validate = validator.validate(clienteDto);
        log.info("Cliente com nome null, mensagem = {}", validate.iterator().next().getMessageTemplate());
        System.err.println(validate.iterator().next().getMessageTemplate());

        assertThat(validate.size()).isNotEqualTo(0);
    }
}
