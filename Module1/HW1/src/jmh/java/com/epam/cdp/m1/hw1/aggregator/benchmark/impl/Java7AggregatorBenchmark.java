package com.epam.cdp.m1.hw1.aggregator.benchmark.impl;

import com.epam.cdp.m1.hw1.aggregator.Java7Aggregator;
import com.epam.cdp.m1.hw1.aggregator.benchmark.AggregatorAbstractBenchmark;

public class Java7AggregatorBenchmark extends AggregatorAbstractBenchmark {
    public Java7AggregatorBenchmark() {
        super(new Java7Aggregator());
    }
}
