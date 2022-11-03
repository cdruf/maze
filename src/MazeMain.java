public class MazeMain {

    public static final int SLOW = 300;
    public static final int NORMAL = 100;
    public static final int FAST = 50;
    public static final int SUPER_FAST = 1;
    public static final int SPEED_OF_LIGHT = 0;

    public static void main(String[] args) {
        // init model
        Maze maze = new Maze();
        System.out.println(maze.toString());
        BirdsEyeView gui = new BirdsEyeView(maze, 24);
        RandomWalker model = new RandomWalker(maze, gui, FAST);

        model.addObserver(gui);
        gui.setVisible(true);

        model.run();
    }
}
