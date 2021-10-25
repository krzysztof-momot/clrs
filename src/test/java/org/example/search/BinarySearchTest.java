package org.example.search;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BinarySearchTest {

    private final Map<Integer, Integer> indexesToValuesMap = new HashMap<>();

    @BeforeEach
    private void setup() {
        indexesToValuesMap.put(0, 1);
        indexesToValuesMap.put(1, 4);
        indexesToValuesMap.put(2, 6);
        indexesToValuesMap.put(3, 9);
        indexesToValuesMap.put(4, 312);
        indexesToValuesMap.put(5, 4214);
        indexesToValuesMap.put(6, 543634);
        indexesToValuesMap.put(7, 2342343);
        indexesToValuesMap.put(8, 515125112);
    }

    @Test
    public void shouldFindNumber() {
        BinarySearch binarySearch = new BinarySearch(IntStream.of(1,4,6,9,312,4214,543634,2342343,515125112).toArray());

        for (Map.Entry<Integer, Integer> row : indexesToValuesMap.entrySet()) {
            assertEquals(row.getKey(), binarySearch.forNumber(row.getValue()));
        }
    }


    @Test
    public void shouldNotFindNumber() {
        BinarySearch binarySearch = new BinarySearch(IntStream.of(22,33,44,55,66,77,88,99,100).toArray());

        for (Map.Entry<Integer, Integer> row : indexesToValuesMap.entrySet()) {
            assertEquals(-1, binarySearch.forNumber(row.getValue()));
        }
    }

}