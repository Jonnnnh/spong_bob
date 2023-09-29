package parts;

import java.awt.*;

public class SmallHouse {
    private int x, y;
    private final Color color;

    public SmallHouse(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public void draw(Graphics2D g) {
        g.setColor(color);
        drawSmallHouse(g);
    }
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    private void drawSmallHouse(Graphics2D g) {
        g.setColor(new Color(0x3E3C67));
        int cornerRadius = 10;
        g.fillRoundRect(x, y + 120, 30, 50, cornerRadius, cornerRadius);
        g.fillRect(x + 5, y + 160, 20, 40);
        g.setColor(Color.BLACK);
        g.drawRoundRect(x, y + 120, 30, 50, cornerRadius, cornerRadius);
        g.drawRect(x + 5, y + 170, 20, 30);

        g.setColor(new Color(0x67658F));
        g.fillRect(x + 5, y + 130, 10, 10);
        g.fillRect(x + 15, y + 150, 10, 10);


    }
}
