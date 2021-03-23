package br.com.compasso.cambio.model.conexao;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public abstract class Conexao {
    protected static final String SIMBOLOS_E_BASE = "&symbols=USD,BRL,BTC&base=EUR";
    protected static final String CHAVE = "7a7f3df0f7897970a918489630acfa5e";

    public abstract HttpURLConnection novaConexao(String s) throws IOException;

    protected HttpURLConnection conectar(URL url) throws IOException{
        HttpURLConnection conexao = (HttpURLConnection)url.openConnection();
        conexao.setRequestMethod("GET");
        conexao.setRequestProperty("Accept", "application/json");
        return conexao;
    }
}