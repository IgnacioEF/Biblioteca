package com.biblio.biblioteca.controller;

import com.biblio.biblioteca.model.Autor;
import com.biblio.biblioteca.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AutorController {
    @Autowired
    private AutorService autorService;

    @GetMapping("/autores")
    public String viewHomePage(Model model){

        return findPaginated(1, "nombre", "asc", model);
    }

    @GetMapping("/autores/page/{pageNo}")
    public String findPaginated(@PathVariable(value="pageNo") int pageNo,
                                @RequestParam("sortField") String sortField,
                                @RequestParam("sortDir") String sortDir,
                                Model model){
        int pageSize=4;
        Page<Autor> page = autorService.findPaginated(pageNo, pageSize, sortField, sortDir) ;
        List<Autor> listAutor=page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ?
                "decs" : "asc");
        model.addAttribute("listAutor", listAutor);

        return "autores";
    }
/*
    @PostMapping("/autores/save")
    public String saveAutor(@ModelAttribute("nombre") Autor a){
        this.autorService.saveAutor(a);
        return "redirect:/";
    }

    @GetMapping("/autores/delete/{id}")
    public String deleteAutor(@PathVariable(value="id") long id, Model model){
        this.autorService.deleteAutorById(id);
        return "redirect:/";
    }

    @GetMapping("/autores/update/{id}")
    public String showFormUpdate(@PathVariable(value="id") long id, Model model){
        Autor autor = autorService.getAutorById(id);
        model.addAttribute("autor", autor);
        return "actualizar_autor";
    }

    @GetMapping("/autores/add")
    public String showNewForm(Model model) {
        Autor a = new Autor();
        model.addAttribute("autor", a);
        return "nuevo_autor";
    }*/
}
