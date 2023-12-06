package com.megatron.megatronapi.model;

import lombok.*;
import org.hibernate.annotations.ColumnTransformer;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name="compras")
@Data
public class Compras {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "data_compra")
    private String dataCompra;

    @Column(name = "quantidade") // real
    private double qtd;

    @Column(name = "valor_compra") // integer
    private Integer valorCompra;

    @ManyToOne
    @JoinColumn(name = "id_moeda") // integer
    private Moeda moeda;

    @Column(name = "status") // text
    private String status;

    @Column(name = "valor_venda") // real
    private Float valorVenda;

    @Column(name = "data_venda")
    private String dataVenda;
}