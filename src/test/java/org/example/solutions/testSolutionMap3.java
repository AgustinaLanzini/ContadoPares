package org.example.solutions;

import org.junit.Before;
import org.junit.Test;

public class testSolutionMap3 extends testSolution{
	
	@Before
	public void setupMap() {
    	solver = new SolutionMap3();
	}
	
    @Test
    public void testSolutionMap1() {
    	testExample(solver, arr1, target1, solution1);    	
    	
    }
    
    @Test
    public void testSolutionMap2() {
    	testExample(solver, arr2, target2, solution2);
    }
    
    @Test
    public void testSolutionMap3() {
    	testExample(solver, arr3, target3, solution3);
    }
    
    @Test
    public void testSolutionMap4() {
    	testExample(solver, arr4, target4, solution4);
    }
    
    @Test
    public void testSolutionMap5() {
    	testExample(solver, arr5, target5, solution5);
    }
    
    @Test
    public void testSolutionMap6() {
    	testExample(solver, arr6, target6, solution6);
    }
}