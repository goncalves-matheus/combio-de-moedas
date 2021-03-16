package br.com.compasso.cambio;

import br.com.compasso.cambio.conexao.Conecta;
import br.com.compasso.cambio.manipulacao.Cotacao;
import br.com.compasso.cambio.manipulacao.ManipulaJson;

import java.io.IOException;

public class TesteConexao {
    public static void main(String[] args) {
        try {
            Cotacao cotacao = ManipulaJson.lerJson();
            System.out.println(cotacao.getBase());
            System.out.println(cotacao.getData());
            System.out.println(cotacao.getBitcoin());
            System.out.println(cotacao.getDolar());
            System.out.println(cotacao.getReal());
        } catch (IOException e) {
            e.printStackTrace();
        }        
    }
}
