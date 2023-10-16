import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

public class SimpleChatClientA {

    JTextField outGoing;
    PrintWriter writer;
    Socket sock;

    public static void main(String[] args) {
        new SimpleChatClientA().go();
    }

    public void go (){
        JFrame frame = new JFrame("Ludicrously Simple Chat Client");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();

        outGoing = new JTextField(20);

        JButton sendButton = new JButton("Send");
        sendButton.addActionListener(new SendButtonListener());

        mainPanel.add(outGoing);
        mainPanel.add(sendButton);
        frame.getContentPane().add(BorderLayout.CENTER,mainPanel);

        setUpNetworking();

        frame.setSize(400,150);
        frame.setVisible(true);
    }

    private void setUpNetworking(){
        try{
            sock = new Socket("127.0.0.1", 5000);
            writer = new PrintWriter(sock.getOutputStream());
            System.out.println("networking established");
        } catch (IOException ex){
            ex.printStackTrace();
        }
    }

    public class SendButtonListener implements ActionListener {
        public void actionPerformed (ActionEvent ev) {
            try {
                writer.println(outGoing.getText());
                writer.flush();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            outGoing.setText("");
            outGoing.requestFocus();
        }
    }

}
