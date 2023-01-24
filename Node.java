package homework5;

import java.util.Comparator;

public class Node implements Comparator<Node>{

	//create class for nodes,  with the distance from the source to the adjacent nodes
	
	public int node;
	public int dist = Integer.MAX_VALUE;
	
	public Node(int node, int dist) {
		this.node = node;
		this.dist = dist;
	}

	public Node() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int compare(Node n1, Node n2) {
		if(n1.dist < n2.dist) {
			return -1;
		}
		if(n1.dist > n2.dist) {
			return 1;
		}
		return 0;
	}
	
}
