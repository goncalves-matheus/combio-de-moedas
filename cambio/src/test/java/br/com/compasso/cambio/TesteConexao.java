package br.com.compasso.cambio;

import java.io.IOException;

import br.com.compasso.cambio.manipulacao.Cotacao;
import br.com.compasso.cambio.manipulacao.ManipulaJson;

public class TesteConexao {
    public static void main(String[] args) {
        try {
            Cotacao cotacao = ManipulaJson.lerJson();
            System.out.println("Base: " + cotacao.getBase());
            System.out.println("Data: " + cotacao.getData());
            System.out.println("Bitcoin: " + cotacao.getBitcoin());
            System.out.println("Dolar: " + cotacao.getDolar());
            System.out.println("Real: " + cotacao.getReal());
        } catch (IOException e) {
            e.printStackTrace();
        }        
    }
}
