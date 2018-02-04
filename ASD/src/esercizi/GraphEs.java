package esercizi;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import java.util.List;
import java.util.Scanner;

import org.jgraph.graph.DefaultEdge;
import org.jgrapht.Graph;
import org.jgrapht.alg.cycle.HawickJamesSimpleCycles;
import org.jgrapht.alg.cycle.HierholzerEulerianCycle;
import org.jgrapht.alg.cycle.JohnsonSimpleCycles;
import org.jgrapht.graph.ClassBasedEdgeFactory;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DirectedAcyclicGraph;
import org.jgrapht.graph.SimpleDirectedGraph;
import org.jgrapht.traverse.DepthFirstIterator;

public class GraphEs {
	
	
	
	public static void main(String[] args) {
		
		Graph<Integer, DefaultEdge> grafo = new SimpleDirectedGraph<Integer,DefaultEdge>(DefaultEdge.class);
		
		Scanner sc = new Scanner(System.in);
		int v = sc.nextInt();
		int k = sc.nextInt();
		for (int i=1; i<=v; i++) {
			
			grafo.addVertex(i);
		}

		
		while(true) {
			
			int e1 = sc.nextInt();
			int e2 = sc.nextInt();
			
			if (e1 == -1 || e2 == -1)
				break;
			
			grafo.addEdge(e1, e2);
			
			
		}
			
			
		//System.out.println(grafo);
		
		JohnsonSimpleCycles find = new JohnsonSimpleCycles(grafo);
		
		List< List<Integer> > cicli =find.findSimpleCycles();
		int cont = 0;
		boolean ok=false;
		List<DefaultEdge> edge = new LinkedList<>();
		
		for (List<Integer> l : cicli) {
			
			Collections.reverse(l);
		}
		
		for (List<Integer> l : cicli) {
			
			boolean rimosso=false;
			for (int i=0; i<l.size()-1; i++) {
				
				boolean remove = false;
				int v1 = l.get(i);
				int v2 = l.get(i+1);
				
				for (List<Integer> l1 : cicli) {
					
					if (l1.equals(l))
						continue;
					
					for (int j=0; j< l1.size()-1; j++) {
						
						if (v1 == l1.get(j) && v2 == l1.get(j+1)) {
							remove = true;
							break;
						}
					}

				}
				
				if (remove) {
					rimosso = true;
					grafo.removeEdge(v1, v2);
					cont++;
				}
			}
			
			if (!rimosso) {
				
				grafo.removeEdge(l.get(0), l.get(1));
				cont++;
			}
			
			if (find.findSimpleCycles().isEmpty()) {
				
				ok=true;
				break;
			}
			
			if (cont == k)
				break;
		}
		
		if (ok) {
			
			System.out.println("SI");
		}
		else
			System.out.println("NO");
		
	}

}
