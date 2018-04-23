package com.epam.cdp.m1.hw1.aggregator;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

public class AggregatorRecursiveTask<T, V> extends RecursiveTask {

    private List<T> workload;

    private ProcessingFunction<T, V> processingFunction;

    private int threshold;

    /**
     * Constructor for for creating ork/join task.
     * @param workload data that need to be processed
     * @param threshold min amount of data that will not be divided
     * @param processingFunction function that will be process data
     */
    public AggregatorRecursiveTask(List<T> workload, int threshold, ProcessingFunction<T, V> processingFunction) {
        this.threshold = threshold;
        this.workload = workload;
        this.processingFunction = processingFunction;
    }

    @Override
    protected List<V> compute() {
        if (workload.size() > threshold) {
            List<AggregatorRecursiveTask<T, V>> subtasks = new ArrayList<>();
            subtasks.addAll(createSubtasks());
            for (AggregatorRecursiveTask<T, V> subtask : subtasks) {
                subtask.fork();
            }

            List<V> subtaskResults = new ArrayList<>();
            for (AggregatorRecursiveTask<T, V> subtask : subtasks) {
                subtaskResults.addAll((List<V>) subtask.join());
            }
            return subtaskResults;

        } else {
            return processing(workload);
        }
    }

    private List<AggregatorRecursiveTask<T, V>> createSubtasks() {
        List<AggregatorRecursiveTask<T, V>> subtasks = new ArrayList<>();

        List<T> partOne = workload.subList(0, workload.size() / 2);
        List<T> partTwo = workload.subList(workload.size() / 2, workload.size());

        subtasks.add(new AggregatorRecursiveTask<>(partOne, threshold, processingFunction));
        subtasks.add(new AggregatorRecursiveTask<>(partTwo, threshold, processingFunction));

        return subtasks;
    }

    private List<V> processing(List<T> work) {
        return processingFunction.apply(work);
    }
}
