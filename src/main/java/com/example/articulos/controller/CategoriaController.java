package com.example.articulos.controller;

import java.net.URI;
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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.articulos.exception.RecursoNoEncontradoException;
import com.example.articulos.model.Categoria;
import com.example.articulos.service.CategoriaService;

import jakarta.validation.Valid;

@RestController 
@RequestMapping("/api/categorias")
public class CategoriaController {
    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping
    public List<Categoria> listarCategorias() {
        return categoriaService.listarCategorias();
    }

    @GetMapping("/{id}")
    public Categoria buscarPorId(@PathVariable Long id) {
        return categoriaService.buscarPorId(id)
            .orElseThrow(() -> new RecursoNoEncontradoException("La categoria no existe."));
    }

    @PostMapping
    public ResponseEntity<Categoria> guardarCategoria(@Valid @RequestBody Categoria categoria) {
        Categoria nuevaCategoria = categoriaService.guardarCategoria(categoria);

        URI location = ServletUriComponentsBuilder
            .fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(nuevaCategoria.getId())
            .toUri();

        return ResponseEntity.created(location).body(nuevaCategoria);
    }

    @PutMapping("/{id}")
    public Categoria modificarCategoria(@PathVariable Long id, @Valid @RequestBody Categoria categoria) {
        return categoriaService.modificarCategoria(id, categoria);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCategoria(@PathVariable Long id) {
        categoriaService.eliminarCategoria(id);
        
        return ResponseEntity.noContent().build();
    }
}
