package textGraph;
import javax.swing.*;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.Random;
import textGraph.GraphViz;
public class features implements ActionListener {
	
	String[] colors = {"aliceblue", "antiquewhite","aqua","aquamarine","azure",
			"beige","bisque","black","blanchedalmond","blue",
			"blueviolet","brown","burlywood","cadetblue","chartreuse",
			"chocolate","coral","cornflowerblue","cornsilk","crimson",
			"cyan ","darkblue","darkcyan","darkgoldenrod","darkgray",
			"darkgreen","darkgrey","darkkhaki","darkmagenta","darkolivegreen",
			"darkorange","darkorchid","darkred","darksalmon","darkseagreen",
			"darkslateblue","darkslategray","darkslategrey","darkturquoise","darkviolet",
			"deeppink","deepskyblue","dimgray","dimgrey","dodgerblue",
			"firebrick","forestgreen","fuchsia","gainsboro","gold","goldenrod","gray","grey",
			"green","greenyellow","honeydew","hotpink","indianred",
			"indigo","ivory","khaki","lavender","lavenderblush",
			"lawngreen","lemonchiffon","lightblue","lightcoral","lightcyan",
			"lightgoldenrodyellow","lightgray","lightgreen","lightgrey","lightpink",
			"lightsalmon","lightseagreen","lightskyblue","lightslategray","lightslategrey",
			"lightsteelblue","lightyellow","lime","limegreen","linen",
			"magenta","maroon","mediumaquamarine","mediumblue","mediumorchid",
			"mediumpurple","mediumseagreen","mediumslateblue","mediumspringgreen","mediumturquoise",
			"mediumvioletred","midnightblue","mistyrose","moccasin",
			"navajowhite","navy","oldlace","olive","olivedrab",
			"orange	orangered","orchid","palegoldenrod","palegreen",
			"paleturquoise","palevioletred","papayawhip","peachpuff","peru", 
			"pink","plum","powderblue","purple","red",
			"rosybrown","royalblue","saddlebrown","salmon","sandybrown",
			"seagreen","seashell","sienna","silver","skyblue",
			"slateblue","slategray","slategrey","springgreen",
			"steelblue","tan","teal","thistle","tomato",
			"turquoise","violet","wheat","yellow","yellowgreen"};
	
