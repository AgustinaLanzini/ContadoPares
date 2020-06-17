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
        for (int i=0; i<data.length;i++){
            if (Arrays.binarySearch(data, sum-data[i]) > 0)
                pairs.add(new Pair(data[i], sum-data[i]));
        }
        return pairs;
    }
}
