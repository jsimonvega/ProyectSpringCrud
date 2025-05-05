package com.example.ProyectSpring.web;

import com.example.ProyectSpring.domain.Individuo;
import com.example.ProyectSpring.service.IndividuoService;
import jakarta.validation.Valid;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@Slf4j
public class MainController {
    
    @Autowired
    
    private IndividuoService individuoService;
    
    @GetMapping("/")
    public String welcome(@RequestParam(defaultValue = "es") String lang,Model model){
        
        List<Individuo> individuos = individuoService.listarIndividuos();
        
        model.addAttribute("individuos", individuos);
        model.addAttribute("lang", lang);
        return "indice";
    }
    
    @GetMapping("/nuevo")
    public String nuevo(Individuo individuo){                
        return "frmIndividuo";
    }
    
    @PostMapping("/grabar")
    public String grabar(@Valid Individuo individuo, Errors error){
        if(error.hasErrors()){
            return "frmIndividuo";
        }
        individuoService.guardar(individuo);
        return "redirect:/";
    }
    
    @GetMapping("/editar/{id}")
    public String editar(Individuo individuo, Model model){
        individuo = individuoService.localizarIndividuo(individuo.getId());
        model.addAttribute(individuo);
        return "frmIndividuo";
    }
    
    @GetMapping("/eliminar/{id}")
    public String eliminar(Individuo individuo){
        individuoService.eliminar(individuo);
        return "redirect:/";
    }
}
