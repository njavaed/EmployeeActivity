import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import org.jfree.ui.RefineryUtilities;

//EmployeeInteraction.java
//This class implements an interface interaction. It creates all the main displays that are required to interact with the user.
//The id of an admin is 000

//INTERFACE
interface interaction{
	void display() throws IOException;
	void readFile(String f1) throws IOException;
	void writeToFile(String f1) throws IOException;
	void adminMenu() throws IOException;
} //end interface



public class EmployeeInteraction implements interaction{
	
	Scanner input = new Scanner(System.in);
	
	//instantiate FileStorage class to let user input his name, role and id
	FileStorage fs = new FileStorage();
	
	//VECTORS to store files and timings when files are accessed
	Vector <Integer>files = new Vector<Integer>();
	Vector <String>time  = new Vector();
	
	//timesatmp to store in graphFile.txt
	String timeStamp = new SimpleDateFormat("hh").format(new Date());
	
	//create a file graphFile.txt in C drive and in folder EmployeeInfo
	File graphFile = new File("C:\\EmployeeInfo\\graphFile.txt");
	
	
	//MAIN
	public static void main(String[] args) throws IOException {
		
		//Instantiate EmployeeInteraction class to start all the program
		EmployeeInteraction EI = new EmployeeInteraction();
		
	}//end main
	
	
	
	//CONSTRUCTOR
	EmployeeInteraction() throws IOException{
		
		FileReader       fr1 = new FileReader("C:\\EmployeeInfo\\employeeInfo.txt");
		BufferedReader   br1 = new BufferedReader(fr1);
		
		//check if user is admin - the id of admin is 000
		if(fs.v.get(1).equals("000")) {
			adminMenu();
		}
		else {
			boolean keepGoing = true;
			//if user is not admin then check if user exists in the company's database
			while(keepGoing) {
				String  currentLine1 = br1.readLine();
			     	String[] record = currentLine1.split(",");
			     	if(fs.v.get(1).equals(record[1])) {
			     		display();
			     		keepGoing = false;
			     	} 
			     	else if(currentLine1 == null) {
			     		System.out.println("Sorry you are not an existing user");
			     		keepGoing = false;
			     	}
			
			} // end while
		}
		
	} // end constructor
	
	
	
	//this function show the main menu that any employee other than an admin sees
	public void display() throws IOException {
		
		boolean keepGoing = true;
		
		//keep going through the loop until user exits
		while(keepGoing) {
			System.out.println("Choose from following options: ");
			System.out.println("1) View existing company files");
			System.out.println("2) Exit");
			String response1 = input.nextLine();
		
			//to store file names
			//Assign a number to every file in the company's system. By doing this we can make a barchart.
			int f1;
			int f2;
			int f3;
			
			//check users responses and take action accordingly
			if(response1.equals("1")) {
				fs.showFiles();
				System.out.println("\nWhich file you want to open? Enter a number (e.g. 1)");
				String response2 = input.nextLine();
			
				if(response2.equals("1")) {
					f1 = 1;
					//add file number to vector files
					files.add(f1);
					
					//add timestamp to vector time
					time.add(timeStamp);
					
					System.out.println("===================");
					System.out.println("File Engine.txt has following content");
					System.out.println("===================");
					
					//read the file and show it to user
					readFile("C:\\CompanyFiles\\Engine.txt");
					System.out.println("===================");
					
					//if user wants to write to the file then write that to file
					writeToFile("C:\\CompanyFiles\\Engine.txt");
				} //end if
				else if(response2.equals("2")) {
					f2 = 2;
					System.out.println("\n\n===================");
					System.out.println("File history.txt has following content");
					System.out.println("===================\n\n");
					readFile("C:\\CompanyFiles\\history.txt");
					System.out.println("===================");
					writeToFile("C:\\CompanyFiles\\history.txt");
					files.add(f2);
					time.add(timeStamp);
				}//end if
				else if(response2.equals("3")) {
					f3 = 3;
					System.out.println("\n\n===================");
					System.out.println("File workflow.txt has following content");
					System.out.println("===================\n\n");
					readFile("C:\\CompanyFiles\\workflow.txt");
					System.out.println("===================");
					writeToFile("C:\\CompanyFiles\\workflow.txt");
					files.add(f3);
					time.add(timeStamp);
				} 
				else {
					System.out.println("\t\tNo Such file exists");
				}
				
			} // end if
		
			//if user wants to exit then exit the program
			else if(response1.equals("2")){
				saveFilesTime(time, files);
				System.out.println("\t\t\tHave a great day!");
				keepGoing = false;
				break;
			} 
			//if user enters anything else other than the required responses
			else{
				System.out.println("\t\tPlease enter a valid answer");
			 } // end if
		}// end while
		  
	}//end display
	
