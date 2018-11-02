package general_sliding_tile_puzzle;

import java.awt.Color;
import java.util.*;
import static javafx.scene.input.KeyCode.C;

/**
 *
 * @author Moaz
 */
public class Grid {

    private int Width;
    private int Height;
    private List<Piece> MyPieces;

    public Grid() {
        Width = 4;
        Height = 4;
        MyPieces = new ArrayList<Piece>();
    }

    public Grid(Grid g) {
        this.Width = (new Integer(g.getWidth())).intValue();
        this.Height = (new Integer(g.getHeight())).intValue();
        this.MyPieces = new ArrayList<Piece>();
        for (Piece p : g.getPieces()) {
            this.MyPieces.add(new Piece(p));
        }
        this.sort();
    }

    public Grid(int Type) {
        List<Grid> Grids = new ArrayList<>();

        //  Grid 1 :
        List<Piece> Pieces = new ArrayList<>();
        Piece P = new Piece();
        P.addSquare(new Square(1, 1));
        P.addSquare(new Square(2, 1));
        P.addSquare(new Square(1, 2));
        P.addSquare(new Square(1, 3));
        P.addSquare(new Square(2, 3));
        P.addSquare(new Square(3, 3));
        P.setColor(Color.red);
        Pieces.add(P);

        P = new Piece();
        P.addSquare(new Square(3, 1));
        P.addSquare(new Square(3, 2));
        P.addSquare(new Square(2, 2));
        P.setColor(Color.yellow);
        Pieces.add(P);
        Grid g = new Grid(4, 4, Pieces);
        Grids.add(g);

        // Grid 2 :
        Pieces = new ArrayList<>();

        P = new Piece();
        P.addSquare(new Square(2, 1));
        P.addSquare(new Square(3, 1));
        P.addSquare(new Square(3, 2));
        P.setColor(Color.red);
        Pieces.add(P);

        P = new Piece();
        P.addSquare(new Square(2, 3));
        P.addSquare(new Square(3, 3));
        P.addSquare(new Square(3, 4));
        P.addSquare(new Square(4, 4));
        P.setColor(Color.yellow);
        Pieces.add(P);

        P = new Piece();
        P.addSquare(new Square(4, 2));
        P.addSquare(new Square(4, 3));
        P.setColor(Color.blue);
        Pieces.add(P);
        g = new Grid(4, 4, Pieces);

        Grids.add(g);

        // Grid 3 :
        Pieces = new ArrayList<>();

        P = new Piece();
        P.addSquare(new Square(1, 3));
        P.addSquare(new Square(1, 4));
        P.addSquare(new Square(2, 3));
        P.setColor(Color.red);
        Pieces.add(P);

        P = new Piece();
        P.addSquare(new Square(2, 1));
        P.addSquare(new Square(2, 2));
        P.setColor(Color.yellow);
        Pieces.add(P);

        P = new Piece();
        P.addSquare(new Square(3, 2));
        P.addSquare(new Square(4, 1));
        P.addSquare(new Square(4, 2));
        P.setColor(Color.blue);
        Pieces.add(P);

        P = new Piece();
        P.addSquare(new Square(3, 3));
        P.addSquare(new Square(4, 3));
        P.setColor(Color.magenta);
        Pieces.add(P);
        g = new Grid(4, 4, Pieces);

        Grids.add(g);
        // Grid 4 :
        Pieces = new ArrayList<>();

        P = new Piece();
        P.addSquare(new Square(1, 1));
        P.addSquare(new Square(2, 1));
        P.setColor(Color.red);
        Pieces.add(P);

        P = new Piece();
        P.addSquare(new Square(1, 3));
        P.addSquare(new Square(1, 4));
        P.setColor(Color.yellow);
        Pieces.add(P);

        P = new Piece();
        P.addSquare(new Square(2, 3));
        P.addSquare(new Square(3, 3));
        P.addSquare(new Square(3, 4));
        P.setColor(Color.blue);
        Pieces.add(P);

        P = new Piece();
        P.addSquare(new Square(3, 2));
        P.addSquare(new Square(4, 2));
        P.addSquare(new Square(4, 3));
        P.setColor(Color.blue);
        Pieces.add(P);

        P = new Piece();
        P.addSquare(new Square(3, 1));
        P.setColor(Color.magenta);
        Pieces.add(P);
        g = new Grid(4, 4, Pieces);

        Grids.add(g);
        // Grid 5 :
        Pieces = new ArrayList<>();

        P = new Piece();
        P.addSquare(new Square(1, 2));
        P.setColor(Color.red);
        Pieces.add(P);

        P = new Piece();
        P.addSquare(new Square(1, 3));
        P.addSquare(new Square(2, 2));
        P.addSquare(new Square(2, 3));
        P.addSquare(new Square(3, 3));
        P.setColor(Color.yellow);
        Pieces.add(P);

        P = new Piece();
        P.addSquare(new Square(2, 1));
        P.setColor(Color.blue);
        Pieces.add(P);

        P = new Piece();
        P.addSquare(new Square(2, 4));
        P.setColor(Color.blue);
        Pieces.add(P);

        P = new Piece();
        P.addSquare(new Square(3, 1));
        P.addSquare(new Square(3, 2));
        P.setColor(Color.magenta);
        Pieces.add(P);

        P = new Piece();
        P.addSquare(new Square(3, 4));
        P.addSquare(new Square(4, 3));
        P.addSquare(new Square(4, 4));
        P.setColor(Color.orange);
        Pieces.add(P);

        g = new Grid(4, 4, Pieces);

        Grids.add(g);

        // Grid 14 :
        Pieces = new ArrayList<>();

        P = new Piece();
        P.addSquare(new Square(1, 1));
        P.setColor(Color.red);
        Pieces.add(P);

        P = new Piece();
        P.addSquare(new Square(1, 2));
        P.setColor(Color.yellow);
        Pieces.add(P);

        P = new Piece();
        P.addSquare(new Square(1, 3));
        P.setColor(Color.yellow);
        Pieces.add(P);

        P = new Piece();
        P.addSquare(new Square(1, 4));
        P.setColor(Color.yellow);
        Pieces.add(P);
        
        P = new Piece();
        P.addSquare(new Square(2, 1));
        P.setColor(Color.yellow);
        Pieces.add(P);

        P = new Piece();
        P.addSquare(new Square(2, 2));
        P.setColor(Color.yellow);
        Pieces.add(P);
        P = new Piece();
        P.addSquare(new Square(2, 3));
        P.setColor(Color.yellow);
        Pieces.add(P);

        P = new Piece();
        P.addSquare(new Square(2, 4));
        P.setColor(Color.yellow);
        Pieces.add(P);
        P = new Piece();
        P.addSquare(new Square(3, 1));
        P.setColor(Color.yellow);
        Pieces.add(P);
        P = new Piece();
        P.addSquare(new Square(3, 2));
        P.setColor(Color.yellow);
        Pieces.add(P);

        P = new Piece();
        P.addSquare(new Square(3, 3));
        P.setColor(Color.yellow);
        Pieces.add(P);

        P = new Piece();
        P.addSquare(new Square(3, 4));
        P.setColor(Color.yellow);
        Pieces.add(P);

        P = new Piece();
        P.addSquare(new Square(4, 1));
        P.setColor(Color.yellow);
        Pieces.add(P);

        P = new Piece();
        P.addSquare(new Square(4, 2));
        P.setColor(Color.yellow);
        Pieces.add(P);

        P = new Piece();
        P.addSquare(new Square(4, 3));
        P.setColor(Color.yellow);
        Pieces.add(P);
        g = new Grid(4, 4, Pieces);

        Grids.add(g);
        // ends

        // Grid 7 :
        Pieces = new ArrayList<>();

        P = new Piece();
        P.addSquare(new Square(1, 2));
        P.addSquare(new Square(1, 3));
        P.setColor(Color.red);
        Pieces.add(P);

        P = new Piece();
        P.addSquare(new Square(1, 4));
        P.addSquare(new Square(2, 4));
        P.setColor(Color.yellow);
        Pieces.add(P);

        P = new Piece();
        P.addSquare(new Square(3, 4));
        P.addSquare(new Square(4, 4));
        P.setColor(Color.yellow);
        Pieces.add(P);

        P = new Piece();
        P.addSquare(new Square(2, 1));
        P.addSquare(new Square(2, 2));
        P.setColor(Color.blue);
        Pieces.add(P);

        P = new Piece();
        P.addSquare(new Square(3, 2));
        P.addSquare(new Square(3, 3));
        P.setColor(Color.blue);
        Pieces.add(P);

        P = new Piece();
        P.addSquare(new Square(3, 1));
        P.addSquare(new Square(4, 1));
        P.setColor(Color.yellow);
        Pieces.add(P);

        P = new Piece();
        P.addSquare(new Square(2, 3));
        P.setColor(Color.pink);
        Pieces.add(P);

        P = new Piece();
        P.addSquare(new Square(4, 3));
        P.setColor(Color.pink);
        Pieces.add(P);

        g = new Grid(4, 4, Pieces);

        Grids.add(g);
        // ends
        g = Grids.get(Type - 1);

        this.Width = g.Width;
        this.Height = g.Height;
        this.MyPieces = g.MyPieces;

    }

