package textGraph;
import textGraph.Graph;
import java.util.*;
public class TextGraph {
	Graph createDirectedGraph(String filename) {
		
	}
	String queryBridgeWords(Graph G, String word1, String word2) {
		List<Integer> bridgeList = G.getBridges(word1, word2);
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
	public static void main(String[] args) {
		
	}
}
