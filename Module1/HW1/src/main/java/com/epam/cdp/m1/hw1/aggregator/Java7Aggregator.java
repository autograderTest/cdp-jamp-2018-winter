package com.epam.cdp.m1.hw1.aggregator;

import java.util.*;

import javafx.util.Pair;

public class Java7Aggregator implements Aggregator {

    @Override
    public int sum(List<Integer> numbers) {
        int aggregator = 0;
        for(int currentNumber : numbers){
            aggregator += currentNumber;
        }
        return aggregator;
    }

    @Override
    public List<Pair<String, Long>> getMostFrequentWords(List<String> words, long limit) {
        Set<String> targetWords = new HashSet<>(words);
        List<Pair<String, Long>> aggregator = new ArrayList<>();

        for (String w : targetWords){
            aggregator.add(new Pair<>(w, (long)Collections.frequency(words, w)));
        }

        Collections.sort(aggregator, Comparators.PAIR_COMPARATOR);
        return aggregator.subList(0, limit >= aggregator.size() ? aggregator.size() : Long.valueOf(limit).intValue());
    }

    @Override
    public List<String> getDuplicates(List<String> targetWords, long limit) {
        List<String> aggregator = new ArrayList<>();
        for(int i = 0; i < (targetWords.size() - 1); i++){
            String word = targetWords.get(i);
            if(!aggregator.contains(word.toUpperCase())){
                List<String> sublist = targetWords.subList(i + 1, targetWords.size());
                for (String w: sublist) {
                    if(w.equalsIgnoreCase(word)){
                        aggregator.add(word.toUpperCase());
                        break;
                    }
                }
            }
        }

        Collections.sort(aggregator, Comparators.WORD_COMPARATOR);
        return aggregator.subList(0, limit >= aggregator.size() ? aggregator.size() : (int)limit);
    }
}
