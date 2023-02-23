package org.example;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.collectingAndThen;

public class WordCounter {
    /**
     * Takes a String and returns a map of the words and their counts in descending order.
     *
     * @param text The string of text containing the words.
     * @return map of words and their counts in descending order.
     */
    public static Map<String, Integer> getWordCounts(String text) {
        var words = WordCounter.words(text);
        return WordCounter.wordCounts(words);
    }

    /**
     * Takes a String and returns an array of the words.
     * any special characters excluding ' are removed.
     * @param text The string of text containing the words.
     * @return array of words.
     */
    private static String[] words(String text) {
        return text.toLowerCase()
                .trim()
                .replaceAll("[^A-Za-z0-9'\\s]", "")
                .split("\\s+");
        }

    /**
     * Takes an array of String and returns and returns a map.
     * the Key of the map is each unique word and the value is the count.
     * @param words The array of words.
     * @return map with key as the word and value as the count.
     */
    private static Map<String, Integer> wordCounts(String[] words) {
        return Arrays.stream(words)
                .collect(
                        Collectors.groupingBy(
                                Function.identity(),
                                collectingAndThen(Collectors.counting(), Long::intValue)
                        )
                )
                .entrySet().stream()
                .sorted(
                        Map.Entry.<String, Integer>comparingByValue()
                                .reversed()
                                .thenComparing(
                                    Map.Entry.comparingByKey()
                                ))
                .collect(
                        Collectors.toMap(
                                Map.Entry::getKey,
                                Map.Entry::getValue,
                                (e1, e2) -> e1,
                                LinkedHashMap::new)
                );
    }
}
