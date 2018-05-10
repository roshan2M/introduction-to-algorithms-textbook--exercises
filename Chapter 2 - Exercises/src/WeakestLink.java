import java.io.*;
import java.util.ArrayList;

public class WeakestLink {
	
	public static void main(String[] args) throws IOException {
		
		ArrayList<Edge> graph = new ArrayList<Edge>();
		File file = new File("D:\\University\\links.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));
		
		String st;
		String[] a;
		while ((st = br.readLine()) != null) {
			a = st.replaceAll(" ", "").split(",");
			graph.add(new Edge(a[1], a[2], Integer.parseInt(a[0])));
		}
		
		// Probability of clicking on a weakest link
		double p = getEliminated(graph, "start.html", 1);
		System.out.format("Probability of clicking on weakest link: %.4f\n", p);
		
		// Expect number out of 16.2 million to reach finish
		int correct = (int) (16200000.0 * (1 - p));
		System.out.println("Expected number of users to reach finish: " + correct + "\n");
		
	}
	
	public static double getEliminated(ArrayList<Edge> graph, String node, double probability) {
		// Get all links from page
		ArrayList<Edge> edges = new ArrayList<Edge>();
		for (Edge e : graph) {
			if (e.from.equals(node)) edges.add(e);
		}
		
		// Get worst link on the page
		int sumWeights = 0;
		int worstLink = 0; // first link
		int worstLinkWeight = edges.get(0).weight;
		for (int i = 0; i < edges.size(); i++) {
			sumWeights += edges.get(i).weight;
			if (edges.get(i).weight < worstLinkWeight) {
				worstLinkWeight = edges.get(i).weight;
				worstLink = i;
			}
		}
		
		// Find probability of clicking on worst link
		double totalProbability = probability * ((double) worstLinkWeight / sumWeights);
		for (int i = 0; i < edges.size(); i++) {
			if (edges.get(i).to.equals("finish.html") || i == worstLink) continue;
			totalProbability += getEliminated(graph, edges.get(i).to, probability * ((double) edges.get(i).weight / sumWeights));
		}
		return totalProbability;
	}

}

class Edge {
	String from;
	String to;
	int weight;
	Edge(String from, String to, int weight) {
		this.from = from;
		this.to = to;
		this.weight = weight;
	}
}
