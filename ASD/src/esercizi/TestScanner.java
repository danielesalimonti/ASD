package esercizi;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class TestScanner {
	
	public static void main(String[] args) {
		
		File file = new File("C:/Users/Daniele/Desktop/text.txt");
		Scanner sc;
		try {
			sc = new Scanner(file);
		
			String i;
			
			List<String> out = new LinkedList<>();
			
			while(sc.hasNextLine()) {
				i=sc.nextLine();
				System.out.println(i);
				StringTokenizer s = new StringTokenizer(i, ", ()");
				while(s.hasMoreTokens()) {
					String dato = s.nextToken();
					if (dato.equals("-1"))
						System.out.println("fine");
					else
						out.add(dato);
					
					
				}
				
				
				
			}
			for (String st : out) {
				
				System.out.println(st);
			}
			sc.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}

}