  public void actionPerformed(ActionEvent event) {
    if (event.getSource().equals(mediumWindow.buttonShowDirectedGraph)) {
    		if(mediumWindow.pictureName.getText().isEmpty()) {
    			JOptionPane.showMessageDialog(null, "Please enter a picture name!");
    		}
    		else {
    			String d = mediumWindow.targetPath;
    			String n = mediumWindow.pictureName.getText();
    			String t = (String)mediumWindow.fileTypeChooser.getSelectedItem();
    			String allName = d + "/" + n + "." + t;
    			File check = new File(allName);
    			if(check.exists()) {
    				JOptionPane.showMessageDialog(null, allName + " has already existed!");
    			}
    			else {
    				ShowDirectedGraph(mediumWindow.graph);
    			}
    		}
    } 
    else if (event.getSource().equals(mediumWindow.buttonQueryBridgeWords)) {
    		inWords readWords = new inWords();
    		readWords.minimumWindow.setVisible(true);
    }
    else if (event.getSource().equals(mediumWindow.buttonGenerateNewText)) {
    		newText newTextGenerated = new newText();
    		newTextGenerated.minimumWindow.setVisible(true);
    }
    else if (event.getSource().equals(mediumWindow.buttonCalcShortestPath)) {
    		shortestPath pathEnds = new shortestPath(mediumWindow.graph);
    		pathEnds.minimumWindow.setVisible(true);
    	
    }
    else if (event.getSource().equals(mediumWindow.buttonRandomWalk)) {
    		String SS = "sdfdfvds";
    		walkText randomWalkText = new walkText(SS);
    		randomWalkText.minimumWindow.setVisible(true);
    }
  }
  private class inWords extends JFrame{
	  private static final long serialVersionUID = 1L;
	  public JFrame minimumWindow;
	  public JLabel label;
	  public JTextField leftWord;
	  public JTextField rightWord;
	  public JButton query;
	  public inWords() {
		  minimumWindow = new JFrame();
		  minimumWindow.setLocation(400, 10);
		  minimumWindow.setSize(400, 200);
		  minimumWindow.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		  minimumWindow.getContentPane().setLayout(null);
		  
		  label = new JLabel("Please enter two words:");
		  label.setBounds(50, 50, 300, 20);
		  minimumWindow.getContentPane().add(label);
		  
		  leftWord = new JTextField();
		  leftWord.setBounds(50, 80, 140, 20);
		  minimumWindow.getContentPane().add(leftWord);
		  
		  rightWord = new JTextField();
		  rightWord.setBounds(210, 80, 140, 20);
		  minimumWindow.getContentPane().add(rightWord);
		  
		  query = new JButton("Query");
		  query.setBounds(100, 110, 200, 40);
		  query.addActionListener(new queryWord());
		  minimumWindow.getContentPane().add(query);
	  }
	  private class queryWord implements ActionListener{
		  public void actionPerformed(ActionEvent event) {
			  if(leftWord.getText().isEmpty() || rightWord.getText().isEmpty()) {
				  JOptionPane.showMessageDialog(null, "Please enter the two words!");
			  }
			  else {
				  String lWord = leftWord.getText();
				  String rWord = rightWord.getText();
				  String result = queryBridgeWords(mediumWindow.graph, lWord, rWord);
				  JOptionPane.showMessageDialog(null, result);
			  }
		  }
	  }
  }
  
  private class newText extends JFrame{
	  private static final long serialVersionUID = 1L;
	  public JFrame minimumWindow;
	  public JTextArea inText;
	  public JTextArea outText;
	  public JScrollPane jspin;
	  public JScrollPane jspout;
	  public JButton write;
	  public newText() {
		  minimumWindow = new JFrame();
		  minimumWindow.setLocation(800, 10);
		  minimumWindow.setSize(900, 600);
		  minimumWindow.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		  minimumWindow.getContentPane().setLayout(null);
		  
		  inText = new JTextArea();
		  inText.setSize(400, 530);
		  inText.setLineWrap(true);
		  inText.setEditable(true);
		  inText.setWrapStyleWord(true);
		  
		  jspin = new JScrollPane(inText);
		  jspin.setBounds(30, 0, 400, 530);
		  minimumWindow.getContentPane().add(jspin);
		  
		  outText = new JTextArea();
		  outText.setSize(400, 530);
		  outText.setLineWrap(true);
		  outText.setEditable(false);
		  outText.setWrapStyleWord(true);
		  
		  jspout = new JScrollPane(outText);
		  jspout.setBounds(470, 0, 400, 530);
		  minimumWindow.getContentPane().add(jspout);
		  
		  write = new JButton("GenerateNewText");
		  write.setBounds(230, 540, 200, 25);
		  write.addActionListener(new writeText());
		  minimumWindow.getContentPane().add(write);
	  }
	  private class writeText implements ActionListener{
		  public void actionPerformed(ActionEvent event) {
			  if(inText.getText().isEmpty()) {
				  JOptionPane.showMessageDialog(null, "Please enter the text!");
			  }
			  else {
				  String lText = inText.getText();
				  String rText = lText;
				  outText.setText(rText);
			  }
		  }
	  }
  }
  
