package sample.Statistics;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

/**
 * Created by kassava on 05.04.2016.
 */
public class Statistic1 {
    public static double[] stat1(int[][] byteArray) {
        DescriptiveStatistics stats = new DescriptiveStatistics();

        int ringWidth = 1;
        int r = 1;
        for (int i = 0; i < 5; i ++) {
            CalcUtils.calculateRing(byteArray, stats, 127, 95, r, r + ringWidth - 1, 0);
            r += (ringWidth);
//			calculateRing(byteArray, stats, 127, 95, r, r + ringWidth - 1, 1);
            r += (ringWidth);
        }
        double[] Kcp = new double[6];
        Kcp[0] = stats.getSum() / stats.getN();
        log("Kcp1 = " + Kcp[0]);

        stats.clear();
        ringWidth = 2;
        r = 2;
        for (int i = 0; i < 5; i ++) {
            CalcUtils.calculateRing(byteArray, stats, 110, 180, r, r + ringWidth - 1, 0);
            r += (ringWidth);
//			calculateRing(byteArray, stats, 110, 180, r, r + ringWidth - 1, 1);
            r += (ringWidth);
        }
        Kcp[1] = stats.getSum() / stats.getN();
        log("Kcp2 = " + Kcp[1]);

        stats.clear();
        ringWidth = 3;
        r = 3;
        for (int i = 0; i < 4; i ++) {
            CalcUtils.calculateRing(byteArray, stats, 40, 225, r, r + ringWidth - 1, 0);
            r += (ringWidth);
//			calculateRing(byteArray, stats, 40, 225, r, r + ringWidth - 1, 1);
            r += (ringWidth);
        }
        Kcp[2] = stats.getSum() / stats.getN();
        log("Kcp3 = " + Kcp[2]);

        stats.clear();
        ringWidth = 4;
        r = 4;
        for (int i = 0; i < 4; i ++) {
            CalcUtils.calculateRing(byteArray, stats, 210, 45, r, r + ringWidth - 1, 0);
            r += (ringWidth);
//			calculateRing(byteArray, stats, 210, 45, r, r + ringWidth - 1, 1);
            r += (ringWidth);
        }
        Kcp[3] = stats.getSum() / stats.getN();
        log("Kcp4 = " + Kcp[3]);

        stats.clear();
        ringWidth = 5;
        r = 5;
        for (int i = 0; i < 4; i ++) {
            CalcUtils.calculateRing(byteArray, stats, 50, 50, r, r + ringWidth - 1, 0);
            r += (ringWidth);
//			calculateRing(byteArray, stats, 50, 50, r, r + ringWidth - 1, 1);
            r += (ringWidth);
        }
        Kcp[4] = stats.getSum() / stats.getN();
        log("Kcp5 = " + Kcp[4]);

        stats.clear();
        ringWidth = 6;
        r = 6;
        for (int i = 0; i < 3; i ++) {
//			calculateRing(byteArray, stats, 210, 210, r, r + ringWidth - 1, 0);
            r += (ringWidth);
            CalcUtils.calculateRing(byteArray, stats, 210, 210, r, r + ringWidth - 1, 1);
            r += (ringWidth);
        }
        double backgroundMean6 = stats.getMean();
        log("backgeroundmean6: " + backgroundMean6);

        stats.clear();
        ringWidth = 6;
        r = 6;
        for (int i = 0; i < 3; i ++) {
            CalcUtils.calculateRing(byteArray, stats, 210, 210, r, r + ringWidth - 1, 0);
            r += (ringWidth);
//			calculateRing(byteArray, stats, 210, 210, r, r + ringWidth - 1, 1);
            r += (ringWidth);
        }
        Kcp[5] = stats.getSum() / stats.getN();
        log("Kcp6 = " + Kcp[5]);

        return Kcp;
    }

    private static void log(String log) {
        System.out.println(log);
    }
}


