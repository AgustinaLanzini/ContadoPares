package org.example.solutions;

import org.example.problem.IProblemSolver;

import java.util.*;

public class SolutionMapNaive implements IProblemSolver {

    @Override
    public List<Pair> isSumIn(int[] data, int sum) {

        List<Pair> pairs = new ArrayList<>();
        Map<Integer, Integer> integerMap = new TreeMap<>();

        for (int i=0; i< data.length; i++){
            Integer value = integerMap.get(data[i]);
            if (value != null){
                integerMap.put(data[i], value+1);
            }
            else
                integerMap.put(data[i], 1);
        }

        integerMap.forEach( (k, v) -> {         if (k > sum- k) {
                                                    Integer times = integerMap.get(sum- k);
                                                    if (times != null){
                                                        for (int i=1; i<= times*v; i++)
                                                            pairs.add(new Pair(k, sum- k));
                                                    }
                                                }
                                                else
                                                    if (k == sum- k) {
                                                        int times = v*(v-1)/2;
                                                        for (int i = 1; i <= times; i++)
                                                            pairs.add(new Pair(k, sum- k));
                                                    }
        });
        return pairs;
    }
}
