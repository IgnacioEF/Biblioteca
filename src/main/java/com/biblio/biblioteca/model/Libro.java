package com.biblio.biblioteca.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="libro")
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long isbn;

    @Column
    private String titulo;

    @Column
    private TipoLibro tipo;

    @Column
    private String editorial;

    @Column
    private int anyo;

    @JoinColumn
    @ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.PERSIST)
    private Autor autor;

    @OneToMany(mappedBy="libro", targetEntity=Copia.class, cascade=CascadeType.ALL)
    @Column
    private Set<Copia> copia = new HashSet<>();


    public Long getIsbn() {
        return isbn;
    }

    public void setIsbn(Long isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public TipoLibro getTipo() {
        return tipo;
    }

    public void setTipo(TipoLibro tipo) {
        this.tipo = tipo;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public int getAnyo() {
        return anyo;
    }

    public void setAnyo(int anyo) {
        this.anyo = anyo;
    }

    public String getAutor(){
        return this.autor.getNombre();
    }

    public void setAutor(Long id) {
        this.autor.setId(id);
    }

    public Libro(Long isbn, String titulo, TipoLibro tipo, String editorial, int anyo) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.tipo = tipo;
        this.editorial = editorial;
        this.anyo = anyo;
        this.autor = new Autor();
    }

    public Libro(){
        this.autor = new Autor();
    }
}
