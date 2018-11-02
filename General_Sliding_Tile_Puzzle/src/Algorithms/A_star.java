/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algorithms;

import general_sliding_tile_puzzle.Grid;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

/**
 *
 * @author Moaz
 */
public class A_star extends Graph {

    public HashMap<Grid, Integer> Step;
    Comparator c;

    public A_star(Grid MyGrid) {
        this.MyGrid = new Grid(MyGrid);
        Map = new HashMap<>();
        Step = new HashMap<>();
        NumMoveToSolve = 0;
        MinStepToSolve = 0;
        c = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {

                Grid grid1 = (Grid) o1;
                Grid grid2 = (Grid) o2;
                int dist1 = 0;
                if (Step.get(o1) != null) {
                    dist1 = Step.get(o1);
                }
                int dist2 = 0;
                if (Step.get(o2) != null) {
                    dist2 = Step.get(o2);
                }
                boolean b = dist1 + grid1.cost() > dist2 + grid2.cost();
                boolean c = dist1 + grid1.cost() < dist2 + grid2.cost();
                if (c) {
                    return -1;
                } else if (b) {
                    return 1;
                }
                return 0;
            }
        };

    }

    @Override
    public Grid getSolve(Grid g) {
        HashSet<Grid> Set = new HashSet<Grid>();
        PriorityQueue<Grid> PQ = new PriorityQueue(c);
        g = new Grid(g);
        PQ.add(g);
        Set.add(g);
        Step.put(g, 0);
        while (!PQ.isEmpty()) {
            NumMoveToSolve++;
            Grid grid = PQ.poll();
            int StepFather = Step.get(grid);
            if (grid.checkEndState()) {
                System.out.println("End");
                System.out.println(grid);
                MyGrid = new Grid(grid);
                return grid;
            }
            List<Grid> Child = grid.generateAllState();
            for (Grid cc : Child) {
                if (!Set.contains(cc)) {
                    Set.add(cc);
                    Step.put(cc, StepFather + 1);
                    PQ.add(cc);
                    Map.put(cc, grid);
                } else {
                    int x = Math.min(StepFather + 1, Step.get(cc));
                    if (StepFather + 1 < Step.get(cc)) {
                        Step.remove(cc);
                        Step.put(cc, x);
                        if (PQ.contains(cc)) {
                            PQ.remove(cc);
                        }
                        PQ.add(cc);
                    }
                }
            }
        }
        return null;
    }

}
