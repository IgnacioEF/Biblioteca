package com.biblio.biblioteca.service;


import com.biblio.biblioteca.model.Prestamo;
import com.biblio.biblioteca.repository.PrestamoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PrestamoServiceImp implements PrestamoService{
    @Autowired
    private PrestamoRepository prestamoRepository;


    @Override
    public List<Prestamo> getAllPrestamos() {
        return prestamoRepository.findAll();
    }

    @Override
    public void savePrestamo(Prestamo prestamo) {
        prestamoRepository.save(prestamo);
    }

    @Override
    public Prestamo getPrestamoById(Long id) {
        Optional<Prestamo> opPrestamo = prestamoRepository.findById(id);
        Prestamo prestamo;
        if(opPrestamo.isPresent()){
            prestamo = opPrestamo.get();
        }else {
            throw new RuntimeException("el libro no se encontro");
        }
        return prestamo;
    }

    @Override
    public void deletePrestamoById(Long id) {
        prestamoRepository.deleteById(id);
    }

    @Override
    public Page<Prestamo> findPaginated(int pageNum, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ?
                Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();
        Pageable pageable= PageRequest.of(pageNum-1, pageSize, sort);
        return this.prestamoRepository.findAll(pageable);
    }
}
