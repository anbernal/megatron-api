package com.megatron.megatronapi.repository;

import com.megatron.megatronapi.model.Moeda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MoedaRepository extends JpaRepository<Moeda, Integer> {
    List<Moeda> findAll();
}