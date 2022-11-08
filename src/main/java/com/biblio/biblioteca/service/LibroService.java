package com.biblio.biblioteca.service;

import com.biblio.biblioteca.model.Libro;
import org.springframework.data.domain.Page;

import java.util.List;

public interface LibroService {
        List<Libro> getAllLibros();
        void saveLibro(Libro l);
        Libro getLibroById(Long id);
        void deleteLibroById(Long id);
        Page<Libro> findPaginated(int pageNum, int pageSize, String sortField, String sortDirection);

}
