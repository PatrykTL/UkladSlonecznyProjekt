package front;

import back.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SPlanet extends SimulationObject {

    private Planet p;
    private Image image;
    private String name;

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

    public SPlanet(Planet p, Adapter adapter,String name, Image image) throws IOException {
        super(adapter.ostatecznaPozycjaX(p.getX()), adapter.ostatecznaPozycjaY(p.getY()), ID.Planet);
        this.adapter = adapter;
        this.p = p;
        this.image = image;
        this.name = name;

    }

    @Override
    public void tick() {
        this.aktualizacjaS(24);
    }



    @Override
    public void paintComponents(Graphics g) {
        super.paintComponents(g);
        int pWidth = image.getWidth(null);
        int pHeigth = image.getHeight(null);
        int xPaint = (int) x - (pWidth / 2);
        int yPaint = (int) y - (pHeigth / 2);

        if (sTrace == null)
            sTrace = new HashSet<>();
        g.setColor(Color.white);
        STrace sTrace = new STrace((int) x , (int) y );
        this.sTrace.add(sTrace);


        this.sTrace.forEach(sTrace1 -> sTrace1.paintComponents(g));
        g.setColor(Color.green);

        g.drawImage(image,xPaint,yPaint,null);
        g.drawString(name,xPaint,yPaint);
    }

    public void aktualizacjaS(double time) {
        //System.out.println("x " + this.x);
        //System.out.println("y " + this.y);
        p.aktualizacja(time);
        this.x = adapter.ostatecznaPozycjaX(p.getX());
        this.y = adapter.ostatecznaPozycjaY(p.getY());
    }
    public void clearTrace(){
        sTrace.clear();
    }
}
