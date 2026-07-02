import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Equation_solver{

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
Set<String> setvar=new HashSet<>();
List<Integer> listconst=new ArrayList<>();

for(int i=0;i<variables.size();i++){
String tem=variables.get(i);
    if(setvar.contains(tem)){
listconst.set(i,list.get(i)+Integer.parseInt(constants.get(i)));
    }else{
        setvar.add(tem);
        listconst.add(Integer.parseInt(constants.get(i)));
    }


  }    
}
    public static void main(String[] args) {   
        String example="+11234567890cj-1cjkhf-1cjgsjh264+6541=4+ll_457682+1jufioaj-fjaokl+48997295208";//at least 1 constant shoudl be attached 
        System.out.println(Seperator(ListMaker(example)).get(0));
                System.out.println(Seperator(ListMaker(example)).get(1));
                System.out.println(ListMaker(example));
            
            }
}
