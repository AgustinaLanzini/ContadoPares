package org.example.solutions;

import org.example.problem.IProblemSolver;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class SolutionMap implements IProblemSolver {

    @Override
    public List<Pair> isSumIn(int[] data, int sum) {

        List<IProblemSolver.Pair> pairs = new ArrayList<>();
        Map<Integer, Integer> integerMap = new LinkedHashMap<>();

        for (int i=0; i< data.length; i++){
            Integer value = integerMap.get(data[i]);
            //No deberían haber keys con null
            if (value != null){
                integerMap.put(data[i], value+1);
            }
            else
                integerMap.put(data[i], 1);
        }
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
