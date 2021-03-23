package br.com.compasso.cambio.model.json;

import java.io.IOException;

import org.json.JSONObject;

import br.com.compasso.cambio.model.Cotacao;
import br.com.compasso.cambio.model.conexao.ConexaoNovaMoeda;

public class JsonNovaMoeda extends LeiuraJsonDaApi{
    private String buscarMoeda;

    @Override
    public Cotacao novaLeitura(String buscarMoeda) throws IOException {
        this.buscarMoeda = buscarMoeda;
        return lerJson(new ConexaoNovaMoeda().novaConexao(buscarMoeda));
    }

    @Override
    protected Cotacao criarObjetoCotacao(JSONObject json, JSONObject ratesJson) {
        return new Cotacao(ratesJson.getDouble("USD"), ratesJson.getDouble("BRL"), ratesJson.getDouble("BTC"), 
        json.getString("date"), ratesJson.getDouble(this.buscarMoeda), this.buscarMoeda.toUpperCase());
    }
}
