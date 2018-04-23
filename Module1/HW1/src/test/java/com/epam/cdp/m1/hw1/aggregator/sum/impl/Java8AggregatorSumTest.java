package com.epam.cdp.m1.hw1.aggregator.sum.impl;

import com.epam.cdp.m1.hw1.aggregator.Java8Aggregator;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import com.epam.cdp.m1.hw1.aggregator.sum.JavaAggregatorSumTest;

@RunWith(Parameterized.class)
public class Java8AggregatorSumTest extends JavaAggregatorSumTest {

    public Java8AggregatorSumTest() {
        super(new Java8Aggregator());
    }
}

