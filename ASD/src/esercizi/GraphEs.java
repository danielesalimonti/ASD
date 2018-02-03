package esercizi;

import java.util.Iterator;
import java.util.Set;

import org.jgraph.graph.DefaultEdge;
import org.jgrapht.Graph;
import org.jgrapht.alg.cycle.HawickJamesSimpleCycles;
import org.jgrapht.graph.ClassBasedEdgeFactory;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DirectedAcyclicGraph;
import org.jgrapht.graph.SimpleDirectedGraph;
import org.jgrapht.traverse.DepthFirstIterator;

public class GraphEs {
	
	
	
	public static void main(String[] args) {
		
		Graph<Integer, DefaultEdge> grafo = new SimpleDirectedGraph<Integer,DefaultEdge>(DefaultEdge.class);
		
		grafo.addVertex(1);
		grafo.addVertex(2);
		grafo.addVertex(3);
		grafo.addVertex(4);
		grafo.addEdge(1, 2);
		grafo.addEdge(2, 3);
		grafo.addEdge(3, 4);
		grafo.addEdge(4, 1);
		
		HawickJamesSimpleCycles find = new HawickJamesSimpleCycles(grafo);
		
		System.out.println(find.findSimpleCycles().toString());
		
		grafo.removeEdge(3, 1);
		
	}

}
