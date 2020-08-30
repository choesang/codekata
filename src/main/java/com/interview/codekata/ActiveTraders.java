package com.interview.codekata;

import java.util.*;

public class ActiveTraders {

    /*
     * Complete the 'mostActive' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts STRING_ARRAY customers as parameter.
     */

    public List<String> mostActive(List<String> customers) {
        HashMap<String, Integer> map = new HashMap<>();
        List<String> activeCustomers = new ArrayList<>();
        for (String customer: customers) {
            map.merge(customer, 1, Integer::sum);
        }

        for (Map.Entry<String, Integer> entry: map.entrySet()) {
            if ((Double.valueOf(entry.getValue()) / (double) customers.size()) >= 0.05d) {
                activeCustomers.add(entry.getKey());
            }
        }
        Collections.sort(activeCustomers);
        return activeCustomers;
    }
}
