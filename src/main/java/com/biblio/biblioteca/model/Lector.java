package com.biblio.biblioteca.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="lector")
public class Lector{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column
    String direccion;

    @Column
    String nombre;

    @Column
    String telefono;

    @Column
    @OneToMany(mappedBy="lector", targetEntity=Prestamo.class)
    private Set<Prestamo> prestamo = new HashSet<>();

    @JoinColumn
    @OneToOne(mappedBy="lector", targetEntity=Multa.class)
    private Multa multa;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Set<Prestamo> getPrestamo() {
        return prestamo;
    }

    public void setPrestamo(Set<Prestamo> prestamo) {
        this.prestamo = prestamo;
    }

    public Multa getMulta() {
        return multa;
    }

    public void setMulta(Multa multa) {
        this.multa = multa;
    }

    public Lector(){

    }

    public Lector(Long id, String direccion, String nombre, String telefono) {
        this.id = id;
        this.direccion = direccion;
        this.nombre = nombre;
        this.telefono = telefono;
    }
}