    public Grid(int Width, int Height, List<Piece> MyPieces) {
        this.Width = Width;
        this.Height = Height;
        this.MyPieces = MyPieces;
        this.sort();
    }

    public void setPieces(List<Piece> Pieces) {
        MyPieces = Pieces;
    }

    public List<Piece> getPieces() {
        return MyPieces;
    }

    public int getWidth() {
        return Width;
    }

    public int getHeight() {
        return Height;
    }

    public Piece getRight(Piece piece) {
        Piece P_Right = new Piece();
        P_Right.setColor(piece.getColor());
        for (Square s : piece.getSquares()) {
            P_Right.addSquare(s.getRight());
        }
        return P_Right;
    }

    public Piece getLeft(Piece piece) {
        Piece P_Left = new Piece();
        P_Left.setColor(piece.getColor());
        for (Square s : piece.getSquares()) {
            P_Left.addSquare(s.getLeft());
        }
        return P_Left;
    }

    public Piece getUp(Piece piece) {
        Piece P_Up = new Piece();
        P_Up.setColor(piece.getColor());
        for (Square s : piece.getSquares()) {
            P_Up.addSquare(s.getUp());
        }
        return P_Up;
    }

    public Piece getDown(Piece piece) {
        Piece P_Down = new Piece();
        P_Down.setColor(piece.getColor());
        for (Square s : piece.getSquares()) {
            P_Down.addSquare(s.getDown());
        }
        return P_Down;
    }

