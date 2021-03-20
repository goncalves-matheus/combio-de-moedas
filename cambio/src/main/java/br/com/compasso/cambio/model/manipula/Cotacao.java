package br.com.compasso.cambio.model.manipula;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Cotacao {
    Double dolar;
    Double real;
    Double bitcoin;
    String base;
    String baseReal = "Real";
    LocalDate data;

    String bitcoinImagem = "https://s3.criptofacil.com/wp-content/uploads/2020/12/maior-gestora-mundo-diz-que-bitcoin-impactara-dolar.jpg";
    String realImagem = "https://exame.com/wp-content/uploads/2020/05/gettyimages-1196644462.jpg";
    String dolarImagem = "https://exame.com/wp-content/uploads/2020/11/dc2b4c3b3lar.jpg";

    private static final String FORMATODINHEIRO = "R$ %.2f";

    DateTimeFormatter formatadorEntrada = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    DateTimeFormatter formatadorBrasil = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Cotacao(Double dolar, Double real, Double bitcoin, String base, String data) {
        this.dolar = dolar;
        this.real = real;
        this.bitcoin = bitcoin;
        this.base = base;
        this.data = LocalDate.parse(data,formatadorEntrada);
    }

    public Double converteEmReal(Double valorAConverter){
        return (this.real/valorAConverter);
    }

    public String getDolar() {
        return  String.format(FORMATODINHEIRO,converteEmReal(this.dolar));
    }

    public String getReal() {
        return String.format(FORMATODINHEIRO,this.real);
    }

    public String getBitcoin() {
        return String.format(FORMATODINHEIRO,converteEmReal(this.bitcoin));
    }

    public String getBase() {
        return baseReal;
    }

    public String getData() {
        return data.format(formatadorBrasil);
    }

    public String getBitcoinImagem() {
        return bitcoinImagem;
    }
    public String getDolarImagem() {
        return dolarImagem;
    }
    public String getRealImagem() {
        return realImagem;
    }
}