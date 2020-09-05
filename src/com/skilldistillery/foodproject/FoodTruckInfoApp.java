package com.skilldistillery.foodproject;

import java.util.Scanner;

public class FoodTruckInfoApp {
	public static void main(String[] args) {
		FoodTruckInfoApp foodTrucks = new FoodTruckInfoApp();
		FoodTruck[] trucks = new FoodTruck[5];
		Scanner kb = new Scanner(System.in);
		
		foodTrucks.printMenu(kb, trucks);
	
	
	}

	private void addTruck(Scanner kb, FoodTruck[] trucks) {
		int counter = 0;
		trucks[counter] = new FoodTruck();
		trucks[counter].setTruckID(counter);
		if (counter < 5) {
		System.out.println("What is the name of the truck?");
		trucks[counter].setName(kb.nextLine());
		System.out.println("What kind of food does it serve?");
		trucks[counter].setFoodType(kb.nextLine());
		System.out.println("How would you rate it?");
		trucks[counter].setRating(kb.nextDouble());
		counter++;
		} else {
			System.out.println("The truck list is full.");
		}
		
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
				System.out.println(foodTruck.getName() + " serves " + 
			foodTruck.getFoodType() + " and has a rating of " + foodTruck.getRating());
			}
		}
	}

	private void printMenu(Scanner kb, FoodTruck[] trucks) {
		boolean run = true;
		while (run) {
			System.out.println("What would you like to do?\nadd");
			int selection = kb.nextInt();
			switch (selection) {
			case 1: addTruck(kb, trucks);
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
