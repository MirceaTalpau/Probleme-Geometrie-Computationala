import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;


public class Problema5 extends JPanel{
private int n,nrM;
private Desen5 canvas;
private JButton adauga;
private JTextField fisier;
private Set p,m;
private AscultatorButon ab;

public Problema5(){
this.setLayout(new BorderLayout());
ab=new AscultatorButon();
canvas=new Desen5();
adauga=new JButton("Citeste");
adauga.addActionListener(ab);
fisier=new JTextField(10);
fisier.setText("prob5.txt");
JPanel p=new JPanel();
JPanel p3=new JPanel(new GridLayout(2,1));
JPanel p1=new JPanel();
p1.add(adauga);
JPanel p2=new JPanel();
p2.add(fisier);
p3.add(p1);
p3.add(p2);
p.add(p3);
this.add(p,BorderLayout.WEST);
this.add(canvas,BorderLayout.CENTER);
}//Problema3() --> constructorul "clasei"
public class AscultatorButon implements ActionListener{
public void actionPerformed(ActionEvent e){
if(e.getSource()==adauga){

String s=fisier.getText();
p=new TreeSet();
m=new TreeSet();
try{
StreamTokenizer st=new StreamTokenizer(new
BufferedReader(new FileReader(s)));
st.nextToken(); nrM=(int)st.nval;
for(int i=0;i<nrM;++i){
st.nextToken(); int x=(int)st.nval;
st.nextToken(); int y=(int)st.nval;
Punct5 punct1=new Punct5(x,y);
p.add(punct1);
st.nextToken(); int x1=(int)st.nval;
st.nextToken(); int y1=(int)st.nval;
Punct5 punct2=new Punct5(x1,y1);
p.add(punct2);
st.nextToken(); int f1=(int)st.nval;
st.nextToken(); int f2=(int)st.nval;
st.nextToken(); int pp1=(int)st.nval;
st.nextToken(); int pp2=(int)st.nval;
m.add(new Muchie5(i,
punct1,
punct2,
f1,
f2,
pp1,
pp2));
}
}
catch(FileNotFoundException fnfe){
JOptionPane.showMessageDialog(null,"Nu exista acest fisier!","Mesaj de eroare",JOptionPane.WARNING_MESSAGE);
}
catch(IOException eeee){ System.out.println("Probleme la introducerea datelor!!!!!!!!!!!!");
}
Punct5[] pp=new Punct5[p.size()];
System.out.println("Numarul de puncte : "+p.size());
Iterator it=p.iterator();
for(int i=0;i<p.size();++i){
pp[i]=(Punct5)(it.next());
}
Muchie5[] mm=new Muchie5[m.size()];
it=m.iterator();
for(int i=0;i<m.size();++i){
mm[i]=(Muchie5)(it.next());

}
Algoritm5 a=new Algoritm5(pp,mm);
canvas.start(a);
}
}
}//actionPerformed()
}


