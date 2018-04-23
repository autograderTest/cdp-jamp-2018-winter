package com.epam.cdp.m1.hw1.aggregator;

import java.util.*;
import java.util.stream.Collectors;

import javafx.util.Pair;

public class Java8Aggregator implements Aggregator {

    @Override
    public int sum(List<Integer> numbers) {
        return numbers.stream()
                .reduce((aggregator, currentNumber) -> aggregator + currentNumber)
                .orElse(0);
    }

    @Override
    public List<Pair<String, Long>> getMostFrequentWords(List<String> words, long limit) {
        return words.stream()
                .distinct()
                .map(word -> new Pair<>(word, words.stream().filter(w -> w.equals(word)).count()))
                .sorted((pair1, pair2) -> (pair2.getValue() - pair1.getValue()) == 0 ?
                        pair1.getKey().compareTo(pair2.getKey()) : Long.compare(pair2.getValue(), pair1.getValue()))
                .limit(limit)
                .collect(Collectors.toList());
    }

    @Override
    public List<String> getDuplicates(List<String> words, long limit) {
        return words.stream()
                .filter(word -> words.stream().filter(word::equalsIgnoreCase).count() > 1)
                .sorted((word1, word2) -> word1.length() == word2.length() ?
                        word1.compareToIgnoreCase(word2) : Integer.compare(word1.length(), word2.length()))
                .map(String::toUpperCase)
                .distinct()
                .limit(limit)
                .collect(Collectors.toList());
    }
}
