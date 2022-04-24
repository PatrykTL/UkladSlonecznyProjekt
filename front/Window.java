package front;

import javax.swing.*;
import java.awt.*;

public class Window extends Canvas {
        public Window(double width, double height, String title, Simulation simulation){
            JFrame frame = new JFrame(title);
            frame.setPreferredSize(new Dimension((int)width, (int)height));
            frame.setMaximumSize(new Dimension((int)width, (int)height));
            frame.setMinimumSize(new Dimension((int)width, (int)height));

            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setResizable(false);
            frame.setLocationRelativeTo(null);
            frame.add(simulation);
            frame.setVisible(true);
            simulation.start();
        }
}
