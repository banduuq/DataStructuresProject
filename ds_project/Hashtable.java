package ds_project;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Hashtable <K, V>  {

	private ArrayList<HTNode<K, V>>elements = new ArrayList<>();
	private int capasity = 10;
	private int size;
	public Hashtable()
	{
		for(int i=0;i < capasity;i++)
		{
			elements.add(null);
		}
	}
	public int getSize()
	{
		return size;
	}
	public boolean isEmpty()
	{
		return size==0;
	}
	private int getElementindex(K key)
	{
		int hashCod=key.hashCode();
		return hashCod%capasity;
	}
	public V findnode(K key)
	{
		int index=getElementindex(key);
		HTNode<K, V> head=elements.get(index);
		int count = 0;
		while(head!=null)
		{
			if(head.key.equals(key))
			{
			  break;
			}
			head=head.next;
			count++;
		}
		System.out.println(head.value + " number of serch level "+ count);
		return null;	
	}
	public V remove(K key)
	{
		int index=getElementindex(key);
		HTNode<K, V>head=elements.get(index);
		if(head==null)
		{
			return null;
		}
		if(head.key.equals(key))
		{
			V val=head.value;
			head=head.next;
			elements.set(index, head);
			size--;
			return val;
		}
		else
		{
			HTNode<K, V>prev=null;
			while(head!=null)
			{
				
				if(head.key.equals(key))
				{
					prev.next=head.next;
					size--;
					return head.value;
				}
				prev=head;
				head=head.next;
			}
			size--;
			return null;
		}
	}
	public void add(K key,V value)
	{
		
		int index=getElementindex(key);
		HTNode<K, V>head=elements.get(index);
		HTNode<K, V>toAdd = new HTNode<>();
		toAdd.key=key;
		toAdd.value=value;
		if(head==null)
		{
			elements.set(index, toAdd);
			size++;
			
		}
		else
		{
		while(head!=null)
		{
			if(head.key.equals(key))
			{
				head.value=value;
				size++;
				break;
			}
			head=head.next;
		}
		if(head==null)
		{
		head=elements.get(index);
		toAdd.next=head;
		elements.set(index, toAdd);
		size++;
		}
		}
		if((1.0*size)/capasity>0.7)
		{
			ArrayList<HTNode<K, V>>tmp=elements;
			elements=new ArrayList<>();
			capasity=2*capasity;
			for(int i=0;i<capasity;i++)
			{
				elements.add(null);
			}
			for(HTNode<K, V> headNode:tmp)
			{
				while(headNode!=null)
				{
					add(headNode.key, headNode.value);
					headNode=headNode.next;
				}
			}
		}
	}
	
	public void list() {
	   
	    ArrayList<HTNode<K, V>> temp = elements; 
	    for (HTNode<K, V> headNode : temp) 
        { 
            while (headNode != null) 
            { 
              System.out.println(headNode.value);
                headNode = headNode.next; 
            } 
        } 
	  }
	
public void List_distinct_Names() {
	Set<String> s= new HashSet<>();
	 ArrayList<HTNode<K, V>> temp = elements; 
	  for (HTNode<K, V> headNode : temp) 
      { 
          while (headNode != null) 
          { 
        	  s.add(((Student) headNode.value).getName());
              headNode = headNode.next; 
          } 
      } 
	  for(String  i :  s) {
		  System.out.println(i);
	  }
}
public void name_count() {
    ArrayList<HTNode<K, V>> temp = elements; 
    Map<String, Integer> m = new HashMap<String, Integer>();
   
    for (HTNode<K, V> headNode : temp) 
    { 
        while (headNode != null) 
        { 
        	  Integer a = m.get(((Student)  headNode.value).getName());
        	  m.put(((Student) headNode.value).getName(), (a == null)  ? 1 : a+ 1);   
             headNode = headNode.next; 
        } 
    } 	
    for (Map.Entry<String, Integer> val : m.entrySet()) { 
        System.out.println("Name:  " + val.getKey() + " "
                           + "occurs"
                           + ": " + val.getValue() + " times"); 
    } 
}
}
	
