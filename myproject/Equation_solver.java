import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;





 class variable{
String mainVar;
int expoPart=1;      
public variable(String a, int b){
    this.mainVar=a;
    this.expoPart=b;
}                                  //later i will make a variabel.display function otot
 public variablePart multiplication(variable a){
    if(this.mainVar!=a.mainVar){
        List<variable> tem=new ArrayList<>(); 
        tem.add(this);
        tem.add(a);
return new variablePart(tem);
    }else{
      List<variable> tem=new ArrayList<>();
      tem.add(new variable(this.mainVar, (this.expoPart+a.expoPart)));
return new variablePart(tem);
    }
 }

 public variable division(variable a){
if(this.mainVar.equals(a.mainVar)){
    if((this.expoPart-a.expoPart)!=0){
        return new variable(mainVar, (this.expoPart-a.expoPart));
    }else{
        return new variable("0", 0);

    }
}else{
   return new variable("0", 0);
}
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

  class variablePart{
  List<variable> varPart;

  public variablePart (List<variable> a){
this.varPart=a;
  }

 }
class Equation_solver{
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
        variable a=new variable("x", 4);
        variable b=new variable("x", 2);
        variable c=new variable("c",1);

        (a.division(b)).display();
    //   (a.multiplication(c)).varPart.get(1).display();
             
            
            }
}
