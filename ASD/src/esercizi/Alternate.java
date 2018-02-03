package esercizi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Alternate {
	
	
	public static void main(String[] args) {
		
		List<Integer> positivi = new ArrayList<>();
		List<Integer> negativi = new ArrayList<>();
		String input = null;
		
		while(true) {
			InputStreamReader is = new InputStreamReader(System.in);
		    BufferedReader br = new BufferedReader(is);
		    
			try {
				input = br.readLine();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			if (input.equals("<END>"))
				break;
			
			int aggiungi = Integer.parseInt(input);
			
			if (aggiungi >= 0)
				positivi.add(aggiungi);
			else
				negativi.add(aggiungi);
			
		}
		
		Collections.sort(positivi);
		Collections.sort(negativi);
		
		List<Integer> finale = new ArrayList<>();
		int neg=0, pos=0;
		boolean alt = false;
		for (int i=0; i<positivi.size()+negativi.size()-1; i++) {

			
			if (alt || neg == negativi.size()-1) {
				
				finale.add(positivi.get(pos));
				pos++;
				alt = false;
			}
			else if (!alt || pos == positivi.size()-1) {
				
				finale.add(negativi.get(neg));
				neg++;
				alt=true;
			}
		}
		
		for (int i=0; i<finale.size(); i++) {
			
			System.out.println(finale.get(i));
		}
		
		
	}

}
