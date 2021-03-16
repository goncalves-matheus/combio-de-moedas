package br.com.compasso.cambio.conexao.controller;

import java.io.IOException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.compasso.cambio.manipulacao.Cotacao;
import br.com.compasso.cambio.manipulacao.ManipulaJson;

@RestController
@RequestMapping("/cotacao")
public class CotacaoController {
    
    @GetMapping
    public Cotacao listar(){
        try {
            return ManipulaJson.lerJson();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
