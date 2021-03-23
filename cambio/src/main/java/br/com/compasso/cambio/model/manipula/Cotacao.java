package br.com.compasso.cambio.model.manipula;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Cotacao {
    private Double dolar;
    private Double real;
    private Double bitcoin;
    private Double novaMoeda = 1.0;
    private String baseReal = "Real";
    private LocalDate data;
    private String siglaNovaMoeda = "BRL";

    private String bitcoinImagem = "https://s3.criptofacil.com/wp-content/uploads/2020/12/maior-gestora-mundo-diz-que-bitcoin-impactara-dolar.jpg";
    private String realImagem = "https://exame.com/wp-content/uploads/2020/05/gettyimages-1196644462.jpg";
    private String dolarImagem = "https://exame.com/wp-content/uploads/2020/11/dc2b4c3b3lar.jpg";
    private String novaMoedaImagem = "https://image.freepik.com/fotos-gratis/dinheiro-de-diferentes-paises-dolares-euros-hryvnia-rublos_104376-255.jpg";

    private static final String FORMATODINHEIRO = "R$ %.3f";
    private DateTimeFormatter formatadorEntrada = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public Cotacao(Double dolar, Double real, Double bitcoin, String data) {
        this.dolar = dolar;
        this.real = real;
        this.bitcoin = bitcoin;
        this.data = LocalDate.parse(data,formatadorEntrada);
    }
    public Cotacao(Double dolar, Double real, Double bitcoin, String data, Double novaMoeda, String siglaNovaMoeda) {
        this.dolar = dolar;
        this.real = real;
        this.bitcoin = bitcoin;
        this.data = LocalDate.parse(data,formatadorEntrada);
        this.novaMoeda = novaMoeda;
        this.siglaNovaMoeda = siglaNovaMoeda;
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

    public String getNovaMoeda() {
        return String.format(FORMATODINHEIRO,converteEmReal(this.novaMoeda));
    }

    public String getBase() {
        return baseReal;
    }

    public String getData() {
        return data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
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
    public String getNovaMoedaImagem() {
        return novaMoedaImagem;
    }
    public String getSiglaNovaMoeda() {
        return siglaNovaMoeda;
    }
}