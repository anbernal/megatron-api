package com.megatron.megatronapi.service.imp;

import com.megatron.megatronapi.model.Compras;
import com.megatron.megatronapi.model.Moeda;
import com.megatron.megatronapi.repository.ComprasRepository;
import com.megatron.megatronapi.service.ComprasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComprasServiceImp implements ComprasService {
    @Autowired
    private ComprasRepository comprasRepository;
    @Override
    public List<Compras> listaCompras() {
        return comprasRepository.findAll();
    }
}
