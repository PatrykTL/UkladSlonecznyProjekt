package front;

import back.Adapter;
import back.Planet;
import back.Sun;
import front.SPlanet;
import front.SStar;
import front.SimulationObject;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.util.LinkedList;
import java.awt.event.MouseWheelEvent;

public class Simulation extends JPanel implements MouseListener, MouseWheelListener {
    LinkedList<SimulationObject> object = new LinkedList<>();
    private final static Dimension WINDOWS_DIMENSION = Toolkit.getDefaultToolkit().getScreenSize();
    private double centerX;
    private double centerY;
    private BigDecimal minOdleglosc;
    private BigDecimal odleglosc;
    private BigDecimal maxOdleglosc;
    private MathContext mc;
    private int tick;
    private int wheel;
    private Adapter adapter;

    public Simulation() throws IOException {

        tick = 0;
        centerY = (double) WINDOWS_DIMENSION.height / 2;
        centerX = (double) WINDOWS_DIMENSION.width / 2;


        mc=new MathContext(50);

        Sun s = new Sun(new BigDecimal("1988400000000000000000000000000"));
        Planet p1 = new Planet(new BigDecimal("69610000"), new BigDecimal("0"), s, new BigDecimal("0"), new BigDecimal("172404"),mc);
        Planet p2 = new Planet(new BigDecimal("108310000"),new BigDecimal("0"), s, new BigDecimal("0"), new BigDecimal("126108"),mc);
        Planet p3 = new Planet(new BigDecimal("149600000"), new BigDecimal("0"), s, new BigDecimal("0"), new BigDecimal("107218"),mc);
        Planet p4 = new Planet(new BigDecimal("207260000"), new BigDecimal("0"), s, new BigDecimal("0"), new BigDecimal("86425"),mc);
        Planet p5 = new Planet(new BigDecimal("757500000"), new BigDecimal("0"), s, new BigDecimal("0"), new BigDecimal("47052"),mc);
        Planet p6 = new Planet(new BigDecimal("1464890000"), new BigDecimal("0"), s, new BigDecimal("0"), new BigDecimal("34848"),mc);
        Planet p7 = new Planet(new BigDecimal("3000580000"), new BigDecimal("0"), s, new BigDecimal("0"), new BigDecimal("24480"),mc);
        Planet p8 = new Planet(new BigDecimal("4486540000"), new BigDecimal("0"), s, new BigDecimal("0"), new BigDecimal("19548"),mc);

        minOdleglosc = new BigDecimal("100000000");
        maxOdleglosc = new BigDecimal("5000000000");
        odleglosc = maxOdleglosc.divide(new BigDecimal("2"),mc).add(minOdleglosc);

        adapter = new Adapter(centerX,centerY, odleglosc);

        object.add(new SStar(centerX, centerY,ImageIO.read(new
                File("C:\\Users\\pweso\\IdeaProjects\\UkladSlonecznyProjekt\\out\\images\\slonce.PNG")).getScaledInstance(50,50,Image.SCALE_DEFAULT))
        );
        object.add(new SPlanet(p1, adapter, "Merkury",
                ImageIO.read(new
                        File("C:\\Users\\pweso\\IdeaProjects\\UkladSlonecznyProjekt\\out\\images\\merkury.PNG")).getScaledInstance(30,30,Image.SCALE_DEFAULT)

        ));
        object.add(new SPlanet(p2, adapter, "Wenus",
                ImageIO.read(new
                        File("C:\\Users\\pweso\\IdeaProjects\\UkladSlonecznyProjekt\\out\\images\\wenus.PNG")).getScaledInstance(30,30,Image.SCALE_DEFAULT)

        ));
        object.add(new SPlanet(p3, adapter,"Ziemia",
                ImageIO.read(new
                        File("C:\\Users\\pweso\\IdeaProjects\\UkladSlonecznyProjekt\\out\\images\\ziemia.PNG")).getScaledInstance(30,30,Image.SCALE_DEFAULT)
        ));
        object.add(new SPlanet(p4, adapter,"Mars",
                ImageIO.read(new
                        File("C:\\Users\\pweso\\IdeaProjects\\UkladSlonecznyProjekt\\out\\images\\mars.PNG")).getScaledInstance(30,30,Image.SCALE_DEFAULT)
        ));
        object.add(new SPlanet(p5, adapter,"Jowisz",
                ImageIO.read(new
                        File("C:\\Users\\pweso\\IdeaProjects\\UkladSlonecznyProjekt\\out\\images\\jowisz.PNG")).getScaledInstance(30,30,Image.SCALE_DEFAULT)

        ));
        object.add(new SPlanet(p6, adapter,"Saturn",
                ImageIO.read(new
                        File("C:\\Users\\pweso\\IdeaProjects\\UkladSlonecznyProjekt\\out\\images\\saturn.PNG")).getScaledInstance(60,30,Image.SCALE_DEFAULT)

        ));
        object.add(new SPlanet(p7, adapter,"Uran",
                ImageIO.read(new
                        File("C:\\Users\\pweso\\IdeaProjects\\UkladSlonecznyProjekt\\out\\images\\uran.PNG")).getScaledInstance(30,30,Image.SCALE_DEFAULT)

        ));
        object.add(new SPlanet(p8, adapter,"Nepturn",
                ImageIO.read(new
                        File("C:\\Users\\pweso\\IdeaProjects\\UkladSlonecznyProjekt\\out\\images\\neptun.PNG")).getScaledInstance(30,30,Image.SCALE_DEFAULT)

        ));

        addMouseListener(this);
        addMouseWheelListener(this);
        wheel = 10;

        Timer timer = new Timer(30, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                for (SimulationObject shape : object) {
                    shape.tick();
                    repaint();
                }
                tick++;
                //System.out.println("tick:" + tick);

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
                Simulation mainWindow = null;
                try {
                    mainWindow = new Simulation();
                } catch (IOException e) {
                    e.printStackTrace();
                }
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




    @Override
    public String paramString() {
        return super.paramString();
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        wheel = wheel + e.getWheelRotation();
        if(wheel>20){
            wheel = 20;
        }
        if(wheel < 0){
            wheel = 0;
        }
        float scale = (float)wheel/20;
        odleglosc = maxOdleglosc.multiply(BigDecimal.valueOf(scale),mc);
        adapter.setMaxOdleglosc(String.valueOf(odleglosc.add(minOdleglosc)));

        for (SimulationObject planet : object) {
            planet.clearTrace();
        }
    }
}
