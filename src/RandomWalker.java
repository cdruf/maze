import java.util.Observable;
import java.util.Random;

public class RandomWalker extends Observable {

    private WalkerState myState;
    private Maze myMaze;
    private MazeDisplay myDisplay;
    private int speed;

    public RandomWalker(Maze maze, MazeDisplay md, int speed) {
        myMaze = maze;
        myState = maze.start();
        myDisplay = md;
        this.speed = speed;
        myDisplay.displayState(myState);

    }

    public void run() {
        Random rand = new Random();
        while (!myState.location().equals(myMaze.goal())) {
            myDisplay.eraseState(myState);
            myDisplay.markLocation(myState.location());
            int choice = rand.nextInt(10);
            if (choice < 7) {
                if (!myMaze.isWall(myState.neighborTo(myState.direction()))) {
                    myState.moveForward();
                }
            } else if (choice == 7)
                myState.turnRight();
            else if (choice == 8)
                myState.turnLeft();
            else
                // choice == 9
                myState.turnAround();

            myDisplay.displayState(myState);
            try {
                Thread.sleep(speed);
            } catch (InterruptedException ex) {
            }
        }
    }

    public Maze getMaze() {
        return myMaze;
    }
}