package com.example.articulos.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.articulos.exception.RecursoNoEncontradoException;
import com.example.articulos.model.Articulo;
import com.example.articulos.service.ArticuloService;

import jakarta.validation.Valid;

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
        .orElseThrow(() -> new RecursoNoEncontradoException("Articulo no encontrado"));
    }

    @PostMapping
    public ResponseEntity<Articulo> crearArticulo(@Valid @RequestBody Articulo articulo) {
        Articulo articuloGuardado = articuloService.guardarArticulo(articulo);

        URI location = ServletUriComponentsBuilder
            .fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(articuloGuardado.getId())
            .toUri();

        return ResponseEntity.created(location).body(articuloGuardado);
    }

    @PutMapping("/{id}")
    public Articulo modificarArticulo(@Valid @PathVariable Long id, @RequestBody Articulo articulo) {
        return articuloService.modificarArticulo(id, articulo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarArticulo (@PathVariable Long id) {
        articuloService.eliminarArticulo(id); 

        return ResponseEntity.noContent().build();
    }
}
