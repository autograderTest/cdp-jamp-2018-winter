package com.epam.cdp.m1.hw1.aggregator.benchmark.impl;

import com.epam.cdp.m1.hw1.aggregator.Java7ParallelAggregator;
import com.epam.cdp.m1.hw1.aggregator.benchmark.AggregatorAbstractBenchmark;

public class Java7ParallelAggregatorBenchmark extends AggregatorAbstractBenchmark {
    public Java7ParallelAggregatorBenchmark() {
        super(new Java7ParallelAggregator());
    }
}
