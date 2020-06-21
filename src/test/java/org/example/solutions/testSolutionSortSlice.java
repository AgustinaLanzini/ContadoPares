package org.example.solutions;

import org.junit.Before;
import org.junit.Test;

public class testSolutionSortSlice extends testSolution{
	
	@Before
	public void setupSortSlice() {
    	solver = new SolutionSortSlice();
	}
	
    @Test
    public void testSolutionSortSlice1() {
    	testExample(solver, arr1, target1, solution1);    	
    	
    }
    
    @Test
    public void testSolutionSortSlice2() {
    	testExample(solver, arr2, target2, solution2);
    }
    
    @Test
    public void testSolutionSortSlice3() {
    	testExample(solver, arr3, target3, solution3);
    }
    
    @Test
    public void testSolutionSortSlice4() {
    	testExample(solver, arr4, target4, solution4);
    }
    
    @Test
    public void testSolutionSortSlice5() {
    	testExample(solver, arr5, target5, solution5);
    }
    
    @Test
    public void testSolutionSortSlice6() {
    	testExample(solver, arr6, target6, solution6);
    }
}