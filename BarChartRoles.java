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

//BarChartRoles.java
//creates a bar chart of employee roles against the count of logins that each employee have made

public class BarChartRoles extends ApplicationFrame{
	
	
	//CONSTRUCTOR
	public BarChartRoles(String title, String chartTitle) throws IOException {
		super(title);
		JFreeChart barchart = ChartFactory.createBarChart(
		chartTitle,
		"Roles",
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
		   BarChartRoles bc = new BarChartRoles("Login of Employees", "Which roles have login the most?");
		//FileStorage fs = new FileStorage();
		
		//count the number of logins from login.txt for a particular employee name
		       File f1 = new File("C:\\EmployeeInfo\\login.txt");
		   //String name = (String) fs.v.get(0);
		   
		//System.out.println(bc.countWord(name, f1));
		
		bc.pack();
		RefineryUtilities.centerFrameOnScreen(bc);
		bc.setVisible(true);
		
		
		//System.out.println("ran successfully");
	}
	
	private CategoryDataset createDataset() throws IOException {
					File f1 = new File("C:\\EmployeeInfo\\login.txt");
		FileReader       fr = new FileReader("C:\\EmployeeInfo\\employeeInfo.txt");
		BufferedReader   br = new BufferedReader(fr);
		
		DefaultCategoryDataset dataset = new DefaultCategoryDataset( );  
		
		String title = "Roles";
		String currentLine  = null;
		while((currentLine  = br.readLine()) != null) {
			  String[] word = currentLine.split(",");
			   String name1 = word[2];
			          int a = countWord(name1, f1);
			dataset.addValue(a, name1, title);
		} // end while
		
	
		return dataset;
	}
	
	
	//this function returns count of occurrences of a word in a file
	public int countWord(String word, File file) throws IOException {
		FileReader       fr = new FileReader(file);
		BufferedReader   br = new BufferedReader(fr);
		
				  int count = 0;
		 String currentLine = null;
		while ((currentLine = br.readLine()) != null) {
			//String currentLine1 = br.readLine();
			String[] s = currentLine.split(",");
			if(word.equals(s[2])) {
				count++;
			} // end if
		
		} // end while
		
		return count;
	}
	
	
	
} // end class def

