package com.biblio.biblioteca.controller;


import com.biblio.biblioteca.model.Lector;
import com.biblio.biblioteca.service.LectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LectorController2 {

    @Autowired private LectorService lectorService;

    //Save
/*
    @PostMapping("/lectores")
    public Lector saveLector(@Validated @RequestBody Lector lector){
       //El metodo no devuelve un lector, hay que cambiar el servicio
        return lectorService.saveLector(lector);

    }
*/
    //READ
    //@GetMapping("/lectores")
    public List<Lector> lectorList(){
        return lectorService.getAllLector();
    }

    //Update





}
