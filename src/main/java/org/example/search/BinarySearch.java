package org.example.search;

public record BinarySearch(int[] numbers) {

    /**
     * Search for number in an ordered array.
     *
     * @param number searched number
     * @return index of searched number in array or -1 if not found
     */
    public int forNumber(int number) {
        int actualMiddle = middleOf(0, numbers.length);
        int start = 0;
        int end = numbers.length;
        int iterations = 0;
        while (!arrayScanned(iterations)) {
            if (numbers[actualMiddle] == number) {
                return actualMiddle;
            } else if (number > numbers[actualMiddle]) {
                start = actualMiddle;
                actualMiddle = middleOf(start, end);
            } else if (number < numbers[actualMiddle]) {
                end = actualMiddle;
                actualMiddle = middleOf(start, end);
            } else {
                break;
            }
            iterations++;
        }
        return -1;
    }

    private boolean arrayScanned(int iterations) {
        return iterations == numbers.length;
    }

    public static int middleOf(int start, int end) {
        return start + (end - start) / 2;
    }

}
