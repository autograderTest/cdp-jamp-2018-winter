package com.epam.cdp.m1.hw1.aggregator.benchmark.impl;

import com.epam.cdp.m1.hw1.aggregator.benchmark.AggregatorAbstractBenchmark;
import com.epam.cdp.m1.hw1.aggregator.Java8ParallelAggregator;

public class Java8ParallelAggregatorBenchmark extends AggregatorAbstractBenchmark {
    public Java8ParallelAggregatorBenchmark() {
        super(new Java8ParallelAggregator());
    }
}
