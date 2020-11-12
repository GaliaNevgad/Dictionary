package com.company;

import java.util.*;
import java.util.stream.Collectors;

public class Dictionary {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_PURPLE = "\u001B[35m";

    Map<String, String> dict = new HashMap<>();
    {
        dict.put("Headphones", "Наушники");
        dict.put("Watch", "Годинник");
        dict.put("Laptop", "Ноутбук");
        dict.put("Cup", "Чашка");
        dict.put("Room", "Кімната");
        dict.put("Blanket", "Покривало");
    }

    public void addWordToDict(String englishWord, String ukrainianWord){
        System.out.println("\nNew English word: " + ANSI_PURPLE + englishWord + ANSI_RESET);
        System.out.println("Translation to this word: " + ANSI_PURPLE + ukrainianWord + ANSI_RESET);
        dict.put(englishWord, ukrainianWord);
        System.out.println("New pair: " + ANSI_PURPLE + englishWord + ANSI_RESET +
                " - " + ANSI_PURPLE + ukrainianWord + ANSI_RESET);
    }

    public boolean isInDict(String englishWord){
        return dict.containsKey(englishWord);
    }

    public String translateWords(String englishWord){
        return "Translation: " + ANSI_PURPLE + Arrays.stream(englishWord.split(" "))
                .map(w -> dict.containsKey(w) ? dict.get(w) : w)
                .collect(Collectors.joining(" ")) + ANSI_RESET;
    }
}
