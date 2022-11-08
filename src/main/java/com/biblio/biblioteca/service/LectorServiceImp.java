package com.biblio.biblioteca.service;

import com.biblio.biblioteca.model.Lector;
import com.biblio.biblioteca.repository.LectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LectorServiceImp implements LectorService{

    @Autowired
    private LectorRepository lectorRepository;

    @Override
    public List<Lector> getAllLector() {
        return lectorRepository.findAll();
    }

    @Override
    public void saveLector(Lector lector) {
        lectorRepository.save(lector);
    }

    @Override
    public Lector getLectorById(Long id) {
        Optional<Lector> opLector = lectorRepository.findById(id);
        Lector lector;
        if(opLector.isPresent()){
            lector = opLector.get();
        }else {
            throw new RuntimeException("el lector no se encontro");
        }
        return lector;
    }

    @Override
    public void deleteLectorById(Long id) {
        lectorRepository.deleteById(id);
    }

    @Override
    public Page<Lector> findPaginated(int pageNum, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ?
                Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();
        Pageable pageable= PageRequest.of(pageNum-1, pageSize, sort);
        return this.lectorRepository.findAll(pageable);
    }


}
