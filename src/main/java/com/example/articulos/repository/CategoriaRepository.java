package com.example.articulos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.articulos.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria,Long> {

}
