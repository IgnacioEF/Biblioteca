package com.biblio.biblioteca.service;



import com.biblio.biblioteca.model.Copia;

import com.biblio.biblioteca.repository.CopiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CopiaServiceImp implements CopiaService{
    @Autowired
    private CopiaRepository copiaRepository;


    @Override
    public List<Copia> getAllCopia() {
        return copiaRepository.findAll();
    }

    @Override
    public void saveCopia(Copia copia) {
        copiaRepository.save(copia);
    }

    @Override
    public Copia getCopiaById(Long id) {
        Optional<Copia> opCopia = copiaRepository.findById(id);
        Copia copia;
        if(opCopia.isPresent()){
            copia = opCopia.get();
        }else {
            throw new RuntimeException("el autor no se encontro");
        }
        return copia;
    }

    @Override
    public void deleteCopiaById(Long id) {
        copiaRepository.deleteById(id);
    }

    @Override
    public Page<Copia> findPaginated(int pageNum, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ?
                Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();
        Pageable pageable= PageRequest.of(pageNum-1, pageSize, sort);
        return this.copiaRepository.findAll(pageable);
    }
}
