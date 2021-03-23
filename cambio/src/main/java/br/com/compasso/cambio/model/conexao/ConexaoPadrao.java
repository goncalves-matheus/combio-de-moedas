package br.com.compasso.cambio.model.conexao;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class ConexaoPadrao extends Conexao {

    public HttpURLConnection novaConexao() throws IOException {
        return conectar(new URL("http://data.fixer.io/api/latest?access_key="+CHAVE+SIMBOLOS_E_BASE));
    }

    @Override
    public HttpURLConnection novaConexao(String s) throws IOException{
        return novaConexao();
    }
}