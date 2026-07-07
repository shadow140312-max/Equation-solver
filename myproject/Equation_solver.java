import java.beans.Expression;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;



class Equation_solver{

    public static int chatToInt(char a) {
        if((a+"").equals('*'+"")){
return 2;
        }
         if((a+"").equals('+'+"")){
            return 1;
        }
         if((a+"").equals('-'+"")){
            return 0;
        }
         if((a+"").equals('/'+"")){
            return 3;
        }
        System.out.println("-----error------------------------------------------------------------------------");
        return -1;
    }
    public static class Node{
        expression value;
List<Node> children=new ArrayList<>();

public Node(expression val){
    this.value=val;
    //this.children.addAll(List.of(a));

    }
    }

public static Node simplify(String s,Node parent){
int smallest=9999;
int index=-67;
boolean therIsoneop=false;

    for(int i=0;i<s.length();i++){
        char tem=s.charAt(i);

if((tem+"").equals('*'+"")||(tem+"").equals('/'+"")||(tem+"").equals('-'+"")||(tem+"").equals('+'+"")){
    if(smallest>chatToInt(tem)){
        smallest=chatToInt(tem);
        index=i;
    }
    therIsoneop=true;
}
    }
    if(therIsoneop==false){
Node b=new  Node(ExpressionInit(s));
b.value.display();
System.out.println(b.children);
return b;
   }
    Node itself=new Node(opExpressionInit(s.charAt(index)));
    
    itself.children.add(simplify(s.substring(0,index), itself));
   itself.children.add(simplify(s.substring(index+1), itself));
   //parent.children.add(itself);
   System.out.print("value=  ");
itself.value.display();

  for(int i=0;i<itself.children.size();i++){
    System.out.print("  children at "+i+" =");
    itself.children.get(i).value.display();
    System.out.println();
   }
    return itself;
}













 public static class  variable{
String mainVar;
int expoPart=1;      
public variable(String a, int b){
    this.mainVar=a;
    this.expoPart=b;
}                                  //later i will make a variabel.display function otot
 public variablePart multiplication(variablePart a){
  if(a.varPart.containsKey(this.mainVar)){
a.varPart.get(this.mainVar).expoPart+=this.expoPart;
  }else{
    a.varPart.put(this.mainVar,this);
    
  }
  return a;

 }

 public variablePart division(variablePart a){
if(a.varPart.containsKey(this.mainVar)){
    if(a.varPart.get(this.mainVar).expoPart-this.expoPart!=0){
a.varPart.get(this.mainVar).expoPart-=this.expoPart;

    }else{
        a.varPart.remove(this.mainVar);
    }
}else{
    a.varPart.put(this.mainVar,new variable(this.mainVar, (this.expoPart*-1)));
   
}
return a;
 }
 public void display(){
  
    if(expoPart!=0){
        if(expoPart==1){
            System.out.print(mainVar);  
              }else{
    System.out.print(mainVar+"^"+expoPart);
              }
    }else{
        //prints nothing
    }
 }

    }
 ///////////////////////////////////////////////////////////////////////////////////////////////////
  public static variablePart variablePartinit(String s){
  HashMap<String,variable> varPart=new HashMap<>();
  if(s.equals("")){
    varPart.put("",new variable("", 1));
    return new variablePart(varPart);
  }
for(int i=0;i<s.length()-1;i++){ //skips the last char
    char tem=s.charAt(i);
 if(s.charAt(i+1)=='^'){
    varPart.put(tem+"",new variable(tem+"", Integer.parseInt(s.charAt(i+2)+"")));
    i+=2;

 }else{
    varPart.put(tem+"",new variable(tem+"",1));
 }
}
char tem=s.charAt(s.length()-1);
if(!(tem>47&&tem<58)){   
    varPart.put(tem+"", new variable(tem+"",1));
}
return new variablePart(varPart);
  }
////////////////////////////////////////////////////////////////////////////////////////////////////////////
  public static class variablePart{
  HashMap<String,variable> varPart;

  
  public  variablePart (HashMap<String,variable> a){
this.varPart=a;
  }                                                               //note whiel inittialzing all the variables parts 
        public static boolean isalike(variablePart a,variablePart b){
for(String i:a.varPart.keySet()){
    if(!b.varPart.containsKey(i)){
return false;
    }
}
return true;
        }

  
  
  
                                                               //shoudl be sorted to use th estring.equal function in add and substract 
  public void display(){
    for(String i:this.varPart.keySet()){
        this.varPart.get(i).display(); 
    }
  }
 
}
 
/////////////////////////////////////////////////////////////////////////
public static term TermInit(String s){
 //   System.out.println("s="+s);
    String num="";
    int start=0;
    for(int i=0;i<s.length();i++){
        char tem=s.charAt(i);
        if((tem>64&&tem<91)||(tem>96&&tem<123)){
start=i;
break;
        }else{
            num+=tem;
        }
    }
    int n=1;
    String sdefault="";
   // System.out.println("num="+num);
    //System.out.println("substring="+s.substring(start));
if(!num.equals("")){
       n=Integer.parseInt(num);


}else{
    //System.out.println("only var i guess");
}

if(start!=0){
sdefault=s.substring(start);
}
   
    term t= new term(variablePartinit(sdefault),n);
  //  System.out.println("term ");
    //t.display();
  //  System.out.println("");
    return t;
}

public static term opTermInti(char a){
return new term(variablePartinit(a+""),1);
}

/////////////////////////////////////////////////////////////////////////
public static class term{
variablePart termvarPart;

