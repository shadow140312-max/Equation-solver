/*Thinking
whats my goal 
Day 1 and 2 -----------------------------------------------------------------------------------------------------------------------------------------
Goal- Make an equation sovler 
 -find values of variables 
  -that can seperate varaibles
  -solve normla arthemetic equations
  -solve quadratic equation 

so  what shoudl i make i should make fundamental then using them i shodul 
   do things first 
   -my code shoudl solve all the constants
   -then all the varables
   so how does an human solve it  
     setp 1 identify constants
     -add them up 
     -done
    
  Matching like terms-   
     89x-34x-90l-90 so these are expressiosn sepertaed by =,-,etc.. 
my function can iterate teh whole string it and it can seperate constants into another list and add them or make another array and add
everything in that array 

to calculate varaibles i should first seperate all the expression then add the const then tehn i shoudl reove all all the numerical
coeffient in all the vraiables like removign 89 form 89x so then i can match like and unlike terms

-- after i have implneted this wherei can seprertae numberical values and variables into 2 list i will create ans set that will sotre how many
varaibles i have 2a+3b+2a in this the lsit woudl be  variable list =a,b,a const list = 2,3,2  so my set will iterate in vatriblae slist and 
check if it has it or not if its nto having it add it and as both list are structured and ordered it will pull it snumberail value
 from const list so , i nend to maintain 2 sets too ones for var and one for const so in 2a+3b+2a case my code will fist iterate through 
 a,b,a list it will add a as its not their then in set1 then add its numerical value in set 2 which is 2 then it will add b
 and is numerical value then again in A when it comes again it wont add A but add add the numerical value in set 2 btu 2 sets in not neede 1 set and 1 list
 will do it 



Day 3-------------------------------------------------------------------------------------------------------------------------------------------------

i have solved many bugs and now my program can seprete variables seperate all the terms then seperte the numerical values and variables and 
add all like terms and make then add the lists that i have seperated 

_next Goal-
now i should make it capable for transposing and solving a liner equation first -
     -so how will it do that firs my  program shoudl knwo all the basic things like +,- 
     firs i shoudl make my program capable of multipllciation and divison 
     and the laws of exponents
     -i can create an object that can help me with that i can name it expresison calss i can make various funtioncs
     like expresion multiplication expresion adding but doing that would be hard changing it may not turn out to be good toto 
while i was making my most fundamentl class i faced on challenge in that the add fuction what shudl it do if the 2 terms are 
unlike terms i can return 0 as the numerical value in tht case now this is solved 
 i am having one more probelm how to multiply and divide variables i can create anohter calss variabel class that takes the vraibel part of a term 
 and variabel part of another and divides or multiplies them but hwo too i can take the shorted varPart take a vairable form that and 
 check if that part is thaving that var or not then check if tis having nad exponental value or not if yes tht increas the exponental value 
  a better way would be cerating a sub class variabels and varPart is jsut list of variabels got it i will create 2 properties for var
  one is string main avar and one is string expo part if i wiant to multiply 2 var that are same i will jsut incrase the expo part 
  by 1 but if thery are different i can jsut reutrn varPart objec tinstead of var object even if thery are smme now in 
  variable class i am encountering one more porbelm what shoudl i do one parts like 6^2
  now its up to me what my program shoudl do show the steps too all just the end result i shoudl tell the steps but ignoring the constants 
  i shoudl make a displey function to that can dispaly the variabel nicely then test it i thin ki did a mistake in var i shoud not multply 
  2 singe var is shoudl multipy a whole varPart



  Day4-------------------------------------------------------------------------------------------------------------------------------------------
 
  now to make my equation solver i soudl first ake my variabel part class then expression class if iimagine my idea 
   2x+4+5xy+p(u+o) in this expression there are 5 terms and each are ahivn htere varaibel part 
   2x term variable part is x means list of len 1 {x} ,4 term is ot having var part ,5xy var part is xy so means lsit of 2 {x,y} 
   in p(u+o) term my program shoudl first multiply p*u woth varaible class it owudl reutrn a lsit of {p,u} then my program would 
   return p*o ={p,o} 2 terms that jsut ttranslpate to pu+po but thre si that plus of -value is stored i think in the term class i shooudl add 
   one more propery whch is - or +  2x+4+5xy+p(u+o) so as in out originla  expression it woudl become 2x+4+5xy+pu+po then my rpgtrqam will run a loop 
   to find teh liek terms and add them jstu liek in our prev case so wahts the advantage of these calss i think hwen solving ewuat ion
   2x+5=90/2-5 my program shoudl be capabel of normal operations with bodmass xy i shoudl first compelter this and make 
   a program called simplifiacation today at all cost.
   i remade the function multiplictation of variabel that multiplied one var with one varpart now i jsut need to run that in 
   multiplication function of var part
for better time complexcity i can use hashmaps - nwo what shoudl my cod ebe able to do 
- can apply most of the formulas 
-so multiple var euqation s
-solve exponental equations
-with bodmass
btu hwo will it apply formuals  
i have ow made the varabel class no wi hsoud make an initializer that will make a string into these classes 
i shodu make initilization function in all class except variable class it would help in conver t a strin gto objectss
i shoud create display function for term and other calss too
now how will my prpgrma handle the sum or subtraction of 2 fractions  
i can create it i can make a recusive thing that finds all the possibel routes and will give the most simplified one 
means there can be mianly 5 things -switching sides
                                   -simplifing
                                   -grouping
                                   -applying formula / reformating
                                   -leave it as it is

                                   if i program is capable of doing this then i can make a recusive program
   Day5--------------------------------------------------------------------------------------------------------
          today i planned how to plan my recursion well properly 
          i will create twich() funciton in each calss it it will return an epxresiion iwht  a slight change in it  
          but first i shodul create anohter class named as termgroup 
          now i shoudl make my term calss capable of regrouping ,and simplification that can handle fractions too 
               -  my term program shoudl be able to add terms , subtract terms, simplify , open brackets do exponents 

               while making fucniton in varibel part i realised that gaving a term calss is not enough 
               there shoudl be an object term group which is groups of term but iwhtout + and -
*/