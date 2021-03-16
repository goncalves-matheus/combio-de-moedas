package br.com.compasso.cambio.manipulacao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

import org.json.JSONObject;

import br.com.compasso.cambio.conexao.Conecta;

public class ManipulaJson {
    
    public static Cotacao lerJson() throws IOException{
        HttpURLConnection novaConexao = new Conecta().conectar();
        BufferedReader entrada = new BufferedReader(new InputStreamReader(novaConexao.getInputStream()));
    
        StringBuilder resposta = new StringBuilder();

        String linha;
        while ((linha = entrada.readLine()) != null) {
            resposta.append(linha);
        }

        entrada.close();

        JSONObject json = new JSONObject(resposta.toString());
        JSONObject ratesJson = new JSONObject(json.getJSONObject("rates").toString());
        
        Cotacao cotacao = new Cotacao(ratesJson.getDouble("USD"), ratesJson.getDouble("BRL"), ratesJson.getDouble("BTC"),
                                         json.getString("base"), json.getString("date"));
        novaConexao.disconnect();
        return cotacao;
    }
}