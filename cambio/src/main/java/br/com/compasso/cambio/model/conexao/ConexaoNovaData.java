package br.com.compasso.cambio.model.conexao;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ConexaoNovaData extends Conexao{

    @Override
    public HttpURLConnection novaConexao(String data) throws IOException{
        try {
            DateTimeFormatter formatadorEntrada = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            DateTimeFormatter formatadorBrasil = DateTimeFormatter.ofPattern("dd/MM/yyyy");

            LocalDate dataLimite = LocalDate.of(2012, 12, 30);
            LocalDate dataAProcurar = LocalDate.parse(data,formatadorBrasil);
            
            if(dataAProcurar.isBefore(dataLimite)){  
                return conectar(new URL("http://data.fixer.io/api/latest?access_key="+CHAVE+SIMBOLOS_E_BASE));
            }
            return conectar(new URL("http://data.fixer.io/api/"+dataAProcurar.format(formatadorEntrada)+"?access_key="+CHAVE+SIMBOLOS_E_BASE));
        } catch (Exception e) {
            return conectar(new URL("http://data.fixer.io/api/latest?access_key="+CHAVE+SIMBOLOS_E_BASE));
        }
    }
}
