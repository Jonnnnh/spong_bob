package parts;

import java.awt.*;

public class Bubbles {
    private int x, y;
    private Color color;

    public Bubbles(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void drawBubbles(Graphics2D g) {
        Composite originalComposite = g.getComposite();
        float alpha = 0.5f;
        g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
        g.setStroke(new BasicStroke(1));
        g.setColor(new Color(255, 255, 255, (int)(alpha * 255)));
        g.fillOval(x, y, 30, 30);
        g.setColor(color);
        float alphaShine = 0.7f;
        g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alphaShine));
        g.setColor(Color.WHITE);
        g.fillOval(x + 18, y + 6, 10, 14);
        g.drawOval(x, y, 30, 30);
        g.setComposite(originalComposite);
    }
}