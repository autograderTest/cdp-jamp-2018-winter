package com.epam.cdp.m1.hw1.aggregator.sum.impl;

import com.epam.cdp.m1.hw1.aggregator.Java7ParallelAggregator;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import com.epam.cdp.m1.hw1.aggregator.sum.JavaAggregatorSumTest;

@RunWith(Parameterized.class)
public class Java7ParallelAggregatorSumTest extends JavaAggregatorSumTest {

    public Java7ParallelAggregatorSumTest() {
        super(new Java7ParallelAggregator());
    }
}
