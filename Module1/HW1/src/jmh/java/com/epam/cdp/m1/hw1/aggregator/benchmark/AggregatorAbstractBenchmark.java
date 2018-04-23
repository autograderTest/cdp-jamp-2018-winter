package com.epam.cdp.m1.hw1.aggregator.benchmark;

import com.epam.cdp.m1.hw1.aggregator.Aggregator;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@State(Scope.Benchmark)
public abstract class AggregatorAbstractBenchmark {
    private static final Integer NUMBER_OF_ELEMENTS = 1000;
    private static final Integer LOWER_BOUND = 0;
    private static final Integer UPPER_BOUND = 1000;
    private static final Random RANDOM = new Random();
    private static final Long LIMIT = Integer.toUnsignedLong(RANDOM.nextInt(UPPER_BOUND));

    protected Aggregator aggregator;

    public AggregatorAbstractBenchmark(Aggregator aggregator) {
        this.aggregator = aggregator;
    }

    @State(Scope.Thread)
    public static class AggregatorBenchmarkState {
        private List<Integer> numbers = new ArrayList<>();
        private List<String> words = new ArrayList<>();


        /**
         * Setup method for generating values for benchmark.
         */
        @Setup(Level.Iteration)
        public void setup() {
            numbers = RANDOM.ints(NUMBER_OF_ELEMENTS, LOWER_BOUND, UPPER_BOUND)
                    .boxed()
                    .collect(Collectors.toList());

            words = numbers.stream()
                    .map(Object::toString)
                    .collect(Collectors.toList());
        }
    }

    @Benchmark
    public void testSum(AggregatorBenchmarkState state, Blackhole blackhole) {
        blackhole.consume(aggregator.sum(state.numbers));
    }

    @Benchmark
    public void testFrequency(AggregatorBenchmarkState state, Blackhole blackhole) {
        blackhole.consume(aggregator.getMostFrequentWords(state.words, LIMIT));
    }

    @Benchmark
    public void testDuplicates(AggregatorBenchmarkState state, Blackhole blackhole) {
        blackhole.consume(aggregator.getDuplicates(state.words, LIMIT));
    }
}
