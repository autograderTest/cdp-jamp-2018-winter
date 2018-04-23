package com.epam.cdp.m1.hw1.aggregator.suits;

import com.epam.cdp.m1.hw1.aggregator.frequency.impl.Java8AggregatorFrequencyTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.epam.cdp.m1.hw1.aggregator.duplicates.impl.Java8AggregatorDuplicatesTest;
import com.epam.cdp.m1.hw1.aggregator.sum.impl.Java8AggregatorSumTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        Java8AggregatorFrequencyTest.class,
        Java8AggregatorSumTest.class,
        Java8AggregatorDuplicatesTest.class,
})
public class TestJava8Aggregator {
}
