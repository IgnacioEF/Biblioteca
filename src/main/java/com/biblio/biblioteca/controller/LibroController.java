package com.biblio.biblioteca.controller;

import com.biblio.biblioteca.model.Autor;
import com.biblio.biblioteca.model.Libro;
import com.biblio.biblioteca.service.AutorService;
import com.biblio.biblioteca.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(method = {RequestMethod.POST, RequestMethod.GET,RequestMethod.DELETE,RequestMethod.PUT}, value = "/libros")

public class LibroController {
    @Autowired
    private LibroService libroService;
    @Autowired
    private AutorService autorService;

    @GetMapping()
    public String viewHomePage(Model model){

        return findPaginated(1, "titulo", "asc", model);
    }

    @GetMapping("/page/{pageNo}")
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
                "desc" : "asc");
        model.addAttribute("listLibro", listLibro);

        return "libros";
    }

    @PostMapping("/save")
    public String saveLibro(@ModelAttribute("isbn") Libro l){
        this.libroService.saveLibro(l);
        return "redirect:/";
    }

    @GetMapping("/delete/{isbn}")
    public String deleteLibro(@PathVariable(value="isbn") long id, Model model){
        this.libroService.deleteLibroById(id);
        return "redirect:/";
    }

    @GetMapping("/update/{isbn}")
    public String showFormUpdate(@PathVariable(value="isbn") long id, Model model){
        Libro libro = libroService.getLibroById(id);
        model.addAttribute("libro", libro);
        return "actualizar_libro";
    }

    @GetMapping("/add")
    public String showNewForm(Model model) {
        Libro l = new Libro();
        List<Autor> listAutor=  autorService.getAllAutor();
        model.addAttribute("libro", l);
        model.addAttribute("listAutor", listAutor);

        return "nuevo_libro";
    }
}
