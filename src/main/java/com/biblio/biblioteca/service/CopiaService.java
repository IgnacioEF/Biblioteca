package com.biblio.biblioteca.service;

import com.biblio.biblioteca.model.Copia;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CopiaService {
    List<Copia> getAllCopia();
    void saveCopia(Copia copia);
    Copia getCopiaById(Long id);
    void deleteCopiaById(Long id);
    Page<Copia> findPaginated(int pageNum, int pageSize, String sortField, String sortDirection);
}
