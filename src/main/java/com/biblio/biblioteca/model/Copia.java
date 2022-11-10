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
    @OneToOne(mappedBy="copia", fetch= FetchType.EAGER, cascade=CascadeType.MERGE)
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

    public String getLibro() {
        return libro.getTitulo();
    }

    public void setLibro(Long id) {
        this.libro.setIsbn(id);
    }

    public Prestamo getPrestamo() {
        return prestamo;
    }

    public void setPrestamo(Prestamo prestamo) {
        this.prestamo = prestamo;
    }

    public Copia(){
        this.libro = new Libro();
    }

    public Copia(long id, EstadoCopia estado, Libro libro) {
        this.id = id;
        this.estado = estado;
        this.libro = new Libro();
        this.prestamo = new Prestamo();
    }
}
