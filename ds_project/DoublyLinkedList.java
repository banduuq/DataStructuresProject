package ds_project;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DoublyLinkedList <T extends Comparable <T>>
{
   private Node  head;  
	public boolean insertItem(T item) {
		 Node n = new Node();
		  n.data = item;
		  if(head == null) {
			  head = n;
			  head.pre = null;
			  head.next = null;
		  }
		  else {
		 n.pre = null;
		 head.pre = n;
		 n.next = head;
		 head = n;
		  }
		  return true;
		}
	public void show() {
		 Node node = head;
		 while(node != null) {
			 System.out.println(node.data);
			 node = node.next;
		 }
	} 
		 public boolean deletItem(T item) {
			   if(head.data == item) {
				 head = head.next;
				 return true;
			   }
			   else {
				Node x = head;
				Node y = head.next;
				while(true) {
				if(y == null || y.data == item) {
					break;
				}
				else {
				 x = y;
				 y = y.next;
				}
				}
				 if(y != null ) {
				 x.next = y.next;
					return true;
					 }
			     else {
				return false;
					 }
			   }
		}
		 
	   public T  findNode (String id) {
		   Node   n  = head;
		   while(n != null) {
			  if( n.data.equals(id) == true) {
				  break;
			  } else {
				  n = n.next;
			  }
		   }
		   if(n == null) {
			   return null;
		   } else {
			   return n.data;
		   }
	   }
	  
	   public void FindStudent( T item) {
		   int count = 0;
		   Node z  = head;
		   while( z  != null) {
			   if(z.data == item) {
				     break;
			   } 
			   else {
				   count += 1;
				  z = z.next;
			    }
	   }
		 if(z == null) {
			 System.out.println("Student not found");
		 }
		 else {
		   System.out.println(z.data);
		   System.out.println("search level "+ count);
		 }
	   }
	  
  public void List_distinc_names() {
	   Set <String>  s = new HashSet<>();
	   Node node = head;
		   while(node != null) {
		  s.add(((Student) node.data).getName());
			  node = node.next;
		   }
		  for(String  i :  s) {
			  System.out.println(i);
		  }
	   }
  
  public void name_count() {
  Map<String, Integer> m = new HashMap<String, Integer>();
  Node node = head;
  while(node != null) {
	  Integer a = m.get(((Student) node.data).getName());
	  m.put(((Student) node.data).getName(), (a == null)  ? 1 : a+ 1);   
	  node = node.next;
  }
  for (Map.Entry<String, Integer> val : m.entrySet()) { 
      System.out.println("Name:  " + val.getKey() + " "
                         + "occurs"
                         + ": " + val.getValue() + " times"); 
  } 
  }
  
	class Node {
		 T data;
		 Node   next;
		 Node  pre;
		 }
}
