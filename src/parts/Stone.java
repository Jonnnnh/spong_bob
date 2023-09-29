package parts;

import java.awt.*;
import java.util.ArrayList;

public class Stone {
    private int x, y, width, height;
    private Color color;
    private static ArrayList<Stone> stones = new ArrayList<>();

    public Stone(int x, int y, int width, int height, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
        stones.add(this);
    }

    public void draw(Graphics2D g) {
        g.setColor(color);
        g.fillOval(x, y, width, height);
    }
}
