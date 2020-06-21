package org.example.solutions;

import org.example.problem.IProblemSolver;

import java.util.*;

public class SolutionMap implements IProblemSolver {

    @Override
    public List<Pair> isSumIn(int[] data, int sum) {

        List<IProblemSolver.Pair> pairs = new ArrayList<>();
        Map<Integer, Integer> integerMap = new TreeMap<>();
        Arrays.sort(data);

        Integer actual = data[0];
        Integer counter = 1;
        int pos=1;
        while ( pos < data.length){
            if (data[pos] == actual)
                counter++;
            else{
                integerMap.put(actual, counter);
                actual = data[pos];
                counter=1;
            }
            pos++;
        }
        integerMap.put(actual, counter);
        /*long start = System.currentTimeMillis();
        for (int i=0; i< data.length; i++){
            Integer value = integerMap.get(data[i]);
            //No deberían haber keys con null
            if (value != null){
                integerMap.put(data[i], value+1);
            }
            else
                integerMap.put(data[i], 1);
        }
        start = System.currentTimeMillis() - start;
        System.out.println("Lo que en tarda en pasa de array a map: " + start);
        */
        integerMap.forEach( (k, v) -> {         int find = sum- k;
                                                if (k > find) {
                                                    Integer times = integerMap.get(find);
                                                    if (times != null){
                                                        for (int i=1; i<= times*v; i++)
                                                            pairs.add(new IProblemSolver.Pair(k, find));
                                                    }
                                                }
                                                else
                                                    if (k == find) {
                                                        Integer times = 0;
                                                        for (int i=2; i<v; i++){
                                                            times = times+v-1;
                                                        }
                                                        for (int i = 1; i <= times; i++)
                                                            pairs.add(new IProblemSolver.Pair(k, find));
                                                    }
        });
        return pairs;
    }
}