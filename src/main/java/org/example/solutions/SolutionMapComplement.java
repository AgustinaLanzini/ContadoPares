package org.example.solutions;

import org.example.problem.IProblemSolver;

import java.util.*;

public class SolutionMapComplement implements IProblemSolver {

    @Override
    public List<Pair> isSumIn(int[] data, int sum) {

        List<IProblemSolver.Pair> pairs = new ArrayList<>();
        Map<Integer, Integer> integerMap = new TreeMap<>();
        Arrays.sort(data);

        int actual = data[0];
        int counter = 1;
        int pos=1;
        while ( pos < data.length){
            if (data[pos] == actual)
                counter++;
            else{
            	if (actual != (float) sum/2){
	            	Integer value = integerMap.get(sum - actual);
	                if (value != null) {
	                	for (int i=1; i<= value*counter; i++)
	                        pairs.add(new IProblemSolver.Pair(actual, sum - actual));
	                }
	                else 
	                	integerMap.put(actual, counter);
            	}
            	else {
            		int times = 0;
                    for (int i=2; i<counter; i++){
                        times = times+counter-1;
                    }
                    for (int i = 1; i <= times; i++)
                        pairs.add(new IProblemSolver.Pair(actual,counter));
            	}           		
                actual = data[pos];
                counter=1;
            }
            pos++;
        }            	
        if (actual != sum/2){
        	Integer value = integerMap.get(sum - data[pos-1]);
            if (value != null) {
            	for (int i=1; i<= value*counter; i++)
                    pairs.add(new IProblemSolver.Pair(data[pos-1], sum - data[pos-1]));
            }
    	}
    	else {
    		int times = 0;
            for (int i=2; i<counter; i++){
                times = times+counter-1;
            }
            for (int i = 1; i <= times; i++)
                pairs.add(new IProblemSolver.Pair(actual,counter));
    	}     
        /*
        integerMap.put(actual, counter);
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
        });*/
        return pairs;
        
    }
}
