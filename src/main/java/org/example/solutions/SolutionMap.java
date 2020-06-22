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
