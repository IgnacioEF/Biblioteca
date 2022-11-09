package com.biblio.biblioteca.controller;

import com.biblio.biblioteca.model.Lector;
import com.biblio.biblioteca.model.Libro;
import com.biblio.biblioteca.service.LectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class LectorController {
    @Autowired
    private LectorService lectorService;

    @GetMapping("/lectores")
    public String viewHomePage(Model model){

        return findPaginated(1, "nombre", "asc", model);
    }

    @GetMapping("/lectores/page/{pageNo}")
    public String findPaginated(@PathVariable(value="pageNo") int pageNo,
                                @RequestParam("sortField") String sortField,
                                @RequestParam("sortDir") String sortDir,
                                Model model){
        int pageSize=4;
        Page<Lector> page = lectorService.findPaginated(pageNo, pageSize, sortField, sortDir) ;
        List<Lector> listLector=page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ?
                "decs" : "asc");
        model.addAttribute("listLector", listLector);


        return "lectores";
    }

    @PostMapping("/lectores/save")
    public String saveLector(@ModelAttribute("id") Lector l){
        this.lectorService.saveLector(l);
        return "redirect:/";
    }

    @GetMapping("/lectores/delete/{id}")
    public String deleteLector(@PathVariable(value="id") long id, Model model){
        this.lectorService.deleteLectorById(id);
        return "redirect:/";
    }

    @GetMapping("/lectores/update/{id}")
    public String showFormUpdate(@PathVariable(value="id") long id, Model model){
        Lector lector = lectorService.getLectorById(id);
        model.addAttribute("lector", lector);
        return "redirect:/"; // corregir path de retorno
    }

    @GetMapping("/lectores/add")
    public String showNewForm(Model model) {
        Libro l = new Libro();
        model.addAttribute("libro", l);
        return "redirect:/"; // corregir path de retorno
    }
}
