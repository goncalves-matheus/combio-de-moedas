package br.com.compasso.cambio.model.json;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONObject;

import br.com.compasso.cambio.model.Cotacao;

public class LeituraJsonListaDePaises {
    
    public Cotacao novaLeitura(String nomePais) throws IOException {
        try {
            BufferedReader entrada = new BufferedReader(new FileReader("cambio/src/main/resources/country-by-currency-code.json"));
            StringBuilder resposta = new StringBuilder();

            String linha;
            while ((linha = entrada.readLine()) != null) {
                resposta.append(linha);
            }

            entrada.close();

            JSONArray arrayDePaises = new JSONArray(resposta.toString());
        
            for(int i = 0; i < arrayDePaises.length(); i ++){
                JSONObject objeto = arrayDePaises.getJSONObject(i);
                if(nomePais.equalsIgnoreCase(objeto.getString("country"))){
                    return new JsonNovaMoeda().novaLeitura(objeto.getString("currency_code"));
                }
            }
            return new JsonPadrao().novaLeitura();
        } catch (Exception e) {
            return new JsonPadrao().novaLeitura();  
        } 
    }
}
