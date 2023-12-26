package com.JDBC.DML;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;



public class DMLOperations {
	static Scanner scn = new Scanner(System.in);
	static int id;
	static String firstname;
	static String lastname;
	
	public static void insertRecord(Statement statement) throws SQLException {
		runtimeData();
		String quaryString = "insert into employee values ("+id+",'"+firstname+"','"+lastname+"')";
		System.out.println(quaryString);
		int rows = statement.executeUpdate(quaryString);
		System.out.println(rows+" rows  got inserted");
	}
	
	public static void selectRecords(Statement statement) throws SQLException {
		
		String quaryString = "select * from employee";
		System.out.println(quaryString);
		ResultSet resultSet = statement.executeQuery(quaryString);
		System.out.println("-----------------------------------------------");
		while(resultSet.next()) {
			System.out.println(resultSet.getString(1)+"\t"+resultSet.getString(2)+"\t"+resultSet.getString(3));
		}
		System.out.println("------------------------------------------------");
	}
	
	public static void updateRecord(Statement statement) throws SQLException {
		
		System.out.println("Please Enter ID to Update Record");
		int id = scn.nextInt();
		System.out.println("Select following options for Update the Record");
		System.out.println("Enter 1 for update the first name");
		System.out.println("Enter 2 for update the last name");
		System.out.println("Enter 3 for update the both the fields");
		int input = scn.nextInt();
		switch (input) {
		case 1: {
			System.out.println("Enter FirstName");
			String firstName = scn.next();
			String quaryString = "update employee set firstname="+"'"+firstName+"'"+"where id ="+id;
			System.out.println(quaryString);
			int rows = statement.executeUpdate(quaryString);
			System.out.println(rows+" row got updated");
			break;
		}
		case 2:{
			System.out.println("Enter LastName");
			String lastName = scn.next();
			String quaryString = "update employee set lastname="+"'"+lastName+"'"+"where id ="+id;
			System.out.println(quaryString);
			int rows = statement.executeUpdate(quaryString);
			System.out.println(rows+" row got updated");
			break;
		}
		case 3:{
			System.out.println("Enter FirstName");
			String firstName = scn.next();
			System.out.println("Enter LastName");
			String lastName = scn.next();
			String quaryString = "update employee set firstname="+"'"+firstName+"',"+"lastname="+"'"+lastName+"'"+"where id ="+id;
			System.out.println(quaryString);
			int rows = statement.executeUpdate(quaryString);
			System.out.println(rows+" row got updated");
			break;
		}
		default:
			System.out.println("-----Invalid Entry------");
		}
		
	}
	
	public static void deleteRecord(Statement statement) throws SQLException {
		System.out.println("Enter Id to delete a record");
		int id = scn.nextInt();
		String quaryString = "delete from employee where id="+id;
		int rows = statement.executeUpdate(quaryString);
		System.out.println(rows+" got deleted");
	}

	private static void runtimeData() {
		System.out.println("Please enter id");
		id =scn.nextInt();
		System.out.println("Please enter first name");
		firstname = scn.next();
		System.out.println("Please enter second name");
		lastname = scn.next();
	}

}
