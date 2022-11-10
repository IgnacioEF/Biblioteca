package com.biblio.biblioteca.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="multa")
public class Multa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column
    Date fInicio;

    @Column
    Date fFin;

    @JoinColumn
    @OneToOne(mappedBy="multa", targetEntity=Lector.class)
    private Lector lector;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getfInicio() {
        return fInicio;
    }

    public void setfInicio(Date fInicio) {
        System.out.println("fecha de incio que se intenta meter " + fInicio);
        this.fInicio = fInicio;
    }

    public Date getfFin() {
        return fFin;
    }

    public void setfFin(Date fFin) {
        System.out.println("fecha de final que se intenta meter " + fFin);
        this.fFin = fFin;
    }

    public Multa() {
        this.fInicio = new Date();
        this.fFin = new Date();
    }

    public Multa(Long id, Date fInicio, Date fFin) {
        this.id = id;
        this.fInicio = fInicio;
        this.fFin = fFin;
    }

    public String getLector() {
        return lector.getNombre();
    }

    public void setLector(Lector lector) {
        this.lector = lector;
        this.lector.setMultado(true);
        this.lector.setMulta(this);
    }
}
