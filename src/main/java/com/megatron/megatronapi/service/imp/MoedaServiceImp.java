package com.megatron.megatronapi.service.imp;

import com.megatron.megatronapi.model.Moeda;
import com.megatron.megatronapi.repository.MoedaRepository;
import com.megatron.megatronapi.service.MoedaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MoedaServiceImp implements MoedaService {

    @Autowired
    private MoedaRepository moedaRepository;
    @Override
    public List<Moeda> listaMoedas() {
        return moedaRepository.findAll();
    }
}
