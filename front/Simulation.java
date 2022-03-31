package front;

import back.*;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Simulation extends Canvas implements Runnable {
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    public final double WIDTH = screenSize.getWidth(), HEIGHT = screenSize.getHeight();
    private double centerX = WIDTH/2;
    private double centerY = HEIGHT/2;
    private Thread thread;
    private boolean running = false;
    private Handler handler;
    public static Image spriteSheet;


    public Simulation(){
        handler = new Handler();

        new Window(WIDTH, HEIGHT, "Let's Build a Simulation", this);


        Sun s = new Sun(10000);
        Planet p1 = new Planet(0,100,s,12.5,0);
        Planet p2 = new Planet(0, 200, s , 7, 0);
        handler.addObject(new SStar(centerX,centerY));
        handler.addObject(new SPlanet(p1,centerX,centerY));
        handler.addObject(new SPlanet(p2,centerX,centerY));

    }

    public synchronized void start(){
        thread = new Thread(this);
        thread.start();
        running = true;

    }
    public synchronized void stop(){
        try{
            thread.join();
            running = false;
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while(running){ // SIMULATION LOOP
            {
                long now = System.nanoTime();
                delta += (now - lastTime) / ns;
                lastTime = now;
                while (delta >= 1) {
                    tick();
                    delta--;
                }
                if (running)
                    render();
                frames++;

                if (System.currentTimeMillis() - timer > 1000) {
                    timer += 1000;
                    System.out.println("FPS: " + frames);
                    frames = 0;
                }
            }

        }
        stop();
    }

    private void tick(){
        handler.tick();
    }

    private void render(){
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null){
            this.createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();

        g.setColor(Color.BLACK);
        g.fillRect(0,0,(int)WIDTH,(int)HEIGHT);

        handler.render(g);

        g.dispose();
        bs.show();
    }


    public static void main(String[] args) {
        new Simulation();
    }
}
