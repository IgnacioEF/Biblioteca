package com.biblio.biblioteca.service;

import com.biblio.biblioteca.model.Libro;
import com.biblio.biblioteca.model.Multa;

import java.util.List;

public interface MultaService {

    //Save multa
    List<Multa> getAllMultas();
    void saveMulta(Multa m);
    Multa getLibroById(Long id);
    void deleteLibroById(Long id);
    //Delete
}
