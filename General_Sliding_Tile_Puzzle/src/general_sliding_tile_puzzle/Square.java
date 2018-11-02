package general_sliding_tile_puzzle;

/**
 *
 * @author Moaz
 */
public class Square {

    private int PositionX;
    private int PositionY;

    public Square() {
        PositionX = 100;
        PositionY = 100;
    }

    public Square(int X, int Y) {
        PositionX = X;
        PositionY = Y;
    }

    public Square(Square s) {
        this.PositionX = (new Integer(s.getPositionX())).intValue();
        this.PositionY = (new Integer(s.getPositionY())).intValue();
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + this.PositionX;
        hash = 71 * hash + this.PositionY;
        return hash;
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
        final Square other = (Square) obj;
        if (this.PositionX != other.PositionX) {
            return false;
        }
        if (this.PositionY != other.PositionY) {
            return false;
        }
        return true;
    }

    public int getPositionX() {
        return PositionX;
    }

    public int getPositionY() {
        return PositionY;
    }

    public Square getRight() {
        return new Square(PositionX, PositionY + 1);
    }

    public Square getLeft() {
        return new Square(PositionX, PositionY - 1);
    }

    public Square getUp() {
        return new Square(PositionX - 1, PositionY);
    }

    public Square getDown() {
        return new Square(PositionX + 1, PositionY);
    }

    public boolean outBounds(int Width, int Height) {
        return !(PositionX >= 1 && PositionX <= Width
                && PositionY >= 1 && PositionY <= Height);
    }

    @Override
    public String toString() {
        return "Square{" + "PositionX=" + PositionX + ", PositionY=" + PositionY + '}';
    }

}
