/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algorithms;

import general_sliding_tile_puzzle.Grid;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/**
 *
 * @author Moaz
 */
public class DFS extends Graph {

    public DFS(Grid MyGrid) {
        this.MyGrid = new Grid(MyGrid);
        Map = new HashMap<>();
        NumMoveToSolve = 0;
        MinStepToSolve = 0;
    }

    @Override
    public Grid getSolve(Grid g) {
        Set<Integer> Set = new HashSet<>();
        Stack<Grid> q = new Stack<>();
        g = new Grid(g);
        q.add(g);
        Set.add(g.hashCode());
        while (!q.isEmpty()) {
            NumMoveToSolve++;
            Grid grid = q.pop();
            if (grid.checkEndState()) {
                System.out.println("End");
                System.out.println(grid);
                MyGrid = new Grid(grid);
                return grid;
            }
            List<Grid> Child = grid.generateAllState();
            for (Grid c : Child) {
                if (!Set.contains(c.hashCode())) {
                    Set.add(c.hashCode());
                    q.push(c);
                    Map.put(c, grid);
                }
            }
        }
        return null;
    }

}
