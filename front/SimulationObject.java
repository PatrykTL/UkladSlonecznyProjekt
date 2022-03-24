package front;

import java.awt.*;

public abstract class SimulationObject {

    protected int x, y;
    protected ID id;
    protected int velX, velY;

    public SimulationObject(int x,int y, ID id){
        this.x = x;
        this.y = y;
        this.id = id;
    }

    public abstract void tick();
    public abstract void render(Graphics g);

}
