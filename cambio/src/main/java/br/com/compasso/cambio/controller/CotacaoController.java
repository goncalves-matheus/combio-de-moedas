package br.com.compasso.cambio.controller;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.compasso.cambio.model.json.JsonBuscarData;
import br.com.compasso.cambio.model.json.JsonPadrao;

@Controller
@RequestMapping("/cotacao")
public class CotacaoController {
    
    @GetMapping
    public String listar(Model model){
         try {
            model.addAttribute(new JsonPadrao().novaLeitura());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "cotacao";
    }
    @PostMapping()
    public String procurar(String buscarData, Model model){
        try {
            model.addAttribute(new JsonBuscarData().novaLeitura(buscarData));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "cotacao";
    }
}
