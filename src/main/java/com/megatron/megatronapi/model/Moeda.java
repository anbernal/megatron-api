package com.megatron.megatronapi.model;


import javax.persistence.*;
import lombok.*;

import java.math.BigDecimal;


@Entity
@Table(name="moeda")
@Data
public class Moeda {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "nome_moeda")
    private String nomeMoeda;

    @Column(name = "mfi_atual")
    private BigDecimal mfiAtual;

    @Column(name = "id_coin_gecko")
    private String idCoinGecko;

    @Column(name = "name_coin_gecko")
    private String nameCoinGecko;

    @Column(name = "image_thumb")
    private String imageThumb;

    @Column(name = "image_small")
    private String imageSmall;

    @Column(name = "image_large")
    private String imageLarge;
}
