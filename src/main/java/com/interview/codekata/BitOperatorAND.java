package com.interview.codekata;

import java.util.List;

public class BitOperatorAND {

    public long countPairs(List<Integer> arr) {
        long count = 0l;
        for (int i=0; i<arr.size(); i++) {
            for (int j = i+1; j <arr.size(); j++) {
                int bitOperatorAND = arr.get(i) & arr.get(j);
                if (isPowerOf2(bitOperatorAND)) {
                    count++;
                }
            }
        }
        return count;
    }

    static boolean isPowerOf2(int num) {
        if(num != 0 && (num & (num - 1)) == 0)
            return true;
        return false;
    }
}
