package br.com.compasso.cambio.model.json;

import java.io.IOException;

import org.json.JSONObject;

import br.com.compasso.cambio.model.Cotacao;
import br.com.compasso.cambio.model.conexao.ConexaoNovaData;

public class JsonBuscarData extends LeiuraJsonDaApi{

    @Override
    public Cotacao novaLeitura(String buscarData) throws IOException {
        return lerJson(new ConexaoNovaData().novaConexao(buscarData));
    }

    @Override
    protected Cotacao criarObjetoCotacao(JSONObject json, JSONObject ratesJson) {
        return new Cotacao(ratesJson.getDouble("USD"), ratesJson.getDouble("BRL"), 
                            ratesJson.getDouble("BTC"), json.getString("date"));
    }
}
