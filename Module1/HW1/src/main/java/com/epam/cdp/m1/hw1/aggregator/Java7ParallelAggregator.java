package com.epam.cdp.m1.hw1.aggregator;

import java.util.*;
import java.util.concurrent.ForkJoinPool;

import javafx.util.Pair;

public class Java7ParallelAggregator implements Aggregator {

    @Override
    public int sum(List<Integer> numbers) {
        AggregatorRecursiveTask<Integer, Integer> sumTask = getSumTask(numbers, 2);
        int result = 0;
        for (int currentNumber : (List<Integer>) ForkJoinPool.commonPool().invoke(sumTask)) {
            result += currentNumber;
        }
        return result;
    }

    @Override
    public List<Pair<String, Long>> getMostFrequentWords(List<String> words, long limit) {
        AggregatorRecursiveTask<String, Pair<String, Long>> mostFrequentWordsTask = getMostFrequentWordsTask(words, 2);
        List<Pair<String, Long>> result =
                (List<Pair<String, Long>>) ForkJoinPool.commonPool().invoke(mostFrequentWordsTask);

        Collections.sort(result, Comparators.PAIR_COMPARATOR);
        return result.subList(0, limit >= result.size() ? result.size() : Long.valueOf(limit).intValue());
    }

    @Override
    public List<String> getDuplicates(List<String> words, long limit) {
        List<String> target = new ArrayList<>();
        for (String word : words) {
            target.add(word.toUpperCase());
        }

        AggregatorRecursiveTask<String, String> duplicatesTask = getDuplicatesTask(target, 2);
        List<String> result = (List<String>) ForkJoinPool.commonPool().invoke(duplicatesTask);

        Collections.sort(result, Comparators.WORD_COMPARATOR);
        return result.subList(0, limit >= result.size() ? result.size() : (int) limit);
    }

    private AggregatorRecursiveTask<Integer, Integer> getSumTask(List<Integer> numbers, int threshold) {
        return new AggregatorRecursiveTask<>(numbers, threshold,
                new ProcessingFunction<Integer, Integer>() {
                    @Override
                    public List<Integer> apply(List<Integer> partWork) {
                        List<Integer> aggregator = new ArrayList<>();
                        int sum = 0;
                        for (int currentNumber : partWork) {
                            sum += currentNumber;
                        }
                        aggregator.add(sum);
                        return aggregator;
                    }
                });
    }

    private AggregatorRecursiveTask<String, Pair<String, Long>> getMostFrequentWordsTask(List<String> words, int threshold) {
        return new AggregatorRecursiveTask<>( new ArrayList<>(new HashSet<>(words)), threshold,
                new ProcessingFunction<String, Pair<String, Long>>() {
                    @Override
                    public List<Pair<String, Long>> apply(List<String> partWork) {
                        List<Pair<String, Long>> aggregator = new ArrayList<>();
                        for (String word : partWork) {
                            aggregator.add(new Pair<>(word, (long) Collections.frequency(words, word)));
                        }
                        return aggregator;
                    }
                });
    }

    private AggregatorRecursiveTask<String, String> getDuplicatesTask(List<String> target, int threshold) {
        return new AggregatorRecursiveTask<>(new ArrayList<>(new HashSet<>(target)),threshold,
                new ProcessingFunction<String, String>() {
                    @Override
                    public List<String> apply(List<String> targetWords) {
                        Set<String> aggregator = new HashSet<>();

                        for (String targetWord : targetWords) {
                            String targetWordUpperCase = targetWord.toUpperCase();
                            if (Collections.frequency(target, targetWordUpperCase) > 1) {
                                aggregator.add(targetWordUpperCase);
                            }
                        }
                        return new ArrayList<>(aggregator);
                    }
                });
    }
}
