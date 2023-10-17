import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class TwoButtons {

    public static void main (String[] args){
        new TwoButtons().go();
    }

    public void go(){

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label = new JLabel("I'm a label");

        MyDrawPanel drawpanel = new MyDrawPanel();

        JButton colorbutton = new JButton("Change circle");
        colorbutton.addActionListener(event->frame.repaint());

        JButton labelbutton = new JButton ("Change label");
        labelbutton.addActionListener(event->label.setText("Ouch!"));

        frame.getContentPane().add(BorderLayout.SOUTH,colorbutton);
        frame.getContentPane().add(BorderLayout.CENTER,drawpanel);
        frame.getContentPane().add(BorderLayout.EAST,labelbutton);
        frame.getContentPane().add(BorderLayout.WEST,label);

        frame.setSize(400,300);
        frame.setVisible(true);

    }

}
