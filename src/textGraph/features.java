package textGraph;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import textGraph.GraphViz;
public class features implements ActionListener {
  public void actionPerformed(ActionEvent event) {
    if (event.getSource().equals(mediumWindow.buttonShowDirectedGraph)) {
    		String dir = mediumWindow.targetPath;
    		GraphViz gv = new GraphViz();
    		gv.setdir(dir);
    		gv.addln(gv.start_graph());
    		gv.addln("A -> B;");
    		gv.addln("B -> C;");
    		gv.addln(gv.end_graph());
    		//System.out.println(gv.getDotSource());
    		
    		String type = (String)mediumWindow.fileTypeChooser.getSelectedItem();
    		File out = new File(dir + "/balabala." + type);
    		gv.writeGraphToFile( gv.getGraph( gv.getDotSource(), type ), out );
    		System.out.println(gv.getDotSource());
    } 
    else if (event.getSource().equals(mediumWindow.buttonQueryBridgeWords)) {
      
    }
    else if (event.getSource().equals(mediumWindow.buttonGenerateNewText)) {
    	
    }
    else if (event.getSource().equals(mediumWindow.buttonCalcShortestPath)) {
    	
    }
    else if (event.getSource().equals(mediumWindow.buttonRandomWalk)) {
    	
    }
  }
}