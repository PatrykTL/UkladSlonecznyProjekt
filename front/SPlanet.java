package front;

import back.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SPlanet extends SimulationObject {

    private Planet p;

    private Simulation simulation;
    Set<STrace> sTrace;
    private Adapter adapter;
/*
    public SPlanet(Planet p, Simulation simulation, Adapter adapter) {
        super(adapter.dostosujDoEkranu(p.getX()). + centerX, -p.getY() + centerY, ID.Planet);
        this.p = p;
        this.centerX = centerX;
        this.centerY = centerY;
        this.simulation = simulation;

    }

    adapter.dostosujDoEkranu(centerX,p.getX()). + centerX, -p.getY() + centerY)

    */

    public SPlanet(Planet p, Adapter adapter) {
        super(adapter.ostatecznaPozycjaX(p.getX()), adapter.ostatecznaPozycjaY(p.getY()), ID.Planet);
        this.adapter = adapter;
        this.p = p;

    }

    @Override
    public void tick() {
        this.aktualizacjaS(365);
    }



    @Override
    public void paintComponents(Graphics g) {
        super.paintComponents(g);
        int pWidth = 32;
        int pHeigth = 32;
        g.setColor(Color.white);
        //g.fillRect((int) x - (pWidth / 2), (int) y - (pHeigth / 2), pWidth, pHeigth);
        g.fillOval((int) x - (pWidth / 2), (int) y - (pHeigth / 2), pWidth, pHeigth);
        //System.out.println((int) x - (pWidth / 2));
        //System.out.println((int) y - (pHeigth / 2));
        if (sTrace == null)
            sTrace = new HashSet<>();

        STrace sTrace = new STrace((int) x , (int) y );
        this.sTrace.add(sTrace);


        this.sTrace.forEach(sTrace1 -> sTrace1.paintComponents(g));

    }

    public void aktualizacjaS(double time) {
        System.out.println("x " + this.x);
        System.out.println("y " + this.y);
        p.aktualizacja(time);
        this.x = adapter.ostatecznaPozycjaX(p.getX());
        this.y = adapter.ostatecznaPozycjaY(p.getY());
    }
}
