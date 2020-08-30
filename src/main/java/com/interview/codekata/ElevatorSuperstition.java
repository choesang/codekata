package com.interview.codekata;

public class ElevatorSuperstition {

    public int getLuckyFloorNumber(int n) {
        for (int i=4; i<=n; i++) {
            if (String.valueOf(i).contains("4") || String.valueOf(i).contains("13")) {
                n++;
            }
        }
        return n;
    }
}
