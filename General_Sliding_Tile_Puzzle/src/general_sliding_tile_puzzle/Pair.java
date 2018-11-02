/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package general_sliding_tile_puzzle;

/**
 *
 * @author Moaz
 */
public class Pair {
    
    public Object First;
    public Object Second;

    public Pair() {
    }
    
    public Pair(int fr, int sc) {
        this.First = (int)fr;
        this.Second = (int)sc;
    }
    
    public Pair(int Step, Grid grid) {
        this.First = (int)Step;
        this.Second = (Grid)grid;
    }
    
    public Pair(Pair fr, Grid sc) {
        this.First =(Pair)( new Pair((int)fr.First, (int)fr.Second));
        this.Second = (Grid)sc;
    }
    
    
    
}
