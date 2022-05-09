package front;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

public class SStar extends SimulationObject implements ImageObserver {

    private BufferedImage starImage;

    public SStar(double x, double y) {
        super(x, y, ID.Star);
    }

    @Override
    public void tick() {

    }

    @Override
    public void paintComponents(Graphics g) {
        int pWidth = 64;
        int pHeigth = 64;
        g.setColor(Color.yellow);
        g.fillOval((int) x - (pWidth / 2), (int) y - (pHeigth / 2), pWidth, pHeigth);
        //g.drawImage(starImage,pWidth,pHeigth,null);
    }

    @Override
    public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
        return false;
    }
}
