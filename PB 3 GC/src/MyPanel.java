import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyPanel extends JPanel implements ActionListener {
    JButton GO = new JButton();
    int offset=32;
    Point O = new Point(0,0);
    JButton adauga = new JButton();

    Algoritm algoritm =new Algoritm(1);
    public MyPanel(){
        super();
        adauga = new JButton();
        adauga.setBounds(200,400,70,70);
        adauga.addActionListener(this);
        adauga.setText("Add");

        GO= new JButton();
        GO.setBounds(300,400,70,70);
        GO.addActionListener(this);
        GO.setText("GO");


        this.setLayout(null);
        this.setPreferredSize(new Dimension(800,800));
        this.add(adauga);
        this.add(GO);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==GO){
            algoritm.algoritm();
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
        int contor = 0;
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawLine(400,offset,400,400-offset);
        g2d.drawLine(150,200,650,200);
        O.setLocation(400,200);
        for(int i=0;i<algoritm.Poligon.size();i++) {
            paintPoint(g2d, algoritm.Poligon.get(i).x, algoritm.Poligon.get(i).y);
            contor++;
        }
        for(int i=0;i<algoritm.Poligon.size()-1;i++)
            paintLinie(g2d,new Point(algoritm.Poligon.get(i).x,algoritm.Poligon.get(i).y),new Point(algoritm.Poligon.get(i+1).x,algoritm.Poligon.get(i+1).y));
        if(algoritm.Poligon.size()>3)
            paintLinie(g2d,new Point(algoritm.Poligon.get(0).x,algoritm.Poligon.get(0).y),new Point(algoritm.Poligon.get(algoritm.Poligon.size()-1).x,algoritm.Poligon.get(algoritm.Poligon.size()-1).y));
        if(algoritm.arataM)
            paintPoint(g2d,algoritm.M.x,algoritm.M.y);

    }
}
