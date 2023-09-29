package parts;

import java.awt.*;
import java.util.Random;

public class SpongeBob {
    private final int x, y;
    private int pupilWidth = 14;
    private int pupilHeight = 14;
    private boolean isIncreasing = true;
    public SpongeBob(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void drawSpongeBob(Graphics2D g) {
        drawBody(g);
        drawEyes(g);
        drawLegs(g);
        drawClothes(g);
        drawArms(g);
        drawMouth(g);
        drawNose(g);
        drawTeeth(g);
    }

    private void drawBody(Graphics2D g) {
        g.setColor(Color.YELLOW);
        int cornerRadius = 10;
        g.fillRoundRect(x, y, 130, 170, cornerRadius, cornerRadius);
        g.setColor(Color.BLACK);
        g.drawRoundRect(x, y, 130, 170, cornerRadius, cornerRadius);

        g.setColor(new Color(0xE48E6B5A, true));
        drawSpot(g, x + 10 , y + 15);
        drawSpot(g, x + 5, y + 30);
        drawSpot(g, x + 100, y + 15);
        drawSpot(g, x + 110, y + 100);
        drawSpot(g, x + 118, y + 80);
        drawSpot(g, x + 9, y + 90);
    }

    private void drawSpot(Graphics2D g, int spotX, int spotY) {
        g.fillOval(spotX, spotY, 10, 10);
        }
    private void drawNose(Graphics2D g) {
        g.setColor(Color.YELLOW);
        g.fillOval(x + 55, y + 60, 10, 15);
        g.setColor(Color.BLACK);
        g.drawOval(x + 60, y + 55, 10, 15);
    }
    private void drawEyes(Graphics2D g) {
        drawSingleEye(g, x + 30, y + 30);
        drawSingleEye(g, x + 65, y + 30);
    }

    private void drawSingleEye(Graphics2D g, int x, int y) {
        g.setColor(Color.WHITE);
        g.fillOval(x, y, 35, 35);
        g.setColor(Color.BLACK);
        g.drawOval(x, y, 35, 35);
        g.setColor(new Color(0x1D7BBD));
        g.fillOval(x + 7, y + 7, 20, 20);
        g.setColor(Color.BLACK);
        g.drawOval(x + 7, y + 7, 20, 20);
        g.fillOval(x + 9, y + 9, pupilWidth, pupilHeight);
    }
    public void animateEyes() {
        if (isIncreasing) {
            pupilWidth++;
            pupilHeight++;
            if (pupilWidth > 18) {
                isIncreasing = false;
            }
        } else {
            pupilWidth--;
            pupilHeight--;
            if (pupilWidth < 10) {
                isIncreasing = true;
            }
        }
    }
    private void drawLegs(Graphics2D g) {
        g.setColor(Color.YELLOW);
        g.fillRect(x + 25, y + 170, 10, 50);
        g.fillRect(x + 95, y + 170, 10, 50);

        g.setColor(Color.BLACK);
        g.drawRect(x + 25, y + 170, 10, 50);
        g.drawRect(x + 95, y + 170, 10, 50);

        g.setColor(Color.WHITE);
        g.fillRect(x + 95, y + 198, 10, 20);
        g.fillRect(x + 25, y + 198, 10, 20);
        g.setColor(Color.BLACK);
        g.drawRect(x + 95, y + 198, 10, 20);
        g.drawRect(x + 25, y + 198, 10, 20);
        g.fillOval(x, y + 215, 40, 20);
        g.fillOval(x + 90, y + 215, 40, 20);
    }

    private void drawClothes(Graphics2D g) {
        Color color = new Color(0x6D2C00);
        g.setColor(color);
        g.fillRect(x, y + 120, 130, 50);
        g.fillRect(x + 15, y + 160, 35, 20);
        g.fillRect(x + 80, y + 160, 35, 20);

        g.setColor(Color.BLACK);
        g.fillRect(x + 15, y + 155, 12, 2);
        g.fillRect(x + 40, y + 155, 12, 2);
        g.fillRect(x + 60, y + 155, 12, 2);
        g.fillRect(x + 80, y + 155, 12, 2);
        g.fillRect(x + 105, y + 155, 12, 2);

        g.setColor(Color.white);
        g.fillRect(x + 10, y + 120, 130, 20);

        int[] xPoints = {x + 40, x + 45, x + 60};
        int[] yPoints = {y + 120, y + 130, y + 120};
        g.fillPolygon(xPoints, yPoints, 3);

        int[] xPoints2 = {x + 90, x + 85, x + 70};
        int[] yPoints2 = {y + 120, y + 130, y + 120};
        g.fillPolygon(xPoints2, yPoints2, 3);

        g.setColor(Color.black);
        g.drawPolygon(xPoints, yPoints, 3);
        g.drawPolygon(xPoints2, yPoints2, 3);

        g.setColor(Color.RED);
        g.fillRect(x + 58, y + 120, 15, 22);

        int[] xPoints3 = {x + 58, x + 65, x + 73};
        int[] yPoints3 = {y + 140, y + 160, y + 140};
        g.fillPolygon(xPoints3, yPoints3, 3);
        g.drawPolygon(xPoints3, yPoints3, 3);
        g.setColor(Color.black);
        g.drawRect(x, y + 120, 130, 50);

        g.setColor(Color.black);
        g.drawRect(x + 58, y + 120, 14, 10);
    }

    private void drawArms(Graphics2D g) {
        drawSingleArm(g, x - 5, y + 80);
        drawSingleArm(g, x + 125, y + 80);
    }

    private void drawSingleArm(Graphics2D g, int x, int y) {
        g.setColor(Color.YELLOW);
        g.fillRect(x, y , 14, 85);
        g.setColor(Color.black);
        g.drawRect(x, y, 14, 85);

        g.setColor(Color.white);
        g.fillRect(x - 2, y, 15, 13);
        g.setColor(Color.black);
        g.drawRect(x - 2, y, 15, 13);
    }

    private void drawMouth(Graphics2D g) {
        g.setColor(Color.BLACK);
        g.fillRect(x + 50, y + 89, 30, 2);
    }

    private void drawTeeth(Graphics2D g) {
        g.setColor(Color.WHITE);
        g.fillRect(x + 54, y + 91, 10, 10);
        g.fillRect(x + 68, y + 91, 10, 10);
        g.setColor(Color.black);
        g.drawRect(x + 54, y + 91, 10, 10);
        g.drawRect(x + 68, y + 91, 10, 10);
    }
}