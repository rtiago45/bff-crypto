package com.example.bff_crypto.application;

import com.example.bff_crypto.domain.model.Coin;
import com.example.bff_crypto.infrastructure.client.CoinGeckoClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service // Diz ao Spring que esta classe é um service (um "bean" com lógica de negócio)
public class CoinService {

    private final CoinGeckoClient coinGeckoClient;

    public CoinService(CoinGeckoClient coinGeckoClient) {
        this.coinGeckoClient = coinGeckoClient;
    }

    /**
     * Busca as moedas da CoinGecko e converte para o nosso model Coin simplificado.
     *
     * @return Lista de objetos Coin
     */
    public List<Coin> getAllCoins() {
        // 1️⃣ Pega a lista bruta da API externa
        List<Map<String, Object>> coinsRaw = coinGeckoClient.getCoinsMarkets();

        // 2️⃣ Transforma cada Map (moeda) em nossa entidade Coin
        return coinsRaw.stream()
                .map(this::mapToCoin)
                .collect(Collectors.toList());
    }

    /**
     * Método auxiliar para mapear dados crus (Map<String, Object>) para Coin.
     *
     * @param map Dados crus da API
     * @return Coin preenchido
     */
    private Coin mapToCoin(Map<String, Object> map) {
        return new Coin(
                (String) map.get("id"),
                (String) map.get("name"),
                (String) map.get("symbol"),
                toDouble(map.get("current_price")),
                toDouble(map.get("market_cap")),
                (String) map.get("image"),
                toDouble(map.get("price_change_percentage_24h"))
        );
    }

    /**
     * Método auxiliar para conversão segura para Double (pode ser Integer na API em alguns casos).
     */
    private Double toDouble(Object value) {
        if (value instanceof Number) {
            return ((Number) value).doubleValue();
        }
        return null;
    }
}

