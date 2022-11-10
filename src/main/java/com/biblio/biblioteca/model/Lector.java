package com.biblio.biblioteca.model;


import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Entity
@Table(name="lector")
public class Lector{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String direccion;

    @Column
    private String nombre;

    @Column
    private String telefono;

    private Boolean multado;

    @Column
    @OneToMany(mappedBy="lector", targetEntity=Prestamo.class, cascade=CascadeType.MERGE ,fetch= FetchType.EAGER)
    private Set<Prestamo> prestamo = new HashSet<>();

    @JoinColumn
    @OneToOne
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
        return this.multa;
    }

    public void setMulta(Multa multa) {
        this.multa = multa;
    }

    public Lector(){
        this.multado=false;
        this.multa = new Multa(0L, new Date(), new Date());
    }

    public Lector(Long id, String direccion, String nombre, String telefono, Boolean multado) {
        this.id = id;
        this.direccion = direccion;
        this.nombre = nombre;
        this.telefono = telefono;
        this.multado=multado;
        this.multa = new Multa(0L, new Date(), new Date());

    }

    public Boolean getMultado() {
        return multado;
    }

    public void setMultado(Boolean multado) {
        this.multado = multado;
    }
}
