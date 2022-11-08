package com.biblio.biblioteca.service;


import com.biblio.biblioteca.model.Autor;
import com.biblio.biblioteca.repository.AutorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutorServiceImp implements AutorService{
    @Autowired
    private AutorRepository autorRepository;


    @Override
    public List<Autor> getAllAutor() {
        return autorRepository.findAll();
    }

    @Override
    public void saveAutor(Autor libro) {
        autorRepository.save(libro);
    }

    @Override
    public Autor getAutorById(Long id) {
        Optional<Autor> opAutor = autorRepository.findById(id);
        Autor autor;
        if(opAutor.isPresent()){
            autor = opAutor.get();
        }else {
            throw new RuntimeException("el autor no se encontro");
        }
        return autor;
    }

    @Override
    public void deleteAutorById(Long id) {
        autorRepository.deleteById(id);
    }

    @Override
    public Page<Autor> findPaginated(int pageNum, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ?
                Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();
        Pageable pageable= PageRequest.of(pageNum-1, pageSize, sort);
        return this.autorRepository.findAll(pageable);
    }
}
