package ru.ex;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


class FactorialTest {

    @Test
    void WhenException() {
        Factorial factorial = new Factorial();
        IllegalArgumentException exception =
                assertThrows(IllegalArgumentException.class, () -> {
                    factorial.calc(-1);
                });
        assertThat(exception.getMessage()).isEqualTo("The number should be more than zero");
    }
}