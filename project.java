 
package Project1;
 
import java.util.*;
 
/**
* -Project 1
* @author Nick Wassom
*
*/
public class Project1 {
 
          
           public static void main(String[] args) {
                     
                      // string for while loop
                      String userChoice ;
                     
                     
                     
                      Scanner scan = new Scanner(System.in);
                     
                      // hash maps to pair id to person, course num - course, lab num- ta id
                      HashMap<Integer, Person> idMatch = new HashMap<Integer, Person>();
                      HashMap<Integer, Lectures> lecMatch = new HashMap<Integer, Lectures>();
                      HashMap<Integer, Integer> labMatch = new HashMap<Integer, Integer>();
          
                      // self populating courses to be used
                      Lectures lecOne = new Lectures("COT6578", "(Advanced Computer Theory, Graduate)", 89745, "F2F", "No");
                      Lectures lecTwo = new Lectures("COP5698", "(Programming Languages, Graduate)", 69745, "F2F", "Yes");
               Lectures lecThree = new Lectures("COP3330", "(Introduction Object Oriented Programming, Undergraduate)", 80000, "F2F", "No" );
 
               // self populating lecture match
                      lecMatch.put(89745, lecOne);
                      lecMatch.put(80000, lecThree);
                      lecMatch.put(69745, lecTwo);
                     
                      // self populating lab match
                      labMatch.put(19745, 1234567);
                      labMatch.put(36598, 2589631);
                      labMatch.put(20315, 7845129);
                     
                     
                      // do while loop to run through each option until user exits
                      do {
                                
                                 System.out.println("___________Choose one of the options____________________");
                                 System.out.println();
                                 System.out.println("1. Enter the information of the faculty, the TA or the student");
                                 System.out.println();
                                 System.out.println("2. Print or Edit schedule");
                                 System.out.println();
                                 System.out.println("3. Exit Program");
                                 System.out.println();
                                 System.out.print("Enter your selection: ");
                                 userChoice = scan.next();
                                 System.out.println();
                                
                                
                                 switch(userChoice) {
                                
                                 case "1":
                                           
                                            optionOne(idMatch, lecMatch, labMatch);
                                           
                                            break;
                                           
                                 case "2":
                                           
                                            optionTwo(idMatch, lecMatch);
                                           
                                            break;
                                           
                                 case "3":
                                           
                                            break;
                                           
                                 default :
                                           
                                            break;
                                           
                                
                                 }
                                
                      }while(!userChoice.equals("3"));
                     
                      System.out.println();
                      System.out.println();
                      System.out.println();
                      System.out.println("Goodbye!");
                     
 
           }
 
