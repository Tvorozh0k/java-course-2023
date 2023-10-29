package edu.hw3;

import edu.hw3.Task7.TreeMapComparator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.TreeMap;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestTask7 {

    @Test
    @DisplayName("Пример к заданию")
    void Examples() {

        // given
        TreeMap<String, String> tree = new TreeMap<>(new TreeMapComparator());
        tree.put(null, "test");
        tree.put("1", "test");

        // when
        boolean result = tree.containsKey(null);

        // then
        assertThat(result)
            .isEqualTo(true);
    }
}
