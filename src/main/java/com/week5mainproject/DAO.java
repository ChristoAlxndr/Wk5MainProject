package com.week5mainproject;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class DAO {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/?user=root&autoReconnect=true&useSSL=false";
	static final String USER = "root";
	static final String Password = "root";
	
	static Connection CONN = null;
	static Statement STMT = null;
	static PreparedStatement PREP_STMT = null;
	static ResultSet RES_SET = null;
	
	public static ArrayList <Trucks> xanderLot = new ArrayList <> ();
	
	
	public static void connToDB() {
		
		try {
			Class.forName(JDBC_DRIVER);
			
			CONN = DriverManager.getConnection(DB_URL, USER, Password);
			
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("Connection failed! YOU LOSE!");
			e.printStackTrace();
		}
	} // End connToDB method
	
	
	public static void readFromDB() {
		
		connToDB();
		
		
		try {
			STMT = CONN.createStatement();
			RES_SET = STMT.executeQuery("SELECT * FROM trucklot.xandertrucklot;");
			
			while (RES_SET.next()) {
				
				Trucks trucksInDB = new Trucks();
				
				trucksInDB.setTruckID(RES_SET.getInt("truck_id"));
				trucksInDB.setDriver(RES_SET.getString("driver"));
				trucksInDB.setTruckMake(RES_SET.getString("truck_make"));
				trucksInDB.setTruckModel(RES_SET.getString("truck_model"));
				trucksInDB.setTruckFuel(RES_SET.getDouble("truck_fuel"));
				
				xanderLot.add(trucksInDB);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} // End readToDB method
	
	
	public static void writeToDB(Trucks trucks) {
		
		Trucks truckToAdd = new Trucks();
		
		truckToAdd = trucks;
		
		try {
			
			connToDB();
			
			PREP_STMT = CONN.prepareStatement(insertIntoTable);
			
			PREP_STMT.setString(1, truckToAdd.getDriver());
			PREP_STMT.setString(2, truckToAdd.getTruckMake());
			PREP_STMT.setString(3, truckToAdd.getTruckModel());
			PREP_STMT.setDouble(4, truckToAdd.getTruckFuel());
			
			PREP_STMT.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} // End writeToDB method
	
	
	public static String insertIntoTable = "INSERT INTO `trucklot`.`xandertrucklot`"
			+ "(driver, truck_make, truck_model, truck_Fuel)"
			+ " VALUES "
			+ "(?, ?, ?, ?)";
	
	
	public static void updateDB (Trucks trucksToUpdate) {
		
		connToDB();
		
		try {
			PREP_STMT = CONN.prepareStatement(updateTheDb);
			
			PREP_STMT.setInt(1, trucksToUpdate.getTruckID());
			
			PREP_STMT.setString(2, trucksToUpdate.getDriver());
			PREP_STMT.setString(3, trucksToUpdate.getTruckMake());
			PREP_STMT.setString(4, trucksToUpdate.getTruckModel());
			PREP_STMT.setDouble(5, trucksToUpdate.getTruckFuel());
			PREP_STMT.setInt(6, trucksToUpdate.getTruckID());
			
			PREP_STMT.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static String updateTheDb = "UPDATE `trucklot`.`xandertrucklot` SET truck_id=?, driver=?,"
	+ "truck_make=?, truck_model=?, truck_fuel=? WHERE truck_id=?";
	
	
	public static void deleteFromDB (int truckID) {
		
		connToDB();
		
		try {
			
			PREP_STMT = CONN.prepareStatement(delFromTable);
			PREP_STMT.setInt(1, truckID);
			
			PREP_STMT.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} // End deleteFromDB Method
	
	public static String delFromTable = "DELETE FROM `trucklot`.`xandertrucklot` WHERE truck_id=?";
	
	
} // End Class Method
