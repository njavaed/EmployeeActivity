//Employee.java
//This class sets the employee names, id and roles

import java.util.*;
import java.io.*;

public class Employee implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String name;
	String id;
	String role;
	
	Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee emp = new Employee();
	}
	
	//CONSTRUCTOR
	Employee(){
		System.out.println("Please enter your name: ");
		name = input.nextLine();
		
		System.out.println("Please enter your role: ");
		role = input.nextLine();
		
		System.out.println("Please enter your id: ");
		id = input.nextLine();
		
		setName(name);
		setId(id);
		setRole(role);
		
	} // end constructor
	
	//set employee name
	void setName(String nameA){
		name = nameA;
	}
	
	//set employee id
	void setId(String idA) {
		id = idA;
	}
	
	//set employee role
	void setRole(String roleA) {
		role = roleA;
	}
	
	//get employee name
	String getName() {
		return name;
	}
	
	//get employee id
	String getId() {
		return id;
	}
	
	//get employee id
	String getRole() {
		return role;
	}
	

} // end class def


