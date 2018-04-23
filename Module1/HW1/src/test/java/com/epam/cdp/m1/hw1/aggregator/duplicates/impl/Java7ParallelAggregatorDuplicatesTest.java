package com.epam.cdp.m1.hw1.aggregator.duplicates.impl;

import com.epam.cdp.m1.hw1.aggregator.Java7ParallelAggregator;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import com.epam.cdp.m1.hw1.aggregator.duplicates.JavaAggregatorDuplicatesTest;

@RunWith(Parameterized.class)
public class Java7ParallelAggregatorDuplicatesTest extends JavaAggregatorDuplicatesTest {

    public Java7ParallelAggregatorDuplicatesTest() {
        super(new Java7ParallelAggregator());
    }
}
