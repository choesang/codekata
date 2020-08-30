package com.interview.codekata;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class UnexpectedDemand {

    public int filledOrders(List<Integer> order, int capacity) {
        // sort the order
//        order.sort((t1, t2) -> {
//            if (t1.equals(t2)) {
//                return 0;
//            } else if (t1 > t2) {
//                return 1;
//            } else {
//                return -1;
//            }
//        });
        Collections.sort(order);
        int customersFulfilled = 0;
        int ordersTaken = 0;
        for (Integer count: order) {
            ordersTaken += count;
            if (capacity >= ordersTaken) {
                customersFulfilled++;
            } else {
                break;
            }
        }

        return customersFulfilled;


    }

}
