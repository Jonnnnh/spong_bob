package parts;

import java.awt.*;
import java.awt.geom.GeneralPath;

public class Seaweed {
    private int x, y;
    private int height;
    private int phase;
    private Color color;
    private float strokeThickness;

    public Seaweed(int x, int y, int height, Color color, float strokeThickness) {
        this.x = x;
        this.y = y;
        this.height = height;
        this.phase = 0;
        this.color = color;
        this.strokeThickness = strokeThickness;
    }

    public void draw(Graphics2D g) {
        GeneralPath path = new GeneralPath();
        path.moveTo(x, y);

        for (int i = 0; i <= height; i += 10) {
            int offsetX = (int) (12 * Math.sin(Math.toRadians(i + phase)));
            path.lineTo(x + offsetX, y - i);
        }

        g.setColor(color);
        g.setStroke(new BasicStroke(strokeThickness));
        g.draw(path);
    }

    public void animate() {
        phase += 4;
        if (phase > 360) {
            phase -= 360;
        }
    }
}
