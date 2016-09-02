package com.week5mainproject;

import java.util.Scanner;

public class TruckLotMain {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		boolean loopTheMenu = false;
		
		System.out.println("Welcome to the Truck Lot Information System.");
		
		do {
			System.out.println("Press 1 to VIEW the database. \n" +
					"Press 2 to ADD to the database. \n" +
					"Press 3 to DELETE from the database. \n" +
					"Press 4 to UPDATE the database.");
			String userMenuInput = scan.nextLine();
			
			switch(userMenuInput) {
			case "1":
				DAO.readFromDB();
				break;
			case "2":
//				DAO.writeToDB(Trucks trucks);
//				break;
//			case "3":
//				DAO.updateDB();
//				break;
//			case "4":
//				DAO.deleteFromDB();
//			
			default:
				System.out.println("Invalid option. PLease try again. \n\n");
				loopTheMenu = true;
				break;
			}
		} while (loopTheMenu);
		scan.close();
	}

}