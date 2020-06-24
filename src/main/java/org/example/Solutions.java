package org.example;

import org.example.problem.IProblemSolver;
import org.example.problem.ProblemGen;
import org.example.solutions.*;

public class Solutions {

	public static void main(String[] args) {
		
		ProblemGen problemGen = new ProblemGen();
		
		IProblemSolver naive = new SolutionSort();

		for(int i=0;i<100;i++) {
			problemGen.genRandomProblem(100000000);
			long start = System.currentTimeMillis();
			System.out.println(" -- Pairs: " + naive.isSumIn(problemGen.getData(), (int)(Math.random() * 2 * Integer.MAX_VALUE + Integer.MIN_VALUE/2)).size());
			//naive.isSumIn(problemGen.getData(), (int)(Math.random() * 2 * Integer.MAX_VALUE + Integer.MIN_VALUE/2));
			start = System.currentTimeMillis() - start;
			System.out.println(start);
		}
	}
}
