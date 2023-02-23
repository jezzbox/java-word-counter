package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.nio.file.Path;

import static java.util.stream.Collectors.collectingAndThen;

public class WordCounter {
    public static Map<String, Integer> getWordCounts(String text) {
        var words = WordCounter.words(text);
        return WordCounter.wordCounts(words);
    }

    private static String[] words(String text) {
        var words = text.toLowerCase().trim().replaceAll("[^A-Za-z0-9'\\s]", "").split("\\s+");
        return words;
        }

    private static Map<String, Integer> wordCounts(String[] words) {
        var result = Arrays.stream(words)
                .collect(Collectors.groupingBy(Function.identity(), collectingAndThen(Collectors.counting(), Long::intValue)))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed().thenComparing(Map.Entry.comparingByKey()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        return result;
    }
}
