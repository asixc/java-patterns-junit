package com.example.behavioral.chain.coins;

import com.example.behavioral.chain.coins.AbstractCoinInserter;
import com.example.behavioral.chain.coins.Coin;

public class CoinInserter50Cent extends AbstractCoinInserter {
    
    private static final double COIN_DIAMETER_MM_50C = 50;
    private static final double COIN_WEIGHT_GR_50C = 50;

    @Override
    boolean isValidCoin(Coin coin) {
        return coin.diameter() == COIN_DIAMETER_MM_50C &&
                coin.weight() == COIN_WEIGHT_GR_50C;
    }
}
