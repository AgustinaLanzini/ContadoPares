package org.example.solutions;

import org.example.problem.IProblemSolver;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class testSolutionSortSlice {
    int[] arr1;
    int[] arr2;
    int[] arr3;
    int[] arr4;
    int[] arr5;
    int[] arr6;

    int target1;
    int target2;
    int target3;
    int target4;
    int target5;
    int target6;
    IProblemSolver naive;

    @Before
    public void setup() {

        arr1 = new int[]{1, 5, 7, -1};
        arr2 = new int[]{1, 5, 7, -1, 5};
        arr3 = new int[]{1, 1, 1, 1};
        arr4 = new int[]{10, 12, 10, 15, -1, 7, 6, 5, 4, 2, 1, 1, 1}; //-1, 1, 1, 1, 2, 4, 5, 6, 7, 10, 10, 12
        arr5 = new int[]{-3,-2,-5,-10,-20,-13,0,7,12};//-20, -13, -10, -5, -2, -3, 0, 7, 12
        arr6 = new int[]{10, 12, 10, -1, 7, 6, 5, 4, 2, 1, 0, 1}; //-1, 1, 1, 0, 2, 4, 5, 6, 7, 10, 10, 12

        target1 = 6;
        target2 = 6;
        target3 = 2;
        target4 = 11;
        target5 = -13;
        target6 = 7;
        naive = new SolutionSortSlice();
    }

    @Test
    public void testSolution1() {
        naive.isSumIn(arr1, target1).forEach(System.out::print);
        assertEquals(2, naive.isSumIn(arr1, target1).size());
    }
    @Test
    public void testSolution2() {
        naive.isSumIn(arr2, target2).forEach(System.out::print);
        assertEquals(3, naive.isSumIn(arr2, target2).size());
    }
    @Test
    public void testSolution3() {
        naive.isSumIn(arr3, target3).forEach(System.out::print);
        assertEquals(6, naive.isSumIn(arr3, target3).size());
    }
    @Test
    public void testSolution4() {
        naive.isSumIn(arr4, target4).forEach(System.out::print);
        assertEquals(9, naive.isSumIn(arr4, target4).size());
    }

    @Test
    public void testSolution5() {
        naive.isSumIn(arr5, target5).forEach(System.out::print);
        assertEquals(3, naive.isSumIn(arr5, target5).size());
    }

    @Test
    public void testSolution6() {
        naive.isSumIn(arr6, target6).forEach(System.out::print);
        assertEquals(4, naive.isSumIn(arr6, target6).size());
    }



}