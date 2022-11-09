package com.biblio.biblioteca.service;

import com.biblio.biblioteca.model.Lector;
import com.biblio.biblioteca.model.Libro;
import com.biblio.biblioteca.model.Multa;
import org.springframework.data.domain.Page;

import java.util.List;

public interface MultaService {

    //Save multa
    List<Multa> getAllMultas();
    void saveMulta(Multa m);
    Multa getMultaById(Long id);
    void deleteMultaById(Long id);

    Page<Multa> findPaginated(int pageNo, int pageSize, String sortField, String sortDir);
    //Delete
}
