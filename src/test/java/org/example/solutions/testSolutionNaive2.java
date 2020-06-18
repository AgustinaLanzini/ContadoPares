package org.example.solutions;

import org.example.problem.IProblemSolver;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class testSolutionNaive2 {
    int[] arr1;
    int[] arr2;
    int[] arr3;
    int[] arr4;
    int target1;
    int target2;
    int target3;
    int target4;
    IProblemSolver naive;

    @Before
    public void setup() {

        arr1 = new int[]{1, 5, 7, -1};
        arr2 = new int[]{1, 5, 7, -1, 5};
        arr3 = new int[]{1, 1, 1, 1};
        arr4 = new int[]{10, 12, 10, 15, -1, 7, 6, 5, 4, 2, 1, 1, 1};

        target1 = 6;
        target2 = 6;
        target3 = 2;
        target4 = 11;

        naive = new SolutionNaive2();
    }

    @Test
    public void testSolution1() {
        assertEquals(2, naive.isSumIn(arr1, target1).size());
    }
    @Test
    public void testSolution2() {
        assertEquals(3, naive.isSumIn(arr2, target2).size());
    }
    @Test
    public void testSolution3() {
        assertEquals(6, naive.isSumIn(arr3, target3).size());
    }
    @Test
    public void testSolution4() {
        assertEquals(9, naive.isSumIn(arr4, target4).size());
    }


}