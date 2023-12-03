package com.megatron.megatronapi.repository;

import com.megatron.megatronapi.model.Compras;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComprasRepository extends  JpaRepository<Compras, Integer> {
    List<Compras> findAll();
}