	//read a file that is fed to this function
	public void readFile(String f1) throws IOException {
		
		//file reader to read a file
		FileReader fr = new FileReader(f1);
		BufferedReader br = new BufferedReader(fr);
		String currentLine = null;
		//loop until current line is equal to null
		while((currentLine = br.readLine()) != null) {
			System.out.println(currentLine);
		} // end while
	} // end readFile
	
	//based on user response writes to a file that is fed to this function
	public void writeToFile(String f1) throws IOException {
		FileWriter outFile = new FileWriter(f1, true);
		PrintWriter out = new PrintWriter(outFile);
		
		System.out.println("\n\nWould you like to write to this file? Enter 'YES' or 'NO'");
		String response = input.nextLine();
		
		//whatever the response is just capitalize
		response = response.toUpperCase();
		
		if(response.equals("YES")) {
			System.out.println("Type what you want to write to file");
			String response2 = input.nextLine();
			out.println(response2);
			System.out.println("Contents being written............\n\n\n");
			System.out.println("Successfully written");
			out.close();
		} // end if 
		
	} // end writeToFile
	
	//this function saves the file numbers and time to vectors v1 and v2
	public void saveFilesTime(Vector v1, Vector v2) throws IOException {
		if(graphFile.exists() == false) {
			graphFile.createNewFile();
		}
		if(graphFile.exists() == true) {
			FileWriter outFile = new FileWriter(graphFile, true);
			PrintWriter out = new PrintWriter(outFile);
			for(int i = 0; i < v1.size(); i++) {
				out.print(v1.get(i) + "," + v2.get(i));
				out.print("\r\n");
			}
			out.close();
			
		} // end if
	}// end saveFilesTime
	
	
	//this function is the menu that admin of the company sees
	public void adminMenu() throws IOException {
		//read file employeeInfo.txt
		             File f = new File("C:\\EmployeeInfo\\employeeInfo.txt");
		
		FileWriter outFile  = new FileWriter(f, true);
		PrintWriter out     = new PrintWriter(outFile);
		
			//create a list of options
			System.out.println("Choose from following options: ");
			System.out.println("1) Add an employee");
			System.out.println("2) Company Files");
			System.out.println("3) Employees Login Chart By Name");
			System.out.println("4) Employees Login Chart By Role");
			System.out.println("5) Peak Times Files are Accessed");
			System.out.println("6) Show Existing Employees");
			System.out.println("7) Exit");
			
			//take users response
			String adminResponse = input.nextLine();
			
			//let user enter the employee into database
			if(adminResponse.equals("1")) {
				System.out.println("Enter the employee name");
				String name = input.nextLine();
				
				System.out.println("Enter the employee id");
				  String id = input.nextLine();
				
				System.out.println("Enter the employee role");
				String role = input.nextLine();
				
				out.println(name + "," + id + "," + role);
				out.close();
				adminMenu();
				
			} // end if
			
			//let admin see company files
			else if(adminResponse.equals("2")) {
				display();
				adminMenu();
			}
			
			//let admin look at the chart of employee logins by names
			else if(adminResponse.equals("3")) {
				BarChart bc = new BarChart("Login of Employees", "Which users have login the most?");
				bc.pack();
				RefineryUtilities.centerFrameOnScreen(bc);
				bc.setVisible(true);
				adminMenu();
			}
			
			//let admin look at the chart of employee logins by roles
			else if(adminResponse.equals("4")) {
				BarChartRoles bcr = new BarChartRoles("Login of Employees", "Which roles have login the most?");
				bcr.pack();
				RefineryUtilities.centerFrameOnScreen(bcr);
				bcr.setVisible(true);
				adminMenu();
			}
			
			//let admin look at the peak times files are accessed 
			else if(adminResponse.equals("5")) {
				PeakTime pt;
				try {
					pt = new PeakTime("Time in hours of files accessed", "What is a good time for system maintenance?");
					pt.pack();
					RefineryUtilities.centerFrameOnScreen(pt);
					pt.setVisible(true);
					adminMenu();
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
			//let admin look at all the employees in the company
			else if(adminResponse.equals("6")) {
				System.out.println("\n\n==============================\n\n");
				fs.showEmp();
				System.out.println("\n\n==============================\n\n");
				adminMenu();
			}
			
			//exit from the portal
			else if(adminResponse.equals("7")) {
				System.out.println("\n\n==============================\n\n");
				System.out.println("\t\t\tThank you for using our portal");
				System.out.println("\t\t\t\tHave a nice day");	
				System.out.println("\n\n==============================\n\n");
			}
			else {
				System.out.println("\n\n\t\t\t\tPlease enter a valid answer\n\n\n");
				adminMenu();
			}
		
	} // end adminMenu
	
	
}//end class def

