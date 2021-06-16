# Projeto web scraping Knewin

Este projeto foi desenvolvido para o desafio da empresa Knewin.

## Objetivo

Implementar um sistema web para visualizar notícias do site InfoMoney.

## Requisitos

- Java 8 ou mais recente
- Os dados da notícia devem ser recuperados através de webscraping

O sistema deve:
- Permitir cadastrar uma notícia do InfoMoney apenas informando a URL da notícia.
- Permitir listar as notícias cadastradas.
- Permitir realizar uma busca por palavras-chave para encontrar as notícias.
- Ter uma visualização da notícia que apresente: URL, título, subtítulo, autor, data de publicação e conteúdo sem tags HTML.
 
## Tecnologias

- Java 11
- Spring Boot
- Hibernate e Spring Data JPA
- MySQL
- Intellij IDEA
- Swagger
- Jsoup
- Docker

## Visão Geral

Conforme requisitado, foram disponibilizados 4 endpoints:
- Cadastro de notícias e seus dados (obtidos através de webscraping);
- Listagem de todas as notícias;
- Obter a notícia através do ID informado;
- Obter notícias através de palavra chave.

**Disponibilizado no DockerHub, bastando utilizar o comando `docker pull humbertoguerrer/hgn-java-webscraping:0.0.1-SNAPSHOT`**

## Executar a aplicação

Para executar a aplicação, faça um clone do projeto.

Tenha instalado o JDK 11 e uma instância do MySQL. Execute o projeto através da classe principal.

As configurações de acesso ao banco de dados MySQL estão em ```resources/application.properties```

## Utilizando os endpoints

**Todos os endpoints estão documentados através de Swagger e podem ser visualizados em `http://localhost:8080/swagger-ui/index.html` após a aplicação inicializar.**

- Cadastrando uma nova notícia: requisição POST em `http://localhost:8080/news` com o link do site InfoMoney.

`https://www.infomoney.com.br/mercados/brf-disputada-confira-os-cenarios-caso-a-marfrig-queira-comprar-100-da-companhia-e-as-dificuldades-que-a-jbs-pode-impor/`

A resposta conterá todos os dados cadastrados e o código 201:

```
{
    "id": 1,
    "url": "https://www.infomoney.com.br/mercados/brf-disputada-confira-os-cenarios-caso-a-marfrig-queira-comprar-100-da-companhia-e-as-dificuldades-que-a-jbs-pode-impor/",
    "title": "BRF disputada: confira os cenários caso a Marfrig queira comprar 100% da companhia – e as dificuldades que a JBS pode impor",
    "subtitle": "Especulações ganham força no mercado, agora com a possibilidade da JBS entrar no páreo pela empresa de processados; expectativa é de volatilidade para BRFS3",
    "author": "Por Lara Rizério",
    "date": "15/06/2021 14:20",
    "content": "Entrar  Entrar  Entrar Melhores da Bolsa 2021 Renda extra na Bolsa Newsletter Cursos de Investimento Fliper: controle financeiro Especulações ganham força no mercado, agora com a possibilidade da JBS entrar no páreo pela empresa de processados; expectativa é de volatilidade para BRFS3 SÃO PAULO – O noticiário sobre frigoríficos tem sido movimentado nas últimas semanas. Após a Marfrig (MRFG3) realizar diversas operações de aquisições de ações da BRF (BRFS3) através de opções e da compra em leilões realizados em Bolsa – no agregado, a participação pode chegar a 31,66% – nos últimos dias ganhou força a notícia de que a JBS (JBSS3) entrou na briga pelos ativos da companhia...
}
```

- Listar todas as notícias cadastradas: requisição GET em `http://localhost:8080/news`.
Retornará todas as notícias cadastradas até então e conterão os dados requisitados e código 200.

- Listar notícia informando ID: requisição GET em `http://localhost:8080/news/1` (varíável conforme o ID da notícia).
Retornará a notícia cadastrada que corresponde ao ID informado, com todos os dados requisitados e código 200.

- Listar notícias que contenham palavra-chave em seu conteúdo: requisição GET em `http://localhost:8080/news/filter?keyword=fusão` (o último campo corresponde à palavra-chave - "fusão").
Retornará as notícias em cujo conteúdo contenha a palavra-chave informada, com todos os dados requisitados e código 200.

