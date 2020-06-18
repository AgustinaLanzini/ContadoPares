package org.example.solutions;

import org.example.problem.IProblemSolver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Si sum es positivo puedo descargar la parte del arreglo mayor a ese numero para chequear
//Este recorre el arreglo completo y no busca por elementos contiguos idénticos
public class SolutionSort implements IProblemSolver {

    @Override
    public List<Pair> isSumIn(int[] data, int sum) {

        List<Pair> pairs = new ArrayList<>();

        Arrays.sort(data);
        for (int i=0; i<data.length-1;i++){
            int[] slice = Arrays.copyOfRange(data,i+1,data.length);
            int position = Arrays.binarySearch(slice, sum-data[i]);
            if (position >= 0){
                    pairs.add(new Pair(data[i], sum-data[i]));
                int j = position+1;
                while ((j >= 0) && (j<slice.length) && (slice[j] == slice[position])) {
                        pairs.add(new Pair(data[i], sum - data[i]));
                    j++;
                }
                j = position-1;
                while ((j >= 0) && (j<slice.length) && (slice[j] == slice[position])){
                        pairs.add(new Pair(data[i], sum - data[i]));
                    j--;
                }
            }
        }
        return pairs;
    }
}
