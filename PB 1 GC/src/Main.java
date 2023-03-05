import javax.swing.*;
import java.awt.*;

public class Main {
    public static void printeaza(Point[] M,int size){
        for(int i=0;i<size;i++)
            System.out.println(M[i]);
    }
    public static void sorteaza(Point[] M,int size) {
        Point temp = new Point(0,0);
        for (int i = 0; i < size; i++) {
            for (int j = 1; j < size ; j++) {
                if(M[j-1].x>M[j].x)
                {
                    temp.x =M[i].x;
                    M[i].x =M[j].x;
                    M[j].x =temp.x;
                }
            }
        }
    }
    public static int apartine(Point[] M,int N){
        for(int i=0;i<M.length;i++)
            if(M[i].x==N)
                return i;
        return -1;

    }
    public static void main(String[] args) {
        Point[] A= new Point[3];
        A[0]=new Point(6,0);A[1]=new Point(3,0);A[2] =new Point(5,0);
        Point[] B= new Point[3];
        B[0]=new Point(5,1);B[1]=new Point(2,1);B[2] =new Point(0,1);
        Point[] C= new Point[3];
        C[0]=new Point(4,2);C[1]=new Point(1,2);C[2] =new Point(3,2);
        sorteaza(B,B.length);sorteaza(C,C.length);
        //Am creat multimile A,B,C
        //Am sortat B,C

        Point[] D= new Point[B.length];
        for(int i=0;i<B.length;i++){
            D[i] = new Point(2*B[i].x,1);
        }
        boolean flag =false;
        for(int i=0;i<A.length;i++){
            for(int j=0;j<C.length;j++){
                if(apartine(D,A[i].x+C[j].x)!= -1) {
                    JOptionPane.showMessageDialog(null, "Exista puncte coliniare");
                    flag =true;
                    return;
                }

            }
        }
        if(flag==false)
            JOptionPane.showMessageDialog(null,"Nu exista puncte coliniare");








    }
}