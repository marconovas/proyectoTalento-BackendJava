package com.example.articulos.service;

import org.springframework.stereotype.Service;

import com.example.articulos.repository.ArticuloRepository;

@Service 
public class ArticuloService {

    private final ArticuloRepository articuloRepository;

    public ArticuloService(ArticuloRepository articuloRepository) {
        this.articuloRepository = articuloRepository;
    }

}
