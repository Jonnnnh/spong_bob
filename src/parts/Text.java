package parts;

import java.awt.*;

public class Text {
    private int x, y;

    public Text(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void draw(Graphics2D g) {
        g.setFont(new Font("TimesRoman", Font.PLAIN, 50));
        g.setColor(Color.GRAY);
        g.drawString("Sponge Bob", x + 2, y + 2);
        g.setColor(Color.BLACK);
        g.drawString("Sponge Bob", x, y);
    }
}