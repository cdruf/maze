public class InteractiveWalkerStart implements MazeDisplayListener {

    private WalkerState myState;
    private Maze myMaze;
    private MazeDisplay display;

    public InteractiveWalkerStart(Maze maze, MazeDisplay md) {
        myMaze = maze;
        myState = maze.start();
        display = md;
        display.addMazeDisplayListener(this);
        display.displayState(myState);
    }

    public void onMazeInput(String action) {
        System.out.println(action);
    }

    public Maze getMyMaze() {
        return myMaze;
    }
}