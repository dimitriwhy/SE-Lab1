package textGraph;
import javax.swing.*;
import java.awt.*;
import textGraph.browseAction;
import textGraph.allFunction;
class TextGraph{
	private JFrame mainFrame;
	private JLabel label1;
	public static JTextField fileLocation;
	public static JButton browseFile;
	public static JButton createGraph;
	/**
	 * Launch the application;
	 * @param args
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TextGraph window = new TextGraph();
					window.mainFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the application;
	 */
	public TextGraph() {
		initialize();
	}
	/**
	 * initialize the contents of the frame;
	 */
	private void initialize() {
		
		mainFrame = new JFrame("Textfile-Graph Convertor");
		Container container = mainFrame.getContentPane();
		mainFrame.setSize(400, 300);
		mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setResizable(false);
		container.setLayout(null);
		
		label1 = new JLabel("Please enter or choose the path of the file:");
		label1.setBounds(30, 10, 300, 20);
		container.add(label1);
		
		fileLocation = new JTextField();
		fileLocation.setBounds(50, 50, 200, 30);
		container.add(fileLocation);
		
		browseFile = new JButton("Select...");
		browseFile.setBounds(270, 50, 100, 30);
		browseFile.addActionListener(new browseAction());
		container.add(browseFile);
		
		createGraph = new JButton("Create Graph");
		createGraph.setBounds(150, 150, 100, 50);
		createGraph.addActionListener(new allFunction());
		container.add(createGraph);
		
	}
	
}
