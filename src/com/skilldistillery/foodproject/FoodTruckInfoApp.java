package com.skilldistillery.foodproject;

import java.util.Scanner;

public class FoodTruckInfoApp {
	public static void main(String[] args) {
		FoodTruckInfoApp foodTrucks = new FoodTruckInfoApp();
		FoodTruck[] trucks = new FoodTruck[5];
		int numOfTrucks = 0;
		Scanner kb = new Scanner(System.in);
		
		foodTrucks.printMenu(kb, trucks, numOfTrucks);
	
	
	}

	private int addTruck(Scanner kb, FoodTruck[] trucks, int numOfTrucks) {
		if (numOfTrucks < 5) {
		trucks[numOfTrucks] = new FoodTruck();
		trucks[numOfTrucks].setTruckID(numOfTrucks);
		System.out.println("What is the name of the truck?");
		trucks[numOfTrucks].setName(kb.next());
		System.out.println("What kind of food does it serve?");
		trucks[numOfTrucks].setFoodType(kb.next());
		System.out.println("How would you rate it?");
		trucks[numOfTrucks].setRating(kb.nextDouble());
		numOfTrucks++;
		} else {
			System.out.println("The truck list is full.");
		}
		return numOfTrucks;
	}

	private void averageTrucks() {
		// TODO Auto-generated method stub
		
	}

	private void highestTruck() {
		// TODO Auto-generated method stub
		
	}

	private void listTrucks(FoodTruck[] trucks) {
		for (FoodTruck foodTruck : trucks) {
			if (foodTruck != null){
				System.out.println(foodTruck.getTruckID()+1 +": " + foodTruck.getName() + " serves " + 
			foodTruck.getFoodType() + " and has a rating of " + foodTruck.getRating());
			}
		}
	}

	private void printMenu(Scanner kb, FoodTruck[] trucks, int numOfTrucks) {
		boolean run = true;
		while (run) {
			System.out.println("What would you like to do?\n1 = add");
			int selection = kb.nextInt();
			switch (selection) {
			case 1: numOfTrucks = addTruck(kb, trucks, numOfTrucks);
			break;
			case 2:
				averageTrucks();
				break;
			case 3:
				highestTruck();
				break;
			case 4:
				listTrucks(trucks);
				break;
			case 5:
				run = false;
				default:
					System.out.println("Please consider using a spell checker.");
			}
			
		}
		
	}
	
	

}
