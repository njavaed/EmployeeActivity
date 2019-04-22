Employee.class: Employee.java
	javac -g Employee.java

EmployeeInteraction.class: EmployeeInteraction.java
	javac -g EmployeeInteraction.java

FileStorage.class: FileStorage.java
	javac -g FileStorage.java

BarChart.class: BarChart.java
	javac -g BarChart.java

BarChartRoles.class: BarChartRoles.java
	javac -g BarChartRoles.java

PeakTime.class: PeakTime.java
	javac -g PeakTime.java

clean:
	rm -f *.class

run: EmployeeInteraction.class
	java EmployeeInteraction

runEmp: Employee.class
	java Employee
runFileSto: FileStorage.class
	java FileStorage
runBarChart: BarChart.class
	java BarChart
runBarChartRoles: BarChartRoles.class
	java BarChartRoles
runPeakTime: PeakTime.class
	java PeakTime
	
dataManagement.jar: EmployeeInteraction.class
	jar -cvfm dataManagement.jar manifest.txt *.*

jar:
	make
	jar -cvfm dataManagement.jar jcommon-1.0.21.jar jfreechart-1.0.18.jar xml-apis-1.3.04.jar manifest.txt *.*

run: dataManagement.jar
	java -jar dataManagement.jar
	

debug: EmployeeInteraction.class
	jdb EmployeeInteraction


