package front;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class STraces extends SimulationObject {

    private Graphics g1;

    public STraces(double x, double y, ID id) {
        super(x, y, id);
    }


    @Override
    public void tick() {

    }


    public void render(Graphics g) {
        g.setColor(Color.green);
        g1.fillRect((int) x, (int) y, 100, 100);

    }
}
