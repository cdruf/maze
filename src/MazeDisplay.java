public interface MazeDisplay {

    /**
     * displays the view of the maze appropriate for the given state.
     *
     * @param state
     */
    void displayState(WalkerState state);

    /**
     * erases appropriate parts of state display
     *
     * @param state
     */
    void eraseState(WalkerState state);

    /**
     * marks a location in the maze display
     *
     * @param loc
     */
    void markLocation(Location loc);

    /**
     * removes the mark for a location
     *
     * @param loc
     */
    void unmarkLocation(Location loc);

    /**
     * adds the listener to this display
     */
    void addMazeDisplayListener(MazeDisplayListener listener);

    /**
     * removes the listener from this display
     */
    void removeMazeDisplayListener(MazeDisplayListener listener);
}
