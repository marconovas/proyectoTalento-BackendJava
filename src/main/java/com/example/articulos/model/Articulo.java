package com.example.articulos.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

@Entity 
@Table (
    name = "articulos"
)
public class Articulo {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "categoria_id", nullable = false)
    @NotNull (message = "La categoria es obligatoria.")
    private Categoria categoria;

    @Column(
        nullable = false,
        length = 100
    )
    @NotBlank(message = "El nombre es obligatorio")
    @Size (min = 3, max = 100, message = "El nombre debe ser minimo 3 caracteres y no debe superar los 100 caracteres")
    private String nombre;

    @Column (
        length = 255
    )
    @Size(max = 255, message = "La descripcion no puede superar los 255 caracteres.")
    private String descripcion;

    @Column (
        nullable = false,
        precision = 10,
        scale = 2 
    )
    @NotNull (message = "El precio es obligatorio.")
    @Positive (message = "EL precio no puede ser negativo.")
    private BigDecimal precio;

    @Column (
        nullable = false
    )
    @NotNull (message = "El stock es obligatorio")
    @PositiveOrZero (message = "El stock debe ser igual o mayor a 0.")
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

    public Categoria getCategoria() {
        return this.categoria;
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
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

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
