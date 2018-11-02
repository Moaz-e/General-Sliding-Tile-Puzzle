package general_sliding_tile_puzzle;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 *
 * @author Moaz
 */
public class Piece {

    private List<Square> MySquares;
    private Color MyColor;

    public Piece() {
        MySquares = new ArrayList<Square>();
        MyColor = new Color(255, 255, 255);
    }

    public Piece(Piece p) {
        MySquares = new ArrayList<Square>();
        MyColor = new Color(p.getColor().getRed(), p.getColor().getGreen(), p.getColor().getBlue());
        for (Square s : p.MySquares) {
            MySquares.add(new Square(s));
        }
        this.sort();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.MySquares);
        hash = 53 * hash + this.MyColor.getRed();
        hash = 53 * hash + this.MyColor.getGreen();
        hash = 53 * hash + this.MyColor.getBlue();
        return hash;
    }

    public Square getMin() {
        Square res = new Square();
        for (Square s : MySquares) {
            if (s.getPositionX() < res.getPositionX()) {
                res = new Square(s);
            } else if (s.getPositionX() == res.getPositionX() && s.getPositionY() < res.getPositionY()) {
                res = new Square(s);
            }
        }
        return res;
    }

    public void sort() {
        List<Square> L = new ArrayList<>();
        while (MySquares.size() > 0) {
            Square s = this.getMin();
            L.add(s);
            MySquares.remove(s);
        }
        MySquares = L;
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
        final Piece other = (Piece) obj;
        for (Square s : this.MySquares) {
            if (!other.MySquares.contains(s)) {
                return false;
            }
        }
        if (!Objects.equals(this.MyColor, other.MyColor)) {
            return false;
        }
        return true;
    }

    public void addSquare(Square s) {
        MySquares.add(s);
    }

    public List<Square> getSquares() {
        return MySquares;
    }

    public Color getColor() {
        return MyColor;
    }

    public void setSquares(List<Square> Squares) {
        MySquares = Squares;
    }

    public void setColor(Color C) {
        MyColor = C;
    }

    public boolean haveSquare(Square s) {
        for (Square s2 : MySquares) {
            if (s.getPositionX() == s2.getPositionX() && s.getPositionY() == s2.getPositionY()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Piece{" + "MySquares=" + MySquares + ", MyColor=" + MyColor + '}';
    }

    public Square getLastRightSquare() {
        Square res = MySquares.get(0);
        for (Square s : MySquares) {
            if (s.getPositionY() > res.getPositionY()) {
                res = s;
            }
        }
        return res;
    }

    public Square getLastDownSquare() {
        Square res = MySquares.get(0);
        for (Square s : MySquares) {
            if (s.getPositionX() > res.getPositionX()) {
                res = s;
            }
        }
        return res;
    }
}
