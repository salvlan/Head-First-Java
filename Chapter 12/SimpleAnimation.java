import javax.swing.*;
import java.awt.*;

public class SimpleAnimation {

    int x;
    int y;

    public static void main (String[] args){
        SimpleAnimation gui = new SimpleAnimation();
        gui.go();
    }

    public void go (){
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        MyDrawPanel panel = new MyDrawPanel();

        frame.getContentPane().add(BorderLayout.CENTER,panel);

        frame.setSize(300,300);
        frame.setVisible(true);

        for (int i= 0; i<300;i++){

            x++;
            y++;
            panel.repaint();
            try{
                Thread.sleep(50);
            } catch (Exception ex){}

        }

    }

    public class MyDrawPanel extends JPanel {

        public void paintComponent(Graphics g) {

            Graphics2D g2d = (Graphics2D) g;

            g2d.setColor(Color.white);
            g2d.fillRect(0, 0, this.getWidth(), this.getHeight());

            int red = (int) (Math.random() * 256);
            int green = (int) (Math.random() * 256);
            int blue = (int) (Math.random() * 256);
            Color startColor = new Color(red, green, blue);

            red = (int) (Math.random() * 256);
            green = (int) (Math.random() * 256);
            blue = (int) (Math.random() * 256);
            Color endColor = new Color(red, green, blue);

            GradientPaint gradient = new GradientPaint(70, 70, startColor, 150, 150, endColor);

            g2d.setPaint(gradient);

            g2d.fillOval(x,y,40,40);

        }

    }

}
