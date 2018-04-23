package com.epam.cdp.m1.hw1.aggregator;

import javafx.util.Pair;

import java.util.Comparator;

public class Comparators {

    public static final Comparator<Pair<String, Long>> PAIR_COMPARATOR = new Comparator<Pair<String, Long>>() {
        @Override
        public int compare(Pair<String, Long> pair1, Pair<String, Long> pair2) {
            int frequencyComparation = Long.compare(pair2.getValue(), (pair1.getValue()));
            return frequencyComparation == 0 ? pair1.getKey().compareTo(pair2.getKey()) : frequencyComparation;
        }
    };

    public static final Comparator<String> WORD_COMPARATOR = new Comparator<String>() {
        @Override
        public int compare(String word1, String word2) {
            int lengthComparation = Integer.compare(word1.length(), word2.length());
            return lengthComparation == 0 ? word1.compareToIgnoreCase(word2) : lengthComparation;
        }
    };
}
