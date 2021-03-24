# Refatoração:

## Melhorias:
### Classes abstratas:
Criação da classes abstradas tanto para **leiura do json** *(LeituraJsonApi.java)* quanto para **conexão com a api** *(Conexao.java)*, visando facilitar a adição de novas funcionalidades sem quebra do código e procurando seguir os princípios do modelo SOLID.
### Saída de dados:
Saída de dados em formato brasileiro padrão mas com arredondado para 3 casas decimais. Ex: R$ 30,963

## Funcionalidades adcionadas:
### Busca por dada:
* Busca de qualquer data no padrão brasileiro: dd/mm/aaaa
* Em caso a data fora do range da API (anterior a 30/12/2012) ou em formato diferente, apresenta apernas o dia atual.
### Busca por nome do país.
* Apresenta o código ISO e a cotação atual de qualquer país que esteja dentro da API do Fixer, a partir do seu nome em ingles. Ex: Brazil, Uruguay, China.

## Json Complementar:
Leitura de Json complementar *(country-by-currency-code)* que conecta os códigos ISO de cada moeda com o nome do país de origem, posibilitando a busca de países por seu nome em inglês.
~~~
   {
        "country": "Brazil",
        "currency_code": "BRL"
    },
~~~
