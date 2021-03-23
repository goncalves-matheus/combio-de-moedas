package br.com.compasso.cambio.model.json;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

import org.json.JSONObject;

import br.com.compasso.cambio.model.Cotacao;

public abstract class LeiuraJsonDaApi {

    public abstract Cotacao novaLeitura(String buscar) throws IOException;

    protected abstract Cotacao criarObjetoCotacao(JSONObject json, JSONObject ratesJson);


    public Cotacao lerJson(HttpURLConnection novaConexao) throws IOException{
        StringBuilder resposta = criarStringBuilder(novaConexao);

        JSONObject json = new JSONObject(resposta.toString());
        JSONObject ratesJson = new JSONObject(json.getJSONObject("rates").toString());
        novaConexao.disconnect();

        return criarObjetoCotacao(json, ratesJson);
    }

    private StringBuilder criarStringBuilder(HttpURLConnection novaConexao) throws IOException {
        BufferedReader entrada = new BufferedReader(new InputStreamReader(novaConexao.getInputStream()));
        StringBuilder resposta = new StringBuilder();
   
        String linha;
        while ((linha = entrada.readLine()) != null) {
            resposta.append(linha);
        }
        entrada.close();
        return resposta;
    }
}
