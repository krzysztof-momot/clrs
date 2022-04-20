package org.example.chapter4.part1.task3.maxsubarray;

public class BruteForce {

    static int[] A = {13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7};

    public static Result maxSubarray() {
        int hsum = A[0];
        Result result = new Result(0, 0, 0);
        for (int i = 0; i < A.length; i++) {
            int csum = 0;
            for (int j = i; j < A.length; j++) {
                csum = csum + A[j];
                if (csum > hsum) {
                    hsum = csum;
                    result = new Result(i, j, hsum);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Result maxSubarray = BruteForce.maxSubarray();
        System.out.println(maxSubarray);
    }
}
