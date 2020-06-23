package org.example.solutions;

import org.example.problem.IProblemSolver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolutionSort implements IProblemSolver {

    @Override
    public List<Pair> isSumIn(int[] data, int sum) {

        List<Pair> pairs = new ArrayList<>();

        Arrays.sort(data);
        for (int i=0; i<data.length-1;i++){
            int position = Arrays.binarySearch(data, i+1, data.length, sum-data[i]);
            if (position >= 0){
                pairs.add(new Pair(data[i], sum-data[i]));
                int j = position+1;
                while ((j<data.length) && (data[j] == data[position])) {
                    pairs.add(new Pair(data[i], sum - data[i]));
                    j++;
                }
                j = position-1;
                while ((j > i) && (data[j] == data[position])){
                    pairs.add(new Pair(data[i], sum - data[i]));
                    j--;
                }
            }
        }
        return pairs;
    }
}
