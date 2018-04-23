package com.epam.cdp.m1.hw1.aggregator;

import java.util.List;


public interface ProcessingFunction<T,V> {

    List<V> apply(List<T> work);

}
