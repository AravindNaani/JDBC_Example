package com.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.JDBC.Constants.Constants;
import com.JDBC.DML.DMLOperations;


public class JDBC_Application {
	
	static Connection connection = null;
	static Statement statement=null;
	static Scanner scnScanner = new Scanner(System.in);
	public static void main(String[] args) {
		
		try {
			connection = getConnetion();
			statement = getStatement(connection);
			int Count=0;
			while(Count<5) {
			System.out.println("Please Select from following Operations");
			System.out.println("1.Insert");
			System.out.println("2.Update");
			System.out.println("3.Delete");
			System.out.println("4.Select");
			int input = scnScanner.nextInt();
			switch (input) {
			case 1: {
				DMLOperations.insertRecord(statement);
				break;
			}
			case 2: {
				DMLOperations.updateRecord(statement);
				break;
			}
			case 3: {
				
			}
			case 4: {
				DMLOperations.selectRecords(statement);
				break;
			}
			default:
				System.out.println("Invalid Selection..!");
				Count++;
			}
		}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	private static Connection getConnetion() throws SQLException {
		Connection connection = DriverManager.getConnection(Constants.DBURL,Constants.DBUSER,Constants.DBPASSWORD);
		System.out.println("Connection Established with DB");
		return connection;
	}
	
	private static Statement getStatement(Connection con) throws SQLException {
		statement = con.createStatement();
		return statement;
	}

}
