package com.rafacost3d.bbs_mod.init;

public class BBSMarketData {
    public final String beerType;
    public final Double maxPrice;
    public final Integer quantity;

    public BBSMarketData(String beerType, Double maxPrice, Integer quantity) {
        this.beerType = beerType;
        this.maxPrice = maxPrice;
        this.quantity = quantity;
    }

}
