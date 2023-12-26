package com.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.JDBC.Constants.Constants;
import com.JDBC.DML.DMLOperations;
import com.JDBC.DQL.DQLOperations;

public class JDBC_Application {

	static Connection connection = null;
	static Statement statement = null;
	static Scanner scnScanner = new Scanner(System.in);

	public static void main(String[] args) throws SQLException {

		try {
			connection = getConnetion();
			statement = getStatement(connection);
			int count = 0;
			while (count < 5) {
				System.out.println("Please Select from following Operations");
				System.out.println("1.Insert");
				System.out.println("2.Update");
				System.out.println("3.Delete");
				System.out.println("4.Select");
				System.out.println("5.Search Record");
				System.out.println("6.CallableStatement");
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
					DMLOperations.deleteRecord(statement);
					break;
				}
				case 4: {
					DQLOperations.selectRecords(statement);
					break;
				}
				case 5:{
					System.out.println("Select from following Operations to Search Record");
					System.out.println("1.Search Record By ID");
					System.out.println("2.Search Record By First 3 characters in first name");
					int input1=scnScanner.nextInt();
					switch(input1) {
					case 1:{
						DQLOperations.searchSpecificRecordbyID(connection);
						break;
					}
					case 2:{
						DQLOperations.SearchByCharactersInName(connection);
						break;
					}
					default:
						System.out.println("------Invalid Selection---------");
					}
				}
				case 6:{
					DQLOperations.callableStatemetExp(connection);
					break;
				}
				default:
					System.out.println("Invalid Selection..!");
					count++;
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connection.close();
			statement.close();
		}

	}

	private static Connection getConnetion() throws SQLException {
		Connection connection = DriverManager.getConnection(Constants.DBURL, Constants.DBUSER, Constants.DBPASSWORD);
		System.out.println("Connection Established with DB");
		return connection;
	}

	private static Statement getStatement(Connection con) throws SQLException {
		statement = con.createStatement();
		return statement;
	}

}
