package com.epam.cdp.m1.hw1.aggregator.suits;

import com.epam.cdp.m1.hw1.aggregator.duplicates.impl.Java7AggregatorDuplicatesTest;
import com.epam.cdp.m1.hw1.aggregator.frequency.impl.Java7AggregatorFrequencyTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.epam.cdp.m1.hw1.aggregator.sum.impl.Java7AggregatorSumTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        Java7AggregatorFrequencyTest.class,
        Java7AggregatorSumTest.class,
        Java7AggregatorDuplicatesTest.class,
})
public class TestJava7Aggregator {
}
