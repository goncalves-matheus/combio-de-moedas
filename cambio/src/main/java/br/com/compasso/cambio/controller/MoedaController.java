package br.com.compasso.cambio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.compasso.cambio.model.manipula.ManipulaJson;

@Controller
@RequestMapping("moeda")
public class MoedaController {

    @PostMapping()
    public String procurarMoeda(String buscarMoeda, Model model){
        try {
            model.addAttribute(ManipulaJson.lerJsonPaises(buscarMoeda));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "cotacao";
    } 
}
