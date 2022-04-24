package front;

import back.*;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Simulation extends Canvas implements Runnable {
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private final double WIDTH = screenSize.getWidth(), HEIGHT = screenSize.getHeight();
    private double centerX = WIDTH / 2;
    private double centerY = HEIGHT / 2;
    private Thread thread;
    private boolean running = false;
    private Handler handler;
    private int i;
    Window window;
    private Graphics windowGraphic2;
    //public static Image spriteSheet;
    //private BufferedImage canvas;


    public Simulation(){
        handler = new Handler();

        window = new Window(WIDTH, HEIGHT, "Let's Build a Simulation", this);
        window.createBufferStrategy(2);
        windowGraphic2 = window.getBufferStrategy().getDrawGraphics();
        //canvas = new BufferedImage((int) WIDTH, (int) HEIGHT,BufferedImage.TYPE_INT_ARGB);
        i = 0;
        Sun s = new Sun(10000);
        Planet p1 = new Planet(0, 100, s, 10, 0);
        Planet p2 = new Planet(0, 200, s, 6, 0);
        Planet p3 = new Planet(0, 300, s, 3, 0);


        STraces sTraces = new STraces(100, 100, ID.Trace);

        //handler.addObject(sTraces);
        handler.addObject(new SStar(centerX, centerY));
        handler.addObject(new SPlanet(p1, centerX, centerY));
        handler.addObject(new SPlanet(p2, centerX, centerY));
        handler.addObject(new SPlanet(p3, centerX, centerY));

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
    public Graphics getWindowGraphic2(){
        return windowGraphic2;
    }
    public void setWindowGraphic2(int x, int y){
        windowGraphic2.fillRect(x,y,1,1);
    }

    public static void main(String[] args) {
        new Simulation();
    }
}