           // adds a person and the classes they are taking into the system
           public static void optionOne(HashMap<Integer, Person> arrPerson, HashMap<Integer, Lectures> lecMatch, HashMap<Integer, Integer> labMatch) {
                      Scanner sc = new Scanner(System.in);
                     
                      String name;
                      int ucfId;
                      String types;
                      int numLectures;
                      int num;
                      int lab = 0;
                      String res = "yes";
                     
                      // collecting info and creating a person object
                      System.out.println();
                      System.out.print("Enter Name: ");
                      name = sc.nextLine();
                      System.out.println();
                      System.out.print("Enter UCF id number: ");
                      ucfId = sc.nextInt();
                      System.out.println();
                      System.out.print("Enter F for faculty, T for TA or S for Student: ");
                      types = sc.next();
                      System.out.println();
                      System.out.print("Enter how many lectures taken by " + name + ": ");
                      numLectures = sc.nextInt();
                      System.out.println();
                     
                      Person pep = new Person(name, ucfId, types, numLectures);
 
                     
                      // collecting classes a person is involved with
                      for(int i = 1; i <= numLectures; i++) {
                                 System.out.println("Collecting info of Lecture " + i + ": ");
                                 System.out.print("\tEnter crn: ");
                                 num = sc.nextInt();
                                 pep.lecTaken.add(num);
                                 System.out.print("\t" + lecMatch.get(num).description + " " + lecMatch.get(num).modality);
                     
                                
                                 if(lecMatch.get(num).lab.equals("Yes") || lecMatch.get(num).lab.equals("yes")) {
                                            System.out.print(". Lab is Required\n" );
                                            System.out.print("\tEnter crn of the Lab: ");
                                            num = sc.nextInt();
                                            pep.labTaken.add(num);
                                            if(pep.type.equals("t") || pep.type.equals("T")) {
                                                       System.out.println("\tNow, enter how many Labs, " + pep.name + " is supervising: ");
                                                       lab = sc.nextInt();
                                                      
                                            }
                                 }
                                 else
                                 {
                                            System.out.print(" with no lab\n" );
                                 }
                                
                                 // collecting info regarding labs a person is involved with
                                 for(int j = 1; j <= lab; j++)
                                 {
                                            System.out.println("Collecting info of Lab " + j + ": ");
                                            for(int k = 0; k < 1; k++)
                                            {
                                                       System.out.print("\n\tEnter crn: ");
                                                       num = sc.nextInt();
                                                       if(labMatch.get(num) == null)
                                                       {
                                                                             System.out.print("\tIncorrect crn ");
                                                                             System.out.print("\n\tWould you like to re-enter the crn (Yes or No)? ");
                                                                             res = sc.next();
                                                                            
                                                                 
                                                                  if(!res.equals("yes") && !res.equals("Yes"))
                                                                  {
                                                                             System.out.println();
                                                                  }
                                                                  else
                                                                  {
                                                                             k--;
                                                                  }
                                            }
                                           
                                            }
 
                                           
                                 }
                                 System.out.println();
                      }
 
                     
                     
                     
                      arrPerson.put(ucfId, pep);
                     
           }
          
          
           // takes a user and returns there schedule, if no user then it states that
           public static void optionTwo(HashMap<Integer, Person> arrPerson, HashMap<Integer, Lectures> lecMatch) {
                     
                      int ucfId;
                     
                     
                      Scanner sc2 = new Scanner(System.in);
                      System.out.println();
                      System.out.println("Enter the UCF id number: ");
                      ucfId = sc2.nextInt();
                     
                                 if(arrPerson.get(ucfId) == null) {
                                            System.out.println("ID doesn't exist");
                                            System.out.println();
                                            System.out.println();
                                 }
                                
                                 // goes through indivuals schedule and prints it out
                                 else {
                                            arrPerson.get(ucfId);
                                            if(arrPerson.get(ucfId).type.equals("T") || arrPerson.get(ucfId).type.equals("t") )
                                            {
                                                       System.out.printf("Record Found: " + arrPerson.get(ucfId).name, ", TA\n");
                                            }
                                            if(arrPerson.get(ucfId).type.equals("S") || arrPerson.get(ucfId).type.equals("s") )
                                            {
                                                       System.out.printf("Record Found: " + arrPerson.get(ucfId).name, ", Student\n");
                                            }
                                            if(arrPerson.get(ucfId).type.equals("F") || arrPerson.get(ucfId).type.equals("f") )
                                            {
                                                       System.out.printf("Record Found: " + arrPerson.get(ucfId).name, ", Faculty\n");
                                            }
                                           
                                            System.out.print("\n"
                                                                  + "Lectures taken: ");
                                            for(int i = 0; i < arrPerson.get(ucfId).numLectures; i++) {
                                            System.out.print(arrPerson.get(ucfId).lecTaken.get(i) + "/" + lecMatch.get(arrPerson.get(ucfId).lecTaken.get(i)).prefix);
                                                       if(lecMatch.get(arrPerson.get(ucfId).lecTaken.get(i)).lab.equals("yes") || lecMatch.get(arrPerson.get(ucfId).lecTaken.get(i)).lab.equals("Yes"))
                                                       {
                                                                  System.out.print(" (Lab 19745)");
                                                       }
                                           
                                            if(i + 1 < arrPerson.get(ucfId).numLectures) {
                                                                  System.out.print(", ");
                                                       }
                                           
                                            }
                                            System.out.println();
                                           
                                           
                                            if(arrPerson.get(ucfId).type.equals("T") || arrPerson.get(ucfId).type.equals("t") )
                                            {
                                                       System.out.print("Labs supervised: ");
                                            }
                                            else
                                            {
                                                       System.out.print("Labs taken: ");
                                            }
                                            for(int i = 0; i < arrPerson.get(ucfId).labTaken.size(); i++) {
                                                       System.out.print(arrPerson.get(ucfId).labTaken.get(i));
                                                       if(i + 1 < arrPerson.get(ucfId).labTaken.size()) {
                                                                  System.out.print(", ");
                                                       }
                                                      
                                            }
                                            System.out.println();
                                           
                                           
                                 }
           }
}
 
// person object
class Person{
           public String name;
           public int ucfId;
           public String type;
           int numLectures;
           public ArrayList<Integer> lecTaken = new ArrayList<>();
           public ArrayList<Integer> labTaken = new ArrayList<>();
          
          
           public Person(String name, int ucfId, String type, int numLectures) {
                      this.name = name;
                      this.ucfId = ucfId;
                      this.type = type;
                      this.numLectures = numLectures;
           }
                     
                                
}
 
          
// lecture object
class Lectures{
          
           Scanner scan = new Scanner(System.in);
          
    public HashMap<Integer, Integer> pair = new HashMap<Integer, Integer>();
   
          
           String prefix;
           int cRN;
           String modality;
           String lab;
           String description;
          
          
           public Lectures(String prefix, String description, int cRN, String modality, String lab) {
                      this.prefix = prefix;
                      this.cRN = cRN;
                      this.modality = modality;
                      this.lab = lab;
                      this.description = description;
                     
                     
                      if(lab.equals("Yes") || lab.equals("yes")) {
                                 pair.put(1234567, 19745);
                                 pair.put(2589631, 36598);
                                 pair.put(7845129, 20315);
                                
                      }
           }
          
          
          
}
 
