package com.practice.transacstat.estatistica;

import lombok.Data;

import java.util.DoubleSummaryStatistics;

@Data
public class Estatistica {

    private long count;
    private double sum;
    private double avg;
    private double min;
    private double max;

    public Estatistica(DoubleSummaryStatistics summaryStatistics) {
        this.count = summaryStatistics.getCount();
        this.sum = summaryStatistics.getSum();
        this.avg = summaryStatistics.getAverage();
        this.min = count==0 ? 0 : summaryStatistics.getMin();
        this.max = count==0 ? 0 : summaryStatistics.getMax();
    }
}
