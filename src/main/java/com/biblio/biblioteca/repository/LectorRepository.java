package com.biblio.biblioteca.repository;

import com.biblio.biblioteca.model.Lector;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LectorRepository extends JpaRepository<Lector, Long> {
}
