package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.ParameterizedTest;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class AnagramTest {

    private static Stream<Arguments> provideStringsForIsBlank() {
        return Stream.of(
                Arguments.of("Ananas", "Nasana", true),
                Arguments.of("Ananas2", "Nasana1", false)
        );
    }
    @org.junit.jupiter.api.Test
    void isAnagram() {
        Anagram anagram = new Anagram();
        //boolean result = anagram.isAnagram("Ananas", "Nasana");
        //System.out.println(result);
        Assertions.assertTrue(anagram.isAnagram("Ananas", "Nasana"));
    }

    @ParameterizedTest
    @MethodSource("provideStringsForIsBlank")
    void isBlank_ShouldReturnTrueForNullOrBlankStrings(String input1, String input2, boolean input3) {
        Anagram anagram = new Anagram();
        assertEquals(input3, anagram.isAnagram(input1,input2));
    }
}