package com.epam.cdp.m1.hw1.aggregator.benchmark.impl;

import com.epam.cdp.m1.hw1.aggregator.Java8Aggregator;
import com.epam.cdp.m1.hw1.aggregator.benchmark.AggregatorAbstractBenchmark;

public class Java8AggregatorBenchmark extends AggregatorAbstractBenchmark {
    public Java8AggregatorBenchmark() {
        super(new Java8Aggregator());
    }
}
