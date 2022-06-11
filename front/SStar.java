package front;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

public class SStar extends SimulationObject implements ImageObserver {

    private Image starImage;

    public SStar(double x, double y,Image starImage) {
        super(x, y, ID.Star);
        this.starImage = starImage;
    }

    @Override
    public void tick() {

    }

    @Override
    public void clearTrace() {

    }

    @Override
    public void paintComponents(Graphics g) {
        int pWidth = starImage.getWidth(null);
        int pHeigth = starImage.getHeight(null);
        int xPaint = (int) x - (pWidth / 2);
        int yPaint = (int) y - (pHeigth / 2);
        g.setColor(Color.yellow);
        g.drawImage(starImage,xPaint,yPaint,null);
        //g.drawImage(starImage,pWidth,pHeigth,null);
    }

    @Override
    public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
        return false;
    }
}
