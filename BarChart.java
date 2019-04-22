import java.util.*;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

import java.io.*;

//BarChart.java
//it creates a bar chart of employee names against the count of login attempts

public class BarChart extends ApplicationFrame{
	
	
	//CONSTRUCTOR
	public BarChart(String title, String chartTitle) throws IOException {
		super(title);
		
		//instantiate JFreeChart to create the barchart
		JFreeChart barchart = ChartFactory.createBarChart(
		chartTitle,
		"Names",
		"CountOfLogin",
		createDataset(),
		PlotOrientation.VERTICAL,
		true, true, false);
		
		ChartPanel chartPanel = new ChartPanel( barchart );        
	    chartPanel.setPreferredSize(new java.awt.Dimension( 560 , 367 ) );        
	    setContentPane( chartPanel ); 
	} // end constructor

	
	//MAIN
	public static void main(String[] args) throws IOException {
		BarChart bc = new BarChart("Login of Employees", "Which users have login the most?");
		//FileStorage fs = new FileStorage();
		
		//count the number of logins from login.txt for a particular employee name
		
		bc.pack();
		RefineryUtilities.centerFrameOnScreen(bc);
		bc.setVisible(true);
		
	}
	
	//this function extracts data from file login.txt and employeeInfo.txt to be fed to the barchart
	private CategoryDataset createDataset() throws IOException {
					File f1 = new File("C:\\EmployeeInfo\\login.txt");
		FileReader       fr = new FileReader("C:\\EmployeeInfo\\employeeInfo.txt");
		BufferedReader   br = new BufferedReader(fr);
		
		DefaultCategoryDataset dataset = new DefaultCategoryDataset( );  
		
		String title = "Names";
		String currentLine  = null;
		while((currentLine  = br.readLine()) != null) {
			
			//split the current line at a comma and store it in a string array
			  String[] word = currentLine.split(",");
			  
			  //name of employee is on index 0 in file employeeInfo.txt
			   String name1 = word[0];
			   
			   //use function countWord to count the occurrences of a name in login.txt
			          int a = countWord(name1, f1);
			          
			//add the count of logins and name along with title to the dataset
			dataset.addValue(a, name1, title);
		} // end while
		
		return dataset;
		
	} // end createDataset
	
	
	//this function returns count of occurrences of a word in a file
	public int countWord(String word, File file) throws IOException {
		FileReader       fr = new FileReader(file);
		BufferedReader   br = new BufferedReader(fr);
		
				  int count = 0;
		 String currentLine = null;
		while ((currentLine = br.readLine()) != null) {
			String[] s = currentLine.split(",");
			if(word.equals(s[0])) {
				count++;
			} // end if
		
		} // end while
		
		return count;
		
	} // end countWord
	
	
	
} // end class def

