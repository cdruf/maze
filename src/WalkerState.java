public class WalkerState {

    Location location;
    Direction direction;

    WalkerState(Location loc, Direction dir) {
        location = loc;
        direction = dir;
    }

    WalkerState(WalkerState state) {
        // copy
        // TODO
    }

    /* getter */
    Location location() {
        return location;
    }

    Direction direction() {
        return direction;
    }

    /**
     * @return the direction 90 degrees to the left of the state's direction
     */
    Direction toLeft() {
        return direction.rotateLeft90();
    }

    /**
     * @return returns the direction 180 degrees from the state's direction
     */
    Direction toReverse() {
        return direction.rotate180();
    }

    Location neighborTo(Direction dir) {
        return new Location(location.x + direction.diffX, location.y
                + direction.diffY);

    }

    /* modifiers */

    void turnRight() {
        direction = direction.rotateRight90();
    }

    void turnLeft() {
        direction = direction.rotateLeft90();
    }

    void turnAround() {
        direction = direction.rotate180();
    }

    void moveForward() {
        location = new Location(location.x + direction.diffX, location.y
                + direction.diffY);
    }

    void moveToward(Direction dir) {
        location = new Location(location.x + dir.diffX, location.y + dir.diffY);
    }

}
