//********************************************************
//Author_Name : Sheetal_Chaudhari
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
	public void getVariable_values() throws SQLException { 
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/CFP_216","root","mishrabhi");
		stmt = con.createStatement();
	}

	@Test
	public void getTableData_successfully() throws SQLException {

		String query= "select * from employee";
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
	@Test
	public void createTableIntoDB_successfully() throws SQLException {

		String query= "create table employee(id int primary key,name varchar(50) not null,gender varchar(20)not null,salary int)";
		stmt.executeUpdate(query);
		System.out.println("employee table created successfully");
		getTableData_successfully();

	}	

	@Test
	public void dropTableFromDB_successfully() throws SQLException {

		String query= "drop table employee";
		stmt.executeUpdate(query);
		System.out.println("employee table drop successfully");
		getTableData_successfully();

	}
	@Test
	public void alterTableIntoDB_successfully() throws SQLException {

		String query= "alter table employee add company varchar(50)";
		stmt.executeUpdate(query);
		System.out.println("add column successfully");
		getTableData_successfully();

	}
	@Test
	public void truncateTableIntoDB_successfully() throws SQLException {

		String truncateTable= "truncate employee";
		stmt.executeUpdate(truncateTable);
		System.out.println("table truncated successfully");
		getTableData_successfully();

	}
	@Test
	public void insertDataIntoTable_successfully () throws SQLException {

		String insertData= "insert into employee(id,name,gender,salary,company) values (101,'abhishek','M',30000,'Qapitol'),(102,'anjali','F',35000,'IBM'),(103,'sanjay','M',40000,'HCL'),(104,'rajeev','M',32000,'TCS')";
		stmt.executeUpdate(insertData);
		System.out.println("data inserted successfully");
		getTableData_successfully();
	}
	@Test
	public void updateDataIntoTable_successfully () throws SQLException {

		String updateSalary = "update employee set salary =40000 where id=102";
		stmt.executeUpdate(updateSalary);
		System.out.println("salary updated successfully");
		getTableData_successfully();
	}
	@Test
	public void deleteRowFromTable_successfully () throws SQLException {

		String deleteRow = "delete from employee where id=103";
		stmt.executeUpdate(deleteRow);
		System.out.println("row deleted successfully");
		getTableData_successfully();
	}
	public void updateData () throws SQLException {
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/CFP_216","root","mishrabhi");
		stmt = con.createStatement();
		String deleteRow = "delete from employee where id=103";
		stmt.executeUpdate(deleteRow);
		System.out.println("row deleted successfully");
		getTableData_successfully();
	}
	@Test

	public void orderbyClause() throws SQLException {

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

	@AfterTest
	public void tearDown() throws SQLException {
		con.close();

	}
}
