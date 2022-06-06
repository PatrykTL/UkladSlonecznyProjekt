package front;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Menu implements ActionListener {
    public Menu() {
        JFrame f = new JFrame("Menu Demo");
        f.setSize(800, 800);

        f.add(new JButton("Start"));


        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        f.setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) {
        String comStr = ae.getActionCommand();
        System.out.println(comStr + " Selected");
    }
    public static void main(String args[]) {
        new Menu();
    }
}