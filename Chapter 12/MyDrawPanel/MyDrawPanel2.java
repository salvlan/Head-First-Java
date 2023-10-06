import java.awt.*;
import javax.swing.*;

public class MyDrawPanel2 extends JPanel {

    public void paintComponent (Graphics g){
        Image image =new ImageIcon ("catzilla.jpg").getImage();
        g.drawImage(image,3,4,this);
        }

}