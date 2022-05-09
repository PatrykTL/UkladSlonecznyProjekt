package front;

import java.awt.*;
import java.util.LinkedList;

public class Handler {

    LinkedList<SimulationObject> object = new LinkedList<SimulationObject>();

    public void tick(){
        for(int i = 0; i < object.size(); i++){
            SimulationObject tempObject = object.get(i);

            tempObject.tick();
        }
    }

    public void render(Graphics g){
        for(int i = 0; i < object.size(); i++){
            SimulationObject tempObject = object.get(i);

            tempObject.paintComponents(g);
        }
    }

    public void addObject(SimulationObject object){
        this.object.add(object);
    }

    public void removeObject(SimulationObject object){
        this.object.remove(object);
    }
}