    public boolean canMoveToRight(int indixPiece) {
        if (indixPiece >= MyPieces.size()) {
            return false;
        }
        Piece P = MyPieces.get(indixPiece);
        Piece P_Right = getRight(P);

        for (Square s : P_Right.getSquares()) {
            if (s.outBounds(Width, Height)) {
//                System.out.println("Out");
                return false;
            }
        }
        int i = 0;
        for (Piece P2 : MyPieces) {
            if (i == indixPiece) {
                i++;
                continue;
            }
            if (TanglePieces(P_Right, P2)) {
//                System.out.println("Tangle");
                return false;
            }
            i++;
        }
        return true;
    }

    public boolean canMoveToLeft(int indixPiece) {
        if (indixPiece >= MyPieces.size()) {
            return false;
        }
        Piece P = MyPieces.get(indixPiece);
        Piece P_Left = getLeft(P);

        for (Square s : P_Left.getSquares()) {
            if (s.outBounds(Width, Height)) {
//                System.out.println("Out");
                return false;
            }
        }
        int i = 0;
        for (Piece P2 : MyPieces) {
            if (i == indixPiece) {
                i++;
                continue;
            }
            if (TanglePieces(P_Left, P2)) {
//                System.out.println("Tangle");
                return false;
            }
            i++;
        }
        return true;
    }

    public boolean canMoveToUp(int indixPiece) {
        if (indixPiece >= MyPieces.size()) {
            return false;
        }
        Piece P = MyPieces.get(indixPiece);
        Piece P_Up = getUp(P);

        for (Square s : P_Up.getSquares()) {
            if (s.outBounds(Width, Height)) {
//                System.out.println("Out");
                return false;
            }
        }
        int i = 0;
        for (Piece P2 : MyPieces) {
            if (i == indixPiece) {
                i++;
                continue;
            }
            if (TanglePieces(P_Up, P2)) {
//                System.out.println("Tangle");
                return false;
            }
            i++;
        }
        return true;
    }

