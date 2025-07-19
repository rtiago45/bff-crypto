# BFF Crypto API

Backend For Frontend (BFF) desenvolvido com **Spring Boot**, que consome dados da API pública [CoinGecko](https://www.coingecko.com/en/api) e expõe um endpoint REST simplificado para consumo no frontend Angular.

## Objetivo
- Buscar dados do mercado de criptomoedas no endpoint `/coins/markets` da CoinGecko
- Filtrar os dados e devolver apenas os campos necessários
- Expor a API para que um frontend Angular possa consumir e exibir os dados

## Arquitetura de camadas
- **Controller:** expõe o endpoint HTTP (`/api/coins`)
- **Service:** centraliza a regra de negócio e faz o mapeamento dos dados crus
- **Client:** consome a API externa CoinGecko
- **Model:** define o contrato que será devolvido ao frontend (`Coin`)

## Fluxo da aplicação
Angular frontend
↓
Spring Boot API - /api/coins
↓
CoinController
↓
CoinService
↓
CoinGeckoClient (WebClient)
↓
CoinGecko API - /coins/markets

shell
Copiar
Editar

## Endpoint disponível
GET http://localhost:8080/api/coins

shell
Copiar
Editar

## Estrutura de diretórios
src/main/java/com/example/bff_crypto
│
├── application
│ └── CoinService.java
│
├── domain/model
│ └── Coin.java
│
├── infrastructure/client
│ └── CoinGeckoClient.java
│
└── presentation
└── CoinController.java

markdown
Copiar
Editar

## Tecnologias utilizadas
- Java 21
- Spring Boot 3.5.x
- Spring WebFlux (WebClient)
- Maven
- Jackson (para serialização JSON)