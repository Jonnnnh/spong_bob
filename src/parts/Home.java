package parts;

import java.awt.*;
import java.awt.geom.GeneralPath;

public class Home {

    private final int x, y;

    public Home(int x, int y) {
        this.x = x;
        this.y = y;


    }

    public void draw(Graphics2D g) {
        drawFlue(g);
        drawPineAppleBody(g);
        drawArcsOnPineApple(g);
        drawDoor(g);
        drawWindows(g);
        drawSidewalk(g);
        drawLeaves(g);

    }

    private void drawPineAppleBody(Graphics2D g) {
        GeneralPath path = new GeneralPath();
        path.moveTo(x, y);
        path.curveTo(x, y, x - 100, y - 125, x + 30, y - 295);
        path.lineTo(x + 170,y - 295);
        path.curveTo(x + 170,  y - 295, x + 300, y - 125, x + 200, y);
        path.lineTo(x, y);


        g.setColor(Color.BLACK);
        g.setStroke(new BasicStroke(6f));
        g.draw(path);
        Color colorPineApple = new Color(0xFF8F00);
        g.setColor(colorPineApple);
        g.fill(path);
    }
    private void drawArcsOnPineApple(Graphics2D g) {
        GeneralPath path = new GeneralPath();
        path.moveTo(x, y);
        path.curveTo(x, y - 120, x + 100, y - 125, x + 170, y - 295);
        path.moveTo(x + 30, y);
        path.curveTo(x + 110, y - 130, x + 150, y - 130, x + 207, y - 239);
        path.moveTo(x + 100, y);
        path.curveTo(x + 100, y - 60, x + 250, y - 120, x + 215, y - 220);
        path.moveTo(x + 150, y);
        path.curveTo(x + 150, y - 60, x + 240, y - 75, x + 230, y - 180);
        path.moveTo(x - 37, y - 80);
        path.curveTo(x - 37, y - 80, x + 100, y - 200, x + 110, y - 295);
        path.moveTo(x - 30, y - 170);
        path.curveTo(x - 30, y - 170, x + 70, y - 240, x + 65, y - 295);

        path.moveTo(x + 200, y);
        path.curveTo(x + 250, y - 180, x, y - 190, x + 30, y - 295);
        path.moveTo(x + 150, y);
        path.curveTo(x + 150, y - 125, x - 40, y - 125, x + 10, y - 270);

        path.moveTo(x + 50, y);
        path.curveTo(x + 50, y - 125, x - 64, 350, x - 18, y - 217);

        path.moveTo(x + 235, y - 145);
        path.curveTo(x + 235, y - 125, x + 250, y - 175, x + 70, y - 295);


        g.setColor(new Color(0x000000));
        g.setStroke(new BasicStroke(2f));
        g.draw(path);
    }
    private void drawDoor(Graphics2D g) {
        GeneralPath path = new GeneralPath();
        path.moveTo(x + 63, y);
        path.curveTo(x + 63, y, x + 63, y - 117, x + 106, y - 117);
        path.curveTo(x + 106, y - 117, x + 149, y - 117, x + 149, y);
        path.lineTo(x + 63, y);

        g.setColor(Color.black);
        g.setStroke(new BasicStroke(3f));
        g.draw(path);
        g.setColor(new Color(0x89CEF6));
        g.fill(path);

        g.setColor(Color.BLACK);
        g.drawOval(x + 96, y - 65, 20, 50);
        g.drawOval(x + 80, y - 50, 50, 20);
    }
    private void drawWindows(Graphics2D g) {
        g.setColor(Color.BLACK);
        g.drawOval(x,y - 200, 60, 60);
        g.setColor(new Color(0x307194));
        g.fillOval(x,y - 200, 60, 60);
        g.setColor(new Color(0x307194));
        g.fillOval(x - 2,y - 200, 60, 60);
        g.setColor(Color.BLACK);
        g.drawOval(x + 10,y - 190, 40, 40);
        g.drawOval(x - 2,y - 200, 60, 60);
        g.setColor(new Color(0x6CC9FF));
        g.fillOval(x + 10,y - 190, 40, 40);

        g.setColor(new Color(0xFAFAFA));
        g.fillOval(x + 10,y - 185, 15, 30);

        g.setColor(Color.BLACK);
        g.drawOval(x + 155,y - 100, 60, 60);
        g.setColor(new Color(0x307194));
        g.fillOval(x + 155,y - 100, 60, 60);
        g.setColor(Color.BLACK);
        g.drawOval(x + 156,y - 100, 60, 60);

        g.setColor(Color.BLACK);
        g.drawOval(x + 165,y - 90, 40, 40);
        g.setColor(new Color(0x6CC9FF));
        g.fillOval(x + 165,y - 90, 40, 40);

        g.setColor(new Color(0xFAFAFA));
        g.fillOval(x + 165,y - 84, 15, 30);
    }


    private void drawFlue(Graphics2D g) {
        GeneralPath path = new GeneralPath();
        path.moveTo(x + 100, y - 245);
        path.lineTo(x + 250, y - 245);
        path.lineTo(x + 250, y - 285);
        path.lineTo(x + 230, y - 285);
        path.lineTo(x + 230, y - 265);
        path.lineTo(x + 175, y - 265);
        g.setColor(Color.BLACK);
        g.draw(path);
        g.setColor(new Color(0x62D0F6));
        g.fill(path);
    }

    private void drawSidewalk(Graphics2D g) {
        g.setColor(new Color(0x494949));
        g.fillRect(x + 60, y + 2, 92, 120);
    }

    private void drawLeaves(Graphics2D g) {
        GeneralPath path = new GeneralPath();

        path.moveTo(x + 30, y - 295);
        path.curveTo(x + 25, y - 295, x, y - 385, x + 25, y - 385);
        path.curveTo(x + 25, y - 385, x + 30, y - 395, x + 40, y - 335);
        path.curveTo(x + 40, y - 335, x + 30, y - 400, x + 60, y - 415);
        path.curveTo(x + 60, y - 479, x + 70, y - 415, x + 80, y - 335);

        path.curveTo(x + 90, y - 350, x+ 70, y - 395, x + 100, y - 415);
        path.curveTo(x + 100, y - 350, x + 130, y - 385, x + 110, y - 335);
        path.curveTo(x + 110, y - 250, x + 100, y - 350, x + 180, y - 400);
        path.curveTo(x + 190, y - 350, x + 140, y - 375, x + 172, y - 295);

        g.setColor(Color.BLACK);
        g.setStroke(new BasicStroke(3f));
        g.draw(path);
        g.setColor(new Color(0x12FF00));
        g.fill(path);
    }
}