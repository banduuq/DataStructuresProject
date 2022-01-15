package ds_project;

import java.util.Scanner;
import java.util.zip.DeflaterOutputStream;

public class Main {
 public static final Scanner  scan  =  new Scanner(System.in); 
	public static void main(String[] args) {
	 Student student1 = new Student("qoryoley", "hassan", "150315051","engineering", "Computer");
	  Student student2 = new Student("mohamed", "qoryoley", "1402536","ngineer","computer engineer");
	 Student student3 = new Student("hassan", "qoryo","45","iktisad","işletme");
	 Student student4 = new Student("mohamed","ban",  "1278569","edcine","doctor");
	 Student student5 = new Student("llllll","ban",  "1278569","edcine","doctor");
		 //  Student s  = new Student();
		 DoublyLinkedList <Student> ob = new DoublyLinkedList<Student>();
	    binarysearchtree<Student> obj= new binarysearchtree<Student>(); 
	   Hashtable <String , Student> object = new Hashtable<>();
//	 obj.add(student1);
//	 obj.add(student2);
//	 obj.add(student3);
//	 obj.add(student4);
//	 obj.add(student5);
//	 obj.remove(student5);
//	 obj.InorderTraversal(obj.root);
//	 //obj.name_caount(obj.root);
//	 obj.listD();
	 //ob.name_count();
//	 object.add("150315051", student1);
//	 object.add("1402536", student2);
//	 object.add("45", student3);
//	 object.add("1278569", student4);
//	object.List_distinct_Names();
	// object.name_count();
//	  object.values();
//	object.List_distinct_Names();
	 
	
//		obj.add(student1);
//		obj.add(student2);
//		obj.add(student3);
//		obj.add(student4);



		
		  showMenu();
		  int choice ;
		  String seç;
		  do {
		  switch(choice = getInt("please enter ur selection")  ) {
		  case 1:
			  Student s = new Student();
			    System.out.println("enter Student id  ");
			    s.setStudent_id(scan.next());
			    System.out.println("enter Student name");
		        s.setName(scan.next());
		        System.out.println("enter Student Surname");
			   s.setSurname(scan.next());
				 System.out.println("enter Student faculty");
		    	s.setFaculty(scan.next());
		    	 System.out.println("enter Student depart ment");
               s.setDeparment(scan.next());		    
              ob.insertItem(s);
              obj.add(s);
              object.add(s.getStudent_id(), s);
              System.out.println(s + "   Stored succesfully ");	  
		      break;
		  case 2:
			  System.out.println("please enter the Student id u want to delete");
				    String  f = scan.next();
		        	Student student =   ob.findNode(f);
				 ob.deletItem(student);
				 obj.remove(student);
				 object.remove(f);
				 System.out.println("Student removed  succesfully");
				 break;
		  case 3:
	   System.out.println("please enter the Student id "); 
	   String  stu = scan.next();
	    object.findnode(stu);
	    break;
		  case 4:		 
			  altMenu();
			  switch(seç = getString("which data structure u want to use ")) {
			  case " LinkedList" :
	         ob.show();
	          break;
			  case "bst":
	         obj.InorderTraversal(obj.root);
	         break;
			  case "hash table":
	         object.list();
	          break;
	          default:
	        	 System.out.println("please enter as written in the menu"); 
			  }
			   break;
		  case 5:
			  object.List_distinct_Names();
			   break;
		  case 6:
			  object.name_count();
			  break;
		  case 7: 	 
			  System.out.println ("name:  " +" mohamed "+ " surname "+ " hassan "+"id "+" 150315051");
			  break;
			 
			  default:
				  System.out.println("please choose correct number! ");
			   }		  
		  }  while(choice != 0);
		  }
	public static void showMenu() {
        System.out.println("This program will preform several types of operations.");
        System.out.println();
        System.out.println("===============MENU=====================");
        System.out.println("Select from the following menu options:");
        System.out.println("0 - Exit");
        System.out.println("1 -Add tudent");
        System.out.println("2 -Delete Student");
        System.out.println("3 - Find student");
        System.out.println("4 - List All Students");
        System.out.println("5 - List distinct names");
        System.out.println("6 - List name counts");
        System.out.println("7- About");
  
      }	
	public static void altMenu() {
    ;
        System.out.println();
        System.out.println("===============MENU=====================");
        System.out.println("Select from the following structures:");
        System.out.println("LinkedList");
        System.out.println("bst");
        System.out.println("hashtable");
      }	
	 private static int getInt(String prompt) {
	        boolean unassigned = true;
	        int value = 0;
	        while(unassigned) {
	          try {
	              System.out.println(prompt);
	              value = scan.nextInt();
	              unassigned = false;
	          }
	          catch (IllegalArgumentException e) {}
	        }
	          System.out.println("[" + value + "]");

	        return value;
	      }
	 private static String getString(String prompt) {
	        boolean unassigned = true;
	        String value = null;
	        while(unassigned) {
	          try {
	              System.out.println(prompt);
	              value = scan.next();
	              unassigned = false;
	          }
	          catch (IllegalArgumentException e) {}
	        }
	          System.out.println("[" + value + "]");

	          return value;
	      }
	  
	 public static String getType() {
		System.out.println("please eneter what kind of data u want to store");
		String type = scan.next();
		 return type;
	 }
	 
	 
}
