package com.biblio.biblioteca.service;

import com.biblio.biblioteca.model.Libro;
import com.biblio.biblioteca.model.Prestamo;
import org.springframework.data.domain.Page;

import java.util.List;

public interface PrestamoService {
    List<Prestamo> getAllPrestamos();
    void savePrestamo(Prestamo p);
    Prestamo getPrestamoById(Long id);
    void deletePrestamoById(Long id);
    Page<Prestamo> findPaginated(int pageNum, int pageSize, String sortField, String sortDirection);
}
