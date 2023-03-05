import java.util.*;
import java.awt.*;
public class Main{
    static void adaugaTot(ArrayList<Point> original,ArrayList<Point> destinatie){
        for(int i=0;i<original.size();i++){
            destinatie.add(new Point(original.get(i)));
        }
    }

   static void sorteazaX(ArrayList<Point> puncte){
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

    static void sorteazaY(ArrayList<Point> puncte){
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

    static int cautareBinaraX(ArrayList <Point> lista,int first,int last,Point key){
        int mid = (first + last)/2;
        System.out.println("ELEM MID: "+ lista.get(mid));
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

    static int cautareBinaraY(ArrayList <Point> lista,int first,int last,Point key){
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

       public static void main(String[] args){

    ArrayList<Point> puncte = new ArrayList<>();
    puncte.add(new Point(3,4));
    puncte.add(new Point(1,5));
    puncte.add(new Point(6,7));
    puncte.add(new Point(5,2));
    puncte.add(new Point(2,6));
    puncte.add(new Point(7,3));
    puncte.add(new Point(4,1));

    
    ArrayList<Point> L1 = new ArrayList<>();
    ArrayList<Point> L2 = new ArrayList<>();
    int[][] mat;
    mat = new int[50][50];

    adaugaTot(puncte, L1);
    adaugaTot(puncte, L2);
        
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
    for(int i =0;i<L1.size()+1;i++){
        System.out.println("matricea "+ i);
        for(int j=0;j<L1.size()+1;j++){
            System.out.println(mat[i][j]);
        }
    }

    ArrayList<Point> L1s = new ArrayList<>();
    ArrayList<Point> L2s = new ArrayList<>();


    ArrayList<Point> dreptunghi = new ArrayList<>();


    dreptunghi.add(new Point(2,6));
    dreptunghi.add(new Point(6,6));
    dreptunghi.add(new Point(6,2));
    dreptunghi.add(new Point(2,2));

    System.out.println("PRIMU ELEM1" + dreptunghi.get(0));

    L1s = new ArrayList<Point>();
    System.out.println("PRIMU ELEM2" + dreptunghi.get(0));
    adaugaTot(L1, L1s);
    System.out.println("PRIMU ELEM3" + dreptunghi.get(0));

    L1s.add(new Point(dreptunghi.get(0)));
    System.out.println("PRIMU ELEM4" + dreptunghi.get(0));

    sorteazaX(L1s);

    System.out.println("PRIMU ELEM5" + dreptunghi.get(0));

        L2s = new ArrayList<Point>();
        adaugaTot(L2, L2s);
        L2s.add(new Point(dreptunghi.get(0)));
        sorteazaY(L2s);
        int xA = cautareBinaraX(L1s,0,L1s.size(),  dreptunghi.get(0))+1;
        int yA = cautareBinaraY(L2s, 0, L2s.size(), dreptunghi.get(0))+1;
        //printeaza(L1s);
        System.out.println("xA" +xA);
        System.out.println("yA" +yA);
        System.out.println("mat[xA][yA] "+mat[xA][yA]);
            int qA = mat[xA][yA];
            System.out.println(qA);


}
}
