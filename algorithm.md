# Data Management Portal
(This program uses Vectors, Object orientation, Interface)

## Goal:
	Make a program that allows to store company files. View the files and update the files. 
	Allows an employee to only view the file and write to it. The administrator has most power. 
	He can add an employee. He can Generate graphs for data analysis on how many employees have 
	logged in the most. He can filter the employees based on role and generate a grpah of them. 
	He can generate a graph of peak time of file access which can be useful if IT team wants to 
	take a down time for maintenance.
	This is basically a data analytics program that helps to make a portal better as it is 
	used more.

## Input:
	1. The inputs are from either employees or administrators.
	2. Employees can input thefile number they want to access or can input data that they want
	   to write to the file.
	3. The administrator can input the employees, files they want to access or choose from any
	   available options.

# Output:
	1. Based on the input the output can be a file content, a graph of employees logged in by name.
	2. Employees logged in by role or peak time of file access.

# Steps:
	Employee class:
		* Create a class employee that sets and gets the employee name, id and role.
	
	FileStorage class:
		* Create a class file storage which instantiates the Employee class and define a Vector 
		* In function called createFiles() create all the necessary file requried 
		  for the program. 
		  It creates the company files and the files to store data for analytics.
		  It also set read, write and executable permissions for all the company files.
		* The function showFiles() shows all the files that are stored in company files folder
		  in C drive.
		* The function savEmpFile saves the employees name, id and role
		  to the file employeeInfo.txt.
		* showEmp() functions shows all the employees in the employeeInfo.txt file.
		* In the constructore FileStorage() we add the employee name, id and role to vector.
		  Then we store the employee info along with its logged in time to the file
		  login.txt.


	BarChart class:
		* This class extends the Application frame.
		* It create a bar chart of the employee names against the count of logins.
		* The constructor BarChart takes two arguments. One is the title of the window pane. 
		  The second is the title of the chart. It instantiates JFreeChart to create
		  a barchart. Then it instantiates the ChartPanel  that takes the object of 
		  JFreeChart as argument. Set the size of the window pane using java.awt.Dimension.
		* Create a function called createDataset of type CategoryDataset.
		  It reads data from the file employeeInfo.txt and uses the employee names and 
		  number of logins by them to create a barchart.
		* It counts the names using a function called countWord(). This function takes the
		  string word and file name as arguments. This function counts the occurrences of
		  the word in the file.

	BarChartRoles class:
		* This class does similar things as BarChart class except that it reads the employee
		  roles from employeeInfo.txt and count their logins from login.txt file.
		* It also uses the function countWord().

	PeakTime class:
		* This class also creates a barchart using JFreeChart and ChartPanel.
		* It reads from the file graphFile.txt. This file contains the files accessed at 
		  a particular time. Creates a barchart to show when is the portal most busy.

	interaction Interface:
		* This interface is the blueprint for the functions that are defined in 
		  EmployeeInteraction class. It has functions display(), readFile(), writeToFile(), 
		  adminMenu().
	
	EmployeeInteraction class:
		* Instatntiates FileStorage class.
		* Creates two vectors files and time. Create a timestamp. Creates a graphFile.txt.
		* It has a function display().
		* This function displays options to the employee from which he can choose.
		* Depending on the choice, an employee can either read, write to a file or exit 
		  from the program.
		* readFile() function takes an argument which is a file. It reads data from the file
		  that is given to it as an argument.
		* writeToFile() that writes data to a file that is given to it as an argument.
		* saveFilesTime() is a function that takes two vectors as an argument. It writes
		  the file names and the time they are accessed into the vectors which are then 
		  written to a file.
		* adminMenu() is a function that defines a menu for th admin of the company.
		  The admin can generate graphs, add an employee, see existing employees, see
		  company files. This function instantiates BarChart, BarChartRoles and PeakTime 
		  classes to generate graphs. It uses recursion to see adminMenu again and again
		  until the user hits Exit. 
		
