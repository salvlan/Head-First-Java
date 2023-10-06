import javax.swing.*;

public class SimpleGui2 {

    public static void main(String[] args) {

        JFrame frame = new JFrame();
        JFrame frame2 = new JFrame();
        JFrame frame3 = new JFrame();
        JFrame frame4 = new JFrame();
        JFrame frame5 = new JFrame();

        MyDrawPanel panel = new MyDrawPanel();
        MyDrawPanel2 panel2 = new MyDrawPanel2();
        MyDrawPanel3 panel3 = new MyDrawPanel3();
        MyDrawPanel4 panel4 = new MyDrawPanel4();
        MyDrawPanel5 panel5 = new MyDrawPanel5();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(panel);
        frame.setSize(300,300);
        frame.setVisible(true);

        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.getContentPane().add(panel2);
        frame2.setSize(300,300);
        frame2.setVisible(true);

        frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame3.getContentPane().add(panel3);
        frame3.setSize(300,300);
        frame3.setVisible(true);

        frame4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame4.getContentPane().add(panel4);
        frame4.setSize(300,300);
        frame4.setVisible(true);

        frame5.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame5.getContentPane().add(panel5);
        frame5.setSize(300,300);
        frame5.setVisible(true);
    }
}
