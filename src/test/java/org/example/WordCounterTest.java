package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class WordCounterTest {
    @Test
    @DisplayName("Get counts of words in a string in descending order.")
    void getWordCounts() {
        String testText1 = "This    is your house this. ;is my hoUse";

        Map<String, Integer> testMap1 = new HashMap<>();
        testMap1.put("is", 2);
        testMap1.put("this", 2);
        testMap1.put("house", 2);
        testMap1.put("my", 1);
        testMap1.put("your", 1);

        String testText2 = "Foo BAR    baz: foo? ;baz baz! bar:(";
        Map<String, Integer> testMap2 = new HashMap<>();
        testMap2.put("baz", 3);
        testMap2.put("bar", 2);
        testMap2.put("foo", 2);

        String testText3 = " once! upon a time there was a time ";
        Map<String, Integer> testMap3 = new HashMap<>();
        testMap3.put("a", 2);
        testMap3.put("time", 2);
        testMap3.put("once", 1);
        testMap3.put("there", 1);
        testMap3.put("upon", 1);
        testMap3.put("was", 1);
        assertAll(
            () -> assertEquals(testMap1, WordCounter.getWordCounts(testText1)),
            () -> assertEquals(testMap2, WordCounter.getWordCounts(testText2)),
            () -> assertEquals(testMap3, WordCounter.getWordCounts(testText3)));
    }
}