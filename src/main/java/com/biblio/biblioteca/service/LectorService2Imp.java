package com.biblio.biblioteca.service;

import com.biblio.biblioteca.model.Lector;
import com.biblio.biblioteca.repository.LectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service

public class LectorService2Imp implements LectorService2 {

    @Autowired
    private LectorRepository lectorRepository;

    @Override
    public Lector saveLector(Lector lector){
        return lectorRepository.save(lector);
    }

    @Override
    public List<Lector> lectoresList() {
        return (List<Lector>) lectorRepository.findAll();
    }

    @Override
    public Lector updateLector(Lector lector, Long lectorId) {
        Lector lec= lectorRepository.findById(lectorId).get();

        //Comprobaciones
        if (Objects.nonNull(lector.getNombre())
                && !"".equalsIgnoreCase(
                lector.getNombre())) {
            lec.setNombre(
                    lector.getNombre());
        }

        if (Objects.nonNull(
                lector.getTelefono())
                && !"".equalsIgnoreCase(
                lector.getTelefono())) {
            lec.setTelefono(
                    lector.getTelefono());
        }

        if (Objects.nonNull(lector.getDireccion())
                && !"".equalsIgnoreCase(
                lector.getDireccion())) {
            lec.setDireccion(
                    lector.getDireccion());
        }
        return lectorRepository.save(lec);

    }


    @Override
    public void deleteLectorById(Long lectorId) {
    lectorRepository.deleteById(lectorId);
    }


}



