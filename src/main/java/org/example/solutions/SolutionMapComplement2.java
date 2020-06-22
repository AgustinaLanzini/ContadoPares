package org.example.solutions;

import org.example.problem.IProblemSolver;

import java.util.*;

public class SolutionMapComplement2 implements IProblemSolver {

    @Override
    public List<Pair> isSumIn(int[] data, int sum) {

        List<Pair> pairs = new ArrayList<>();
        Map<Integer, Integer> integerMap = new HashMap<>();
        Arrays.sort(data);

        if (sum > 0) {
            int actual = data[0];
            int counter = 0;
            int pos = 0;
            while (pos < data.length && (data[pos] <= actual - data[0])) { //&& (adding |	 (data[pos] <= (sum - lastAdded)))){ //  && !empty){
                counter++;
                if ((pos == data.length - 1) || (data[pos + 1] != actual)) {
                    if (actual != (float) sum / 2) {
                        Integer value = integerMap.get(sum - actual);
                        if (value != null) {
                            for (int i = 1; i <= value * counter; i++)
                                pairs.add(new Pair(actual, sum - actual));
                        } else {
                            integerMap.put(actual, counter);
                        }
                    } else {
                        int times = 0;
                        for (int i = 2; i < counter; i++) {
                            times = times + counter - 1;
                        }
                        for (int i = 1; i <= times; i++)
                            pairs.add(new Pair(actual, counter));
                    }
                    if (!(pos == data.length - 1)) {
                        actual = data[pos + 1];
                        counter = 0;
                    }
                }
                pos++;
            }
        }
        else{}
        return pairs;

    }
}
