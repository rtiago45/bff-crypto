package com.example.bff_crypto.presentation;

import com.example.bff_crypto.application.CoinService;
import com.example.bff_crypto.domain.model.Coin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/coins")
public class CoinController {

    private final CoinService coinService;

    public CoinController(CoinService coinService) {
        this.coinService = coinService;
    }

    @GetMapping
    public List<Coin> getAllCoins() {
        return coinService.getAllCoins();
    }
}
