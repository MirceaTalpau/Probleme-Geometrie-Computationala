import java.util.*;
public class Algoritm5{
private Punct5[] a;
private Muchie5[] dcel;
private List matura; //maturatorul
//private int[] W; //vectorul care retine ponderile muchiilor;
private double x,y;
private Muchie5 mBin;
private ArrayList lantBin;
private ArrayList[] L;
private TreeSet OUT1;
private int mijloc=0;
public Algoritm5(Punct5[] a,Muchie5[] dcel){
this.a=a;
this.dcel=dcel;
Arrays.sort(a);
interschimba();
listeaza();
calculeazaPonderi();
gasesteLanturi();
}
/***
private void sorteaza(){
for(int i=0;i<a.length-1;++i)
for(int j=i+1;j<a.length;++j){
if(a[i].getY()>a[j].getY()){
Punct3 aux;
aux=a[i];
a[i]=a[j];
a[j]=aux;
}
4
}
}
***/
private void interschimba(){
for(int i=0;i<dcel.length;++i){
if(((dcel[i].getV1()).compareTo(dcel[i].getV2()))>0)
dcel[i].inverseaza();
}
}
public void listeaza(){
for(int i=0;i<a.length;++i){
TreeSet c=new TreeSet();
TreeSet b=new TreeSet();
for(int j=0;j<dcel.length;++j){
if(((dcel[j].getV1()).compareTo(a[i]))==0) c.add(dcel[j]);
if(((dcel[j].getV2()).compareTo(a[i]))==0) b.add(dcel[j]);
}
Iterator it=c.iterator();
System.out.print("+"+(i+1)+"\t:");
while(it.hasNext()) System.out.print("
"+((Muchie5)(it.next())).getNr());
System.out.println();
a[i].setC(c);//muchiile care ies
it=b.iterator();
System.out.print("-"+(i+1)+"\t:");
while(it.hasNext()) System.out.print("
"+((Muchie5)(it.next())).getNr());
System.out.println();
a[i].setB(b); //muchiile care intra
for(int l=0;l<dcel.length;++l){
if(dcel[l].getV1().compareTo(a[i])==0) {
dcel[l].getV1().setB(b);
dcel[l].getV1().setC(c);
}
if(dcel[l].getV2().compareTo(a[i])==0) {
dcel[l].getV2().setB(b);
dcel[l].getV2().setC(c);
}
}
}
5
}
public void calculeazaPonderi(){
for(int i=0;i<dcel.length;++i) dcel[i].setW(1);
for(int i=1;i<a.length-1;++i){
TreeSet IN=(TreeSet)(a[i].getB());
int wIn=0;
Iterator it=IN.iterator();
while(it.hasNext()){
Muchie5 muchie=(Muchie5)(it.next());
wIn+=muchie.getW();
}
TreeSet OUT=(TreeSet)(a[i].getC());
int wOut=0;
it=OUT.iterator();
while(it.hasNext()){
Muchie5 muchie=(Muchie5)(it.next());
wOut+=muchie.getW();
}
if (wIn>wOut) {
it=OUT.iterator();
Muchie5 muchie=(Muchie5)(it.next());
muchie.setW(1+wIn-wOut);
}
}
for(int i=a.length-1;i>0;--i){
TreeSet IN=(TreeSet)(a[i].getB());
int wIn=0;
Iterator it=IN.iterator();
while(it.hasNext()){
Muchie5 muchie=(Muchie5)(it.next());
wIn+=muchie.getW();
}
TreeSet OUT=(TreeSet)(a[i].getC());
int wOut=0;
it=OUT.iterator();
while(it.hasNext()){
Muchie5 muchie=(Muchie5)(it.next());
wOut+=muchie.getW();
}
6
if (wIn<wOut) {
it=IN.iterator();
Muchie5 muchie=(Muchie5)(it.next());
muchie.setW(muchie.getW()+wOut-wIn);
}
}
//afisare poderi muchii
System.out.println("---***---...afisare ponderi muchii...---***---");
for(int i=0;i<dcel.length;++i){
System.out.println(dcel[i].getNr()+":\t"+dcel[i].getW());
}
}
public void gasesteLanturi(){
int nr=0;
TreeSet OUT=(TreeSet)a[0].getC();
Iterator it=OUT.iterator();
while(it.hasNext()){
nr+=((Muchie5)(it.next())).getW();
}
L=new ArrayList[nr];
System.out.println("nr= "+nr);
it=OUT.iterator();
int i=-1;
while(it.hasNext()){
Muchie5 muchie=(Muchie5)(it.next());
while(muchie.getW()!=0){
++i;
L[i]=new ArrayList();
Lant(muchie,i);
}
}
System.out.println("+++***---Afisarea lanturilor---***+++");
for(int k=0;k<nr;++k){
System.out.print("start");
Object[] array=L[k].toArray();
for(int j=0;j<array.length;++j) System.out.print(" -->
"+((Muchie5)array[j]).getNr());
System.out.println();
}
}
7
public void Lant(Muchie5 muchie,int i){
L[i].add(muchie);
muchie.setW(muchie.getW()-1);
if(muchie.getV2().compareTo(a[a.length-1])==0) return;
else{
//if(muchie.getW()!=0){
//System.out.println(muchie.getNr());
Punct5 nextPunct=(Punct5)(muchie.getV2());
TreeSet o=(TreeSet)(nextPunct.getC());
//OUT1=(TreeSet)(((Punct5)(muchie.getV2())).getC());
//if (o==null) {
// System.out.println("M-am oprit la
//:+((Punct5)(muchie.getV2())).getX()+" "+((Punct5)(muchie.getV2())).getY());
//}
Iterator it=o.iterator();
Muchie5 muchie1=null;
while(it.hasNext()){
muchie1=(Muchie5)(it.next());
if(muchie1.getW()>0) break;
}
Lant(muchie1,i);
}
}
public int cautaLantul(double x, double y){
this.x=x; this.y=y;
cautaBinar(0,L.length-1);
Object[] array=lantBin.toArray();
Punct5[] array1=new Punct5[array.length+1];
for(int i=0;i<array.length;++i){
array1[i]=((Muchie5)array[i]).getV1();
}
Muchie5 muchie=null;
array1[array1.length-1]=((Muchie5)array[array.length-1]).getV2();
Punct5 punctCautat=new Punct5(x,y);
int nr=Math.abs(Arrays.binarySearch(array1,punctCautat));
System.out.println("Punct de insertie "+nr);
if (nr<=1) {muchie=(Muchie5)array[0];}
if (nr>=array1.length) muchie=(Muchie5)array[array.length-1];
if ((nr>1)&&(nr<array1.length)) {muchie=(Muchie5)array[nr-2];}
System.out.println(nr);
mBin=muchie;
int F=0;
if(mBin==null) return 0;
if(calcDet (mBin.getV1().getX(),

mBin.getV1().getY(),
x,
y,
mBin.getV2().getX(),
mBin.getV2().getY()
)>0)
F=mBin.getF2();
else F=mBin.getF1();
System.out.println(mBin.getNr()+"Numarul muchiei");
return F;
}
public Muchie5 getMuchie(){
return mBin;
}
public ArrayList []getLant(){
ArrayList[] array=new ArrayList[2];
array[0]=lantBin;
if(calcDet (mBin.getV1().getX(),
mBin.getV1().getY(),
x,
y,
mBin.getV2().getX(),
mBin.getV2().getY()
)>0)
array[1]=L[mijloc+1];
else array[1]=L[mijloc-1];
return array;
}
public ArrayList[] getListaLanturi(){
return L;
}
public ArrayList getUnLant(){
return lantBin;
}
public void cautaBinar(int s,int d){
int mijloc=(s+d)/2;
if(s<d){
Object[] array=L[mijloc].toArray();
Punct5[] array1=new Punct5[array.length+1];
for(int i=0;i<array.length;++i){
array1[i]=((Muchie5)array[i]).getV1();
9
}
array1[array1.length-1]=((Muchie5)array[array.length-1]).getV2();
Punct5 punctCautat=new Punct5(x,y);
int nr=Math.abs(Arrays.binarySearch(array1,punctCautat));
Muchie5 muchie=null;
if (nr<=1) muchie=(Muchie5)array[0];
if (nr>=array1.length) muchie=(Muchie5)array[array.length-1];
if ((nr>1)&&(nr<array1.length)) muchie=(Muchie5)array[nr-2];
if (calcDet(muchie.getV1().getX(),
muchie.getV1().getY(),
x,
y,
muchie.getV2().getX(),
muchie.getV2().getY())>0) cautaBinar(mijloc+1,d);
else cautaBinar(s,mijloc-1);
}
else {
lantBin=L[mijloc];
System.out.println("mijlocul este"+mijloc);
this.mijloc=mijloc;
}
}
public int cautaLespede(double x, double y){
return ~Arrays.binarySearch(a,new Punct5(x,y));
} //intoarce in a cata lespede se afla punctul cautat
public double calcDet(double x1,double y1, double x2, double y2, double x3,
double y3){
return x1*y2+x2*y3+x3*y1-y2*x3-y3*x1-y1*x2;
}
public Muchie5[] getDCEL(){
return dcel;
}
}