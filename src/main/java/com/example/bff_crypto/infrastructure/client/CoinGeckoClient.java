package com.example.bff_crypto.infrastructure.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Map;

@Component
public class CoinGeckoClient {

    private static final Logger log = LoggerFactory.getLogger(CoinGeckoClient.class);

    private final WebClient webClient;

    public CoinGeckoClient(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder
                .baseUrl("https://api.coingecko.com/api/v3")
                .build();
    }

    public List<Map<String, Object>> getCoinsMarkets() {
        String url = UriComponentsBuilder.fromPath("/coins/markets")
                .queryParam("vs_currency", "usd")
                .build()
                .toUriString();

        List<Map<String, Object>> response = webClient.get()
                .uri(url)
                .retrieve()
                .bodyToMono(List.class)
                .block();

        log.info("Recebemos {} moedas da API CoinGecko", response != null ? response.size() : 0);
        return response;
    }
}

