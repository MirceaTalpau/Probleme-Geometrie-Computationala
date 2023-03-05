import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

import javax.swing.JOptionPane;

import java.awt.*;
public class Main {
    static ArrayList<dcel> poligon = new ArrayList<dcel>();
    static ArrayList<varf> varfuri = new ArrayList<>();
    static ArrayList<lespede> Lespede = new ArrayList<lespede>(); 
    static ArrayList<fata> fete = new ArrayList<fata>(); 


    static void localizare(varf M){
        int l=0,f=0,m1,m2;
        for(int i=0;i<varfuri.size()-1;i++){
            if(M.y>=varfuri.get(i).y && M.y <= varfuri.get(i+1).y)
            {
                l = i+1;
                break;
            }

        }
        for(int i=0;i<fete.size();i++){
            Polygon P = new Polygon();
            for(int j=0;j<fete.get(i).varfuri.size();j++){
                P.addPoint((int)fete.get(i).varfuri.get(j).x, (int)fete.get(i).varfuri.get(j).y);
            }
            if(P.contains(new java.awt.Point((int)M.x,(int)M.y))){
                f=i+2;
                break;
            }
            
        }
       JOptionPane.showMessageDialog(null,"Punctul M se afla in lespedea "+ l + " ,in fata "+ f);

    }
    public static void main(String[] args) {
       
        
        poligon.add(new dcel(1, 5, 6, 1, 2, 10, 2));
        poligon.add(new dcel(2, 3, 6, 2, 6, 3, 5));
        poligon.add(new dcel(3, 3, 5, 3, 2, 9, 10));
        poligon.add(new dcel(4, 3, 4, 6, 5, 2, 7));
        poligon.add(new dcel(5, 4, 6, 6, 1, 4, 1));
        poligon.add(new dcel(6, 1, 3, 4, 5, 8, 4));
        poligon.add(new dcel(7, 1, 4, 5, 1, 6, 5));
        poligon.add(new dcel(8, 1, 2, 1, 4, 7, 9));
        poligon.add(new dcel(9, 2, 3, 3, 4, 10, 6));
        poligon.add(new dcel(10, 2, 5, 1, 3, 8, 3));
        ArrayList<Integer> A=new ArrayList<>();
        ArrayList<Integer> B=new ArrayList<>();
        B.add(8);B.add(6);B.add(7);

        A.add(8);
        B.add(10);B.add(9);

        A.add(9);A.add(6);
        B.add(3);B.add(2);B.add(4);

        A.add(4);A.add(7);
        B.add(5);

        A.add(10);A.add(3);
        B.add(1);

        A.add(1);A.add(2);A.add(5);
        
        varfuri.add(new varf(5,-4));
        varfuri.add(new varf(-2,-3));
        varfuri.add(new varf(0,0));
        varfuri.add(new varf(6,3));
        varfuri.add(new varf(-3,4));
        varfuri.add(new varf(2,6));
        
        fata f = new fata();
        f.varfuri.add(varfuri.get(4));
        f.varfuri.add(varfuri.get(2));
        f.varfuri.add(varfuri.get(5));
        fete.add(f);

        
        f = new fata();
        f.varfuri.add(varfuri.get(4));
        f.varfuri.add(varfuri.get(1));
        f.varfuri.add(varfuri.get(2));
        fete.add(f);

        
        f = new fata();
        f.varfuri.add(varfuri.get(0));
        f.varfuri.add(varfuri.get(1));
        f.varfuri.add(varfuri.get(2));
        fete.add(f);

        
        f = new fata();
        f.varfuri.add(varfuri.get(0));
        f.varfuri.add(varfuri.get(3));
        f.varfuri.add(varfuri.get(2));
        fete.add(f);

        
        f = new fata();
        f.varfuri.add(varfuri.get(3));
        f.varfuri.add(varfuri.get(5));
        f.varfuri.add(varfuri.get(2));
        fete.add(f);

        lespede L = new lespede();
        L.muchii.add(8);L.muchii.add(6);L.muchii.add(7);
        Lespede.add(L);

        L = new lespede();
        L.muchii.add(10);L.muchii.add(9);L.muchii.add(6);L.muchii.add(7);
        Lespede.add(L);

        L = new lespede();
        L.muchii.add(10);L.muchii.add(3);L.muchii.add(2);L.muchii.add(4);L.muchii.add(7);
        Lespede.add(L);

        L = new lespede();
        L.muchii.add(10);L.muchii.add(3);L.muchii.add(2);L.muchii.add(5);
        Lespede.add(L);

        L = new lespede();
        L.muchii.add(1);L.muchii.add(2);L.muchii.add(5);
        Lespede.add(L);

        L = new lespede();
        L.muchii.add(1);L.muchii.add(2);L.muchii.add(5);
        Lespede.add(L);
        localizare(new varf(Integer.parseInt(JOptionPane.showInputDialog(null,"xM")),Integer.parseInt(JOptionPane.showInputDialog(null,"yM"))));
        
    }

}