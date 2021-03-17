package br.com.compasso.cambio.controller;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.compasso.cambio.model.manipula.ManipulaJson;

@Controller
@RequestMapping("/cotacao")
public class CotacaoController {
    
    @GetMapping
    public String listar(Model model){
         try {
            model.addAttribute(ManipulaJson.lerJson());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "cotacao";
    }
}
