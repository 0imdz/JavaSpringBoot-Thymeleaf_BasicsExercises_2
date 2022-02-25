package com.eep.controller;

import com.eep.entity.Perro;
import com.eep.service.PerroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@Controller
@RequestMapping("/veterinario")
public class PerroController {

    @Autowired
    @Qualifier("perroServiceImpl")
    private PerroService perroService;

    @GetMapping("/inicio")
    public String inicio(@ModelAttribute Perro perro,
                         Model model){

        model.addAttribute("perro", new Perro());

        model.addAttribute("listaPerros", perroService.mostrarPerros());
        return "inicio";
    }

    @PostMapping("/perroanyadido")
    public String subidaExitosa(@ModelAttribute("perro") Perro perro,
                                Model model){

        model.addAttribute("perro", perroService.anyadirPerro(perro));

        return "redirect:/veterinario/inicio";
    }

    @PostMapping("/borrar")
    public String borrar(@RequestParam("perrosSeleccionados") ArrayList<Integer> perrosSeleccionados){

        System.out.println(perrosSeleccionados);
        perroService.borrarPerros(perrosSeleccionados);
        return "redirect:/veterinario/inicio";
    }

    @GetMapping("/modificar/{id}")
    public String modificar(@PathVariable int id,
                            Model model){

        Optional<Perro> perro=perroService.buscarPerro(id);
        model.addAttribute("perroEnviado", perro);
        return "update";
    }

    @PostMapping("/editarperro")
    public String edicionHecha(@ModelAttribute("perro") Perro perro,
                               Model model){

        model.addAttribute("perro", perroService.editarPerro(perro));
        return "redirect:/veterinario/inicio";
    }
}
