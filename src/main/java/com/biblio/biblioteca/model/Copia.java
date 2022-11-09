package com.biblio.biblioteca.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="copia")
public class Copia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private EstadoCopia estado;

    @JoinColumn
    @ManyToOne(fetch= FetchType.EAGER, cascade=CascadeType.MERGE)
    private Libro libro;

    @JoinColumn
    @OneToOne
    private Prestamo prestamo;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public EstadoCopia getEstado() {
        return estado;
    }

    public void setEstado(EstadoCopia estado) {
        this.estado = estado;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public Prestamo getPrestamo() {
        return prestamo;
    }

    public void setPrestamo(Prestamo prestamo) {
        this.prestamo = prestamo;
    }

    public Copia(){

    }

    public Copia(long id, EstadoCopia estado, Libro libro, Prestamo prestamo) {
        this.id = id;
        this.estado = estado;
        this.libro = libro;
        this.prestamo = prestamo;
    }
}
