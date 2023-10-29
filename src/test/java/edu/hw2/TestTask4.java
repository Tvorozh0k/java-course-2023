package edu.hw2;

import edu.hw2.Task4.CallingInfo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static edu.hw2.Task4.Main.callingInfo;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestTask4 {

    @Test
    @DisplayName("Пример")
    void Example() {
        // when
        CallingInfo result = callingInfo();

        // then
        assertThat(result)
                .isEqualTo(new CallingInfo("edu.hw2.TestTask4", "Example"));
    }
}
