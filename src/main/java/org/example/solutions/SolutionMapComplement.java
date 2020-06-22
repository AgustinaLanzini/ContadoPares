package org.example.solutions;

import org.example.problem.IProblemSolver;

import java.util.*;

public class SolutionMapComplement implements IProblemSolver {

    @Override
    public List<Pair> isSumIn(int[] data, int sum) {

        List<IProblemSolver.Pair> pairs = new ArrayList<>();
        Map<Integer, Integer> integerMap = new HashMap<>();
        Arrays.sort(data);

        int actual = data[0];
        int counter = 0;
        int pos=0;
        //int lastAdded = data[data.length-1];
        //boolean adding = true;
        while (pos < data.length) { //&& (adding |	 (data[pos] <= (sum - lastAdded)))){ //  && !empty){
        	counter++;
        	if ((pos == data.length-1) || (data[pos+1] != actual)){
            	if (actual != (float) sum/2){
                    Integer value = integerMap.get(sum - actual);
                    if (value != null) {
                        for (int i=1; i<= value*counter; i++)
                            pairs.add(new IProblemSolver.Pair(actual, sum - actual));
                        //adding = false;
                    }
                    else {
                        integerMap.put(actual, counter);
                        //lastAdded=actual;
                    }
                }
            	else {
            		int times = 0;
                    for (int i=2; i<counter; i++){
                        times = times+counter-1;
                    }
                    for (int i = 1; i <= times; i++)
                        pairs.add(new IProblemSolver.Pair(actual,actual));
            		}
            	if (!(pos == data.length-1)) {
                    actual = data[pos+1];
                    counter=0;
            	}
            }
	        pos++;
        }
        return pairs;
        
    }
}
