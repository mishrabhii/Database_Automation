//********************************************************
//Author_Name : Abhishek_Mishra
//Project     : Database_Automation
//Date        : 29/01/2023
//********************************************************

package com.bridhelabz.db.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DbAutomationTest {

	public Connection con;
	public Statement stmt;
	static ResultSet result;

	@BeforeTest
	public void getVariable_values() {
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/CFP_216","root","mishrabhi");
			stmt = con.createStatement();
		}
		catch(SQLException e) {
			System.out.println(e);
		}

	}

	@Test(priority = 3)
	public void getTableData_successfully()  {

		try {	String query= "select * from employee";
		ResultSet result = stmt.executeQuery(query);

		while(result.next()) 
		{
			String id=result.getString("id");
			String name=result.getString("name");
			String gender=result.getString("gender");
			String salary=result.getString("salary");
			String company=result.getString("company");
			System.out.println(id +"  "+name +"  "+gender+"  "+salary+ "   "+company);
		}	
		}
		catch (SQLException e) {
			System.out.println(e);

		}
	}
	@Test(priority =1)
	public void createTableIntoDB_successfully() {

		try {	String query= "create table employee(id int primary key,name varchar(50) not null,gender varchar(20)not null,salary int,company varchar(50) not null)";
		stmt.executeUpdate(query);
		System.out.println("employee table created successfully");
		getTableData_successfully();
		}
		catch(SQLException e) {
			System.out.println(e);
		}

	}	

	@Test(priority =10)
	public void dropTableFromDB_successfully() {

		try {
			String query= "drop table employee";
			stmt.executeUpdate(query);
			System.out.println("employee table drop successfully");
		}
		catch(SQLException e) {
			System.out.println("e");
		}

	}
	@Test(priority =5)
	public void alterTableIntoDB_successfully() {

		try {

			String query= "alter table employee add Location varchar(50)";
			stmt.executeUpdate(query);
			System.out.println("add column successfully");
			getTableData_successfully();
		}
		catch(SQLException e) {
			System.out.println(e);

		}
	}
	@Test(priority =9)
	public void truncateTableIntoDB_successfully() {

		try {
			String truncateTable= "truncate employee";
			stmt.executeUpdate(truncateTable);
			System.out.println("table truncated successfully");
			getTableData_successfully();
		}
		catch(SQLException e) {
			System.out.println(e);

		}

	}
	@Test(priority =2)
	public void insertDataIntoTable_successfully () {
		try {

			String insertData= "insert into employee(id,name,gender,salary,company) values (101,'abhishek','M',30000,'Qapitol'),(102,'anjali','F',35000,'IBM'),(103,'sanjay','M',40000,'HCL'),(104,'rajeev','M',32000,'TCS')";
			stmt.executeUpdate(insertData);
			System.out.println("data inserted successfully");
			getTableData_successfully();
		}
		catch(SQLException e) {
			System.out.println(e);
		}
	}
	@Test(priority =4)
	public void updateDataIntoTable_successfully () {
		try {
			String updateSalary = "update employee set salary =40000 where id=102";
			stmt.executeUpdate(updateSalary);
			System.out.println("salary updated successfully");
			getTableData_successfully();
		}
		catch(SQLException e) {
			System.out.println(e);

		}
	}
	@Test(priority =6)
	public void deleteRowFromTable_successfully () {
		try {
			String deleteRow = "delete from employee where id=103";
			stmt.executeUpdate(deleteRow);
			System.out.println("row deleted successfully");
			getTableData_successfully();
		}
		catch(SQLException e) {
			System.out.println(e);

		}
	}
	@Test(priority =7)

	public void updateData () {
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/CFP_216","root","mishrabhi");
			stmt = con.createStatement();
			String deleteRow = "delete from employee where id=103";
			stmt.executeUpdate(deleteRow);
			System.out.println("row deleted successfully");
			getTableData_successfully();
		}
		catch(SQLException e) {
			System.out.println(e);
		}
	}
	@Test(priority =8)

	public void orderbyClause() {
		try {

			String orderby= "select * from employee order by name";
			ResultSet result = stmt.executeQuery(orderby);

			while(result.next()) 
			{
				String id=result.getString("id");
				String name=result.getString("name");
				String gender=result.getString("gender");
				String salary=result.getString("salary");
				String company=result.getString("company");
				System.out.println(id +"  "+name +"  "+gender+"  "+salary+ "   "+company);
			}	
		}
		catch(SQLException e) {
			System.out.println(e);

		}
	}

	@AfterTest
	public void tearDown() {
		try {
			con.close();
		}
		catch(SQLException e) {
			System.out.println(e);
		}

	}
}
