package edu.hw3;

import edu.hw3.Task6.Stock;
import edu.hw3.Task6.StockMarket;
import edu.hw3.Task8.BackwardIterator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestTask8 {

    @Test
    @DisplayName("Пример к заданию")
    void Example() {
        // given
        List<Integer> numbers = List.of(1, 2, 3);
        BackwardIterator<Integer> iterator = new BackwardIterator<>(numbers);

        // then
        assertThat(iterator.next())
            .isEqualTo(3);

        assertThat(iterator.next())
            .isEqualTo(2);

        assertThat(iterator.next())
            .isEqualTo(1);
    }
}
