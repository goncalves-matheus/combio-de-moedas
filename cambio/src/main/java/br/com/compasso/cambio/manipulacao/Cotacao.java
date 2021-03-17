package br.com.compasso.cambio.manipulacao;

public class Cotacao {
    Double dolar;
    Double real;
    Double bitcoin;
    String base;
    String data;
    String bitcoinImagem = "https://s3.criptofacil.com/wp-content/uploads/2020/12/maior-gestora-mundo-diz-que-bitcoin-impactara-dolar.jpg";
    String realImagem = "https://super.abril.com.br/wp-content/uploads/2018/07/real-thumb.jpg";
    String dolarImagem = "https://exame.com/wp-content/uploads/2020/11/dc2b4c3b3lar.jpg";

    public Cotacao(Double dolar, Double real, Double bitcoin, String base, String data) {
        this.dolar = dolar;
        this.real = real;
        this.bitcoin = bitcoin;
        this.base = base;
        this.data = data;
    }

    public Double getDolar() {
        return dolar;
    }

    public Double getReal() {
        return real;
    }

    public Double getBitcoin() {
        return bitcoin;
    }

    public String getBase() {
        return base;
    }

    public String getData() {
        return data;
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