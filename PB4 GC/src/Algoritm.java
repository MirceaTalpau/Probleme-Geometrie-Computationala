import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Algoritm {

    public ArrayList<Point> Poligon;
    boolean arataM= false;
    ;
    public ArrayList<Point> PoligonOrdonat;

    Point S;
    Point M;
    Point N;
    Point PoligonArray[];
    int count =0;


    Algoritm() {
        Poligon = new ArrayList<Point>();
        //PoligonOrdonat = new ArrayList<Point>();
        S = new Point(0,0);
        M = new Point();
        N = new Point();

    }

    ;

    /*public int cautareBinara(ArrayList<Point> PoligonOrdonat, Point M, int first, int size) {
        int mid =(int) (first + size) / 2;
        System.out.println(mid +" "+ PoligonOrdonat.get(mid)) ;
        System.out.println("CADRAN MID: "+ cadran(PoligonOrdonat.get(mid)));
        System.out.println("CADRAN M: "+ cadran(M));
        System.out.println(cadran(PoligonOrdonat.get(mid)) == cadran(M));
        if (PoligonOrdonat.get(mid).equals(M)) {
            return mid;
        }
        if (cadran(PoligonOrdonat.get(mid)) == cadran(M)) {
            System.out.println("CADRAN MID = CADRAN M");
            if (det((PoligonOrdonat.get(mid)), this.S, M) > 0){
                System.out.println("MID,S,M >0");
                return cautareBinara(PoligonOrdonat, M, first, mid - 1);

            }
            if (det(M, this.S, PoligonOrdonat.get(mid)) > 0){
                System.out.println("M,S,MID >0");
                return cautareBinara(PoligonOrdonat, M, mid + 1, size);}
            if (det(M, new Point(0, 0), PoligonOrdonat.get(mid)) == 0)
                System.out.println("Ceva nu e in regula");
        }
        if (cadran(PoligonOrdonat.get(mid)) > cadran(M)) {
            return cautareBinara(PoligonOrdonat, M, mid + 1, size);
        } else {
            return cautareBinara(PoligonOrdonat, M, first, mid - 1);
        }
    }*/
    public int cautareBinara(Point A,int first,int last){
        int mid = (first + last)/2;
        int cadranA = cadran(A);
        int cadranMid = cadran(PoligonOrdonat.get(mid));
        if(PoligonOrdonat.get(mid).x == A.x && PoligonOrdonat.get(mid).y == A.y){
            return mid;
        }
        if(cadranA == cadranMid){
            if (det(A, this.S, PoligonOrdonat.get(mid)) < 0){
                return cautareBinara(A,mid+1,last);
            }
            if(det(A, this.S, PoligonOrdonat.get(mid)) > 0){
                return cautareBinara(A,first,mid-1);
            }
        }
        if(cadranA < cadranMid){
            return cautareBinara(A,mid+1,last);
        }
        else{
            return cautareBinara(A,first,mid-1);
        }

    }

    /*public int cautareBinara(Point P,int l,int r){
        for(int i =l;i<r;i++){
            if(PoligonOrdonat.get(i).equals(P)){
                return i;
            }
        }
        return -1;
    }*/
    public void cloneaza(ArrayList<Point> PoligonOrdonat, ArrayList<Point> Poligon) {
        for (int i = 0; i < Poligon.size(); i++) {
            PoligonOrdonat.add(new Point(i, i));
            PoligonOrdonat.get(i).setLocation(Poligon.get(i));
        }
    }


    public static int det(Point A, Point B, Point C) {
        return ((A.x * B.y) + (B.x * C.y) + (C.x * A.y)) - ((B.y * C.x) + (C.y * A.x) + (A.y * B.x));
    }

    public void printeaza(ArrayList<Point> Poligon) {
        for (int i = 0; i < Poligon.size(); i++)
            System.out.println(Poligon.get(i));
    }
    public void arrayPoligon(Point[] Poligon){
        for(int i=0;i<Poligon.length;i++){
            Poligon[i].x = PoligonOrdonat.get(i).x;
            Poligon[i].y = PoligonOrdonat.get(i).y;
    }}

    public void citeste() {
        Main.frame.panel.repaint();
        /*int size = Integer.parseInt(JOptionPane.showInputDialog(null,"Introduceti numarul de puncte"));
        for(int i = 0; i< size; i++)
        {
            Poligon.add(new Point(Integer.parseInt(JOptionPane.showInputDialog("X:")),Integer.parseInt(JOptionPane.showInputDialog("Y:"))));
            Main.frame.panel.repaint();
        }*/
        Poligon.add(new Point(2, 3));
        Poligon.add(new Point(3, 2));
        Poligon.add(new Point(3, 0));
        Poligon.add(new Point(3, -2));
        Poligon.add(new Point(2,-3));
        Poligon.add(new Point(-2,-3));
        Poligon.add(new Point(-3,-2));
        Poligon.add(new Point(-3,0));
        Poligon.add(new Point(-3,2));
        Poligon.add(new Point(-2,3));

        Main.frame.panel.repaint();


    }

    public void citesteM(){

       this.M.setLocation(Integer.parseInt(JOptionPane.showInputDialog(null,"X:")),Integer.parseInt(JOptionPane.showInputDialog(null,"y:")));
        PoligonOrdonat = new ArrayList<Point>();
        this.arataM = true;
        cloneaza(PoligonOrdonat, Poligon);
        Main.frame.panel.repaint();

    }

    void translateaza() {


        for (int i = 0; i < Poligon.size(); i++) {
            Poligon.get(i).x -= S.x;
            Poligon.get(i).y -= S.y;
        }
        S.setLocation(0, 0);
        Main.frame.panel.repaint();
    }

    int cadran(Point A) {
        if (A.x > 0 && A.y >= 0)
            return 1;
        if (A.x <= 0 && A.y > 0)
            return 2;
        if (A.x < 0 && A.y <= 0)
            return 3;
        if (A.x >= 0 && A.y < 0)
            return 4;
        return -1;
    }

    void ordoneaza() {


        if(cadran(M)!=10){
            this.N.x= this.M.x;
            this.N.y= this.M.y;
            PoligonOrdonat.add(M);
            this.count++;
        }
        else{
            for(int i=0;i<PoligonOrdonat.size();i++){
                if(PoligonOrdonat.get(i).equals(N)){
                    PoligonOrdonat.get(i).x = this.M.x;
                    PoligonOrdonat.get(i).y = this.M.y;
                    System.out.println(M);
                    this.N.x = M.x;
                    this.N.y = M.y;
                    break;
                    }
            }
        }
        Point temp = new Point(1, 1);
        for (int i = 0; i < PoligonOrdonat.size() -1; i++) {
            for (int j = 0; j < PoligonOrdonat.size() -1 ; j++) {
                if (cadran(PoligonOrdonat.get(j)) < cadran(PoligonOrdonat.get(j + 1))) {
                    temp.setLocation(PoligonOrdonat.get(j));
                    PoligonOrdonat.get(j).setLocation(PoligonOrdonat.get(j + 1));
                    PoligonOrdonat.get(j + 1).setLocation(temp);
                }
                if (cadran(PoligonOrdonat.get(j)) == cadran(PoligonOrdonat.get(j + 1)) && det(PoligonOrdonat.get(j), S, PoligonOrdonat.get(j + 1)) < 0) {
                    temp.setLocation(PoligonOrdonat.get(j));
                    PoligonOrdonat.get(j).setLocation(PoligonOrdonat.get(j + 1));
                    PoligonOrdonat.get(j + 1).setLocation(temp);
                }


            }
        }
            int rezultat = det(PoligonOrdonat.get(cautareBinara( N, 0, PoligonOrdonat.size())), PoligonOrdonat.get(cautareBinara( N, 0, PoligonOrdonat.size()) -1), PoligonOrdonat.get(cautareBinara( N, 0, PoligonOrdonat.size()) + 1));
            if(rezultat>0)
                System.out.println("Punctul : " + N + "apartine exteriorului");
            if (rezultat<0)
                System.out.println("Punctul : " + N + "apartine interiorului");
            if(rezultat == 0)
                System.out.println("Punctul : " + N + "se afla pe frontiera");
            

}
}