    public boolean canMoveToDown(int indixPiece) {
        if (indixPiece >= MyPieces.size()) {
            return false;
        }
        Piece P = MyPieces.get(indixPiece);
        Piece P_Down = getDown(P);

        for (Square s : P_Down.getSquares()) {
            if (s.outBounds(Width, Height)) {
//                System.out.println("Out");
                return false;
            }
        }
        int i = 0;
        for (Piece P2 : MyPieces) {
            if (i == indixPiece) {
                i++;
                continue;
            }
            if (TanglePieces(P_Down, P2)) {
//                System.out.println("Tangle");
                return false;
            }
            i++;
        }
        return true;
    }

    private boolean TanglePieces(Piece P1, Piece P2) {
        for (Square s : P1.getSquares()) {
            if (P2.haveSquare(s)) {
                return true;
            }
        }
        return false;
    }

    public Grid MoveToRight(int indixPiece) {
        if (indixPiece >= MyPieces.size()) {
            return null;
        }
        List<Piece> NewPieces = new ArrayList<Piece>();
        Piece P = MyPieces.get(indixPiece);
        Piece P_Right = getRight(P);
        for (int i = 0; i < MyPieces.size(); i++) {
            if (i != indixPiece) {
                NewPieces.add(MyPieces.get(i));
            }
        }
        NewPieces.add(P_Right);
        return new Grid(Width, Height, NewPieces);
    }

    public Grid MoveToLeft(int indixPiece) {
        if (indixPiece >= MyPieces.size()) {
            return null;
        }
        List<Piece> NewPieces = new ArrayList<Piece>();
        Piece P = MyPieces.get(indixPiece);
        Piece P_Left = getLeft(P);
        for (int i = 0; i < MyPieces.size(); i++) {
            if (i != indixPiece) {
                NewPieces.add(MyPieces.get(i));
            }
        }
        NewPieces.add(P_Left);
        return new Grid(Width, Height, NewPieces);
    }

    public Grid MoveToUp(int indixPiece) {
        if (indixPiece >= MyPieces.size()) {
            return null;
        }
        List<Piece> NewPieces = new ArrayList<Piece>();
        Piece P = MyPieces.get(indixPiece);
        Piece P_Up = getUp(P);
        for (int i = 0; i < MyPieces.size(); i++) {
            if (i != indixPiece) {
                NewPieces.add(MyPieces.get(i));
            }
        }
        NewPieces.add(P_Up);
        return new Grid(Width, Height, NewPieces);
    }

    public Grid MoveToDown(int indixPiece) {
        if (indixPiece >= MyPieces.size()) {
            return null;
        }
        List<Piece> NewPieces = new ArrayList<Piece>();
        Piece P = MyPieces.get(indixPiece);
        Piece P_Down = getDown(P);
        for (int i = 0; i < MyPieces.size(); i++) {
            if (i != indixPiece) {
                NewPieces.add(MyPieces.get(i));
            }
        }
        NewPieces.add(P_Down);
        return new Grid(Width, Height, NewPieces);
    }

