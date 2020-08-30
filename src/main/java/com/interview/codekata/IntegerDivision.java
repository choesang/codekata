package com.interview.codekata;

import java.util.*;

public class IntegerDivision {
    /*
     * Complete the 'minOperations' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY arr
     *  2. INTEGER threshold
     *  3. INTEGER d
     */

    public int minOperations(List<Integer> arr, int threshold, int d) {
        int operations = 0;
        HashMap<Integer, Integer> map = populateMap(arr);

        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            while (!isThresholdReached(map.values(), threshold)) {
                int value = entry.getKey() / d;
                if (map.containsValue(value)) {
                    map.put(value, map.get(value)+1);
                    map.put(entry.getKey(), entry.getValue()-1);
//                    map.merge(value, 1, Integer::sum);
//                    map.merge(number, -1, Integer::sum);
                }
            }
        }
        return operations;
    }

    private HashMap<Integer, Integer> populateMap(List<Integer> arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (Integer number: arr) {
            map.merge(number, 1, Integer::sum);
        }
        return map;
    }

    public boolean isThresholdReached(Collection<Integer> values, int threshold) {
        return (Collections.max(values) >= threshold);
    }
}
