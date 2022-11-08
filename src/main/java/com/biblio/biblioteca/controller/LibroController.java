package com.biblio.biblioteca.controller;

import com.biblio.biblioteca.model.Libro;
import com.biblio.biblioteca.repository.LibroRepository;
import com.biblio.biblioteca.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller

public class LibroController {
    @Autowired
    private LibroService libroService;

    @GetMapping("/libros")
    public String viewHomePage(Model model){

        return findPaginated(1, "titulo", "asc", model);
    }

    @GetMapping("/librospage/{pageNo}")
    public String findPaginated(@PathVariable(value="pageNo") int pageNo,
                                @RequestParam("sortField") String sortField,
                                @RequestParam("sortDir") String sortDir,
                                Model model){
        int pageSize=4;
        Page<Libro> page = libroService.findPaginated(pageNo, pageSize, sortField, sortDir) ;
        List<Libro> listLibro=page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ?
                "decs" : "asc");
        model.addAttribute("listLibro", listLibro);


        return "libros";
    }

    @PostMapping("/libros/save")
    public String saveLibro(@ModelAttribute("titulo") Libro l){
        this.libroService.saveLibro(l);
        return "redirect:/";
    }

    @GetMapping("/libros/delete/{isbn}")
    public String deleteLibro(@PathVariable(value="ibsn") long id, Model model){
        this.libroService.deleteLibroById(id);
        return "redirect:/";
    }

    @GetMapping("/libros/update/{isbn}")
    public String showFormUpdate(@PathVariable(value="isbn") long id, Model model){
        Libro libro = libroService.getLibroById(id);
        model.addAttribute("libro", libro);
        return "actualizar_libro";
    }

    @GetMapping("/libros/add")
    public String showNewForm(Model model) {
        Libro l = new Libro();
        model.addAttribute("libro", l);
        return "nuevo_libro";
    }
}
