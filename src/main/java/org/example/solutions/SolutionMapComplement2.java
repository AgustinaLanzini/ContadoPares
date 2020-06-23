package org.example.solutions;

import org.example.problem.IProblemSolver;

import java.util.*;

public class SolutionMapComplement2 implements IProblemSolver {

    @Override
    public List<Pair> isSumIn(int[] data, int sum) {

        List<Pair> pairs = new ArrayList<>();
        Map<Integer, Integer> integerMap = new HashMap<>();
        Arrays.sort(data);

		float middle = (float) sum / 2;
		int counter = 0;
        if (sum >=0) {
			int actual = data[0];
			int pos = 0;
			while ((pos < data.length) && (data[pos] < middle)) {
				counter++;
				if ((pos == data.length - 1) || (data[pos + 1] != actual)) {
					integerMap.put(actual, counter);
					if (!(pos == data.length - 1)) {
						actual = data[pos + 1];
						counter = 0;
					}
				}
				pos++;
			}
			while ((pos < data.length) && ((float) data[pos] == middle)) {
				counter++;
				int times = 0;
				if ((pos == data.length - 1) || (data[pos + 1] != actual)) {
					for (int i = 2; i < counter; i++) {
						times = times + counter - 1;
					}
					for (int i = 1; i <= times; i++)
						pairs.add(new IProblemSolver.Pair(actual, actual));
					if (!(pos == data.length - 1)) {
						actual = data[pos + 1];
						counter = 0;
					}
				}
				pos++;
			}
			while (pos < data.length) {
				counter++;
				if ((pos == data.length - 1) || (data[pos + 1] != actual)) {
					Integer value = integerMap.get(sum - actual);
					if (value != null)
						for (int i = 1; i <= value * counter; i++)
							pairs.add(new IProblemSolver.Pair(actual, sum - actual));
					if (!(pos == data.length - 1)) {
						actual = data[pos + 1];
						counter = 0;
					}
				}
				pos++;
			}
		}
        else{
			int actual = data[data.length-1];
			int pos = data.length-1;
			while ((pos >= 0) && (data[pos] >= middle)) {
				counter++;
				if ((pos == 0) || (data[pos - 1] != actual)) {
					integerMap.put(actual, counter);
					if (!(pos == 0)) {
						actual = data[pos - 1];
						counter = 0;
					}
				}
				pos--;
			}
			while ((pos >= 0) && ((float) data[pos] == middle)) {
				counter++;
				int times = 0;
				if ((pos == 0) || (data[pos - 1] != actual)) {
					for (int i = data.length-2; i < counter; i++) { //no c
						times = times + counter - 1;
					}
					for (int i = 1; i <= times; i++)
						pairs.add(new IProblemSolver.Pair(actual, actual));
					if (!(pos == 0)) {
						actual = data[pos - 1];
						counter = 0;
					}
				}
				pos--;
			}
			while (pos >= 0) {
				counter++;
				if ((pos == 0) || (data[pos - 1] != actual)) {
					Integer value = integerMap.get(sum - actual);
					if (value != null) {
						for (int i = 1; i <= value * counter; i++)
							pairs.add(new IProblemSolver.Pair(actual, sum - actual));
					}
					if (!(pos == 0)) {
						actual = data[pos - 1];
						counter = 0;
					}
				}
				pos--;
			}
		}
        return pairs;

    }
}
