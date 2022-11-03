public class Direction {

    /* Static direction constants */
    public final static Direction NORTH = new Direction(0, 0, 1);
    public final static Direction EAST = new Direction(1, 1, 0);
    public final static Direction SOUTH = new Direction(2, 0, -1);
    public final static Direction WEST = new Direction(3, -1, 0);

    public final static Direction[] DIRECTIONS;

    static {
        DIRECTIONS = new Direction[4];
        DIRECTIONS[0] = NORTH;
        DIRECTIONS[1] = EAST;
        DIRECTIONS[2] = SOUTH;
        DIRECTIONS[3] = WEST;
    }

    /* Fields */
    public final int ordinal;
    public final int diffX;
    public final int diffY;
    public final boolean isHorizontal;

    private Direction(int ordinal, int diffX, int diffY) {
        this.ordinal = ordinal;
        this.diffX = diffX;
        this.diffY = diffY;
        this.isHorizontal = (diffX != 0);
    }

    public Direction rotateRight90() {
        return DIRECTIONS[(ordinal + 1) % 4];
    }

    public Direction rotateLeft90() {
        return DIRECTIONS[(ordinal - 1 + 4) % 4];
    }

    public Direction rotate180() {
        return DIRECTIONS[(ordinal + 2) % 4];
    }

    @Override
    public String toString() {
        return "Direction [ordinal=" + ordinal + ", diffX=" + diffX
                + ", diffY=" + diffY + ", isHorizontal=" + isHorizontal + "]";
    }

}
