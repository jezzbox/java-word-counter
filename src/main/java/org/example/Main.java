package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Path filePath = Paths.get(args[0]);
        try {
            var text = Files.readString(filePath);
            var result = WordCounter.getWordCounts(text);
            result.forEach((k, v) -> System.out.println(k + ": " + v));

        } catch (IOException e) {
            System.out.println("File not found, please check filepath.");
            e.printStackTrace();
        }
    }


}