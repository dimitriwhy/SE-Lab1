package textGraph;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import textGraph.Graph;
import textGraph.features;
class mediumWindow{
	public static Graph graph;
	public static String targetPath;
	public JFrame mediumFrame;
	public JLabel label1;
	public static JComboBox<String> fileTypeChooser;
	public static JButton buttonShowDirectedGraph;
	public static JButton buttonQueryBridgeWords;
	public static JButton buttonGenerateNewText;
	public static JButton buttonCalcShortestPath;
	public static JButton buttonRandomWalk;
	String[] types = {"*", "jpg", "png", "gif", "bmp", "tiff", "ico", "svg", "pdf"};
	public mediumWindow(Graph gottenGraph, String path) {
		graph = gottenGraph;
		targetPath = path;
		initialize();
	}
	/**
	 * initialize the contents of the frame;
	 */
	private void initialize() {
		mediumFrame = new JFrame("Textfile-Graph Convertor");
		Container container = mediumFrame.getContentPane();
		mediumFrame.setSize(800, 450);
		mediumFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		mediumFrame.setLocation(100, 50);
		mediumFrame.setResizable(false);
		container.setLayout(null);
		
		label1 = new JLabel("Please choose the format of the object file:");
		label1.setBounds(420, 20, 360, 20);
		container.add(label1);
		
		fileTypeChooser = new JComboBox<String>(types);
		fileTypeChooser.setBounds(420, 50, 360, 20);
		fileTypeChooser.setEditable(false);
		fileTypeChooser.addItemListener(chooseAction);
		container.add(fileTypeChooser);
		
		buttonShowDirectedGraph = new JButton("ShowDirectedGraph");
		buttonShowDirectedGraph.setBounds(420, 80, 360, 50);
		buttonShowDirectedGraph.setEnabled(false);
		buttonShowDirectedGraph.addActionListener(new features());
		container.add(buttonShowDirectedGraph);
		
		buttonQueryBridgeWords = new JButton("QueryBridgeWords");
		buttonQueryBridgeWords.setBounds(420, 150, 360, 50);
		buttonQueryBridgeWords.addActionListener(new features());
		container.add(buttonQueryBridgeWords);
		
		buttonGenerateNewText = new JButton("GenerateNewText");
		buttonGenerateNewText.setBounds(420, 220, 360, 50);
		buttonGenerateNewText.addActionListener(new features());
		container.add(buttonGenerateNewText);
		
		buttonCalcShortestPath = new JButton("CalcShortestPath");
		buttonCalcShortestPath.setBounds(420, 290, 360, 50);
		buttonCalcShortestPath.setEnabled(false);
		buttonCalcShortestPath.addActionListener(new features());
		container.add(buttonCalcShortestPath);
		
		buttonRandomWalk = new JButton("RandomWalk");
		buttonRandomWalk.setBounds(420, 360, 360, 50);
		buttonRandomWalk.addActionListener(new features());
		container.add(buttonRandomWalk);
		
	}
	
	ItemListener chooseAction = new ItemListener() {
		public void itemStateChanged(ItemEvent event) {
			if(event.getStateChange() == ItemEvent.SELECTED) {
				if(fileTypeChooser.getSelectedItem() != "*") {
					mediumWindow.buttonShowDirectedGraph.setEnabled(true);
					mediumWindow.buttonCalcShortestPath.setEnabled(true);
				}
				else {
					mediumWindow.buttonShowDirectedGraph.setEnabled(false);
					mediumWindow.buttonCalcShortestPath.setEnabled(false);
				}
			}
		}
	};
	
}