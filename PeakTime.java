import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;


//PeakTime.java
//It shows a barchart of time in hours and the number of files being accessed at that particular hour


public class PeakTime extends ApplicationFrame {

	//MAIN
	public static void main(String[] args) throws ParseException, IOException {
		PeakTime pk = new PeakTime("Peak time of file access", "Downtime analysis for IT team");
		RefineryUtilities.centerFrameOnScreen(pk);
		pk.pack();
		pk.setVisible(true);
	}
	
	
	//CONSTRUCTOR
	public PeakTime(String title, String chartTitle) throws ParseException, IOException {
		super(title);
		JFreeChart barchart = ChartFactory.createBarChart(
		chartTitle,
		"Time",
		"CountOfFiles",
		createDataset(),
		PlotOrientation.VERTICAL,
		true, true, false);
		
		ChartPanel chartPanel = new ChartPanel( barchart );        
	    chartPanel.setPreferredSize(new java.awt.Dimension( 560 , 367 ) );        
	    setContentPane( chartPanel ); 
	    
	    
	} // end constructor
	
	
	private CategoryDataset createDataset() throws IOException {
			   File f1          = new File("C:\\EmployeeInfo\\graphFile.txt");
			FileReader       fr = new FileReader("C:\\EmployeeInfo\\graphFile.txt");
			BufferedReader   br = new BufferedReader(fr);

			DefaultCategoryDataset dataset = new DefaultCategoryDataset( );  

			String title = "Hours";
			String currentLine  = null;
			while((currentLine  = br.readLine()) != null) {
				String[] word = currentLine.split(",");
				String date = word[0];
				int a = countWord(date, f1);
				dataset.addValue(a, date, title);
			} // end while
			
			return dataset;
			
	} // end createDataset
	
	
	public int countWord(String word, File file) throws IOException {
		FileReader       fr = new FileReader(file);
		BufferedReader   br = new BufferedReader(fr);
		
				  int count = 0;
		 String currentLine = null;
		while ((currentLine = br.readLine()) != null) {
			//String currentLine1 = br.readLine();
			String[] s = currentLine.split(",");
			if(word.equals(s[0])) {
				count++;
			} // end if
		
		} // end while
		
		return count;
		
	} // end countWord
	
} // end class def

