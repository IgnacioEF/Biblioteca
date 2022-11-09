package com.biblio.biblioteca.service;


import com.biblio.biblioteca.model.Lector;

import java.util.List;

public interface LectorService2 {

    //Save
    Lector saveLector(Lector lector);
    //Read
    List<Lector> lectoresList();
    //Update
    Lector updateLector(Lector lector, Long lectorId);

    void deleteLectorById(Long lectorId);

}
