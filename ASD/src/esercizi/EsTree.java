package esercizi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

import tree.Node;
import tree.TraversalStrategy;
import tree.Tree;

public class EsTree {
	
	public static void main(String[] args) {
		
		Tree tree = new Tree();
		String input = null;
		boolean primo = true;
		String padre = null, figlio = null, root=null;
		int in = 1;
		
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
				
				if (primo) {
					root = t.nextToken();
					primo = false;
					tree.addNode(root);
					break;
				}
				else {
					if (in == 1) {
						figlio = t.nextToken();
						in++;
					}
					else if (in == 2) {
						padre = t.nextToken();
						tree.addNode(figlio, padre);
						//System.out.println("figlio: "+figlio+" padre: "+padre);
						in--;
					}
				}
				
			}
		}
		
		List<Supporto> out = new ArrayList<>();
		int somma=0;		
		Iterator<Node> breadthIterator = tree.iterator(root, TraversalStrategy.BREADTH_FIRST);

        while (breadthIterator.hasNext()) {
            Node node = breadthIterator.next();
            boolean first = true;
            Iterator<Node> breadthIterator2 = tree.iterator(node.getIdentifier(), TraversalStrategy.BREADTH_FIRST);
            
            while (breadthIterator2.hasNext()) {
            	
          
            	somma += Integer.parseInt(breadthIterator2.next().getIdentifier());
            	
            }
            
            Supporto s = new Supporto();
            
            s.node=node.getIdentifier();
            s.sum=somma-Integer.parseInt(node.getIdentifier());
            somma = 0;
            
            out.add(s);
            
        }
        
        for (int i=0; i<out.size(); i++) {
        	
        	System.out.println(out.get(i).node+" -> "+out.get(i).sum);
        }

	}
	

}

class Supporto{
	
	String node;
	int sum;
}
