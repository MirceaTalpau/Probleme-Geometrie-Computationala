import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics.*;
import java.awt.Graphics2D.*;
import java.awt.geom.*;
import java.util.*;
public class Desen5 extends Canvas{
private boolean pornesteMouse=false,mouseSelect=false;
private int[] x,y;
private Color[] culoare;
private int mouseX,mouseY,cc,n=0,nn,MMx,MMy;
private double Mx,MMMx;
private double My,MMMy;
private JTextField output;
// private Punct[] punct;
private int centrux,centruy,F;
private Algoritm5 a;
public Desen5(){
this.setSize(500,500);
}
public void start(Algoritm5 a){
pornesteMouse=true;
this.a=a;
repaint();
}
public boolean mouseDown(Event e,int x,int y){
if (pornesteMouse) {
mouseX=x; mouseY=y;
Mx=(mouseX-250)/10.0;
My=(250-mouseY)/10.0;
F=a.cautaLantul(Mx,My);
System.out.println("F este: "+F);
mouseSelect=true;
repaint();
}
return true;
}
public void paint(Graphics g){
Graphics2D g2 = (Graphics2D) g;
g2.setColor(Color.BLACK);
g2.drawLine(0,0,500,0);
g2.drawLine(0,0,0,500);
g2.drawLine(500,0,500,500);
g2.drawLine(0,500,500,500);

//trasez axa x'
g2.drawLine(calcX(-20),calcY(0),calcX(20),calcY(0));
g2.drawString("x",calcX(21),calcY(-1));
g2.drawLine(calcX(20)-3,calcY(0)-3,calcX(20),calcY(0));
g2.drawLine(calcX(20)-3,calcY(0)+3,calcX(20),calcY(0));
//trasez axa y'
g2.drawLine(calcX(0),calcY(-20),calcX(0),calcY(20));
g2.drawString("y",calcX(-1),calcY(21));
g2.drawLine(calcX(0)+3,calcY(20)+3,calcX(0),calcY(20));
g2.drawLine(calcX(0)-3,calcY(20)+3,calcX(0),calcY(20));
Muchie5[] dcel;
if(a!=null) dcel=a.getDCEL();
else dcel=new Muchie5[0];
for(int i=0;i<dcel.length;++i){
g2.drawLine(calcX((int)dcel[i].getV1().getX()),
calcY((int)dcel[i].getV1().getY()),
calcX((int)dcel[i].getV2().getX()),
calcY((int)dcel[i].getV2().getY())
);
int
mijlocX=(calcX((int)dcel[i].getV1().getX())+calcX((int)dcel[i].getV2().getX()))/2;
int
mijlocY=(calcY((int)dcel[i].getV1().getY())+calcY((int)dcel[i].getV2().getY()))/2;
g2.fillOval(calcX((int)dcel[i].getV1().getX())-
2,calcY((int)dcel[i].getV1().getY())-2,4,4);
g2.fillOval(calcX((int)dcel[i].getV2().getX())-
2,calcY((int)dcel[i].getV2().getY())-2,4,4);
//desenatul arcelor corect!!!!!
double mX=(dcel[i].getV1().getX()+dcel[i].getV2().getX())/2.0;
double mY=(dcel[i].getV1().getY()+dcel[i].getV2().getY())/2.0;
double mmX=mX;
double mmY=mY;
double mp1X=mX-0.3;
double mp1Y=mY-0.3;
double mp2X=mX+0.3;
double mp2Y=mY-0.3;
double inclinare=0d;

if(dcel[i].getV1().getX()<dcel[i].getV2().getX()) inclinare=-Math.PI/2;
else inclinare=Math.PI/2;
g2.setColor(Color.red);
//double teta=(Math.sqrt(Math.pow(dcel[i].getV1().getX()-
//mX,2)+Math.pow(dcel[i].getV1().getY()-
//mY,2)))/(Math.sqrt(Math.pow(dcel[i].getV1().getY()-mY,2)));
double cosu=Math.sqrt(Math.cos(Math.pow(dcel[i].getV1().getY()-
mY,2)))/Math.sqrt((Math.pow(dcel[i].getV1().getX()-mX,2)));
double tangenta=(dcel[i].getV2().getY()-
dcel[i].getV1().getY())/(dcel[i].getV2().getX()-dcel[i].getV1().getX());
double teta=Math.atan(tangenta)+inclinare;
AffineTransform at = new AffineTransform();
mX-=mp1X;
mY-=mp1Y;
at.rotate(teta,mX,mY);
double newX = at.getTranslateX();
double newY = at.getTranslateY();
newX+=mp1X;
newY+=mp1Y;
g2.drawLine(mijlocX,mijlocY,calcX(newX),calcY(newY));
AffineTransform at1 = new AffineTransform();
mmX-=mp2X;
mmY-=mp2Y;
at1.rotate(teta,mmX,mmY);
newX = at1.getTranslateX();
newY = at1.getTranslateY();
newX+=mp2X;
newY+=mp2Y;
g2.drawLine(mijlocX,mijlocY,calcX(newX),calcY(newY));
//g2.drawLine(mijlocX,mijlocY,mijlocX+3,mijlocY+3);
//g2.drawLine(mijlocX,mijlocY,mijlocX-3,mijlocY+3);
g2.drawString(""+dcel[i].getNr(),mijlocX+2,mijlocY+2);

g2.setColor(Color.black);
}
if(mouseSelect){
g.setColor(Color.blue);
g.fillOval(mouseX,mouseY,1,1);
g.drawLine(mouseX+2,mouseY-2,mouseX-2,mouseY+2);
g.drawLine(mouseX-2,mouseY-2,mouseX+2,mouseY+2);
dcel=a.getDCEL();
for(int i=0;i<dcel.length;++i){
if((dcel[i].getF1()==F)||(dcel[i].getF2()==F))
g.drawLine(calcX((int)dcel[i].getV1().getX()),
calcY((int)dcel[i].getV1().getY()),
calcX((int)dcel[i].getV2().getX()),
calcY((int)dcel[i].getV2().getY())
);
}
/***
if (F==0) {
ArrayList sir3 = a.getUnLant();
g.setColor(Color.YELLOW);
Object[] sir4=sir3.toArray();
for(int d=0;d<sir4.length;++d){
g.drawLine(calcX((int)((Muchie5)sir4[d]).getV1().getX())+2,
calcY((int)((Muchie5)sir4[d]).getV1().getY())+2,
calcX((int)((Muchie5)sir4[d]).getV2().getX())+2,
calcY((int)((Muchie5)sir4[d]).getV2().getY())+2
);
}
} else{
ArrayList[] array=a.getLant();
g.setColor(Color.YELLOW);
Object[] sir1=array[0].toArray();
for(int d=0;d<sir1.length;++d){
g.drawLine(calcX((int)((Muchie5)sir1[d]).getV1().getX())+2,
calcY((int)((Muchie5)sir1[d]).getV1().getY())+2,
calcX((int)((Muchie5)sir1[d]).getV2().getX())+2,
calcY((int)((Muchie5)sir1[d]).getV2().getY())+2
14
);
}
g.setColor(Color.pink);
Object[] sir2=array[1].toArray();
for(int d=0;d<sir2.length;++d){
g.drawLine(calcX((int)((Muchie5)sir2[d]).getV1().getX())-2,
calcY((int)((Muchie5)sir2[d]).getV1().getY())-2,
calcX((int)((Muchie5)sir2[d]).getV2().getX())-2,
calcY((int)((Muchie5)sir2[d]).getV2().getY())-2
);
}
g.setColor(Color.blue);
}
***/ //era prea oribil
}
}
public int calcX(double x){
return (int)(250+x*10);
}//calcX(int x)
public int calcY(double y){
return (int)(250-y*10);
}//calcY(int y)
}