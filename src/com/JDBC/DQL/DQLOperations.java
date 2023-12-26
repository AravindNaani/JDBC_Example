package com.JDBC.DQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DQLOperations {
	static Scanner scn = new Scanner(System.in);
	public static void selectRecords(Statement statement) throws SQLException {

		String quaryString = "select * from employee";
		System.out.println(quaryString);
		ResultSet resultSet = statement.executeQuery(quaryString);
		ResultSetMetaData metaData = resultSet.getMetaData();
		int columnCount = metaData.getColumnCount();
		for(int i=1;i<=columnCount;i++) {
			System.out.print(metaData.getColumnName(i)+"\t");
		}
		System.out.println();
		System.out.println("-----------------------------------------------");
		while (resultSet.next()) {
			System.out.println(resultSet.getString(1) + "\t" + resultSet.getString(2) + "\t\t" + resultSet.getString(3));
		}
		System.out.println("------------------------------------------------");
	}
	
	public static void searchSpecificRecordbyID(Connection connection) throws SQLException {
		System.out.println("Enter id to Search the Record");
		int id = scn.nextInt();
		PreparedStatement prepareStatement = connection.prepareStatement("select * from employee where id=?");
		prepareStatement.setInt(1, id);
		ResultSet resultSet = prepareStatement.executeQuery();
		ResultSetMetaData metaData = resultSet.getMetaData();
		int columnCount = metaData.getColumnCount();
		for(int i=1;i<=columnCount;i++) {
			System.out.print(metaData.getColumnName(i)+"\t");
		}
		System.out.println();
		resultSet.next();
		System.out.println("-----------------------------------------------");
		System.out.println(resultSet.getString(1) + "\t" + resultSet.getString(2) + "\t\t" + resultSet.getString(3));
		System.out.println("-----------------------------------------------");
		prepareStatement.close();
	}
	
	public static void SearchByCharactersInName(Connection connection) throws SQLException {
		System.out.println("Enter First 3 characters in first name");
		String firstThreeCharecters = scn.next();
		PreparedStatement prepareStatement = connection.prepareStatement("select * from employee where firstname like ?");
		prepareStatement.setString(1, firstThreeCharecters+"%");
		ResultSet resultSet = prepareStatement.executeQuery();
		ResultSetMetaData metaData = resultSet.getMetaData();
		int columnCount = metaData.getColumnCount();
		for(int i=1;i<=columnCount;i++) {
			System.out.print(metaData.getColumnName(i)+"\t");
		}
		System.out.println();
		System.out.println("-----------------------------------------------");
		while(resultSet.next()) {
			System.out.println(resultSet.getString(1) + "\t" + resultSet.getString(2) + "\t\t" + resultSet.getString(3));
		}
		System.out.println("-----------------------------------------------");
		prepareStatement.close();
	}
		
}
