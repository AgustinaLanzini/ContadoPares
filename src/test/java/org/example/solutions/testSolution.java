package org.example.solutions;

import org.example.problem.IProblemSolver;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
	
public class testSolution {


	protected int[] arr1;
	protected int[] arr2;
	protected int[] arr3;
	protected int[] arr4;
	protected int[] arr5;
	protected int[] arr6;

	protected int target1;
	protected int target2;
	protected int target3;
	protected int target4;
	protected int target5;
	protected int target6;
	    
	protected int solution1;
	protected int solution2;
	protected int solution3;
	protected int solution4;
	protected int solution5;
	protected int solution6;
	    
	protected IProblemSolver solver;

	    @Before
	    public void setup() {

	        arr1 = new int[]{1, 5, 7, -1};
	        arr2 = new int[]{1, 5, 7, -1, 5};
	        arr3 = new int[]{1, 1, 1, 1};
	        arr4 = new int[]{10, 12, 10, 15, -1, 7, 6, 5, 4, 2, 1, 1, 1};
	        arr5 = new int[]{-3,-2,-5,-10,-20,-13,0,7,12};
	        arr6 = new int[]{10, 12, 10, -1, 7, 6, 5, 4, 2, 1, 0, 1};

	        target1 = 6;
	        target2 = 6;
	        target3 = 2;
	        target4 = 11;
	        target5 = -13;
	        target6 = 7;
	        
	        solution1 = 2;
	        solution2 = 3;
	        solution3 = 6;
	        solution4 = 9;
	        solution5 = 3;
	        solution6 = 4;
	        
	    }

	    public void testExample(IProblemSolver solver, int[] arr, int target, int solution) {
	        assertEquals(solution, solver.isSumIn(arr, target).size());
	    }
	    

}
