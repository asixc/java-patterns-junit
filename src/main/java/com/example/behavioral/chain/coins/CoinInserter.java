package com.example.behavioral.chain.coins;

public interface CoinInserter {
    CoinInserter setNextInserter(CoinInserter coinInserter);
    boolean insert(Coin coin);
}
