package com.biblio.biblioteca.service;

import com.biblio.biblioteca.model.Lector;
import com.biblio.biblioteca.model.Libro;
import com.biblio.biblioteca.repository.LectorRepository;
import com.biblio.biblioteca.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
public class LibroServiceImp implements LibroService{

    @Autowired
    private LibroRepository libroRepository;


    @Override
    public List<Libro> getAllLibros() {
        return libroRepository.findAll();
    }

    @Override
    public void saveLibro(Libro libro) {
        libroRepository.save(libro);
    }

    @Override
    public Libro getLibroById(Long id) {
        Optional<Libro> opLibro = libroRepository.findById(id);
        Libro libro;
        if(opLibro.isPresent()){
            libro = opLibro.get();
        }else {
            throw new RuntimeException("el libro no se encontro");
        }
        return libro;
    }

    @Override
    public void deleteLibroById(Long id) {
        libroRepository.deleteById(id);
    }

    @Override
    public Page<Libro> findPaginated(int pageNum, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ?
                Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();
        Pageable pageable= PageRequest.of(pageNum-1, pageSize, sort);
        return this.libroRepository.findAll(pageable);
    }
}
