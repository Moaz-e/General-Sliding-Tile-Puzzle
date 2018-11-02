/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algorithms;

import general_sliding_tile_puzzle.Grid;
import java.util.HashMap;

/**
 *
 * @author Moaz
 */
public abstract class Graph {

    public Grid MyGrid;
    public HashMap<Grid, Grid> Map;
    public int NumMoveToSolve;
    public int MinStepToSolve;

    abstract public Grid getSolve(Grid g);

    public int getMinStepToSolve() {
        MinStepToSolve = 0;
        Grid G = new Grid(MyGrid);
        while (Map.get(G) != null) {
            G = Map.get(G);
            MinStepToSolve++;
        }
        return MinStepToSolve;
    }

    public int getNumMoveToSolve() {
        return NumMoveToSolve;
    }
}
