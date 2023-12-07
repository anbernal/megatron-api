package com.megatron.megatronapi.repository;

import com.megatron.megatronapi.model.Moeda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface MoedaRepository extends JpaRepository<Moeda, Integer> {
    List<Moeda> findAll();

    @Query("SELECT m FROM Moeda m WHERE m.imageThumb IS NULL OR m.imageSmall IS NULL OR m.imageLarge IS NULL")
    List<Moeda> buscarMoedasImagemVazia();

    @Transactional
    @Modifying
    @Query("UPDATE Moeda m SET m.idCoinGecko = :idCoingecko WHERE m.id = :moedaId")
    void atualizarIdCoinGecko(@Param("moedaId") Integer moedaId, @Param("idCoingecko") String idCoingecko);

    @Transactional
    @Modifying
    @Query("UPDATE Moeda m SET m.imageThumb = :imagemThumb, m.imageSmall = :imagemSmall, m.imageLarge = :imagemLarge WHERE m.id = :moedaId")
    void atualizarImagens(@Param("moedaId") Integer moedaId, @Param("imagemThumb") String imagemThumb, @Param("imagemSmall") String imagemSmall, @Param("imagemLarge") String imagemLarge);
}