package front;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

public class STrace extends JComponent {
    int x;
    int y;

    public STrace(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void paintComponents(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;
        Rectangle2D rectangle = new Rectangle2D.Double(x, y, 1, 1);
        g2d.draw(rectangle);
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

}
