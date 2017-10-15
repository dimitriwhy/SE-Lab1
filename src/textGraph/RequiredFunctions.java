package textGraph;
import java.util.ArrayList;
import java.util.Random;
import textGraph.Graph;

public class RequiredFunctions {
    /*get bridge words comments*/
	public String queryBridgeWords(Graph G, String word1, String word2) {
		ArrayList<Integer> bridgeList = G.getBridges(word1, word2);
		String output;
		if (bridgeList.size() == 0) {
			output = "No bridge words from "+word1+" to "+word2+"!";
		}else {
			output = "The bridge words from "+word1+" to "+word2+" are: ";
			for (int i = 0; i < bridgeList.size(); i++) {
				if  (i != bridgeList.size() - 1)
					output += " " + G.getName(bridgeList.get(i))+",";
				else output += " and "+G.getName(bridgeList.get(i))+".";
			}
		}
		return output;
	}
    /*randomWalk*/
	public String randomWalk(Graph G) {
		Random rand = new Random();
		int u = rand.nextInt(G.n);
		int v;
		String s = G.getName(u);
		int[][] visit = new int[G.n][G.n];
		while (true) {
			boolean flag = false;
			for (v = 0; v < G.n; v++) {
				if (G.queryWeight(u, v) != 0) {
					flag = true;
					break;
				}
			}
			if (!flag)
				break;
			v = rand.nextInt(G.n);
			if (G.queryWeight(u, v) != 0) {
				s += " " + G.getName(v);
				if (visit[u][v] == 1)
					break;
				visit[u][v] = 1;
			}
		}
		return s;
	}
}
