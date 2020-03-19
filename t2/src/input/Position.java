package input;

import java.util.Objects;

public final class Position {
    private int x;
    private int y;

    public Position() {
        x = 0;
        y = 0;
    }

    public Position(final int x1, final int y1) {
        this.x = x1;
        this.y = y1;
    }

    /**
     *
     * @param x linia pe care se afla eroul din cadrul
     *          matricei corespunzatoare hartii
     */
    public void setX(final int x) {
        this.x = x;
    }

    public int getX() {
        return x;
    }

    /**
     *
     * @param y coloana pe care se afla eroul din cadrul
     *          matricei corespunzatoare hartii
     */
    public void setY(final int y) {
        this.y = y;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Position position = (Position) o;
        return x == position.x
                && y == position.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
