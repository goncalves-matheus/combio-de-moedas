package br.com.compasso.cambio.manipulacao;

public class Cotacao {
    Double dolar;
    Double real;
    Double bitcoin;
    String base;
    String data;

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
}