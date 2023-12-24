package com.JDBC.DML;

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

	private static void runtimeData() {
		System.out.println("Please enter id");
		id =scn.nextInt();
		System.out.println("Please enter first name");
		firstname = scn.next();
		System.out.println("Please enter second name");
		lastname = scn.next();
	}

}
