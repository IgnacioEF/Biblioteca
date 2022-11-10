package com.biblio.biblioteca.repository;

import com.biblio.biblioteca.model.Copia;
import com.biblio.biblioteca.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CopiaRepository extends JpaRepository<Copia, Long> {
}
