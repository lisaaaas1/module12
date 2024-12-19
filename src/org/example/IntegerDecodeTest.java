package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class IntegerDecodeTest {

    @Test
    void testNullInput() {
        assertThrows(NullPointerException.class, () -> Integer.decode(null));
    }

    @Test
    void testEmptyString() {
        assertThrows(NumberFormatException.class, () -> Integer.decode(""));
    }

    @Test
    void testHexadecimalInput() {
        assertEquals(Integer.valueOf(255), Integer.decode("0xFF")); // 255 в десятичной системе
        assertEquals(Integer.valueOf(255), Integer.decode("0XFF")); // эквивалент
        assertEquals(Integer.valueOf(255), Integer.decode("#FF")); // эквивалент
    }

    @Test
    void testOctalInput() {
        assertEquals(Integer.valueOf(8), Integer.decode("010")); // 8 в десятичной системе
    }

    @Test
    void testDecimalInput() {
        assertEquals(Integer.valueOf(100), Integer.decode("100")); // база)
    }

    @Test
    void testInvalidHexadecimal() {
        assertThrows(NumberFormatException.class, () -> Integer.decode("0xZ1")); // Z недопустимый символ в
    }

    @Test
    void testInvalidOctal() {
        assertThrows(NumberFormatException.class, () -> Integer.decode("09")); // 9 недопустимый для восьмеричной системы
    }

    @Test
    void testInvalidDecimal() {
        assertThrows(NumberFormatException.class, () -> Integer.decode("10xyz15")); // xyz в десятичной недопустимы
    }

    @Test
    void testInvalidStringInput() {
        assertThrows(NumberFormatException.class, () -> Integer.decode("kjajd")); // недопустимая строка
    }

    @Test
    void testNegativeOverflow() {
        assertThrows(NumberFormatException.class, () -> Integer.decode("-74979327984723974923479")); // -74979327984723974923479 меньше минимального значения Integer
    }

    @Test
    void testOverflow() {
        assertThrows(NumberFormatException.class, () -> Integer.decode("74979327984723974923479")); // 74979327984723974923479 превышает максимальное значение Integer
    }

    @Test
    void testCharacterInWrongPosition() {
        assertThrows(NumberFormatException.class, () -> Integer.decode("123-456"), "Sign character in wrong position");
        assertThrows(NumberFormatException.class, () -> Integer.decode("123+456"), "Sign character in wrong position");
    }}