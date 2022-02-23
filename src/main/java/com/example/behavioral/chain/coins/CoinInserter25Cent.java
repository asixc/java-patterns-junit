package com.example.behavioral.chain.coins;

import com.example.behavioral.chain.coins.AbstractCoinInserter;
import com.example.behavioral.chain.coins.Coin;

public class CoinInserter25Cent extends AbstractCoinInserter {
    
    private static final double COIN_DIAMETER_MM_25C = 25;
    private static final double COIN_WEIGHT_GR_25C = 25;

    @Override
    boolean isValidCoin(Coin coin) {
        return coin.diameter() == COIN_DIAMETER_MM_25C &&
                coin.weight() == COIN_WEIGHT_GR_25C;
    }
}
