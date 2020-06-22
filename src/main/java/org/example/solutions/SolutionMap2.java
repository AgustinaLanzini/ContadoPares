package org.example.solutions;

import org.example.problem.IProblemSolver;

import java.util.*;

public class SolutionMap2 implements IProblemSolver {

    @Override
    public List<Pair> isSumIn(int[] data, int sum) {

        List<Pair> pairs = new ArrayList<>();
        Map<Integer, Integer> integerMap = new TreeMap<>();
        Arrays.sort(data);

        int actual;
        int counter;
        int pos;
        if (sum >= 0) {
            actual = data[0];
            counter = 0;
            pos=0;
            while ((pos < data.length) && (data[pos] <= sum - data[0])){
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
        }
        else {
            actual = data[data.length-1];
            counter = 0;
            pos=data.length-1;
            while ((pos >= 0) && (data[pos] >= sum - data[data.length-1])){
                counter++;
                if ((pos == 0) || (data[pos-1] != actual)){
                    integerMap.put(actual, counter);
                    if (pos != 0){
                        actual = data[pos-1];
                        counter=0;
                    }
                }
                pos--;
            }
        }

        /*
        List<Map.Entry> entries = new ArrayList<>();
        Iterator<Map.Entry> it = entries.iterator();
        boolean duplicated = false;
        for ((it != null) && !duplicated){
            int find = sum - ;
            if (k > find) {
                Integer times = integerMap.get(find);
                if (times != null){
                    for (int i=1; i<= times*v; i++)
                        pairs.add(new Pair(k, find));
                }
            }
            else
                if (k == find) {
                    Integer times = 0;
                    for (int i=2; i<v; i++){
                        times = times+v-1;
                    }
                    for (int i = 1; i <= times; i++)
                        pairs.add(new Pair(k, find));
                }
                else
                    duplicated = true;
        }

        */
        integerMap.forEach( (k, v) -> {         int find = sum- k;
                                                if (k > find) {
                                                    Integer times = integerMap.get(find);
                                                    if (times != null){
                                                        for (int i=1; i<= times*v; i++)
                                                            pairs.add(new Pair(k, find));
                                                    }
                                                }
                                                else
                                                    if (k == find) {
                                                        Integer times = 0;
                                                        for (int i=2; i<v; i++){
                                                            times = times+v-1;
                                                        }
                                                        for (int i = 1; i <= times; i++)
                                                            pairs.add(new Pair(k, find));
                                                    }
        });

        return pairs;
    }
}
