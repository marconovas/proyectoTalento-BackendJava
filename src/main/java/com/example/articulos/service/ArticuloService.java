package com.example.articulos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.articulos.model.Articulo;
import com.example.articulos.repository.ArticuloRepository;

@Service 
public class ArticuloService {

    private final ArticuloRepository articuloRepository;

    public ArticuloService(ArticuloRepository articuloRepository) {
        this.articuloRepository = articuloRepository;
    }

    public List<Articulo> devolverTodos() {
        return articuloRepository.findAll();
    }

    public Optional<Articulo> buscarPorId(Long id) {
        return articuloRepository.findById(id);
    }

    public Articulo guardarArticulo(Articulo articulo) {
        return articuloRepository.save(articulo);
    }

    public Articulo modificarArticulo(Long id, Articulo articulo) {
        Articulo articuloBuscado = buscarPorId(id).orElseThrow(() -> new RuntimeException("Articulo no encontrado."));

        articuloBuscado.setNombre(articulo.getNombre());
        articuloBuscado.setDescripcion(articulo.getDescripcion());
        articuloBuscado.setPrecio(articulo.getPrecio());
        articuloBuscado.setStock(articulo.getStock());

        return articuloRepository.save(articuloBuscado);
    }

    public void eliminarArticulo(Long id) {
        Articulo articuloBuscado = buscarPorId(id).orElseThrow(() -> new RuntimeException("Articulo no encontrado"));

        articuloRepository.delete(articuloBuscado);
    }
}
