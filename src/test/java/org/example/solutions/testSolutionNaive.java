package org.example.solutions;

import org.junit.Before;
import org.junit.Test;

public class testSolutionNaive extends testSolution{
	
	@Before
	public void setupNaive() {
    	solver = new SolutionNaive();
	}
	
    @Test
    public void testSolutionNaive1() {
    	testExample(solver, arr1, target1, solution1);    	
    	
    }
    
    @Test
    public void testSolutionNaive2() {
    	testExample(solver, arr2, target2, solution2);
    }
    
    @Test
    public void testSolutionNaive3() {
    	testExample(solver, arr3, target3, solution3);
    }
    
    @Test
    public void testSolutionNaive4() {
    	testExample(solver, arr4, target4, solution4);
    }
    
    @Test
    public void testSolutionNaive5() {
    	testExample(solver, arr5, target5, solution5);
    }
    
    @Test
    public void testSolutionNaive6() {
    	testExample(solver, arr6, target6, solution6);
    }
}