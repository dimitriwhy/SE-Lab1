package textGraph;
import java.util.*;
public class Graph {
	/** n is the number of nodes in the graph */
	public int n;
	/** map is the adjacent matrix for graph */
	int [][] map;
	/** names is the word for a specific node */
	String[] names;
	/** nameMap is the map between words to indexes */
	Map<String, Integer> nameMap = new HashMap<String, Integer>();
	/**
	 * @param input_n number of nodes in the graph
	 */
	public Graph(int input_n) {
		n = input_n;
		map = new int[n][n];
		names = new String[n];
	}
	/**
	 * naming a node of index u a specific string s.
	 * @param u the index of node in the graph
	 * @param s the name for the index
	 */
	public void namingNode(int u, String s) {
		//
		names[u] = s;
		nameMap.put(s, u);
	}
	/**
	 * add weight d to arc (u,v)
	 * @param u head of the arc
	 * @param v tail of the arc
	 * @param d weight added to the graph
	 */
	public void addEdge(int u, int v, int d) {
		map[u][v] += d;
	}
	/**
	 * give the weight of arc (u,v). 0 means there's no such arc.
	 * @param u head of the arc
	 * @param v tail of the arc
	 * @return weight of the arc
	 */
	public int queryWeight(int u, int v) {
		return map[u][v];
	}
	/**
	 * return the index of word s.
	 * @param s word
	 * @return index of word s
	 */
	public int getIndex(String s) {
		return nameMap.get(s);
	}
	/**
	 * return the name of index u
	 * @param u index
	 * @return word of index u
	 */
	public String getName(int u) {
		return names[u];
	}
	/**
	 * get a list of indexes of bridge words from word1 to word2.
	 * @param word1 word1
	 * @param word2 word2
	 * @return a list of indexes of bridge words from word1 to word2
	 */
	public List<Integer> getBridges(String word1, String word2){
		int u = getIndex(word1), v = getIndex(word2);
		List<Integer> bridgeList = new ArrayList<Integer>();
		for (int x = 0; x < n; x++) {
			if (x != u && x != v) {
				if (queryWeight(u, x) > 0 && queryWeight(x, v) > 0) {
					bridgeList.add(x);
				}
			}
		}
		return bridgeList;
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
}
