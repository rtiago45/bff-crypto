package com.example.bff_crypto.presentation;

import com.example.bff_crypto.application.CoinService;
import com.example.bff_crypto.domain.model.Coin;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/coins")
@CrossOrigin(origins = "http://localhost:4200")
public class CoinController {

    private final CoinService coinService;

    public CoinController(CoinService coinService) {
        this.coinService = coinService;
    }

    @GetMapping
    public List<Coin> getAllCoins() {
        return coinService.getAllCoins();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Coin> getCoinById(@PathVariable String id) {
        Coin coin = coinService.getCoinById(id);
        if (coin != null) {
            return ResponseEntity.ok(coin);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
