package com.biblio.biblioteca.repository;

import com.biblio.biblioteca.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {

}
