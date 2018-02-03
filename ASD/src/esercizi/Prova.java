package esercizi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Prova {
	
	public static void main(String[] args) {
		
		String input = null;
		
		while(true) {
			InputStreamReader is = new InputStreamReader(System.in);
		    BufferedReader br = new BufferedReader(is);
		    
			try {
				input = br.readLine();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			if (input.equals("-1"))
				break;
			
			StringTokenizer t = new StringTokenizer(input, ",.;- \n");
			
			while (t.hasMoreTokens()) {
				
				System.out.println(t.nextToken());
			}
			
			
		}
	}

}
