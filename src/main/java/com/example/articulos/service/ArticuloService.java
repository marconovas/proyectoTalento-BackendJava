package com.example.articulos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.articulos.exception.RecursoNoEncontradoException;
import com.example.articulos.model.Articulo;
import com.example.articulos.model.Categoria;
import com.example.articulos.repository.ArticuloRepository;
import com.example.articulos.repository.CategoriaRepository;

@Service 
public class ArticuloService {

    private final ArticuloRepository articuloRepository;
    private final CategoriaRepository categoriaRepository;

    public ArticuloService(ArticuloRepository articuloRepository, CategoriaRepository categoriaRepository) {
        this.articuloRepository = articuloRepository;
        this.categoriaRepository = categoriaRepository;
    }

    public List<Articulo> devolverArticulos() {
        return articuloRepository.findAll();
    }

    public Optional<Articulo> buscarPorId(Long id) {
        return articuloRepository.findById(id);
    }

    public Articulo guardarArticulo(Articulo articulo) {
        Categoria categoriaArticulo = articulo.getCategoria();
        Long idCategoria = categoriaArticulo.getId();

        Categoria categoriaBuscada = categoriaRepository.findById(idCategoria)
            .orElseThrow(() -> new RecursoNoEncontradoException("La categoria no existe."));

        articulo.setCategoria(categoriaBuscada);

        return articuloRepository.save(articulo);
    }

    public Articulo modificarArticulo(Long id, Articulo articulo) {
        Articulo articuloBuscado = buscarPorId(id).orElseThrow(() -> new RecursoNoEncontradoException("Articulo no encontrado."));

        Categoria categoriaArticulo = articulo.getCategoria();
        Categoria categoriaBuscada = categoriaRepository.findById(categoriaArticulo.getId())
            .orElseThrow(() -> new RecursoNoEncontradoException("La categoria no existe."));

        articuloBuscado.setNombre(articulo.getNombre());
        articuloBuscado.setDescripcion(articulo.getDescripcion());
        articuloBuscado.setPrecio(articulo.getPrecio());
        articuloBuscado.setStock(articulo.getStock());
        articuloBuscado.setCategoria(categoriaBuscada);

        return articuloRepository.save(articuloBuscado);
    }

    public void eliminarArticulo(Long id) {
        Articulo articuloBuscado = buscarPorId(id).orElseThrow(() -> new RecursoNoEncontradoException("Articulo no encontrado."));

        articuloRepository.delete(articuloBuscado);
    }
}
