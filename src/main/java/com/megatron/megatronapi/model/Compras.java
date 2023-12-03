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
    @ColumnTransformer(
            read = "datetime(data_compra, 'DD-MM-YYYY HH24:MI:SS')",
            write = "strftime('%d-%m-%Y %H:%M:%S', ?)"
    )
    private LocalDateTime dataCompra;
    @Column(name = "quantidade") // real
    private float qtd;

    @Column(name = "valor_compra") // integer
    private int valorCompra;

    @Column(name = "id_moeda") // integer
    private int idMoeda;

    @Column(name = "status") // text
    private String status;

    @Column(name = "valor_venda") // real
    private Float valorVenda;

    @Column(name = "data_venda")
    @ColumnTransformer(
            read = "datetime(data_venda, 'DD-MM-YYYY HH24:MI:SS')",
            write = "strftime('%d-%m-%Y %H:%M:%S', ?)"
    )
    private LocalDateTime dataVenda;
}