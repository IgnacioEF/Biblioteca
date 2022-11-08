package com.biblio.biblioteca.service;

import com.biblio.biblioteca.model.Autor;
import org.springframework.data.domain.Page;

import java.util.List;

public interface AutorService {
    List<Autor> getAllAutor();
    void saveAutor(Autor autor);
    Autor getAutorById(Long id);
    void deleteAutorById(Long id);
    Page<Autor> findPaginated(int pageNum, int pageSize, String sortField, String sortDirection);
}
