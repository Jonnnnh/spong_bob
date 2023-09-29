package parts;

import java.awt.*;
import java.awt.geom.GeneralPath;

public class Background {
    private int x1, x2, y1, y2;
    private Color c1, c2;
    private Gary gary;

    public Background(int x1, int x2, int y1, int y2, Color c1, Color c2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.c1 = c1;
        this.c2 = c2;
        this.gary = new Gary(560, 520);
    }
    public void draw(Graphics2D g) {
        g.setColor(c1);
        g.fillRect(x1, y1, 1920, 1080);
        g.setColor(c2);
        g.fillRect(x2, y2, 1920, 350);
        g.setColor(new Color(0x494949));
        g.fillRect(x2, y1 + 120, 1920, 120);
        gary.draw(g);
        drawFlowers(g, x1, y1, new Color(0xFFE4EEEB, true));
        drawJellyfish(g, x1, y1);
    }
    private void drawFlowers(Graphics2D g, int x, int y, Color color) {
        GeneralPath path = new GeneralPath();
        path.moveTo(x + 166, y - 146);
        path.curveTo(x + 54, y - 208, x + 34, y - 56, x + 165, y - 133);
        path.moveTo(x + 191, y - 151);
        path.curveTo(x + 222, y - 275, x + 82, y - 251, x + 166, y - 146);
        path.moveTo(x + 194, y - 136);
        path.curveTo(x + 378, y - 213, x + 222, y - 253, x + 191, y - 151);
        path.moveTo(x + 165, y - 133);
        path.curveTo(x + 164, y - 3.5, x + 372, y - 88, x + 193, y - 136);
        g.setColor(color);
        g.drawOval(x + 168, y - 146, 15, 15);
        g.draw(path);
        path.reset();

        path.moveTo(x + 419, y - 259);
        path.curveTo(x + 270, y - 187, x + 429, y - 141, x + 440, y - 249);
        path.moveTo(x + 435, y - 272);
        path.curveTo(x + 449, y - 391, x + 301, y - 319, x + 419, y - 259);
        path.moveTo(x + 465, y - 256);
        path.curveTo(x + 633, y - 270, x + 498, y - 429, x + 435, y - 272);
        path.moveTo(x + 440, y - 247);
        path.curveTo(x + 440, y - 96, x + 610, y - 231, x + 465, y - 256);
        g.drawOval(x + 429, y - 267, 15, 15);
        g.draw(path);
        path.reset();
    }
    private void drawJellyfish(Graphics2D g, int x, int y) {
        drawFlowers(g, x, y, new Color(0xDC6AC6));
        drawFlowers(g, x + 650, y - 20, new Color(0x0CF5F5));
    }
}
