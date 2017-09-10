package textGraph;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import javax.swing.JOptionPane;
import java.util.*;
import textGraph.Graph;
public class allFunction implements ActionListener {
	public void actionPerformed(ActionEvent event) {
		/**
		 * when the text field is empty
		 */
		if(window.fileLocation.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Please choose a file!");
		}
		/**
		 * when the text field is not empty
		 */
		else {
			String filePath = window.fileLocation.getText();
			File file = new File(filePath);
			/**
			 * when we can get a text file using the provided path
			 */
			if(file.exists()) {
				/**
				 * allWordsNumber is total number of the words appeared in the text, including repeated ones.
				 * finalWordsNumber is the number of distinct words in the text.
				 * words is a structure to store the text content.
				 * set is a set to store these distinct words.
				 */
				int allWordsNumber = 0, finalWordsNumber;
				String[] words = new String[200000];
				Set<String> set = new HashSet<String>();
				try {
					/**
					 * word is the temporary word we have got by reading the file by character.
					 */
					FileReader fr = new FileReader(file);
					int ch;
					String word = null;
					while((ch = fr.read()) != -1) {
						/**
						 * when the character is uppercase，transform it into lowercase
						 * and add it to the end of word
						 */
						if(ch >= 65 && ch <= 90) {
							ch += 32;
							word += (char)ch;
						}
						/**
						 * when the charactrer is lowercase, just add it to the end of word
						 */
						else if(ch >= 97 && ch <= 122){
							word += (char)ch;
						}
						/**
						 * When the character is not in A-Z or a-z, a single word has been gotten.
						 * Then add it to words and set.
						 */
						else {
							if(word != null) {
								set.add(word);
								words[allWordsNumber] = word;
								allWordsNumber ++;
								word = null;
							}
							else {
								continue;
							}
						}
					}
					fr.close();
				}catch(Exception e1) {
					JOptionPane.showMessageDialog(null, "Unkonwn Errors！");
				}
				/**
				 * Create a graph
				 */
				finalWordsNumber = set.size();
				Graph originGraph = new Graph(finalWordsNumber);
				int iterator = 0;
				/**
				 * name every distinct word in the graph with a unique index.
				 */
				for(String name : set) {
					originGraph.namingNode(iterator, name);
					iterator ++;
				}
				/**
				 * record the adjacency between two words using their corresponding index.
				 */
				int x = originGraph.getIndex(words[0]), y;
				for(int i = 1; i < allWordsNumber; ++i) {
					y = originGraph.getIndex(words[i]);
					originGraph.addEdge(x,  y,  1);
					x = y;
				}
				
				
			}
			/**
			 * when we can not get a text file using the provided path
			 */
			else {
				JOptionPane.showMessageDialog(null, "No such file or directory!");
			}
		}
	}

}
