import java.beans.Expression;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;



class Equation_solver{

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
        /*          
public term mul(int index1,int index2,term t){
    variablePart a=t.termvarPart;
    variablePart b=t.termvarPart;
}
 */ 
  
  
                                                               //shoudl be sorted to use th estring.equal function in add and substract 
  public void display(){
    for(String i:this.varPart.keySet()){
        this.varPart.get(i).display(); 
    }
  }
 
}
/////////////////////////////////////////////////////////////////////////
public static term TermInit(String s){
    System.out.println("s="+s);
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
    System.out.println("num="+num);
    System.out.println("substring="+s.substring(start));
if(!num.equals("")){
     n=Integer.parseInt(num);
    
}else{
    System.out.println("only var i guess");
}

if(start!=0){
sdefault=s.substring(start);
}
   
    term t= new term(variablePartinit(sdefault),n);
    System.out.println("term ");
    t.display();
    System.out.println("");
    return t;
}
/////////////////////////////////////////////////////////////////////////
public static class term{
variablePart termvarPart;
boolean isbracket=false;
 int constant=1;
 expression bracketsPart;           // i shoudl change term inti too

public term(variablePart a,int b){
this.termvarPart=a;
this.constant=b;
}
/* 
public expression add(int index1,int index2, expression exp){
   term a= exp.listTermGroup.get(index1);
   term b=  exp.listTerm.get(index2);
if(a.isbracket==false&&b.isbracket==false){
    for(String i:a.termvarPart.varPart.keySet()){
        if(!b.termvarPart.varPart.containsKey(i)){
return exp;
        }
    }
}else{
    return exp;
}
    a.constant+=b.constant;
    exp.listTerm.remove(index2);
    return exp;
}

public expression sub(int index1,int index2, expression exp){
   term a= exp.listTerm.get(index1);
   term b=  exp.listTerm.get(index2);
if(a.isbracket==true&&b.isbracket==true){
    for(String i:a.termvarPart.varPart.keySet()){
        if(!b.termvarPart.varPart.containsKey(i)){
return exp;
        }
    }
}else{
    return exp;
}
    a.constant-=b.constant;
    exp.listTerm.remove(index2);
    return exp;
}

*/



 public void display(){
    if(constant>-1){
    System.out.print("+"+constant);
    }else{
        System.out.print(constant);
    }
      termvarPart.display();
 }
}

public static class termGroup{
    List<term> termList;

    public termGroup(List<term> a){
        this.termList =a;
    }
    public void display(){
for(int i=0;i<this.termList.size();i++){
    this.termList.get(i).display();
}
    }
}
public static termGroup TermGroupInit(String s){
List<term> list=new ArrayList<>();
int start=0;
if(s.equals("")){
System.out.println("---error---------------------------");
list.add(TermInit(s));
return new termGroup(list);
}

for(int i=0;i<s.length()-1;i++){
    char tem=s.charAt(i);
    if(tem=='*'||tem=='/'){
list.add(TermInit(s.substring(start,i)));
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
return new termGroup(list);
}



public static class expression{

List<termGroup> listTermGroup;
 public expression(List<termGroup> a){
    this.listTermGroup=a;
 }
 public void display(){
for(int i=0;i<this.listTermGroup.size();i++){
this.listTermGroup.get(i).display();
}
 }
}
/////////////////////////////////////////////////////////////// 
public static expression ExpressionInit(String s){
     int start=0;
     List<termGroup> listTerm=new ArrayList<>();

    for(int i=0;i<s.length()-1;i++){
        char tem=s.charAt(i);
       
if(tem=='+'||tem=='-'){
listTerm.add(TermGroupInit(s.substring(start,i)));
start=i;
}
    }
    char tem=s.charAt(s.length()-1);
 
        listTerm.add(TermGroupInit(s.substring(start,s.length())));
    
    return new expression(listTerm);
}


 /* 


    class term{
         int numerical;
        String variable;
        

    public term(int a, String b){
        this.numerical=a;
        this.variable=b;
    }
        public term add(term a){
if(a.variable.equals(this.variable)){
return new term(this.numerical+a.numerical,this.variable);

}else{
return new term(0,"");
}
        }

    public term subtract(term a){
if(a.variable.equals(this.variable)){
return new term(this.numerical-a.numerical,this.variable);

}else{
return new term(0,"");
}
    }

    }
*/
    /* 

    public static List<String> ListMaker(String s){
        List<String> expressions =new ArrayList<>();
        s=s+"-";
        int start=0;
for(int i=0;i<s.length();i++){
    char curr=s.charAt(i);
    
    if(curr=='+'||curr=='-'){
expressions.add(s.substring(start,i));
start=i;

    }
}
return expressions;
    }


    public static List<List<String>> Seperator(List<String> s){
List<String> varables=new ArrayList<>();
List<String> constants=new ArrayList<>();

for(int i=0;i<s.size();i++){
    String tem=s.get(i);
    String temVar="";
    String temConst="";
    for(int j=0;j<tem.length();j++){
        char curr=tem.charAt(j);
        if((curr>47&&curr<58)||(curr==43||curr==45)){
temConst+=curr;
        }else{
           
            temVar+=curr;
            
        }
    }
varables.add(temVar);
constants.add(temConst);
}
List<List<String>> finalans=new ArrayList<>();
finalans.add(varables);
finalans.add(constants);
return finalans;
    }

    public static String adder(List<String> variables,List<String> constants){
HashMap<String,Integer> setvar=new HashMap<>();
List<Integer> listconst=new ArrayList<>();
List<String> liststring=new ArrayList<>();
if(constants.get(0)==""){
variables.remove(0);
constants.remove(0);
}
System.out.println(variables);
System.out.println(constants);

for(int i=0;i<variables.size();i++){
String tem=variables.get(i);
System.out.println("i "+i);
    if(setvar.containsKey(tem)){
      
listconst.set(setvar.get(tem),listconst.get(setvar.get(tem))+Integer.parseInt(constants.get(i)));
System.out.println(listconst);
        
    }else{
    
        setvar.put(tem, i);
        liststring.add(tem);
        System.out.println("tem "+tem);
        System.out.println(i);
        
        
        listconst.add(Integer.parseInt(constants.get(i)));
        System.out.println(listconst);
        
    }


  }  
  String ans="";
System.out.println(liststring);
for(int i=0;i<listconst.size();i++){
    String tem=listconst.get(i).toString();

    if(listconst.get(i)>=0){
tem="+"+tem;
    }
ans+=tem+liststring.get(i);
}

  return ans;
}
  /* */
    public static void main(String[] args) {   
        /* 
        String example="+1000+4x+8b+3x+2b+5x+50+10x+5b+1x+5b+50";//at least 1 constant shoudl be attac
     System.out.println(adder(Seperator(ListMaker(example)).get(0),Seperator(ListMaker(example)).get(1)));
      */
     String s="2x+90+86+4xh*90b/78y+90";
     expression exp=ExpressionInit(s);
     exp.display();

     
             
            
            }
}
