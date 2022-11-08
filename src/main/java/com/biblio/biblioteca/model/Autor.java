package com.biblio.biblioteca.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;



@Entity
@Table(name="autor")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String nombre;

    @Column
    private String nacionalidad;

    @Column
    private Date fechaNacimiento;

    @OneToMany(mappedBy="autor", targetEntity=Libro.class, cascade=CascadeType.ALL)
    @Column
    private Set<Libro> librosPublicados = new HashSet<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Set<Libro> getLibrosPublicados() {
        return librosPublicados;
    }

    public void setLibrosPublicados(Set<Libro> librosPublicados) {
        this.librosPublicados = librosPublicados;
    }

    public Autor(long id, String nombre, String nacionalidad, Date fechaNacimiento, Set<Libro> librosPublicados) {
        this.id = id;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.fechaNacimiento = fechaNacimiento;
        this.librosPublicados = librosPublicados;
    }

    public Autor(){

    }
}
