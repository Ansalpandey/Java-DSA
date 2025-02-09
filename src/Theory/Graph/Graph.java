package Theory.Graph;

import java.util.ArrayList;

public class Graph {
	public Graph() {
	}

	public static class Edge {
		int src;
		int dest;
		int weight;

		public Edge(int src, int dest, int weight) {
			this.src = src;
			this.dest = dest;
			this.weight = weight;
		}
	}

	public void createGraph(ArrayList<Edge>[] graph) {
		for (int i = 0; i < graph.length; i++) {
			graph[i] = new ArrayList<Edge>();
		}
		graph[0].add(new Edge(0, 2, 10));

		graph[1].add(new Edge(1, 2, 13));
		graph[1].add(new Edge(1, 3, 45));

		graph[2].add(new Edge(2, 0, 76));
		graph[2].add(new Edge(2, 1, 21));
		graph[2].add(new Edge(2, 3, 22));

		graph[3].add(new Edge(3, 1, 34));
		graph[3].add(new Edge(3, 2, 56));
	}
}
