package org.example.solutions;

import org.example.problem.IProblemSolver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolutionSortSlice implements IProblemSolver {

    @Override
    public List<IProblemSolver.Pair> isSumIn(int[] data, int sum) {

        List<IProblemSolver.Pair> pairs = new ArrayList<>();

        Arrays.sort(data);
        if (sum >= 0 ) {
            int last = Arrays.binarySearch(data, sum - data[0]);
            if (last < 0){
                last = -last-1;
            }
            int it = last + 1;
            while ((it < data.length) && (data[it] == data[last])) {
                last = it;
                it++;
            }
            for (int i = 0; i < last ; i++) {
                int[] slice = Arrays.copyOfRange(data, i + 1, last+1);
                int position = Arrays.binarySearch(slice, sum - data[i]);
                if (position >= 0) {
                    pairs.add(new IProblemSolver.Pair(data[i], sum - data[i]));
                    int j = position + 1;
                    while ((j < slice.length) && (slice[j] == slice[position])) {
                        pairs.add(new IProblemSolver.Pair(data[i], sum - data[i]));
                        j++;
                    }
                    j = position - 1;
                    while ((j >= 0) && (j < slice.length) && (slice[j] == slice[position])) {
                        pairs.add(new IProblemSolver.Pair(data[i], sum - data[i]));
                        j--;
                    }
                }
            }
        }
        else {
            int first = Arrays.binarySearch(data, sum - data[data.length-1]);
            if (first < 0){
                first = -first -1;
            }
            int it = first - 1;
            while ((it >= 0) && (data[it] == data[first])) {
                first = it;
                it--;
            }
            for (int i = data.length-1; i > first; i--) {
                int[] slice = Arrays.copyOfRange(data, first, i-1);
                int position = Arrays.binarySearch(slice, sum - data[i]);
                if (position >= 0) {
                    pairs.add(new IProblemSolver.Pair(data[i], sum - data[i]));
                    int j = position + 1;
                    while ((j < slice.length) && (slice[j] == slice[position])) {
                        pairs.add(new IProblemSolver.Pair(data[i], sum - data[i]));
                        j++;
                    }
                    j = position - 1;
                    while ((j >= 0) && (j < slice.length) && (slice[j] == slice[position])) {
                        pairs.add(new IProblemSolver.Pair(data[i], sum - data[i]));
                        j--;
                    }
                }
            }
        }
        return pairs;
    }
}
