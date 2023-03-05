import java.util.*;

import javax.swing.JOptionPane;

import java.awt.*;

public class Algoritm {

    Date date;
    ArrayList<Point> L1;
    ArrayList<Point> L2;
    ArrayList<Point> L1s;
    ArrayList<Point> L2s;

    ArrayList<Point> dreptunghi;
    int[][] mat;
    boolean dreptunghiAdaugat;




    Algoritm(){
        this.L1 = new ArrayList<Point>();
        this.L2 = new ArrayList<Point>();
        dreptunghi = new ArrayList<Point>();
        this.date = new Date();
        mat = new int[50][50];
        dreptunghiAdaugat = false;
    }

    void adaugaTot(ArrayList<Point> original,ArrayList<Point> destinatie){
        for(int i=0;i<original.size();i++){
            destinatie.add(new Point(original.get(i)));
        }
    }
    
    int cautareBinaraX(ArrayList <Point> lista,int first,int last,Point key){
        int mid = (first + last)/2;
        
        if(lista.get(mid).equals(key))
        {
            return mid;
        }
        if(key.x<lista.get(mid).x){
            return cautareBinaraX(lista, first, mid-1, key);
        }
        else{
            return cautareBinaraX(lista, mid+1, last, key);
        }
    }

    int cautareBinaraY(ArrayList <Point> lista,int first,int last,Point key){
        int mid = (first + last)/2;
       
        if(lista.get(mid).equals(key))
        {
            return mid;
        }
        if(key.y<lista.get(mid).y){
            return cautareBinaraY(lista, first, mid-1, key);
        }
        else{
            return cautareBinaraY(lista, mid+1, last, key);
        }
    }

    void printeaza(ArrayList<Point> puncte){
        for(int i =0;i<puncte.size();i++)
        {
            System.out.println(puncte.get(i));
        }
    }

    void sorteazaX(ArrayList<Point> puncte){
        Point aux = new Point(0,0);
        for(int i=0;i<puncte.size()-1;i++){
            for(int j=0;j<puncte.size()-i-1;j++){
                if(puncte.get(j).x>puncte.get(j+1).x)
                {
                    aux.setLocation(puncte.get(j+1));
                    puncte.get(j+1).setLocation(puncte.get(j));
                    puncte.get(j).setLocation(aux);
                }
            }
        }
    }

    void sorteazaY(ArrayList<Point> puncte){
        Point aux = new Point(0,0);
        for(int i=0;i<puncte.size()-1;i++){
            for(int j=0;j<puncte.size()-i-1;j++){
                if(puncte.get(j).y>puncte.get(j+1).y)
                {
                    aux.setLocation(puncte.get(j+1));
                    puncte.get(j+1).setLocation(puncte.get(j));
                    puncte.get(j).setLocation(aux);
                }
            }
        }
    }

    void adaugaDreptunghi(){
            for(int i=0;i<4;i++){
                if(dreptunghiAdaugat == true)
                    dreptunghi.get(i).setLocation(new Point(Integer.parseInt(JOptionPane.showInputDialog(null, "x"+i)),Integer.parseInt(JOptionPane.showInputDialog(null, "y"+i))));
                else{
                    dreptunghi.add(new Point(Integer.parseInt(JOptionPane.showInputDialog(null, "x"+i)),Integer.parseInt(JOptionPane.showInputDialog(null, "y"+i))));
                }
        }

    }
    int Algoritm1(Point A,Point B,Point C,Point D,ArrayList<Point> puncte){
        int qB=0;
        int qA=0;
        int qC=0;
        int qD=0;
        for(int i=0;i<puncte.size();i++){
            if(puncte.get(i).x<B.x && puncte.get(i).y < B.y){
                qB++;
            }
            if(puncte.get(i).x<A.x && puncte.get(i).y < A.y){
                qA++;
            }
            if(puncte.get(i).x<D.x && puncte.get(i).y < D.y){
                qD++;
            }
            if(puncte.get(i).x<C.x && puncte.get(i).y < C.y){
                qC++;
            }
        }
        return qB-qA-qC+qD;
    }

