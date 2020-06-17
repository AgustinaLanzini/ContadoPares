package org.example;

import org.example.problem.IProblemSolver;
import org.example.problem.ProblemGen;
import org.example.solutions.SolutionNaive;
import org.junit.Before;
import org.junit.Test;

public class testContadorPares {

    @Before
    public void setup() {

    }

    @Test
    public void testSolutionNaive1() {
        ProblemGen problemGen = new ProblemGen();
        IProblemSolver naive = new SolutionNaive();

        //Warm-up. Ejecuto el problema un par de veces
        //for (int i = 0; i < 1000; i++) {
            //micro.getMinimum(list);
        //}

        //Cálculo el tiempo de ejecución
        for(int i=0;i<20;i++) {
            problemGen.genRandomProblem(100000);
//			System.out.println(Arrays.toString(problemGen.getData()));
            long time = System.nanoTime();
            //Evito imprimir por consola para el benchmark grax
            System.out.println(" -- Pairs: " + naive.isSumIn(problemGen.getData(), (int)(Math.random() * 2 * Integer.MAX_VALUE + Integer.MIN_VALUE/2)).size());
            time = System.nanoTime() - time;
            System.out.println("    ns: " + time);
        }
        //assertEquals(1,1);
    }


}
