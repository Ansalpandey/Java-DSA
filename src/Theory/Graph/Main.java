package Theory.Graph;

import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		int v = 4;
		Graph graph = new Graph();
		ArrayList<Graph.Edge>[] graphArr = new ArrayList[v];
		graph.createGraph(graphArr);
		for (int i = 0; i < graphArr[1].size(); i++) {
			Graph.Edge e = graphArr[1].get(i);
			String ans = e.dest + " " + e.weight;
			System.out.println(ans);
		}
	}
}
