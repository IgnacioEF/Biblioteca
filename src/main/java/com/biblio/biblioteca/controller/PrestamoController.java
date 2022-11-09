package com.biblio.biblioteca.controller;


import com.biblio.biblioteca.model.Autor;
import com.biblio.biblioteca.model.Libro;
import com.biblio.biblioteca.model.Prestamo;
import com.biblio.biblioteca.service.AutorService;
import com.biblio.biblioteca.service.LibroService;
import com.biblio.biblioteca.service.PrestamoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(method = {RequestMethod.POST, RequestMethod.GET,RequestMethod.DELETE,RequestMethod.PUT}, value = "/prestamos")

public class PrestamoController {
    @Autowired
    private PrestamoService prestamoService;

    @GetMapping()
    public String viewHomePage(Model model) {

        return findPaginated(1, "id", "asc", model);
    }

    @GetMapping("/page/{pageNo}")
    public String findPaginated(@PathVariable(value = "pageNo") int pageNo,
                                @RequestParam("sortField") String sortField,
                                @RequestParam("sortDir") String sortDir,
                                Model model) {
        int pageSize = 4;
        Page<Prestamo> page = prestamoService.findPaginated(pageNo, pageSize, sortField, sortDir);
        List<Prestamo> listPrestamo = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ?
                "desc" : "asc");
        model.addAttribute("listPrestamo", listPrestamo);

        return "prestamos";
    }

    @PostMapping("/save")
    public String savePrestamo(@ModelAttribute("id") Prestamo p) {
        this.prestamoService.savePrestamo(p);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteLibro(@PathVariable(value = "Id") long id, Model model) {
        this.prestamoService.deletePrestamoById(id);
        return "redirect:/";
    }

    @GetMapping("/update/{isbn}")
    public String showFormUpdate(@PathVariable(value="isbn") long id, Model model){
        Prestamo prestamo = prestamoService.getPrestamoById(id);
        model.addAttribute("libro", prestamo);
        return "actualizar_libro";
    }

    @GetMapping("/add")
    public String showNewForm(Model model) {
        Prestamo p = new Prestamo();
        model.addAttribute("prestamo", p);
        return "nuevo_prestamo";
    }
}