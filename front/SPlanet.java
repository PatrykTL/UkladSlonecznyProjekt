package front;

import back.*;

import java.awt.*;

public class SPlanet extends SimulationObject{

    private Planet p;
    private double centerX;
    private double centerY;


    public SPlanet(Planet p,double centerX,double centerY) {
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
        int pHeigth =32;
        g.setColor(Color.white);
        g.fillRect((int)x-(pWidth/2),(int)y-(pHeigth/2),pWidth,pHeigth);
    }

    public void aktualizacjaS(double time){
        System.out.println("x " +p.getX());
        p.aktualizacja(0.1);
        this.x = p.getX()+centerX;
        this.y = -p.getY()+centerY;
    }
}
