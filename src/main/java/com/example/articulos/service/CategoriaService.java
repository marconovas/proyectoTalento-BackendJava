package com.example.articulos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.articulos.model.Categoria;
import com.example.articulos.repository.CategoriaRepository;


@Service 
public class CategoriaService {
    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public List<Categoria> listarCategorias() {
        return categoriaRepository.findAll();
    }

    public Optional<Categoria> buscarPorId(Long id) {
        return categoriaRepository.findById(id);
    }

    public Categoria guardarCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    public Categoria modificarCategoria(Long id, Categoria categoria) {
        Categoria categoriaEncontrada = buscarPorId(id).orElseThrow(() -> new RuntimeException("No existe la categoria."));

        categoriaEncontrada.setNombre(categoria.getNombre());

        return categoriaRepository.save(categoriaEncontrada);
    
    }

    public void eliminarCategoria(Long id) {
        Categoria categoriaEncontrada = buscarPorId(id)
        .orElseThrow(() -> new RuntimeException("No existe la categoria."));

        categoriaRepository.delete(categoriaEncontrada);
    }

}
