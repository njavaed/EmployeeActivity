import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

//FileStorage.java
//this class creates files and saves data to files

public class FileStorage{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//define a fector to store employee information
	Vector    v  = new Vector();
	
	//instantiate employee class to let user enter his name, id and role
	Employee emp = new Employee();
	
	//MAIN
	public static void main(String[] args) throws IOException {
		
		FileStorage fs = new FileStorage();
	} // end main
	
	//CONSTRUCTOR
	FileStorage() throws IOException{
		
		//add emp name, id and role to vector
		v.add(emp.getName());
		v.add(emp.getId());
		v.add(emp.getRole());
		
		createFiles();
		
		
		//LOGIN FILE
		//store employee info along with login times in login.txt
		//time stamps for login times of employees
		            File f2 = new File("C:\\EmployeeInfo\\login.txt");
		String timeStamp    = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
		FileWriter outFile1 = new FileWriter(f2, true);
		PrintWriter out1    = new PrintWriter(outFile1);
		out1.println(v.get(0) + "," + v.get(1) + "," + v.get(2) + "," + timeStamp);
		out1.close();
		
	}
	
	//create all the files required for this program and set permissions where necessary
	void createFiles() throws IOException {
		File dir1 = new File("C:\\CompanyFiles");
		dir1.mkdir();
		
		File dir2 = new File("C:\\EmployeeInfo");
		dir2.mkdir();
		
		File f1 = new File("C:\\CompanyFiles\\workflow.txt");
		File f2 = new File("C:\\CompanyFiles\\history.txt");
		File f3 = new File("C:\\CompanyFiles\\Engine.txt");
		File f4 = new File("C:\\EmployeeInfo\\employeeInfo.txt");
		File f5 = new File("C:\\EmployeeInfo\\login.txt");
		File f6 = new File("C:\\EmployeeInfo\\Name_CountofLogin.txt");
		
		f1.createNewFile();
		f2.createNewFile();
		f3.createNewFile();
		f4.createNewFile();
		f6.createNewFile();
		
		f1.setExecutable(true);
		f1.setReadable(true);
		f1.setWritable(true);
		
		f2.setExecutable(true);
		f2.setReadable(true);
		f2.setWritable(true);
		
		f3.setExecutable(true);
		f3.setReadable(true);
		f3.setWritable(true);
	}

	//show the files from the folder company files
	void showFiles() {
		File folder  = new File("C:\\CompanyFiles");
		 
        File[] files = folder.listFiles();
        int i = 0;
        
        for (File file : files)
        {
        	i++;
            System.out.println(i + ")" + file.getName());
        }
	}
	
	//save the employee information to file employeeInfo.txt
	void saveEmpFile() throws IOException{
		FileReader       fr = new FileReader("C:\\EmployeeInfo\\employeeInfo.txt");
		BufferedReader   br = new BufferedReader(fr);
		
		boolean keepGoing   = true;
		
		File f1 = new File("C:\\EmployeeInfo\\employeeInfo.txt");
		
		
		FileWriter outFile  = new FileWriter(f1, true);
		PrintWriter out     = new PrintWriter(outFile);
		
		while(keepGoing) {
			String  currentLine = br.readLine();
			
			if(v.get(1).equals(currentLine)) {
				keepGoing = false;
			} // end if
			if(currentLine == null) {
				out.println(v.get(0) + "," + v.get(1) + "," + v.get(2));
				keepGoing = false;
			} // end if
			
		} // end while
	
		out.close();
		
	} // end saveEmpFile
	
		
	//this function reads information form file employeeInfo.txt and shows it to the user
	void showEmp() throws IOException {
		FileReader fr = new FileReader("C:\\EmployeeInfo\\employeeInfo.txt");
		BufferedReader br = new BufferedReader(fr);
		String currentLine = null;
		while((currentLine = br.readLine()) != null) {
			String[] a = currentLine.split(",");
			System.out.println("\n================");
			System.out.println("Name: " + a[0]);
			System.out.println("Id: " + a[1]);
			System.out.println("Role: " + a[2]);
			System.out.println("================\n");
		}
	} // end showEmp
	

}// end class def

