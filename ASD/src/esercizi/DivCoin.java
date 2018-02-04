package esercizi;

import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;

public class DivCoin {
	
	public static int dividiMonete(Vector<Integer> monete) {
		
		int sommaMax=0;
		
		for (int i = 0; i<monete.size(); i++) {
			
			sommaMax+=monete.get(i);
		}
		
		Vector<Integer> somme = new Vector<Integer>();
		
		int sum = 0;
		somme.add(0);
		
		for (int i=0; i<monete.size(); i++) {
			
			int size=somme.size();
			for (int j=0; j<size; j++) {
				
				sum= monete.get(i)+somme.get(j);
				somme.add(sum);
				sum=0;
			}
		}
		
		Collections.sort(somme);
		
		int val = sommaMax/2;
		
		int index=0;
		
		for (int i=0; i<somme.size(); i++) {
			
			if (somme.get(i)>val) {
				index=i;
				break;
			}
		}
		
		int val1=Math.abs(somme.get(index) - (sommaMax-somme.get(index)));
		int val2=Math.abs(somme.get(index-1) - (sommaMax-somme.get(index-1)));
		if (val1 < val2)
			return val1;
		else
			return val2;
		
		
		
		
	}
	
	
	
	public static void main(String[] args) {
		
		int numMonete;
		Vector<Integer> monete = new Vector<>();
		
		Scanner sc = new Scanner(System.in);
		numMonete = sc.nextInt();
		
		for (int i=0; i<numMonete; i++) {
			
			monete.add(sc.nextInt());
		}
		
		System.out.println(DivCoin.dividiMonete(monete));
	}

}
