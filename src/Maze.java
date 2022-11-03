import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;

public class Maze {

    int numRows;
    int numCols;

    boolean[][] walls;

    boolean[][] visible;

    WalkerState start;
    Location goal;

    /**
     * Initialize random from text file.
     */
    public Maze() {
        List<String> lines = TextFileReader.readLines("./data/my_maze.txt");
        numRows = lines.size();
        numCols = lines.get(0).length();
        walls = new boolean[numRows][numCols];
        visible = new boolean[numRows][numCols];

        for (int i = 0; i < lines.size(); i++) {
            for (int j = 0; j < lines.get(i).length(); j++) {
                if (lines.get(i).charAt(j) == '#') {
                    walls[i][j] = true;
                } else if (lines.get(i).charAt(j) == 's') {
                    start = new WalkerState(new Location(j, i), Direction.NORTH);
                } else if (lines.get(i).charAt(j) == 'g') {
                    goal = new Location(j, i);
                }
            }
        }
    }

    /* getter */
    int numRows() {
        return numRows;
    }

    int numCols() {
        return numCols;
    }

    /**
     * @return starting state
     */
    WalkerState start() {
        return start;
    }

    Location goal() {
        return goal;
    }

    boolean isWall(Location loc) {
        return walls[loc.y][loc.x];
    }

    @Override
    public String toString() {
        String str = "";
        for (int i = 0; i < numCols + 2; i++) {
            str += "~";
        }
        str += "\n";
        for (int i = 0; i < numRows; i++) {
            str += "~";
            for (int j = 0; j < numCols; j++) {
                if (walls[i][j]) {
                    str += "#";
                } else {
                    str += " ";
                }
            }
            str += "~\n";
        }
        for (int i = 0; i < numCols + 2; i++) {
            str += "~";
        }
        return str;
    }

}
