package edu.hw3;

import edu.hw3.Task6.Stock;
import edu.hw3.Task6.StockMarket;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestTask6 {

    @Test
    @DisplayName("Пример к заданию")
    void Example() {
        // given
        StockMarket market = new StockMarket();

        market.add(new Stock("Apple Inc.", 1500));
        market.add(new Stock("Amazon.com Inc.", 3000));
        market.add(new Stock("Microsoft Corporation", 2500));
        market.add(new Stock("Tesla Inc.", 2000));
        market.add(new Stock("Alphabet Inc.", 1800));

        // then
        assertThat(market.mostValuableStock())
            .isEqualTo(new Stock("Amazon.com Inc.", 3000));

        market.remove(new Stock("Amazon.com Inc.", 3000));

        // then
        assertThat(market.mostValuableStock())
            .isEqualTo(new Stock("Microsoft Corporation", 2500));

        market.remove(new Stock("Microsoft Corporation", 2500));

        // then
        assertThat(market.mostValuableStock())
            .isEqualTo(new Stock("Tesla Inc.", 2000));

        market.remove(new Stock("Tesla Inc.", 2000));

        // then
        assertThat(market.mostValuableStock())
            .isEqualTo(new Stock("Alphabet Inc.", 1800));

        market.remove(new Stock("Alphabet Inc.", 1800));

        // then
        assertThat(market.mostValuableStock())
            .isEqualTo(new Stock("Apple Inc.", 1500));
    }
}
