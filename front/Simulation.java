package front;

import back.Adapter;
import back.Planet;
import back.Sun;
import front.SPlanet;
import front.SStar;
import front.SimulationObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.util.LinkedList;

public class Simulation extends JPanel {
    LinkedList<SimulationObject> object = new LinkedList<>();
    private final static Dimension WINDOWS_DIMENSION = Toolkit.getDefaultToolkit().getScreenSize();
    private double centerX;
    private double centerY;
    private BigDecimal maxOdleglosc;
    private MathContext mc;

    public Simulation() {

        centerY = (double) WINDOWS_DIMENSION.height / 2;
        centerX = (double) WINDOWS_DIMENSION.width / 2;

        mc=new MathContext(50);

        Sun s = new Sun(new BigDecimal("1988400000000000000000000000000"));
        Planet p1 = new Planet(new BigDecimal("69610000"), new BigDecimal("0"), s, new BigDecimal("0"), new BigDecimal("172404"),mc);
        Planet p2 = new Planet(new BigDecimal("108310000"),new BigDecimal("0"), s, new BigDecimal("0"), new BigDecimal("126108"),mc);
        Planet p3 = new Planet(new BigDecimal("108310000"), new BigDecimal("0"), s, new BigDecimal("0"), new BigDecimal("107218"),mc);
        Planet p4 = new Planet(new BigDecimal("207260000"), new BigDecimal("0"), s, new BigDecimal("0"), new BigDecimal("86425"),mc);
        Planet p5 = new Planet(new BigDecimal("757500000"), new BigDecimal("0"), s, new BigDecimal("0"), new BigDecimal("47052"),mc);
        Planet p6 = new Planet(new BigDecimal("1464890000"), new BigDecimal("0"), s, new BigDecimal("0"), new BigDecimal("34848"),mc);
        Planet p7 = new Planet(new BigDecimal("3000580000"), new BigDecimal("0"), s, new BigDecimal("0"), new BigDecimal("24480"),mc);
        Planet p8 = new Planet(new BigDecimal("4486540000"), new BigDecimal("0"), s, new BigDecimal("0"), new BigDecimal("19548"),mc);

        maxOdleglosc = new BigDecimal("4986540000");

        Adapter adapter = new Adapter(centerX,centerY,maxOdleglosc);

        object.add(new SStar(centerX, centerY));
        object.add(new SPlanet(p1, adapter));
        object.add(new SPlanet(p2, adapter));
        object.add(new SPlanet(p3, adapter));
        object.add(new SPlanet(p4, adapter));
        object.add(new SPlanet(p5, adapter));
        object.add(new SPlanet(p6, adapter));
        object.add(new SPlanet(p7, adapter));
        object.add(new SPlanet(p8, adapter));


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
