package br.com.compasso.cambio.model.manipula;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

import org.json.JSONArray;
import org.json.JSONObject;

import br.com.compasso.cambio.model.conexao.ConexaoNovaData;
import br.com.compasso.cambio.model.conexao.ConexaoNovaMoeda;
import br.com.compasso.cambio.model.conexao.ConexaoPadrao;

public class ManipulaJson {

    private ManipulaJson(){
        throw new IllegalStateException("Utility class");
    }
    
    public static Cotacao lerJson() throws IOException{
        return criarObjetoCotacao(new ConexaoPadrao().novaConexao());
    }

    public static Cotacao lerJson(String buscarData) throws IOException{
        return criarObjetoCotacao(new ConexaoNovaData().novaConexao(buscarData));
    }

    public static Cotacao lerJsonNovaMoeda(String buscarMoeda) throws IOException {
        try{
            HttpURLConnection novaConexao = new ConexaoNovaMoeda().novaConexao(buscarMoeda);
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

    public static Cotacao lerJsonPaises(String nomePais) throws IOException {
        try {
            BufferedReader entrada = new BufferedReader(new FileReader("cambio/src/main/resources/country-by-currency-code.json"));
            StringBuilder resposta = new StringBuilder();

            String linha;
            while ((linha = entrada.readLine()) != null) {
                resposta.append(linha);
            }

            entrada.close();

            JSONArray arrayDePaises = new JSONArray(resposta.toString());
        
            for(int i = 0; i < arrayDePaises.length(); i ++){
                JSONObject objeto = arrayDePaises.getJSONObject(i);
                if(nomePais.equals(objeto.getString("country"))){
                    return lerJsonNovaMoeda(objeto.getString("currency_code"));
                }
            }
            return lerJson();
        } catch (Exception e) {
            lerJson();
            return lerJson();  
        } 
    }
}