package org.example.chapter4.part1.task3.maxsubarray;

public class Main {
    public static void main(String[] args) {
        int[] A = {13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7};
        Result maxSubarray = findMaxSubarray(A, 0, A.length - 1);
        System.out.println(maxSubarray);
    }

    private static Result findMaxSubarray(int[] A, int low, int high) {
        if (high == low) {
            return new Result(low, high, A[low]);
        }
        else {
            int mid = (int) Math.floor((double) (low + high) / 2);
            Result leftResult = findMaxSubarray(A, low, mid);
            Result rightResult = findMaxSubarray(A, mid + 1, high);
            Result crossResult = findMaxCrossingSubarray(A, low, mid, high);
            if (leftResult.getSum() >= rightResult.getSum() && leftResult.getSum() >= crossResult.getSum()) {
                return leftResult;
            } else if (rightResult.getSum() >= leftResult.getSum() && rightResult.getSum() >= crossResult.getSum()) {
                return rightResult;
            } else {
                return crossResult;
            }
        }
    }

    private static Result findMaxCrossingSubarray(int[] A, int low, int mid, int high) {
        int leftSum = Integer.MIN_VALUE;
        int sum = 0;
        int maxLeft = mid;
        int maxRight = mid;
        for (int i = mid; i >= low; i--) {
            sum += A[i];
            if (sum > leftSum) {
                leftSum = sum;
                maxLeft = i;
            }
        }
        int rightSum = Integer.MIN_VALUE;
        sum = 0;
        for (int j = mid + 1; j <= high; j++) {
            sum += A[j];
            if (sum > rightSum) {
                rightSum = sum;
                maxRight = j;
            }
        }
        return new Result(maxLeft, maxRight, leftSum + rightSum);
    }
}
