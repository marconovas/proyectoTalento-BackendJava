package com.example.articulos.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.articulos.exception.ArticuloNoEncontradoException;
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

    @GetMapping("/{id}")
    public Articulo buscarPorId(@PathVariable Long id) {
        return articuloService.buscarPorId(id)
        .orElseThrow(() -> new ArticuloNoEncontradoException("Articulo no encontrado"));
    }

    @PostMapping
    public Articulo crearArticulo(@RequestBody Articulo articulo) {
        return articuloService.guardarArticulo(articulo);
    }

    @PutMapping("/{id}")
    public Articulo modificarArticulo(@PathVariable Long id, @RequestBody Articulo articulo) {
        return articuloService.modificarArticulo(id, articulo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarArticulo (@PathVariable Long id) {
        articuloService.eliminarArticulo(id); 

        return ResponseEntity.noContent().build();
    }
}
