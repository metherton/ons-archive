package com.ethertons;

import java.util.List;

public class RecursiveAdder {


    public static int add(List<Integer> listOfNumbers) {
        int runningTotal;
        assert listOfNumbers.size() > 0;
        if (listOfNumbers.size() == 1) {
            return listOfNumbers.get(0);
        } else {
            runningTotal = listOfNumbers.get(0) + listOfNumbers.get(1);
            listOfNumbers.set(0,runningTotal);
            listOfNumbers.remove(1);
            return add(listOfNumbers);
        }
    }
}
