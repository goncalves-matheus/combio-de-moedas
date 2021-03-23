package br.com.compasso.cambio.model.json;

import java.io.IOException;

import org.json.JSONObject;

import br.com.compasso.cambio.model.Cotacao;
import br.com.compasso.cambio.model.conexao.ConexaoPadrao;

public class JsonPadrao extends LeiuraJsonDaApi{

    public Cotacao novaLeitura() throws IOException {
        return lerJson(new ConexaoPadrao().novaConexao());
    }

    @Override
    public Cotacao novaLeitura(String buscar) throws IOException {
        return novaLeitura();
    }

    @Override
    protected Cotacao criarObjetoCotacao(JSONObject json, JSONObject ratesJson) {
        return new Cotacao(ratesJson.getDouble("USD"), ratesJson.getDouble("BRL"), 
                            ratesJson.getDouble("BTC"), json.getString("date"));
    }
    
}
