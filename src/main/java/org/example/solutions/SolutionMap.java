package org.example.solutions;

import org.example.problem.IProblemSolver;

import java.util.*;

public class SolutionMap implements IProblemSolver {

    @Override
    public List<Pair> isSumIn(int[] data, int sum) {

        List<IProblemSolver.Pair> pairs = new ArrayList<>();
        Map<Integer, Integer> integerMap = new TreeMap<>();
        Arrays.sort(data);

        int actual = data[0];
        int counter = 0;
        int pos=0;
        while ( pos < data.length){
            counter++;
            if ((pos == data.length-1) || (data[pos+1] != actual)){
                integerMap.put(actual, counter);
                if (pos != data.length-1){
                    actual = data[pos+1];
                    counter=0;
                }
            }
            pos++;
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
