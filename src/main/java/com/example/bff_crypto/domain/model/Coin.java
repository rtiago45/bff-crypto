package com.example.bff_crypto.domain.model;

public class Coin {

    private String id;
    private String name;
    private String symbol;
    private Double currentPrice;
    private Double marketCap;
    private String image;
    private Double priceChangePercentage24h;

    public Coin(String id, String name, String symbol, Double currentPrice, Double marketCap, String image, Double priceChangePercentage24h) {
        this.id = id;
        this.name = name;
        this.symbol = symbol;
        this.currentPrice = currentPrice;
        this.marketCap = marketCap;
        this.image = image;
        this.priceChangePercentage24h = priceChangePercentage24h;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }

    public Double getCurrentPrice() {
        return currentPrice;
    }

    public Double getMarketCap() {
        return marketCap;
    }

    public String getImage() {
        return image;
    }

    public Double getPriceChangePercentage24h() {
        return priceChangePercentage24h;
    }
}
