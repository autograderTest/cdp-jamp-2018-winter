package com.epam.cdp.m1.hw1.aggregator;

import com.epam.cdp.m1.hw1.aggregator.benchmark.impl.Java7AggregatorBenchmark;
import com.epam.cdp.m1.hw1.aggregator.benchmark.impl.Java7ParallelAggregatorBenchmark;
import com.epam.cdp.m1.hw1.aggregator.benchmark.impl.Java8AggregatorBenchmark;
import com.epam.cdp.m1.hw1.aggregator.benchmark.impl.Java8ParallelAggregatorBenchmark;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

public class Main {
    /**
     * Method for benchmark running.
     * @param args console inputs
     * @throws RunnerException if there is some problems with test execution.
     */
    public static void main(String[] args) throws RunnerException {
        Options options = new OptionsBuilder()
                .include(Java7AggregatorBenchmark.class.getSimpleName())
                .include(Java7ParallelAggregatorBenchmark.class.getSimpleName())
                .include(Java8AggregatorBenchmark.class.getSimpleName())
                .include(Java8ParallelAggregatorBenchmark.class.getSimpleName())
                .forks(1)
                .build();

        new Runner(options).run();
    }
}