    int Algoritm2(){
        adaugaTot(date.puncte, L1);
        adaugaTot(date.puncte, L2);
        
        sorteazaX(L1);
        sorteazaY(L2);
        
        for(int i=0;i<L1.size()+1;i++){
            mat[i][0] = 0;
        }
        for(int j=1;j<L1.size()+1;j++){
            int k =cautareBinaraY(L2, 0, L2.size(), L1.get(j-1));
            for(int i=0;i<=k;i++){
                mat[i][j] = mat[i][j-1];
            }
            for(int i =k+1;i<L1.size()+1;i++)
                mat[i][j] = mat[i][j-1] +1;
        }
        /*for(int i =0;i<L1.size()+1;i++){
            System.out.println("matricea "+ i);
            for(int j=0;j<L1.size()+1;j++){
                System.out.println(mat[i][j]);
            }
        }*/
        //printeaza(L1);
        //System.out.println("L2->");
        //printeaza(L2);
        //adaugaDreptunghi();

        dreptunghi.add(new Point(2,6));
        dreptunghi.add(new Point(6,6));
        dreptunghi.add(new Point(6,2));
        dreptunghi.add(new Point(2,2));


        L1s = new ArrayList<Point>();
        adaugaTot(L1, L1s);
        L1s.add(new Point(dreptunghi.get(0)));
        sorteazaX(L1s);

        L2s = new ArrayList<Point>();
        adaugaTot(L2, L2s);
        L2s.add(new Point(dreptunghi.get(0)));
        sorteazaY(L2s);
        int xA = cautareBinaraX(L1s,0,L1s.size(),  dreptunghi.get(0))+1;
        int yA = cautareBinaraY(L2s, 0, L2s.size(), dreptunghi.get(0))+1;
        //printeaza(L1s);
            int qA = mat[xA][yA];
        
        //AICI SE TERMINA A
        L1s = new ArrayList<Point>();
        adaugaTot(L1, L1s);
        L1s.add(new Point(dreptunghi.get(1)));
        sorteazaX(L1s);

        L2s = new ArrayList<Point>();
        adaugaTot(L2, L2s);
        L2s.add(new Point(dreptunghi.get(1)));
        sorteazaY(L2s);
        int xB =cautareBinaraX(L1s,0,L1s.size(),  dreptunghi.get(1))+1;
        int yB =cautareBinaraY(L2s, 0, L2s.size(), dreptunghi.get(1))+1;
            int qB = mat[xB][yB];
        //AICI SE TERMINA B
        L1s = new ArrayList<Point>();
        adaugaTot(L1, L1s);
        L1s.add(new Point(dreptunghi.get(2)));
        sorteazaX(L1s);

        L2s = new ArrayList<Point>();
        adaugaTot(L2, L2s);
        L2s.add(new Point(dreptunghi.get(2)));
        sorteazaY(L2s);
        int xC =cautareBinaraX(L1s,0,L1s.size(),  dreptunghi.get(2))+1;
        int yC =cautareBinaraY(L2s, 0, L2s.size(), dreptunghi.get(2))+1;
            int qC = mat[xC][yC];
        //AICI SE TERMINA C
        L1s = new ArrayList<Point>();
        adaugaTot(L1, L1s);
        L1s.add(new Point(dreptunghi.get(3)));
        sorteazaX(L1s);

        L2s = new ArrayList<Point>();
        adaugaTot(L2, L2s);
        L2s.add(new Point(dreptunghi.get(3)));
        sorteazaY(L2s);
        int xD = cautareBinaraX(L1s,0,L1s.size(),
          dreptunghi.get(3))+1;
        int yD = cautareBinaraY(L2s, 0, L2s.size(), dreptunghi.get(3))+1;
            int qD = mat[xD][yD];
        //AICI SE TERMINA D
        System.out.println("QB " +qB);
        System.out.println("QA " + qA);
        System.out.println("QC " + qC);
        System.out.println("QD " +qD);
        return qB-qA-qC+qD;
        
    }
}
