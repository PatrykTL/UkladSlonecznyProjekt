package front;

import javax.swing.*;
import java.awt.*;

public abstract class SimulationObject extends JComponent
{

    protected double x, y;
    protected ID planetoidType;
    protected int velX, velY;

    public SimulationObject(double x,double y, ID planetoidType)
    {
        this.x = x;
        this.y = y;
        this.planetoidType = planetoidType;
    }

    public abstract void tick();

    public abstract void clearTrace();

}

