package com.formacao.caixaeletronico.domain.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@Builder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TB_CLIENTE")
public class ClienteEntity implements Serializable {
    private static final long serialVersionUID = 679666449636947661L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private BigDecimal saldo;

}
