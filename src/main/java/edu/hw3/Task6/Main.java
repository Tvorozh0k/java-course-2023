package edu.hw3.Task6;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    private final static Logger LOGGER = LogManager.getLogger();

    public static void main(String[] args) {
        StockMarket market = new StockMarket();

        market.add(new Stock("Apple Inc.", 1500));
        market.add(new Stock("Amazon.com Inc.", 3000));
        market.add(new Stock("Microsoft Corporation", 2500));
        market.add(new Stock("Tesla Inc.", 2000));
        market.add(new Stock("Alphabet Inc.", 1800));

        LOGGER.info(market.mostValuableStock());
    }
}
