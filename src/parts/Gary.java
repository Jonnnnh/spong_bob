package parts;

import java.awt.*;
import java.awt.geom.GeneralPath;

public class Gary {
    private final int x, y;

    public Gary(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void draw(Graphics2D g) {
        drawBody(g);
        drawShell(g);
        drawEyes(g);
        drawingShell(g);

    }

    private void drawBody(Graphics2D g) {
        g.setColor(new Color(0x61B7CE));
        g.fillOval(x, y - 3, 100, 20);

    }

    private void drawEyes(Graphics2D g) {
        g.setColor(new Color(0x61B7CE));
        g.fillRect(x + 85, y - 50, 5, 60);
        g.fillRect(x + 75, y - 40, 5, 54);
        g.setStroke(new BasicStroke(1f));
        g.setColor(Color.BLACK);
        g.drawRect(x + 85, y - 50, 5, 60);
        g.drawRect(x + 75, y - 40, 5, 54);
        g.setColor(new Color(0xE1EEA3));
        g.fillOval(x + 83, y - 51, 20, 20);
        g.setColor(Color.BLACK);
        g.drawOval(x + 83, y - 51, 20, 20);
        g.setColor(new Color(0xE1EEA3));
        g.fillOval(x + 70, y - 43, 20, 20);
        g.setColor(Color.BLACK);
        g.drawOval(x + 70, y - 43, 20, 20);
        g.setColor(new Color(0xF57D3D));
        g.fillOval(x + 89, y - 47, 8, 8);
        g.fillOval(x + 77, y - 38, 8, 8);
        g.setColor(Color.BLACK);
        g.drawOval(x + 89, y - 47, 8, 8);
        g.drawOval(x + 77, y - 38, 8, 8);

        g.setColor(new Color(0x61B7CE));
        g.fillOval(x + 20, y + 2, 80, 15);
    }

    private void drawShell(Graphics2D g) {
        GeneralPath path = new GeneralPath();
        path.moveTo(x + 15, y);
        path.curveTo(x + 15, y, x - 15, y - 75, x + 40, y - 75);
        path.curveTo(x + 80, y - 75, x + 95, y - 75, x + 75, y);
        path.lineTo(x + 15, y);

        g.setColor(Color.black);
        g.setStroke(new BasicStroke(3f));
        g.draw(path);
        g.setColor(new Color(0xF4A097));
        g.fill(path);
    }

    private void drawingShell(Graphics2D g) {
        int yOffset = 0;
        int xOffset = +15;
        GeneralPath path = new GeneralPath();
        path.moveTo(x + 25 + xOffset, y - 24 + yOffset);
        path.curveTo(x + 1.6 + xOffset, y - 36 + yOffset, x + 69 + xOffset, y - 84 + yOffset, x + 29 + xOffset, y - 1 + yOffset);
        g.setColor(Color.RED);
        g.setStroke(new BasicStroke(2f));
        g.draw(path);
        g.setColor(new Color(0x2479AE));
        g.fillOval(x + 3 + xOffset, y - 45, 5, 5);
        g.fillOval(x + 10 + xOffset, y - 57, 7, 7);
        g.fillOval(x + 26 + xOffset, y - 66, 9, 9);
        g.fillOval(x + 50 + xOffset, y - 45, 5, 5);
        g.fillOval(x + 45 + xOffset, y - 58, 7, 7);

    }
}
