package br.com.compasso.cambio.model.conexao;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class Conecta {
    String link = "http://data.fixer.io/api/latest?access_key=7a7f3df0f7897970a918489630acfa5e&symbols=USD,BRL,BTC&base=EUR";

    public HttpURLConnection conectar() throws IOException{
        URL url = new URL(link);
        HttpURLConnection conexao = (HttpURLConnection)url.openConnection();

        conexao.setRequestMethod("GET");
        conexao.setRequestProperty("Accept", "application/json");
        return conexao;
    }
}