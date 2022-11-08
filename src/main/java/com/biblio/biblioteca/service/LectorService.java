package com.biblio.biblioteca.service;

import com.biblio.biblioteca.model.Lector;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

public interface LectorService  {
        List<Lector> getAllLector();
        void saveLector(Lector lector);
        Lector getLectorById(Long id);
        void deleteLectorById(Long id);
        Page<Lector> findPaginated(int pageNum, int pageSize, String sortField, String sortDirection);

}
