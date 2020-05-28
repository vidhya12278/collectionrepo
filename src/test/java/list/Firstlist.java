package list;

import java.util.ArrayList;
import java.util.List;

public class Firstlist {
public static void main(String[] args) {
	List<Integer> l=new ArrayList<Integer>();
	
	l.add(10);
	l.add(30);
	l.add(60);
	
	System.out.println("all list values : " + l);
	
	int s = l.size();
	System.out.println("list size: " + s);
	
	Integer u = l.remove(2);
	System.out.println(" remove value : " + u);
	
	Integer o = l.set(4, 67);
	System.out.println("set  value : " + o);
	
	



}
}
