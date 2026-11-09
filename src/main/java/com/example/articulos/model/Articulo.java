package com.example.articulos.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity 
@Table (
    name = "articulos"
)
public class Articulo {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(
        nullable = false,
        length = 20
    )
    private String nombre;

    @Column (
        length = 255
    )
    private String descripcion;

    @Column (
        nullable = false,
        precision = 10,
        scale = 2 
    )
    private BigDecimal precio;

    @Column (
        nullable = false
    )
    private Integer stock;

    public Articulo() {

    }

    public Articulo(String nombre, String descripcion, BigDecimal precio, Integer stock) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
    }

    //GETTERS
    public Long getId() {
        return this.id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public BigDecimal getPrecio() {
        return this.precio;
    }

    public Integer getStock() {
        return this.stock;
    }

    //SETTERS
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}
