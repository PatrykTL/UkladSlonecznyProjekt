package front;

import back.Planet;
import back.Sun;
import front.SPlanet;
import front.SStar;
import front.SimulationObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

public class Simulation extends JPanel {
    LinkedList<SimulationObject> object = new LinkedList<>();
    private final static Dimension WINDOWS_DIMENSION = Toolkit.getDefaultToolkit().getScreenSize();
    private final double centerX;
    private final double centerY;

    public Simulation() {

        centerY = (double) WINDOWS_DIMENSION.height / 2;
        centerX = (double) WINDOWS_DIMENSION.width / 2;
        Sun s = new Sun(10000);
        Planet p1 = new Planet(0, 100, s, 12.5, 0);
        Planet p2 = new Planet(0, 200, s, 7, 0);
        Planet p3 = new Planet(0, 100, s, 12.5, 0);
        Planet p4 = new Planet(0, 200, s, 7, 0);
        Planet p5 = new Planet(0, 100, s, 12.5, 0);
        Planet p6 = new Planet(0, 200, s, 7, 0);
        Planet p7 = new Planet(0, 100, s, 12.5, 0);
        Planet p8 = new Planet(0, 200, s, 7, 0);

        object.add(new SStar(centerX, centerY));
        object.add(new SPlanet(p1, centerX, centerY));
        object.add(new SPlanet(p2, centerX, centerY));
        object.add(new SPlanet(p3, centerX, centerY));
        object.add(new SPlanet(p4, centerX, centerY));
        object.add(new SPlanet(p5, centerX, centerY));
        object.add(new SPlanet(p6, centerX, centerY));
        object.add(new SPlanet(p7, centerX, centerY));
        object.add(new SPlanet(p8, centerX, centerY));


        Timer timer = new Timer(30, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                for (SimulationObject shape : object) {
                    shape.tick();
                    repaint();
                }
            }
        });
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (SimulationObject simulationObject : object) {
            simulationObject.paintComponents(g);
        }

    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame();
                Simulation mainWindow = new Simulation();
                mainWindow.setBackground(Color.BLACK);
                frame.add(mainWindow);
                frame.pack();
                frame.setSize(WINDOWS_DIMENSION);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
}
