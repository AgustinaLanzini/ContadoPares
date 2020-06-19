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
        	//System.out.println("Busco: " + (sum - data[0]));
            int last = Arrays.binarySearch(data, 1, data.length, (sum - data[0]));
            if (last < 0){
                last = -last-2; //índice anterior a donde debería encontrarse el valor, por lo tanto es el menor más proximo
                //System.out.println("El menor más proximo: " + data[last]);
            }
            else {
            	//busco repetidos
            	//System.out.println("Busco repetidos de " + data[last]);
	            int it = last + 1; 
	            while ((it < data.length) && (data[it] == data[last])) {
	                it++;
	            }
	            last = it-1; //ultimo repetido o fin del arreglo
	            //System.out.println("Ultimo repetido: " + last);
            }
            for (int i = 0; i < last ; i++) {
            	//System.out.println("Primero del corte: " + data[i+1] + " Ultimo: " + data[last]);
                //System.out.println("Con: " + data[i] );
            	//System.out.println("last: " + last );
                int position = Arrays.binarySearch(data, i+1, last+1, sum - data[i]);
                if (position >= 0){
                    pairs.add(new IProblemSolver.Pair(data[i], sum - data[i]));
                    int j = position + 1;
                    while ((j < data.length) && (j > i) && (data[j] == data[position])) {
                        pairs.add(new IProblemSolver.Pair(data[i], sum - data[i]));
                        j++;
                    }
                    j = position - 1;
                    while ((j >= 0) && (j > i) && (data[j] == data[position])) {
                        pairs.add(new IProblemSolver.Pair(data[i], sum - data[i]));
                        j--;
                    }
                }
            }
        }
        else {
        	//System.out.println("Busco: " + (sum - data[data.length-1]));
            int first = Arrays.binarySearch(data, 0, data.length-2, sum - data[data.length-1]); 
            if (first < 0){
                first = -first -1; //posición donde debería estar (elemento mayor al buscado)
                //System.out.println("El mayor más proximo: " + data[first]);
            }
            else {
            	//busco repetidos
            	//System.out.println("Busco repetidos de " + data[first]);
	            int it = first - 1;
	            while ((it >= 0) && (data[it] == data[first])) {
	                it--;
	            }
	            first = it +1;
            }
            for (int i = data.length-1; i > first; i--) {
                int position = Arrays.binarySearch(data, first, i-1, sum - data[i]);
                if (position >= 0) {
                    pairs.add(new IProblemSolver.Pair(data[i], sum - data[i]));
                    int j = position + 1;
                    while ((j < data.length) && (j < i) && (data[j] == data[position])) {
                        pairs.add(new IProblemSolver.Pair(data[i], sum - data[i]));
                        j++;
                    }
                    j = position - 1;
                    while ((j >= 0) && (j < i) && (data[j] == data[position])) {
                        pairs.add(new IProblemSolver.Pair(data[i], sum - data[i]));
                        j--;
                    }
                }
            }
        }
        return pairs;
    }
}
