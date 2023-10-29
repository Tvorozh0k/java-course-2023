package edu.hw3.Task6;

import java.util.Comparator;
import java.util.PriorityQueue;

public class StockMarket {
    private PriorityQueue<Stock> stocks;

    public StockMarket() {
        stocks = new PriorityQueue<>(Comparator.comparingDouble(Stock::price).reversed());
    }

    /** Добавить акцию */
    public void add(Stock stock) {
        stocks.add(stock);
    }

    /** Удалить акцию (Предупреждение: метод работает за O(n)) */
    public void remove(Stock stock) {
        stocks.remove(stock);
    }

    /** Самая дорогая акция */
    public Stock mostValuableStock() {
        return stocks.peek();
    }
}
