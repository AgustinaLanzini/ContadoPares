package org.example.solutions;

import org.example.problem.IProblemSolver;
import org.example.problem.ProblemGen;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class testSolutionNaive {
    /*
    List<ProblemGen> problems = new ArrayList<>();
    ProblemGen problem1;
    ProblemGen problem2;
    ProblemGen problem3;
    */

    int[] arr1;
    int[] arr2;
    int[] arr3;
    int[] arr4;
    int[] arr5;
    int target1;
    int target2;
    int target3;
    int target4;
    int target5;
    IProblemSolver naive;

    @Before
    public void setup() {
    /*
        problem1= new ProblemGen();
        problem2= new ProblemGen();
        problem3= new ProblemGen();

        problems.add(problem1);
        problems.add(problem2);
        problems.add(problem3);
    */
        arr1 = new int[]{1, 5, 7, -1};
        arr2 = new int[]{1, 5, 7, -1, 5};
        arr3 = new int[]{1, 1, 1, 1};
        arr4 = new int[]{10, 12, 10, 15, -1, 7, 6, 5, 4, 2, 1, 1, 1};
        arr5 = new int[]{-3,-2,-5,-10,-20,-13,0,7,12};

        target1 = 6;
        target2 = 6;
        target3 = 2;
        target4 = 11;
        target5 = -13;

        naive = new SolutionNaive();
    }
    /*
    @Test
    public void testSolutionNaive1() {
        IProblemSolver naive = new SolutionNaive();
        assertTrue(((2 == naive.isSumIn(arr1, target1).size())
                && (3 == naive.isSumIn(arr1, target1).size())
                && (6 == naive.isSumIn(arr1, target1).size())
                && (9 == naive.isSumIn(arr1, target1).size())));

        //assertEquals(1, naive.isSumIn(problem1.getData(), problem1.getTarget()));
    }*/

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
    @Test
    public void testSolution5() {
        naive.isSumIn(arr5, target5).forEach(System.out::print);
        assertEquals(3, naive.isSumIn(arr5, target5).size());
    }


}