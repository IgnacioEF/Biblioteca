package com.biblio.biblioteca.controller;

import com.biblio.biblioteca.model.Lector;
import com.biblio.biblioteca.model.Multa;
import com.biblio.biblioteca.service.LectorService;
import com.biblio.biblioteca.service.MultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MultaController {


    @Autowired
    MultaService multaService;
    @Autowired
    LectorService lectorService;
    @GetMapping("/multas")
    public String viewHomePage(Model model){

        return findPaginated(1, "id", "asc", model);
    }

    @GetMapping("/multas/page/{pageNo}")
    public String findPaginated(@PathVariable(value="pageNo") int pageNo,
                                @RequestParam("sortField") String sortField,
                                @RequestParam("sortDir") String sortDir,
                                Model model){
        int pageSize=4;
        Page<Multa> page = multaService.findPaginated(pageNo, pageSize, sortField, sortDir) ;
        List<Multa> listMulta=page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ?
                "decs" : "asc");
        model.addAttribute("listMulta", listMulta);

        return "multas";
    }

    @PostMapping("/multas/save")
    public String saveMulta(@ModelAttribute("id") Multa m){
        this.multaService.saveMulta(m);
        return "redirect:/multas";
    }

    @GetMapping("/multas/delete/{id}")
    public String deleteMulta(@PathVariable(value="id") long id, Model model){
        this.multaService.deleteMultaById(id);
        return "redirect:/multas";
    }

   /* @GetMapping("/lectores/update/{id}")
    public String showFormUpdate(@PathVariable(value="id") long id, Model model){
        Multa multa = multaService.getMultaById(id);
        model.addAttribute("lector", multa);
        return "actualizar_lector";
    } */

    @GetMapping("/multas/add")
    public String showNewForm(Model model) {
        Multa multa = new Multa();
        multa.setLector(new Lector());
        List<Lector> listLector = lectorService.getAllLector();
        model.addAttribute("multa", multa);
        model.addAttribute("listLector", listLector);
        return "nueva_multa";
    }

}
