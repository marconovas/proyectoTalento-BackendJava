package com.example.articulos.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.articulos.model.Articulo;
import com.example.articulos.service.ArticuloService;

@RestController 
@RequestMapping("/api/articulos")
public class ArticuloController {
    private final ArticuloService articuloService;

    public ArticuloController(ArticuloService articuloService) {
        this.articuloService = articuloService;
    }

    @GetMapping
    public List<Articulo> obtenerArticulos() {
        return articuloService.devolverArticulos();
    }
}