  private class shortestPath extends JFrame{
	  private static final long serialVersionUID = 1L;
	  public JFrame minimumWindow;
	  public JLabel label;
	  public JTextField leftWord;
	  public JTextField rightWord;
	  public JButton query;
	  public Graph g;
	  public shortestPath(Graph graph) {
		  g = graph;
		  minimumWindow = new JFrame();
		  minimumWindow.setLocation(400, 10);
		  minimumWindow.setSize(400, 200);
		  minimumWindow.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		  minimumWindow.getContentPane().setLayout(null);
		  
		  label = new JLabel("Please enter two words:");
		  label.setBounds(50, 50, 300, 20);
		  minimumWindow.getContentPane().add(label);
		  
		  leftWord = new JTextField();
		  leftWord.setBounds(50, 80, 140, 20);
		  minimumWindow.getContentPane().add(leftWord);
		  
		  rightWord = new JTextField();
		  rightWord.setBounds(210, 80, 140, 20);
		  minimumWindow.getContentPane().add(rightWord);
		  
		  query = new JButton("CalcShortestPath");
		  query.setBounds(100, 110, 200, 40);
		  query.addActionListener(new queryWord());
		  minimumWindow.getContentPane().add(query);
	  }
	  private class queryWord implements ActionListener{
		  public void actionPerformed(ActionEvent event) {
			  if(leftWord.getText().isEmpty()) {
				  JOptionPane.showMessageDialog(null, "You must enter the name of the starting node!");
			  }
			  else {
				  if(rightWord.getText().isEmpty()) {
					  String startnode = leftWord.getText();
					  String dir = mediumWindow.targetPath;
					  String name = mediumWindow.pictureName.getText();
					  String type = (String)mediumWindow.fileTypeChooser.getSelectedItem();
					  String fullName = dir + "/" + name + "-" + startnode + "-" + "ShortestPath." + type;
					  File out = new File(fullName);
					  if(out.exists()) {
						  JOptionPane.showMessageDialog(null, fullName + " has already existed! Please change that file's name.");
					  }
					  else {
						  if(g.getIndex(startnode) == -1 ) {
							  JOptionPane.showMessageDialog(null, startnode + " is not in the graph!");
						  }
						  else {
							  GraphViz gv = new GraphViz();
							  gv.setdir(dir);
							  gv.addln(gv.start_graph());
							  String line;
							  for(int j = 0; j < g.n; ++j) {
								  int i = g.getIndex(startnode);
								  if(j != i) {
									  ArrayList<Integer> result = g.getShortestPath(i, j);
									  System.out.println(result);
									  if(result.get(result.size() - 1) != -1) {
										  for(int k = 1; k < result.size(); ++i) {
											  System.out.println(g.getName(result.get(k)));
											  System.out.println("\n");
											  line = "";
											  line += startnode;
											  line += " -> ";
											  line += g.getName(result.get(k));
											  line += " [ label = \"";
											  line += Integer.toString(g.queryWeight(i, result.get(k)));
											  line += "\", color = \"";
											  line += colors[j];
											  line += "\" ];";
											  gv.addln(line);
										  }
									  }
								  }
							  }
							  gv.addln(gv.end_graph());
							  gv.writeGraphToFile( gv.getGraph( gv.getDotSource(), type ), out );
						  }
					  }
				  }
				  else {
					  String startnode = leftWord.getText();
					  String endnode = rightWord.getText();
					  String dir = mediumWindow.targetPath;
					  String name = mediumWindow.pictureName.getText();
					  String type = (String)mediumWindow.fileTypeChooser.getSelectedItem();
					  String fullName = dir + "/" + name + "-" + startnode + "-" + endnode + "-" + "ShortestPath." + type;
					  File out = new File(fullName);
					  if(out.exists()) {
						  JOptionPane.showMessageDialog(null, fullName + " has already existed! Please change that file's name.");
					  }
					  else {
						  
					  }
				  }
			  }
		  }
	  }
  }
  
