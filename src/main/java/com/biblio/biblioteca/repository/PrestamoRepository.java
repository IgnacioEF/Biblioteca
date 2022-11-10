package com.biblio.biblioteca.repository;

import com.biblio.biblioteca.model.Prestamo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PrestamoRepository extends JpaRepository<Prestamo, Long> {

    /*@Query("FROM Prestamo WHERE Prestamo.lector = ?1")
    List<Prestamo> findPrestamoByIdLector(Long idLector);*/
}