    public boolean checkEndState() {
        for (Piece piece : MyPieces) {
            if (piece.getColor().getRed() == 255 && piece.getColor().getBlue() == 0 && piece.getColor().getGreen() == 0) {
                if (piece.getLastRightSquare().getPositionY() == Width && piece.getLastDownSquare().getPositionX() == Height) {
                    return true;
                }
                return false;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Grid{" + "Width=" + Width + ", Height=" + Height + ", MyPieces=" + MyPieces + '}' + "\n";
    }

    public List<Grid> generateAllState() {
        List<Grid> res = new ArrayList<>();
        int i = 0;
        for (Piece P : MyPieces) {
            if (canMoveToDown(i)) {
                Grid G = MoveToDown(i);
                res.add(new Grid(G));
            }
            if (canMoveToRight(i)) {
                Grid G = MoveToRight(i);
                res.add(new Grid(G));
            }
            if (canMoveToUp(i)) {
                Grid G = MoveToUp(i);
                res.add(new Grid(G));
            }
            if (canMoveToLeft(i)) {
                Grid G = MoveToLeft(i);
                res.add(new Grid(G));
            }
            i++;
        }
        return res;
    }

    public String getHexColor(Color c) {
        int red = (int) (c.getRed());
        String redString = Integer.toHexString(red);
        if (redString.length() == 1) {
            redString = "0" + redString;
        }
        int green = (int) (c.getGreen());
        String greenString = Integer.toHexString(green);
        if (greenString.length() == 1) {
            greenString = "0" + greenString;
        }
        int blue = (int) (c.getBlue());
        String blueString = Integer.toHexString(blue);
        if (blueString.length() == 1) {
            blueString = "0" + blueString;
        }
        String hexColor = "#" + redString + greenString + blueString;
        return hexColor;
    }

    public int cost() {
        int x = Math.abs(((int) this.Width) - ((int) this.MyPieces.get(0).getLastRightSquare().getPositionY()));
        int y = Math.abs(((int) this.Height) - ((int) this.MyPieces.get(0).getLastDownSquare().getPositionX()));
        return x + y;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + this.Width;
        hash = 67 * hash + this.Height;
        hash = 67 * hash + Objects.hashCode(this.MyPieces);
        return hash;
    }

    public Piece getMin() {
        if (this.getPieces().size() == 0) {
            return null;
        }
        Piece res = this.getPieces().get(0);
        for (Piece p : MyPieces) {
            if (p.getColor().getRed() == 255 && p.getColor().getGreen() == 0 && p.getColor().getBlue() == 0) {
                return new Piece(p);
            }
            if (p.getColor().getRed() < res.getColor().getRed()) {
                res = new Piece(p);
            } else if (p.getColor().getRed() == res.getColor().getRed() && p.getColor().getGreen() < res.getColor().getGreen()) {
                res = new Piece(p);
            } else if (p.getColor().getRed() == res.getColor().getRed() && p.getColor().getGreen() == res.getColor().getGreen() && p.getColor().getBlue() < res.getColor().getBlue()) {
                res = new Piece(p);
            } else if (p.getSquares().size() < res.getSquares().size()) {
                res = new Piece(p);
            } else if(p.getSquares().size() == res.getSquares().size()){
                p.sort();
                res.sort();
                for (int i = 0; i < p.getSquares().size(); i++) {
                    Square sp = p.getSquares().get(i);
                    Square sres = res.getSquares().get(i);
                    if (sp.getPositionX() < sres.getPositionX()) {
                        res = new Piece(p);
                        break;
                    } else if (sp.getPositionX() == sres.getPositionX() && sp.getPositionY() < sres.getPositionY()) {
                        res = new Piece(p);
                        break;
                    }
                }
            }
        }
        return res;
    }

    public void sort() {
        List<Piece> L = new ArrayList<>();
        while (MyPieces.size() > 0) {
            Piece p = this.getMin();
            L.add(p);
            MyPieces.remove(p);
        }
        MyPieces = L;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Grid other = (Grid) obj;
        if (this.Width != other.Width) {
            return false;
        }
        if (this.Height != other.Height) {
            return false;
        }
        for (Piece p : this.MyPieces) {
            if (!other.MyPieces.contains(p)) {
                return false;
            }
        }
        return true;
    }

}

/*

    public Grid dfs(Grid g, final HashMap<Grid, Grid> Map) {
        HashSet<Integer> Set = new HashSet<>();
        Stack<Grid> q = new Stack<>();
        g.id = 0;
        q.push(g);
        while (!q.isEmpty()) {
            Grid grid = q.pop();
            if (grid.checkEndState()) {
                System.out.println("End");
                System.out.println(grid);
                return grid;
            }
            if (Set.contains(grid.hashCode())) {
                continue;
            }
            Set.add(grid.hashCode());
            List<Grid> Child = grid.generateAllState();
            for (Grid c : Child) {
                c.id = 0;
                q.push(c);
                Map.put(c, grid);
            }
        }
        return null;
    }

    public Grid dij(Grid g, final HashMap<Grid, Grid> Map) {
        HashSet<Integer> Set = new HashSet<>();
        Comparator c = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Pair g1 = (Pair) o1;
                Pair g2 = (Pair) o2;
                Grid grid1 = (Grid) ((Pair) o1).Second;
                Grid grid2 = (Grid) ((Pair) o2).Second;
                boolean b = (int) g1.First + grid1.cost() < (int) g2.First + grid2.cost();
                if (b) {
                    return 1;
                } else {
                    return 0;
                }
            }
        };
        PriorityQueue<Pair> PQ = new PriorityQueue(c);
        PQ.add(new Pair(0, g));
        int x = 0;
        Map.put(g, null);
        while (!PQ.isEmpty()) {
            x++;
            Pair pair = PQ.poll();
            int step = (int) pair.First;
            Grid grid = (Grid) pair.Second;
            if (Set.contains(grid.hashCode())) {
                continue;
            }
            Set.add(grid.hashCode());
            if (grid.checkEndState()) {
                System.out.println("End");
                System.out.println(grid);
                System.out.println("x = " + x);
                return new Grid(grid);
            }
            List<Grid> Child = grid.generateAllState();
            for (Grid cc : Child) {
                Pair pp = new Pair(step + 1, cc);
                PQ.add(pp);
                Map.put(cc, grid);
            }
        }
        return null;
    }

    public Grid dij1(Grid g, final HashMap<Grid, Grid> Map) {
        HashSet<Grid> Set = new HashSet<>();
        Comparator c = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Pair g1 = (Pair) o1;
                Pair g2 = (Pair) o2;
                boolean b = (int) ((Pair) g1.First).First >= (int) ((Pair) g2.First).First;
                if (!b) {
                    return 1;
                } else {
                    return 0;
                }
            }
        };
        PriorityQueue<Pair> PQ = new PriorityQueue(c);
        int Cost = g.cost();
        Pair pp = new Pair(new Pair(Cost, 0), g);
        PQ.add(pp);
        int x = 0;
        while (!PQ.isEmpty()) {
            x++;
            Pair pair = PQ.poll();
            int step = (int) ((Pair) pair.First).Second;
            Grid grid = (Grid) pair.Second;
            if (Set.contains(grid)) {
                continue;
            }
            Set.add(grid);
            if (grid.checkEndState()) {
                System.out.println("End");
                System.out.println(grid);
                System.out.println("x = " + x);
                return new Grid(grid);
            }
            List<Grid> Child = grid.generateAllState();
            for (Grid cc : Child) {
                Cost = cc.cost() + step + 1;
                pp = new Pair(new Pair(Cost, step + 1), cc);
                PQ.add(pp);
                Map.put(new Grid(cc), new Grid(grid));
            }
        }
        return null;
    }

    public Grid dij2(Grid g) {
        HashMap<Grid, Pair> Map = new HashMap<>();
        HashSet<Integer> Set = new HashSet<>();
        Comparator c = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Grid g1 = (Grid) o1;
                Grid g2 = (Grid) o2;
                int x1 = 0, x2 = 0;
                if (Map.get(g1) != null) {
                    Pair p1 = Map.get(g1);
                    x1 = (int) p1.Second + 1;
                }
                if (Map.get(g2) != null) {
                    Pair p2 = Map.get(g2);
                    x2 = (int) p2.Second + 1;
                }
                boolean b = (x1 + g1.cost()) < (x2 + g2.cost());
                boolean c = (x1 + g1.cost()) == (x2 + g2.cost());
                if (b) {
                    return -1;
                } else if (c) {
                    return 0;
                } else {
                    return 1;
                }
            }
        };
        PriorityQueue<Grid> PQ = new PriorityQueue(c);
        PQ.add(g);
        while (!PQ.isEmpty()) {
            Grid grid = PQ.poll();
            int step = 0;
            if (Map.get(grid) != null) {
                Pair p = Map.get(grid);
                step = (int) p.Second + 1;
            }
            if (Set.contains(grid.hashCode())) {
                continue;
            }
            Set.add(grid.hashCode());
            if (grid.checkEndState()) {
                System.out.println("End");
                System.out.println(grid);
                return new Grid(grid);
            }
            List<Grid> Child = grid.generateAllState();
            for (Grid cc : Child) {
                PQ.add(cc);
                Pair p = new Pair(step, grid);
                Map.put(cc, p);
            }
        }
        return null;
    }
 */
