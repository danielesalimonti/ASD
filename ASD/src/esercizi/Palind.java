package esercizi;

import java.util.Scanner;
import java.util.Vector;

public class Palind {
	
	
	public int numPal(Vector<Character> c, int i, int f) {
		
		
		if (c.size()==0)
			return 0;
		
		if (i==f) {
			return 1;
		}
		
		if (i+1==f && c.get(i)==c.get(f))
			return 2;
		
		if (c.get(i) == c.get(f)) {
			
			return 2 + numPal(c, i+1, f-1);
		}
		
		int num1 = numPal(c, i, f-1);
		int num2 = numPal(c, i+1, f);
		
		
		if (num1>num2)
			return num1;
		else
			return num2;
			
		
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		
		char [] tmp = s.toCharArray();
		
		Vector<Character> c = new Vector<>();
		
		for (int i=0; i<tmp.length; i++) {
			
			c.add(tmp[i]);
		}
		Palind p = new Palind();
		System.out.println(p.numPal(c, 0, c.size()-1));
	}
	
}
