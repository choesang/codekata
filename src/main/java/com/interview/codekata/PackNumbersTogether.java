package com.interview.codekata;

import java.util.ArrayList;
import java.util.List;

public class PackNumbersTogether {

    List<String> packNumbers(List<Integer> arr) {
        Integer prev = null;
        int count = 0;

        List<String> list = new ArrayList<>();

        for (int i=0; i<arr.size(); i++) {
            int current = arr.get(i);
            if (i == arr.size()-1) {        // last item
                lastItem(prev, count, list, current);
                break;
            }
            if (i == 0) {                   // first item
                prev = current;
                count++;
            } else if (prev.equals(current)) { // previous item and current item are EQUAL
                count++;
            } else {                            // previous item and current item are NOT EQUAL
                if (count > 1) {                // duplicate numbers
                    list.add(prev + ":" + count);
                    count = 1;
                } else {                        // no duplicate numbers
                    list.add(String.valueOf(prev));
                    count = 1;
                }
                prev = current;
            }
        }
        return list;
    }

    private void lastItem(Integer prev, int count, List<String> list, int current) {
        if (prev.equals(current)) {
            count++;
            list.add(prev + ":" + count);
        } else {
            list.add(String.valueOf(prev));
            list.add(String.valueOf(current));
        }
    }
}
