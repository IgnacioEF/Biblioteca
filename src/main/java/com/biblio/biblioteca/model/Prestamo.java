package com.biblio.biblioteca.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="prestamo")
public class Prestamo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column
    LocalDate inicio;

    @Column
    LocalDate fin;

    @JoinColumn
    @ManyToOne(fetch=FetchType.LAZY)
    private Lector lector;

    @JoinColumn
    @OneToOne(mappedBy="prestamo", targetEntity=Copia.class, cascade=CascadeType.ALL)
    private Copia copia;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getInicio() {
        return inicio;
    }

    public void setInicio(LocalDate inicio) {
        this.inicio = inicio;
    }

    public LocalDate getFin() {
        return fin;
    }

    public void setFin(LocalDate fin) {
        this.fin = fin;
    }

    public Prestamo(Long id, LocalDate inicio, LocalDate fin) {
        this.id = id;
        this.inicio = inicio;
        this.fin = fin;
    }

    public Prestamo(){

    }
}
