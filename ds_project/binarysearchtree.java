package ds_project;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class binarysearchtree <T  extends Comparable<T>> {
 public Node<T> root;
 private int size;
 public void add(T value) {
     if (root == null) {
         root = new Node<T>(value);
         ++size;
         return;
     }

     recursiveAdd(root, value);
 }

private void recursiveAdd(Node<T> current, T value) {
     int comparisonResult = current.getValue().compareTo(value);
     if (comparisonResult < 0) {
         if (current.getRight()== null) {
             current.setRight(new Node<>(value));
             ++size;
             return;
         }
         recursiveAdd(current.getRight(), value);
     } else if (comparisonResult > 0) {
         if (current.getLeft() == null) {
             current.setLeft(new Node<>(value));
             ++size;
         }
         recursiveAdd(current.getLeft(), value);
     }
 }
	
 public void InorderTraversal(Node<T> n ) {
	  if( n != null) {
	  InorderTraversal(n.getLeft());
	  System.out.println(n.getValue());
	  InorderTraversal(n.getRight());
	  }
	 }
	
 public boolean remove(T value) {
     return removeRecursive(root, null, value);
 }

 private boolean removeRecursive(Node<T> current, Node<T> parent, T value) {
     if (current == null) {
         return false;
     }

     int comparisonResult = value.compareTo(current.getValue());

     if (comparisonResult < 0) {
         return removeRecursive(current.getLeft(), current, value);

     } else if (comparisonResult > 0) {
         return removeRecursive(current.getRight(), current, value);

     }

     int childCount = 0;
     childCount += (current.getLeft() == null) ? 0 : 1;
     childCount += (current.getRight()== null) ? 0 : 1;

     if (childCount == 0) {
         if (current == root) {
             root = null;
             --size;
             return true;
         }

         if (parent.getLeft() == current) {
             parent.setLeft(null);;
         } else {
             parent.setRight(null);;
         }

         --size;
         return true;
     } else if (childCount == 1) {
         if (current == root)
         {
             if (root.getLeft()!= null)
             {
                 root = root.getLeft();
             }
             else
             {
                 root = root.getRight();
             }

             --size;
             return true;
         }

         Node<T> child = (current.getLeft()!= null) ?
                 current.getLeft() :
                 current.getLeft();

         if (parent.getLeft()== current) {
             parent.setLeft(child);
         } else {
             parent.setRight(child);
         }

         --size;
         return true;
     }
   
     Node<T> successor = getLeftMostChild(current.getRight());
     current.setValue(successor.getValue());

     Node<T> successorsParent = current.getLeft();
     while (successorsParent.getLeft()!= null && successorsParent.getLeft() != successor) {
         successorsParent = successorsParent.getLeft();
     }

     if (successorsParent == successor) {
         current.setRight(successor.getRight());
     } else {
         successorsParent.setLeft(successor.getRight());
     }

     --size;
     return true;

 }
 
 private Node<T> getLeftMostChild(Node<T> current)
 {
     while (current.getLeft() != null)
     {
         current = current.getLeft();
     }

     return current;
 }
 

 public  void  findNode(T value) {
	 int count = 0;
	 Node<T> current = root;  
     while(current != null) {
    int compResult = value.compareTo(current.getValue());
     if (compResult == 0) {
    	  break;
     } else if (compResult < 0) {
         current = current.getLeft();
          ++count;
     } else {
       current = current.getRight();
       ++count;
     }
 }
    if(current != null) {
    System.out.println(current.getValue() + "search level " + count);
    }else {
    	System.out.println("Not Found! ");
    }
 }
 private  boolean  list_distinc_names( Node <T>  n,  Set<String> set) {
	  if(n.getLeft()!= null) {
		  set.add(((Student) n.getValue()).getName());
		   return list_distinc_names(n.getLeft(), set);

	  }
	  
	  if(n.getRight() != null) {
		  set.add(((Student) n.getValue()).getName());
		     return list_distinc_names(n.getRight(), set);
		  
	  } 
	   return true;
 }
  public void listD() {
	   Set <String>  set = new HashSet<>();
	    list_distinc_names(root, set);
	   for(String  i :  set) {
			  System.out.println(i);
	   }
  }
  
 public void name_count( Node<T> current ) {
 Map<String, Integer> m = new HashMap<String, Integer>();
	 if(current != null) {
		 name_count(current.getLeft());
		 name_count(current.getRight());
		  Integer a = m.get(((Student) current.getValue()).getName());
		  m.put(((Student)current.getValue()).getName(), (a == null)  ? 1 : a+ 1);   	 
	 }
	 for (Map.Entry<String, Integer> val : m.entrySet()) { 
	      System.out.println("Name:  " + val.getKey() + " "
	                         + "occurs"
	                         + ": " + val.getValue() + " times"); 
	  } 
 }
 
 
 }

