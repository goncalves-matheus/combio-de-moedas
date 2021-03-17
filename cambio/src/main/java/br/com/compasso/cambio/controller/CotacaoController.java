package br.com.compasso.cambio.controller;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;

import br.com.compasso.cambio.manipulacao.Cotacao;
import br.com.compasso.cambio.manipulacao.ManipulaJson;

//@RestController
@Controller
@RequestMapping("/cotacao")
public class CotacaoController {
    
    @GetMapping
    public String listar(Model model){
         try {
            Cotacao cotacao = ManipulaJson.lerJson();
            model.addAttribute(cotacao);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "cotacao";
    }
}
