package com.megatron.megatronapi.model;


import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;


@Entity
@Table(name="moeda")
@Data
public class Moeda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "nome_moeda")
    private String nomeMoeda;

    @Column(name = "mfi_atual")
    private BigDecimal mfiAtual;
}
