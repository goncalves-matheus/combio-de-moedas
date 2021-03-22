package br.com.compasso.cambio.model.manipula;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

import org.json.JSONObject;

import br.com.compasso.cambio.model.conexao.Conecta;

public class ManipulaJson {
    
    public static Cotacao lerJson() throws IOException{
        return criarObjetoCotacao(new Conecta().conectar());
    }

    public static Cotacao lerJson(String buscarData) throws IOException{
        return criarObjetoCotacao(new Conecta().conectar(buscarData));
    }

    public static Cotacao lerJsonNovaMoeda(String buscarMoeda) throws IOException {
        try{
            HttpURLConnection novaConexao = new Conecta().conectarNovaMoeda(buscarMoeda);
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
                                        json.getString("date"), ratesJson.getDouble(buscarMoeda), buscarMoeda.toUpperCase());
            novaConexao.disconnect();
            return cotacao;
        } catch (Exception e) {
            return lerJson();
        }
        
    }

    private static Cotacao criarObjetoCotacao(HttpURLConnection novaConexao) throws IOException {
        BufferedReader entrada = new BufferedReader(new InputStreamReader(novaConexao.getInputStream()));
        StringBuilder resposta = new StringBuilder();

        String linha;
        while ((linha = entrada.readLine()) != null) {
            resposta.append(linha);
        }

        entrada.close();

        JSONObject json = new JSONObject(resposta.toString());
        JSONObject ratesJson = new JSONObject(json.getJSONObject("rates").toString());
        
        Cotacao cotacao = new Cotacao(ratesJson.getDouble("USD"), ratesJson.getDouble("BRL"), 
                                ratesJson.getDouble("BTC"), json.getString("date"));
        novaConexao.disconnect();
        return cotacao;
    }

}