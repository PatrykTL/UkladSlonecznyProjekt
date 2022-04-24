package front;


import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Frame extends JFrame {
    private JButton start = new JButton("Start");
    private JButton exit = new JButton("Exit");
    private JPanel panel = new JPanel();

    public Frame() throws IOException {
        super("Solar system");

        //ImageIcon backgroundImage = new ImageIcon("background.png");
        //Image img=backgroundImage.getImage();
        //Image temp=img.getScaledInstance(500,600,Image.SCALE_SMOOTH);
        //backgroundImage=new ImageIcon(temp);
        //JLabel back=new JLabel(backgroundImage);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel.setLayout(new GridBagLayout());
        panel.add(start);
        panel.add(exit);
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        add(panel);
        //add(back);
        setSize(500,600);
        setLocationRelativeTo(null);

        setVisible(true);
    }
}
