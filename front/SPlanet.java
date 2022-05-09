package front;

import back.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SPlanet extends SimulationObject {

    private Planet p;
    private double centerX;
    private double centerY;
    private Simulation simulation;
    Set<STrace> sTrace;

    public SPlanet(Planet p, double centerX, double centerY, Simulation simulation) {
        super(p.getX() + centerX, -p.getY() + centerY, ID.Planet);
        this.p = p;
        this.centerX = centerX;
        this.centerY = centerY;
        this.simulation = simulation;

    }


    public SPlanet(Planet p, double centerX, double centerY) {
        super(p.getX() + centerX, -p.getY() + centerY, ID.Planet);
        this.p = p;
        this.centerX = centerX;
        this.centerY = centerY;
    }

    @Override
    public void tick() {
        this.aktualizacjaS(0.6);
    }



    @Override
    public void paintComponents(Graphics g) {
        super.paintComponents(g);
        int pWidth = 32;
        int pHeigth = 32;
        g.setColor(Color.white);
        //g.fillRect((int) x - (pWidth / 2), (int) y - (pHeigth / 2), pWidth, pHeigth);
        g.fillOval((int) x - (pWidth / 2), (int) y - (pHeigth / 2), pWidth, pHeigth);
        if (sTrace == null)
            sTrace = new HashSet<>();

        STrace sTrace = new STrace((int) x , (int) y );
        this.sTrace.add(sTrace);


        this.sTrace.forEach(sTrace1 -> sTrace1.paintComponents(g));

    }

    public void aktualizacjaS(double time) {
        System.out.println("x " + p.getX());
        p.aktualizacja(0.1);
        this.x = p.getX() + centerX;
        this.y = -p.getY() + centerY;
    }
}
