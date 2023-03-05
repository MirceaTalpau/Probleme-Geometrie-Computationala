import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyPanel extends JPanel implements ActionListener {
    int offset=32;
    Point O = new Point(0,0);
    JButton ordoneaza = new JButton();
    JButton adauga = new JButton();

    JButton translateaza =new JButton();
    JButton GO = new JButton();

    Algoritm algoritm =new Algoritm();
    public MyPanel(){
        super();
        adauga = new JButton();
        adauga.setBounds(200,400,70,70);
        adauga.addActionListener(this);
        adauga.setText("Add");

        ordoneaza = new JButton();
        ordoneaza.setBounds(300,500,140,70);
        ordoneaza.addActionListener(this);
        ordoneaza.setText("ORDONEAZA");

        translateaza= new JButton();
        translateaza.setBounds(300,400,140,70);
        translateaza.addActionListener(this);
        translateaza.setText("Translateaza");

        GO= new JButton();
        GO.setBounds(450,400,70,70);
        GO.addActionListener(this);
        GO.setText("GO");

        this.setLayout(null);
        this.setPreferredSize(new Dimension(800,800));
        this.add(adauga);
        this.add(GO);
        this.add(translateaza);
        this.add(ordoneaza);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==ordoneaza){
            algoritm.ordoneaza();
        }
        if(e.getSource()==GO){
            algoritm.citesteM();
            ;
        }
        if(e.getSource()==translateaza){
            algoritm.translateaza();
        }

        if(e.getSource()==adauga){
            algoritm.citeste();
        }

    }
    public void paintPoint(Graphics2D g2d,int x,int y){
        g2d.fillOval(O.x+x*20-4,O.y-y*20-4,8,8);

    }

    public void paintLinie(Graphics2D g2d,Point A,Point B){
        g2d.drawLine(O.x+A.x*20,O.y-A.y*20,O.x+B.x*20,O.y-B.y*20);
    }

    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawLine(400,offset,400,400-offset);
        g2d.drawLine(150,200,650,200);
        O.setLocation(400,200);
        for(int i=0;i<algoritm.Poligon.size();i++) {
            paintPoint(g2d, algoritm.Poligon.get(i).x, algoritm.Poligon.get(i).y);
        }
        for(int i=0;i<algoritm.Poligon.size()-1;i++)
            paintLinie(g2d,new Point(algoritm.Poligon.get(i).x,algoritm.Poligon.get(i).y),new Point(algoritm.Poligon.get(i+1).x,algoritm.Poligon.get(i+1).y));
        if(algoritm.Poligon.size()>2)
            paintLinie(g2d,new Point(algoritm.Poligon.get(0).x,algoritm.Poligon.get(0).y),new Point(algoritm.Poligon.get(algoritm.Poligon.size()-1).x,algoritm.Poligon.get(algoritm.Poligon.size()-1).y));
        if(algoritm.arataM)
            paintPoint(g2d,algoritm.M.x,algoritm.M.y);

    }
}