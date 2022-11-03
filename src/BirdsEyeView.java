import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

@SuppressWarnings("serial")
public class BirdsEyeView extends JFrame implements Observer, MazeDisplay {

    public static final Color WALL_COLOR = Color.black;
    public static final Color NO_WALL_COLOR = Color.white;
    public static final Color WALKER_COLOR = Color.red;
    public static final Color GOAL_COLOR = Color.green;

    private JLabel[][] labels;
    private ImageIcon[] walkerIcons;
    private JLabel currentPositionLabel;

    public BirdsEyeView(Maze maze, int size) {
        int columns = maze.numCols();
        int rows = maze.numRows();
        int windowWidth = columns * size + 6;
        int windowHeight = rows * size + 28;
        int xLocation = ((int) Toolkit.getDefaultToolkit().getScreenSize()
                .getWidth() - windowWidth) / 2;
        int yLocation = ((int) Toolkit.getDefaultToolkit().getScreenSize()
                .getHeight() - windowHeight) / 2;

        this.labels = new JLabel[columns][rows];

        this.setLayout(null);
        this.setSize(windowWidth, windowHeight);
        this.setLocation(xLocation, yLocation);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // draw maze
        for (int x = 0; x < columns; x++) {
            for (int y = 0; y < rows; y++) {
                labels[x][y] = new JLabel();

                labels[x][y].setSize(size, size);

                if (maze.isWall(new Location(x, y))) {
                    labels[x][y].setBackground(WALL_COLOR);
                } else {
                    labels[x][y].setBackground(NO_WALL_COLOR);
                }
                labels[x][y].setOpaque(true);
                labels[x][y].setBounds(x * size, y * size, size, size);

                this.add(labels[x][y]);
            }
        }

        // create walker icons
        walkerIcons = new ImageIcon[4];
        for (int i = 0; i < walkerIcons.length; i++) {
            BufferedImage img = null;
            try {
                img = ImageIO.read(new File("./data/bug_" + i + ".png"));
            } catch (IOException e) {
            }
            int type = img.getType() == 0 ? BufferedImage.TYPE_INT_ARGB : img
                    .getType();
            BufferedImage imgResized = new BufferedImage(size, size, type);
            Graphics2D g = imgResized.createGraphics();
            g.drawImage(img, 0, 0, size, size, null);
            g.dispose();
            ImageIcon icon = new ImageIcon(imgResized);
            walkerIcons[i] = icon;
        }

        // add walker
        currentPositionLabel = labels[maze.start().location.x][maze.start().location.y];
        currentPositionLabel.setIcon(walkerIcons[maze.start.direction.ordinal]);

        // add goal
        labels[maze.goal.x][maze.goal.y].setBackground(GOAL_COLOR);
    }

    @Override
    public void update(Observable obs, Object arg) {
        // Game model = (Game) obs;
        // for (int x = 0; x < labels.length; x++) { // 100
        // for (int y = 0; y < labels[x].length; y++) { // 200
        // if (model.getGrid()[x][y].isAlive()) {
        // labels[x][y].setBackground(Color.black);
        // } else {
        // labels[x][y].setBackground(Color.white);
        // }
        // }
        // }
    }

    @Override
    public void displayState(WalkerState state) {
        currentPositionLabel = labels[state.location.x][state.location.y];
        // currentBugLabel = new JLabel(walkerIcons[state.direction.ordinal]);
        // currentBugLabel.setSize(size, size);
        // currentPositionLabel.add(currentBugLabel);
        currentPositionLabel.setIcon(walkerIcons[state.direction.ordinal]);
    }

    @Override
    public void eraseState(WalkerState state) {
        // currentPositionLabel.remove(currentBugLabel);
        currentPositionLabel.setIcon(null);
    }

    @Override
    public void markLocation(Location loc) {
        // TODO so wie Fußspuren oder so

    }

    @Override
    public void unmarkLocation(Location loc) {
        // TODO Auto-generated method stub

    }

    @Override
    public void addMazeDisplayListener(MazeDisplayListener listener) {
        // TODO Auto-generated method stub

    }

    @Override
    public void removeMazeDisplayListener(MazeDisplayListener listener) {
        // TODO Auto-generated method stub

    }
}