 int constant=1;
         // i shoudl change term inti too

public term(variablePart a,int b){
this.termvarPart=a;
this.constant=b;

}
public static void add(int index1,int index2,expression exp1,expression exp2){
term a=exp1.listTerm.get(index1);
term b=exp2.listTerm.get(index2);
if(variablePart.isalike(a.termvarPart,b.termvarPart)){
a.constant+=b.constant;
exp2.listTerm.remove(index2);

}

}

 public void display(){
   if(constant!=1){
        System.out.print(constant);
   }
      termvarPart.display();
 }
}

public static class termGroup{
    List<term> termList;
    boolean issimplified=false;
    List<String> operation;

    public termGroup(List<term> a,List<String> b){
        this.termList =a;
        this.operation=b;
    }




    public void display(){
for(int i=0,j=0;i<this.termList.size();i++){
    this.termList.get(i).display();
    if(i!=this.termList.size()-1){
    System.out.print(operation.get(i));
    }
}
    }
}
/* 
public static termGroup TermGroupInit(String s){
List<term> list=new ArrayList<>();
List<String> op=new ArrayList<>();
int start=0;
if(s.equals("")){
System.out.println("---error---------------------------");
list.add(TermInit(s));
return new termGroup(list,op);
}

for(int i=0;i<s.length()-1;i++){
    char tem=s.charAt(i);
    if(tem=='*'||tem=='/'){ 
list.add(TermInit(s.substring(start,i)));
op.add(tem+"");
start=i+1;
    }else{
        if(tem=='('){
//pending----------------------------
//---------------------------
        }
    }
}
char tem=s.charAt(s.length()-1);
if(!(tem+"").equals(")")){
    list.add(TermInit(s.substring(start)));
}
return new termGroup(list,op);
}

*/
public static class expression{

List<term> listTerm;
List<String> operation;
 public expression(List<term> a,List<String>b){
    this.listTerm=a;
    this.operation=b;
 }

public expression add(expression a,expression b){
    for(int i=0;i<b.listTerm.size();i++){
for(int j=0;j<a.listTerm.size();j++){
 term.add(j,i,a,b);
}
}
return a;
}

 public void display(){
for(int i=0;i<this.listTerm.size();i++){
   
this.listTerm.get(i).display();
if(i!=this.listTerm.size()-1){
System.out.print(operation.get(i));
}

}
 }
} /////////////////////////////////////////////////////////////// 

public static expression opExpressionInit(char a){
     List<term> listTerm=new ArrayList<>();
     listTerm.add(new term(variablePartinit(a+""),1));
     List<String> l=new ArrayList<>();
     l.add("");
return new expression(listTerm,l);
}
public static expression ExpressionInit(String s){
     int start=0;
     List<term> listTerm=new ArrayList<>();
List<String> op=new ArrayList<>();
    for(int i=0;i<s.length()-1;i++){
        char tem=s.charAt(i);
       
if((tem+"").equals('+'+"")||(tem+"").equals('-'+"")){
listTerm.add(TermInit(s.substring(start,i)));
op.add(tem+"");

start=i;
}
    }
  
 
        listTerm.add(TermInit(s.substring(start,s.length())));
    
    return new expression(listTerm,op);
}





 


    public static void main(String[] args) {   
String s="29+3-4+6*9/2";
Node test=new Node(ExpressionInit("2x"));
Node ta=simplify(s, test);



        
    }
}
        
        
