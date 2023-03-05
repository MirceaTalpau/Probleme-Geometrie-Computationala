import javax.swing.*;
import java.awt.*;

public class Main {
    public static int det(Point A, Point B,Point C){
        return ((A.x * B.y)+(B.x*C.y)+(C.x*A.y))-((B.y*C.x)+(C.y*A.x)+(A.y*B.x));
    } // Metoda de calcul pentru determinant

    public static void cazul1(Point A,Point B,Point C,Point M){
        if(det(M,A,B)>0 && det(M,B,C)>0 && det(M,C,A)>0)
            System.out.println("Punctul M se afla in zona 1");
        if(det(M,A,B)<0 && det(M,B,C)>0 && det(M,C,A)<0)
            System.out.println("Punctul M se afla in zona 2");
        if(det(M,A,B)<0 && det(M,B,C)<0 && det(M,C,A)>0)
            System.out.println("Punctul M se afla in zona 3");
        if(det(M,A,B)>0 && det(M,B,C)<0 && det(M,C,A)<0)
            System.out.println("Punctul M se afla in zona 4");
        if(det(M,A,B)>0 && det(M,B,C)<0 && det(M,C,A)>0)
            System.out.println("Punctul M se afla in zona 5");
        if(det(M,A,B)>0 && det(M,B,C)>0 && det(M,C,A)<0)
            System.out.println("Punctul M se afla in zona 6");
        if(det(M,A,B)<0 && det(M,B,C)>0 && det(M,C,A)>0)
            System.out.println("Punctul M se afla in zona 7");
        if(det(M,A,B)==0 || det(M,B,C)==0 ||  det(M,C,A)==0)
            System.out.println("Punctul M se afla pe frontiera");
    }
    public static void cazul2(Point A,Point B,Point C,Point M){
        if(det(M,A,C)<0 && det(M,C,B)<0 && det(M,B,A)<0)
            System.out.println("Punctul M se afla in zona 1");
        if(det(M,A,C)>0 && det(M,C,B)<0 && det(M,B,A)>0)
            System.out.println("Punctul M se afla in zona 2");
        if(det(M,A,C)<0 && det(M,C,B)>0 && det(M,B,A)>0)
            System.out.println("Punctul M se afla in zona 3");
        if(det(M,A,C)>0 && det(M,C,B)>0 && det(M,B,A)<0)
            System.out.println("Punctul M se afla in zona 4");
        if(det(M,A,C)<0 && det(M,C,B)>0 && det(M,B,A)<0)
            System.out.println("Punctul M se afla in zona 5");
        if(det(M,A,C)>0 && det(M,C,B)<0 && det(M,B,A)<0)
            System.out.println("Punctul M se afla in zona 6");
        if(det(M,A,C)<0 && det(M,C,B)<0 && det(M,B,A)>0)
            System.out.println("Punctul M se afla in zona 7");
        if(det(M,A,C)==0 || det(M,C,B)==0 ||  det(M,B,A)==0)
            System.out.println("Punctul M se afla pe frontiera");
    }



    public static void main(String[] args) {
        Point A = new Point(0,5);
        Point B = new Point(0,0);
        Point C = new Point(6,0);
        int xM=Integer.parseInt(JOptionPane.showInputDialog("X:")) ;
        int yM=Integer.parseInt(JOptionPane.showInputDialog("Y:")) ;
        Point M =new Point(xM,yM);
        if(det(A,B,C)>0)
            cazul1(A,B,C,M);
        else if(det(A,B,C)<0)
            cazul2(A,B,C,M);
        else
            System.out.println("Punctele A,B,C,M sunt coliniare");

    }
}