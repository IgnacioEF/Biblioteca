package com.biblio.biblioteca.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="prestamo")
public class Prestamo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column
    Date inicio;

    @Column
    Date fin;

    @JoinColumn
    @ManyToOne(fetch= FetchType.EAGER, cascade=CascadeType.MERGE)
    private Lector lector;

    @JoinColumn
    @OneToOne
    private Copia copia;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Date getFin() {
        return fin;
    }

    public void setFin(Date fin) {
        this.fin = fin;
    }

    public Prestamo(Long id, LocalDate inicio, LocalDate fin) {
        this.id = id;
        this.inicio = inicio;
        this.fin = fin;
        this.lector = new Lector();
        this.copia = new Copia();
    }

    public Prestamo(){
        this.lector = new Lector();
        this.copia = new Copia();
    }

    public String getLector() {
        return lector.getNombre();
    }

    public void setLector(Long id) {
        this.lector.setId(id);
    }

    public String getCopia() {
        return copia.getLibro().getTitulo();
    }

    public void setCopia(Long id) {
        this.copia.setId(id);
    }
}
