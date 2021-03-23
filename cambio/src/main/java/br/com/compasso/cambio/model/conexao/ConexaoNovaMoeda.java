package br.com.compasso.cambio.model.conexao;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class ConexaoNovaMoeda extends Conexao {

    @Override
    public HttpURLConnection novaConexao(String novaMoeda) throws IOException{
        try {
            return conectar(new URL("http://data.fixer.io/api/latest?access_key="+CHAVE+"&symbols=USD,BRL,BTC,"+novaMoeda+"&base=EUR"));
        } catch (Exception e) {
            return conectar(new URL("http://data.fixer.io/api/latest?access_key="+CHAVE+SIMBOLOS_E_BASE));
        }
    }
}
