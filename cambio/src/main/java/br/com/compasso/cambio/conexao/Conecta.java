/* 
* Crie uma aplicação, utilizando a linguagem Java e o framework Spring Boot, para buscar os 
* valores atualizados em tempo real do Bitcoin, Dólar e Euro e exibir o resultado para o usuário.
 */
package br.com.compasso.cambio.conexao;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class Conecta {

    //String link = "http://data.fixer.io/api/latest?access_key=c8d07190c602ddb54470123b47b5c554&base=EUR";
    String link = "http://data.fixer.io/api/latest?access_key=c8d07190c602ddb54470123b47b5c554&symbols=USD,BRL,BTC&base=EUR";

    public HttpURLConnection conectar() throws IOException{
        URL url = new URL(link);
        HttpURLConnection conexao = (HttpURLConnection)url.openConnection();

        conexao.setRequestMethod("GET");
        conexao.setRequestProperty("Accept", "application/json");
        return conexao;
    }
    void desconectar(HttpURLConnection conexao){
        conexao.disconnect();
    }
}