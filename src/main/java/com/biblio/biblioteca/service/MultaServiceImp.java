package com.biblio.biblioteca.service;

import com.biblio.biblioteca.model.Lector;
import com.biblio.biblioteca.model.Multa;
import com.biblio.biblioteca.repository.MultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MultaServiceImp implements MultaService {

    @Autowired MultaRepository multaRepository;

    @Override
    public List<Multa> getAllMultas() {
        return multaRepository.findAll();
    }

    @Override
    public void saveMulta(Multa m) {
        multaRepository.save(m);
    }

    @Override
    public Multa getMultaById(Long id) {
        Optional<Multa> opMulta = multaRepository.findById(id);
        Multa multa;
        if(opMulta.isPresent()){
            multa = opMulta.get();
        }else {
            throw new RuntimeException("No se ha podido encontrar la multa, buen dia");
        }
        return multa;
    }

    @Override
    public void deleteMultaById(Long id) {
    multaRepository.deleteById(id);
    }

    @Override
    public Page<Multa> findPaginated(int pageNum, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ?
                Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();
        Pageable pageable= PageRequest.of(pageNum-1, pageSize, sort);
        return this.multaRepository.findAll(pageable);
    }
}
