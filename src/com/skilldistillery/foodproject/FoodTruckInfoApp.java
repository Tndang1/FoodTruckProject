package com.skilldistillery.foodproject;

import java.util.Scanner;

public class FoodTruckInfoApp {
	private int numOfTrucks = 0;
	
	
	public static void main(String[] args) {
		FoodTruckInfoApp foodTrucks = new FoodTruckInfoApp();
		FoodTruck[] trucks = new FoodTruck[5];
		Scanner kb = new Scanner(System.in);

		foodTrucks.printMenu(kb, trucks);

	}

	private void addTruck(Scanner kb, FoodTruck[] trucks) {
		if (numOfTrucks < 5) {
			System.out.println("What is the name of the truck?");
			String name = kb.next();
			System.out.println("What kind of food does it serve?");
			String food = kb.next();
			System.out.println("How would you rate it?");
			int rate = kb.nextInt();
			trucks[numOfTrucks] = new FoodTruck(numOfTrucks, name, food, rate);
			numOfTrucks++;
		} else {
			System.out.println("The truck list is full.");
		}
	}

	private void averageTrucks(FoodTruck[] trucks) {
		// TODO Auto-generated method stub
		double counter = 0;
		double total = 0.0;
		for (FoodTruck foodTruck : trucks) {
			if (foodTruck != null) {
				total += foodTruck.getRating();
				counter++;
			}
		}
		total /= counter;
		System.out.println("The average rating of all entered trucks is " + total);

	}

	private void highestTruck(FoodTruck[] trucks) {
		// TODO Auto-generated method stub
		double highest = 0;
		FoodTruck ultimate = new FoodTruck();
		for (FoodTruck foodTruck : trucks) {
			if (foodTruck != null) {
				if (highest < foodTruck.getRating()) {
					highest = foodTruck.getRating();
					ultimate = foodTruck;
				}
			} else {
				break;
			}
		}
		if (ultimate != null) {
			System.out.println("The highest rated truck is " + (ultimate.getTruckID() + 1) + ": " + ultimate.getName()
					+ " serves " + ultimate.getFoodType() + " and has a rating of " + ultimate.getRating());
		}
	}

	private void listTrucks(FoodTruck[] trucks) {
		for (FoodTruck foodTruck : trucks) {
			if (foodTruck != null) {
				System.out.println(foodTruck.toString());
			}
		}
	}

	private void printMenu(Scanner kb, FoodTruck[] trucks) {
		boolean run = true;
		while (run) {
			System.out.println("What would you like to do?");
			System.out.println("1: Add trucks");
			System.out.println("2: Average trucks");
			System.out.println("3: Show highest scoring trucks");
			System.out.println("4: Show all trucks");
			System.out.println("5: Quit");
			int selection = kb.nextInt();
			switch (selection) {
			case 1:
				boolean addAnother = true;
				while (addAnother && numOfTrucks < 5) {
					addTruck(kb, trucks);
					System.out.println("Enter \"Quit\" to stop entering trucks, or \"Continue\" to add another.");
					String quit = kb.next().toLowerCase();
					if (quit.contentEquals("quit")) {
						addAnother = false;
					} else if (numOfTrucks >= 5) {
						System.out.println("Max number of trucks entered!");
						addAnother = false;
					}
				}
				break;
			case 2:
				averageTrucks(trucks);
				break;
			case 3:
				highestTruck(trucks);
				break;
			case 4:
				listTrucks(trucks);
				break;
			case 5:
				run = false;
				System.out.println("Ok fine, bye.");
				System.out.println(numOfTrucks);
				break;
			default:
				System.out.println("That wasn't a valid option. It's okay though, we all make happy little mistakes sometimes.");
			}

		}

	}

}
