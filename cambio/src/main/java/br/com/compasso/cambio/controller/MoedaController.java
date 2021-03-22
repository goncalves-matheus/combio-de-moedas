package br.com.compasso.cambio.controller;

import java.io.IOException;

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
            model.addAttribute(ManipulaJson.lerJsonNovaMoeda(buscarMoeda));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "cotacao";
    } 
}
