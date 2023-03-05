import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class Algoritm {

    public ArrayList <Point> Poligon = new ArrayList<Point>();
    public boolean arataM = false;
    public Point M;
    Algoritm(int n){
        //citeste();

}

    Algoritm(){
        algoritm();
    }

    public static int det(Point A, Point B,Point C){
        return ((A.x * B.y)+(B.x*C.y)+(C.x*A.y))-((B.y*C.x)+(C.y*A.x)+(A.y*B.x));
    }

    public static void printeaza(Point[] Poligon){
        for(int i=0;i<Poligon.length;i++)
            System.out.println(Poligon[i]);
    }

    public void citeste(){
        int size = Integer.parseInt(JOptionPane.showInputDialog(null,"Introduceti numarul de puncte"));
        for(int i = 0; i< size; i++)
        {
            Poligon.add(new Point(Integer.parseInt(JOptionPane.showInputDialog("X:")),Integer.parseInt(JOptionPane.showInputDialog("Y:"))));
            Main.frame.panel.repaint();
        }

    }



    public  void algoritm(){
        //Point[] Poligon = new Point[5];
        //Point[] this.Poligon = new Point[5];
        //this.Poligon[0] = new Point(0, 0);
        //this.Poligon[1] = new Point(4, 0);
        //this.Poligon[2] = new Point(4, 4);
        //this.Poligon[3] = new Point(0, 4);
        //this.Poligon[4] = new Point(6, 3);
        //this.Poligon[5] = new Point(4, 4);
        //this.Poligon[6] = new Point(2, 4);

         M = new Point(Integer.parseInt(JOptionPane.showInputDialog("X:")), Integer.parseInt(JOptionPane.showInputDialog("Y:")));
        arataM = true;
        Main.frame.panel.repaint();
        this.Poligon.add(new Point(this.Poligon.get(0).x, this.Poligon.get(0).y));
        int c = 0;
        Point A = new Point();
        Point B = new Point();
        for (int i = 0; i < this.Poligon.size() - 1; i++) {
            if ((this.Poligon.get(i).y == this.Poligon.get(i+1).y && this.Poligon.get(i+1).y == M.y) && (M.x - this.Poligon.get(i).x) * (M.x - this.Poligon.get(i+1).x) <= 0) {
                JOptionPane.showMessageDialog(null, "M se gaseste pe frontiera1");
                return;
            }
            if (this.Poligon.get(i).y > this.Poligon.get(i+1).y) {
                A = this.Poligon.get(i);
                B = this.Poligon.get(i+1);
            }
            if (this.Poligon.get(i).y < this.Poligon.get(i+1).y) {
                A = this.Poligon.get(i+1);
                B = this.Poligon.get(i);
            }
            if (this.Poligon.get(i).y != this.Poligon.get(i+1).y && M.y > B.y && M.y < A.y) {
                if (det(A, M, B) > 0) {
                    c++;
                }
                if (det(A, M, B) == 0) {
                    JOptionPane.showMessageDialog(null, "Punctul M se gaseste pe frontiera2");
                    return;
                }
            }
            if (this.Poligon.get(i).y != this.Poligon.get(i+1).y && M.y >= A.y) {
                if (M.x < A.x)
                    c++;
                if (M.x == A.x) {
                    JOptionPane.showMessageDialog(null, "Punctul M se gaseste pe frontiera3");
                    return;
                }
            }
            if (this.Poligon.get(i).y != this.Poligon.get(i+1).y && M.y == B.y && M.x == B.x) {
                JOptionPane.showMessageDialog(null, "Punctul M se gaseste pe frontiera4");
                return;
            }
        }
        if (c % 2 == 0) {
            JOptionPane.showMessageDialog(null, "M apartine exteriorului");
            return;
        } else {
            JOptionPane.showMessageDialog(null, "M apartine interiorului");
            return;
        }

    }
}
