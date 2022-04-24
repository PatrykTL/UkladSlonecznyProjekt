package front;

import back.*;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;


public class SPlanet extends SimulationObject{

    private Planet p;
    private double centerX;
    private double centerY;

    public SPlanet(Planet p, double centerX, double centerY) {
        super(p.getX()+centerX, -p.getY()+centerY, ID.Planet);
        this.p = p;
        this.centerX = centerX;
        this.centerY = centerY;
    }

    @Override
    public void tick() {
        this.aktualizacjaS(0.6);
    }

    @Override
    public void render(Graphics g) {
        int pWidth = 32;
        int pHeigth = 32;
        Graphics2D g1 = (Graphics2D) g;
        Ellipse2D.Double circle = new Ellipse2D.Double(0, 0, 100, 100);
        g1.setColor(Color.white);
        g1.fillRect((int)x-(pWidth/2),(int)y-(pHeigth/2),pWidth,pHeigth);
        g1.draw(circle);
    }

    public void aktualizacjaS(double time){
        System.out.println("x " +p.getX());
        p.aktualizacja(0.1);
        this.x = p.getX()+centerX;
        this.y = -p.getY()+centerY;
    }
    public double getX(){
        return x;
    }
    public double getY(){
        return y;
    }
}
