import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class TwoButtons {
    JFrame frame;
    JLabel label;

    public static void main (String[] args){
        TwoButtons gui = new TwoButtons();
        gui.go();
    }

    public void go(){

        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton colorbutton = new JButton("Change circle");
        colorbutton.addActionListener(new ColorListener());
        JButton labelbutton = new JButton ("Change label");
        labelbutton.addActionListener(new LabelListener());

        MyDrawPanel drawpanel = new MyDrawPanel();
        label = new JLabel("I'm a label");

        frame.getContentPane().add(BorderLayout.SOUTH,colorbutton);
        frame.getContentPane().add(BorderLayout.CENTER,drawpanel);
        frame.getContentPane().add(BorderLayout.EAST,labelbutton);
        frame.getContentPane().add(BorderLayout.WEST,label);

        frame.setSize(300,300);
        frame.setVisible(true);

    }

    public class ColorListener implements ActionListener {
        public void actionPerformed (ActionEvent event){
            frame.repaint();
        }
    }

    public class LabelListener implements ActionListener {
        public void actionPerformed (ActionEvent event){
            label.setText("Ouch!");
        }

    }
}
