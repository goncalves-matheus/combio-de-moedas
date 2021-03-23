package br.com.compasso.cambio.model.conexao;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Conecta {
    String link = "http://data.fixer.io/api/latest?access_key=7a7f3df0f7897970a918489630acfa5e&symbols=USD,BRL,BTC&base=EUR";

    public HttpURLConnection conectar() throws IOException{
        URL url = new URL(link);
        HttpURLConnection conexao = (HttpURLConnection)url.openConnection();

        conexao.setRequestMethod("GET");
        conexao.setRequestProperty("Accept", "application/json");
        return conexao;
    }

    public HttpURLConnection conectar(String data) throws IOException{
        try {
            DateTimeFormatter formatadorEntrada = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            DateTimeFormatter formatadorBrasil = DateTimeFormatter.ofPattern("dd/MM/yyyy");

            LocalDate dataLimite = LocalDate.of(2012, 12, 30);
            LocalDate dataAProcurar = LocalDate.parse(data,formatadorBrasil);
            if(dataAProcurar.isBefore(dataLimite)){
                return conectar();
            }
            URL url = new URL("http://data.fixer.io/api/"+dataAProcurar.format(formatadorEntrada)+"?access_key=7a7f3df0f7897970a918489630acfa5e&symbols=USD,BRL,BTC&base=EUR");
            HttpURLConnection conexao = (HttpURLConnection)url.openConnection();
    
            conexao.setRequestMethod("GET");
            conexao.setRequestProperty("Accept", "application/json");
            return conexao;
        } catch (Exception e) {
            return conectar();
        }
    }

    public HttpURLConnection conectarNovaMoeda(String novaMoeda) throws IOException{
        try {
            URL url = new URL("http://data.fixer.io/api/latest?access_key=7a7f3df0f7897970a918489630acfa5e&symbols=USD,BRL,BTC,"+novaMoeda.toUpperCase() +"&base=EUR");
            HttpURLConnection conexao = (HttpURLConnection)url.openConnection();

            conexao.setRequestMethod("GET");
            conexao.setRequestProperty("Accept", "application/json");
            return conexao;
        } catch (Exception e) {
            return conectar();
        }
    }
}