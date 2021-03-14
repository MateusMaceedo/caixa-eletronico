package com.formacao.caixaeletronico.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.formacao.caixaeletronico.domain.entities.ClienteEntity;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDto {

    @JsonProperty("nome_cliente")
    @NotEmpty
    @NotNull
    private String nome;

    @JsonProperty("cpf_cliente")
    @NotEmpty
    @NotNull
    private String cpf;

    @JsonProperty("email_cliente")
    private String email;

    @JsonProperty("telefone_cliente")
    @NotEmpty
    @NotNull
    private String telefone;

    @JsonProperty("saldo_cliente")
    @NotNull
    @PositiveOrZero
    private BigDecimal saldo;

    public ClienteDto(final ClienteEntity clienteEntity) {
        this.nome = clienteEntity.getNome();
        this.cpf = clienteEntity.getCpf();
        this.email = clienteEntity.getEmail();
        this.telefone = clienteEntity.getTelefone();
        this.saldo = clienteEntity.getSaldo();
    }
}
