package org.example.solutions;

import org.junit.Before;
import org.junit.Test;

public class testSolutionMapComplement2 extends testSolution{
	
	@Before
	public void setupMapComplement() {
    	solver = new SolutionMapComplement2();
	}
	
    @Test
    public void testSolutionMapComplement1() {
    	testExample(solver, arr1, target1, solution1);    	
    	
    }
    
    @Test
    public void testSolutionMapComplement2() {
    	testExample(solver, arr2, target2, solution2);
    }
    
    @Test
    public void testSolutionMapComplement3() {
    	testExample(solver, arr3, target3, solution3);
    }
    
    @Test
    public void testSolutionMapComplement4() {
    	testExample(solver, arr4, target4, solution4);
    }
    
    @Test
    public void testSolutionMapComplement5() {
    	testExample(solver, arr5, target5, solution5);
    }
    
    @Test
    public void testSolutionMapComplement6() {
    	testExample(solver, arr6, target6, solution6);
    }
}