  private class walkText extends JFrame{
	  private static final long serialVersionUID = 1L;
	  public JFrame minimumWindow;
	  public JTextArea wText;
	  public JScrollPane jsp;
	  public walkText(String S) {
		  minimumWindow = new JFrame();
		  minimumWindow.setLocation(1000, 10);
		  minimumWindow.setSize(800, 400);
		  minimumWindow.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		  minimumWindow.getContentPane().setLayout(null);
		  
		  wText = new JTextArea(60, 30);
		  wText.setSize(800, 400);
		  wText.setLineWrap(true);
		  wText.setEditable(false);
		  wText.setWrapStyleWord(true);
		  wText.setText(S);
		  
		  jsp = new JScrollPane(wText);
		  jsp.setBounds(0, 0, 800, 400);
		  minimumWindow.getContentPane().add(jsp);
	  }
  }
  
  void showShortestPathGraph(Graph g, String s, File picture) {
	  
  }

  void ShowDirectedGraph(Graph g) {
	  String dir = mediumWindow.targetPath;
	  String name = mediumWindow.pictureName.getText();
	  String type = (String)mediumWindow.fileTypeChooser.getSelectedItem();
	  String fullName = dir + "/" + name + "." + type;
	  GraphViz gv = new GraphViz();
	  gv.setdir(dir);
	  gv.addln(gv.start_graph());
	  String line = "";
	  for(int i = 0; i < g.n; ++i) {
		  line = "";
		  line += g.getName(i);
		  line += ";";
		  gv.addln(line);
	  }
	  gv.addln();
	  for(int i = 0; i < g.n; ++i) {
		  for(int j = 0; j < g.n; ++j) {
			  if(g.queryWeight(i, j) > 0) {
				  line = "";
				  line += g.getName(i);
				  line += " -> ";
				  line += g.getName(j);
				  line += " [ label = \"";
				  line += Integer.toString(g.queryWeight(i, j));
				  line += "\" ];";
				  gv.addln(line);
			  }
		  }
	  }
	  gv.addln(gv.end_graph());
	  File out = new File(fullName);
	  gv.writeGraphToFile( gv.getGraph( gv.getDotSource(), type ), out );
	  if(type == "jpg" || type == "png" || type == "gif") {
		  JFrame showPicture = new JFrame(name + "." + type);
		  showPicture.setVisible(true);
		  showPicture.setSize(600, 800);
		  showPicture.setLocation(1000, 10);
		  showPicture.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		  JLabel label = new JLabel();
		  label.setSize(570, 770);
		  showPicture.getContentPane().add(label);
		  ImageIcon icon = new ImageIcon(fullName);
	  
		  int imgWidth = icon.getIconWidth();  
		  int imgHeight = icon.getIconHeight();  
		  int conWidth = label.getWidth(); 
		  int conHeight = label.getHeight();
		  int reImgWidth;  
		  int reImgHeight;  
		  if (((double)imgWidth / imgHeight) > ((double)conWidth / conHeight)) {
			  reImgWidth = conWidth;  
			  reImgHeight = imgHeight * conWidth / imgWidth;
		  }
		  else { 
			  reImgHeight = conHeight;  
			  reImgWidth = imgWidth * conHeight / imgHeight;
		  }  
		  Image img = icon.getImage();  
		  img = img.getScaledInstance(reImgWidth, reImgHeight, Image.SCALE_DEFAULT);  
		  icon.setImage(img); 
		  label.setIcon(icon);
		  label.setHorizontalAlignment(SwingConstants.CENTER);
	  }
	  else {
		  JOptionPane.showMessageDialog(null, fullName + " has been saved to the choosen path.But it can not been shown in this window.");
	  }
  }
  
  public String queryBridgeWords(Graph G, String word1, String word2) {
	  ArrayList<Integer> bridgeList = G.getBridges(word1, word2);
	  String output;
	  if (bridgeList.size() == 0) {
		  output = "No bridge words from "+word1+" to "+word2+"!";
	  }else if(bridgeList.size() == 1){
		  output = "The bridge words from "+word1+" to "+word2+" is: " + G.getName(bridgeList.get(0));
	  }
	  else{
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