package algorithmsD21;

import java.util.*;

import homework5.Node;

public class DijkstrasAlgorithm {

	private int distance[];
	private static int sourceNode[];
	private Set<Integer> settled;
	private PriorityQueue<Node> pq;
	private int vertices;
	
	List<List<Node>> adjNodes;
	
	public DijkstrasAlgorithm (int vertices) {
		this.vertices = vertices;
		distance = new int[vertices];
		sourceNode = new int[vertices];
		settled = new HashSet<Integer>();
		pq = new PriorityQueue<Node>(vertices, new Node());
	}
	
	public void dijkAlg(List<List<Node>> adjNodes, int source) {
		this.adjNodes = adjNodes;
		
		for(int i = 0; i < vertices; i++) 
			distance[i] = Integer.MAX_VALUE;
			
		//add source node to pq
		pq.add(new Node(source, 0));
		distance[source] = 0;
		sourceNode[source] = -1;
		//until we've processed every vertex
		while(settled.size() != vertices) {
			int z = pq.remove().node;
			if(!settled.contains(z)) {
				settled.add(z);
				edges(z);
			}
		}
		
	}
	
	//look at all edges of node
	private void edges(int z) {
		int edgeDist = Integer.MIN_VALUE;
		int newDist = Integer.MIN_VALUE;
		
		for(int i = 0; i < adjNodes.get(z).size(); i++) {
			Node v = adjNodes.get(z).get(i);
			
			//for unprocessed nodes
			if(!settled.contains(v.node)) {
				edgeDist = v.dist;
				newDist = distance[z] + edgeDist;
				
				//new distance shorter path?
				if(newDist < distance[v.node]) {
					distance[v.node] = newDist;
					sourceNode[v.node]= z;
				}
				
				//add node to pq
				pq.add(new Node(v.node, distance[v.node]));
			}
		} 
	}
	
	public static ArrayList<Integer> tracePath(int node){
		ArrayList<Integer> path = new ArrayList<Integer>();
		while(node != -1) {
			path.add(node);
			node = sourceNode[node];
		}
		Collections.reverse(path);
		
		return path;
	}
	public static void main(String[] args) {
		int vertices = 10;
		int src = 0;
		
		
		//make adjacency list for connected edges
		List<List<Node>> adjNodes = new ArrayList<List<Node>>();
		
		for(int i = 0; i < vertices; i++) {
			List<Node> item = new ArrayList<Node>();
			adjNodes.add(item);
		}
		
		adjNodes.get(0).add(new Node(1, 50)); //node 0 = node A... A to J
		adjNodes.get(0).add(new Node(3, 9)); //A to R
		adjNodes.get(0).add(new Node(2, 7)); //A to M
		
		adjNodes.get(1).add(new Node(2, 30)); //node 1 = node J... J to M
		adjNodes.get(1).add(new Node(4, 2)); //J to K
		adjNodes.get(1).add(new Node(6, 98)); // J to I
		adjNodes.get(1).add(new Node(0, 50)); // J to A

		adjNodes.get(2).add(new Node(3, 6)); //node 2 = node M... M to R
		adjNodes.get(2).add(new Node(5, 15)); // M to S
		adjNodes.get(2).add(new Node(4, 27)); //M to K
		adjNodes.get(2).add(new Node(1, 30)); // M to J
		adjNodes.get(2).add(new Node(0, 7)); // M to A
		
		adjNodes.get(3).add(new Node(5, 10));//node 3 = node R... R to S
		adjNodes.get(3).add(new Node(8, 3));// R to T
		adjNodes.get(3).add(new Node(2, 6)); // R to M
		adjNodes.get(3).add(new Node(0, 9)); // R to A
		
		adjNodes.get(4).add(new Node(6, 120)); //node 4 = node K... K to I
		adjNodes.get(4).add(new Node(7, 105));// K to N
		adjNodes.get(4).add(new Node(5, 11));//K to S
		adjNodes.get(4).add(new Node(1, 2)); // K to J
		adjNodes.get(4).add(new Node(2, 27)); // K to M
		
		adjNodes.get(5).add(new Node(7, 119));//node 5 = node S... S to N
		adjNodes.get(5).add(new Node(8, 4)); //S to T
		adjNodes.get(5).add(new Node(2, 15)); // S to M
		adjNodes.get(5).add(new Node(3, 10)); // S to R
		adjNodes.get(5).add(new Node(4, 11)); // S to K
		
		adjNodes.get(6).add(new Node(9, 66)); //node 6 = node I... I to D
		adjNodes.get(6).add(new Node(7, 5)); //I to N
		adjNodes.get(6).add(new Node(1, 98)); // I to J
		adjNodes.get(6).add(new Node(4, 120)); // I to K
		
		adjNodes.get(7).add(new Node(8, 122)); //node 7 = node N... N to T
		adjNodes.get(7).add(new Node(9, 62)); //N to D
		adjNodes.get(7).add(new Node(4, 105)); // N to K
		adjNodes.get(7).add(new Node(5, 119)); // N to S
		adjNodes.get(7).add(new Node(6, 5)); // N to I
		
		adjNodes.get(8).add(new Node(9, 190));//node 8 = node T... T to D
		adjNodes.get(8).add(new Node(3, 3)); // T to R
		adjNodes.get(8).add(new Node(5, 4)); // T to S
		adjNodes.get(8).add(new Node(7, 122)); // T to N
		
		adjNodes.get(9).add(new Node(6, 66)); // node 9 = node D... D to I
		adjNodes.get(9).add(new Node(7, 62)); // D to N
		adjNodes.get(9).add(new Node(8, 190)); // D to T
		
		//find shortest path
		DijkstrasAlgorithm da = new DijkstrasAlgorithm(vertices);
		da.dijkAlg(adjNodes, src);
		
		System.out.println("The shortest path from node :");
		for(int i = 0; i < da.distance.length; i++) {
			System.out.println(src + " to " + i + " is " + da.distance[i]);
			System.out.println("The shortest path is : " + tracePath(i));
		}
		
		
	}

}
