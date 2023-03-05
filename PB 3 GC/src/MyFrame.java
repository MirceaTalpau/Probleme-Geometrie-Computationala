import javax.swing.*;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame {
    JFrame frame = new JFrame();
    public MyPanel panel =  new MyPanel();

     MyFrame(){

        this.setTitle("Problema 3 GC");
        this.add(panel);
        this.setSize(800,800);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon icon= new ImageIcon("E:\\cube-logo.jpg");
        this.setIconImage(icon.getImage());


    }
}
