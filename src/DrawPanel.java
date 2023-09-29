import parts.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class DrawPanel extends JPanel implements ActionListener {

    private final Background background;
    private final SpongeBob spongeBob;
    private final Text text;
    private final Home home;
    private final Bubbles bubbles;
    private final SmallHouse smallHouse;

    private static final int TIMER_DELAY = 7;
    private static final int HOME_X = 800;
    private static final int HOME_Y = 425;
    private static final int BUBBLE_START_X = HOME_X + 225;
    private static final int BUBBLE_START_Y = HOME_Y - 310;
    private static final int BUBBLE_RESET_Y = -20;

    private final Timer t;
    private static final int NUM_BUBBLES = 10;
    private final ArrayList<Bubbles> bubblesList;
    private static final int NUM_HOUSES = 10;
    private final ArrayList<SmallHouse> smallHouses;
    private final ArrayList<Seaweed> seaweeds;
    private final ArrayList<Seaweed> seaweedsBackground;
    private final ArrayList<Stone> stones;

    public DrawPanel() {
        background = new Background(0, 0, 350, 0, new Color(0xFCF0A5), new Color(0x1775EC));
        spongeBob = new SpongeBob(300, 270);
        text = new Text(10, 50);
        home = new Home(HOME_X, HOME_Y);
        bubbles = new Bubbles(BUBBLE_START_X, BUBBLE_START_Y, new Color(0xD6DBDE));
        bubblesList = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < NUM_BUBBLES; i++) {
            int startX = random.nextInt(800);
            int startY = random.nextInt(600);
            bubblesList.add(new Bubbles(startX, startY,  new Color(0xCDD0D9)));
        }
        int minDistance = 50;
        smallHouses = new ArrayList<>();
        Random randomHome = new Random();
        smallHouse = new SmallHouse(200, 150, new Color(0x3D345E));

        for (int i = 0; i < NUM_HOUSES; ) {
            int x = randomHome.nextInt(1200);
            int y = randomHome.nextInt(20) + 150;
            Color color = new Color(randomHome.nextInt(0xFFFFFF));
            boolean tooClose = false;
            for (SmallHouse otherHouse : smallHouses) {
                if (isTooClose(x, y, otherHouse.getX(), otherHouse.getY(), minDistance)) {
                    tooClose = true;
                    break;
                }
            }
            if (isTooClose(x, y, smallHouse.getX(), smallHouse.getY(), minDistance)) {
                tooClose = true;
            }
            if (!tooClose) {
                smallHouses.add(new SmallHouse(x, y, color));
                i++;
            }
        }
        t = new Timer(TIMER_DELAY, this);
        t.start();

        seaweedsBackground = new ArrayList<>();
        int[][] seaweedBackgroundCoords = {
                {100, 400},
                {45, 450},
                {650, 430},
                {1020, 450}
        };

        stones = new ArrayList<>();
        addStones();

        for (int[] coord : seaweedBackgroundCoords) {
            int x = coord[0];
            for (int j = 0; j < 3; j++) {
                int height = 30 + (j * 15);
                Color color = new Color(0x2E8B57);
                int offsetX = (j * 6) + 10;
                float strokeThickness = 3.0f;
                seaweedsBackground.add(new Seaweed(x + offsetX, coord[1], height, color, strokeThickness));
            }
        }
        Random seaweedRandom = new Random();
        seaweeds = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int x = seaweedRandom.nextInt(1300);
            int height = 100 + seaweedRandom.nextInt(200);
            Color color = new Color(0x478C55);
            float strokeThickness = 5.0f;
            seaweeds.add(new Seaweed(x, 700, height, color, strokeThickness));
        }
    }
    private void addStones() {
        stones.add(new Stone(44, 440, 36, 18, new Color(0x504F5B)));
        stones.add(new Stone(100, 390, 37, 17,  new Color(0x575572)));
        stones.add(new Stone(649, 420, 37, 15,  new Color(0x4F4E59)));
        stones.add(new Stone(1018, 445, 37, 16,  new Color(0x425667)));
    }
    private boolean isTooClose(int x1, int y1, int x2, int y2, int minDistance) {
        int distance = (int) Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
        return distance < minDistance;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;

        g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        background.draw(g2D);
        text.draw(g2D);
        bubbles.drawBubbles(g2D);

        for (SmallHouse smallHouse : smallHouses) {
            smallHouse.draw(g2D);
        }

        smallHouse.draw(g2D);
        spongeBob.drawSpongeBob(g2D);
        home.draw(g2D);

        for (Bubbles bubble : bubblesList) {
            bubble.drawBubbles(g2D);
        }
        for (Seaweed seaweed : seaweedsBackground) {
            seaweed.draw(g2D);
        }
        for (Stone stone : stones) {
            stone.draw(g2D);
        }
        for (Seaweed seaweed : seaweeds) {
            seaweed.draw(g2D);
        }
    }

    private void updateBubbles() {
        bubbles.setY(bubbles.getY() - 2);
        bubbles.setX((int) (bubbles.getX() - 2 * Math.sin(bubbles.getY())));
        if (bubbles.getY() <= BUBBLE_RESET_Y) {
            bubbles.setX(BUBBLE_START_X);
            bubbles.setY(BUBBLE_START_Y);
        }
        for (Bubbles bubble : bubblesList) {
            bubble.setY(bubble.getY() - 2);
            bubble.setX((int) (bubble.getX() - 2 * Math.sin(bubble.getY())));
            if (bubble.getY() <= BUBBLE_RESET_Y) {
                Random random = new Random();
                bubble.setX(random.nextInt(1200));
                bubble.setY(random.nextInt(600));
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        spongeBob.animateEyes();
        updateBubbles();
        repaint();
        for (Seaweed seaweed : seaweedsBackground) {
            seaweed.animate();
        }
        for (Seaweed seaweed : seaweeds) {
            seaweed.animate();
        }
    }
}
