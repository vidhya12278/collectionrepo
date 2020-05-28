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
	
	Integer p = l.get(30);
	System.out.println("get the index value: " + p);
	
	



}
}
