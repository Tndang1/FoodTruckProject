package com.skilldistillery.foodproject;

import java.util.Scanner;

public class FoodTruckInfoApp {
	private static int numOfTrucks = 0;

	public static void main(String[] args) {
		FoodTruckInfoApp foodTrucks = new FoodTruckInfoApp();
		FoodTruck[] trucks = new FoodTruck[5];
		Scanner kb = new Scanner(System.in);

		foodTrucks.printMenu(kb, trucks);
		kb.close();

	}

	private void addTruck(Scanner kb, FoodTruck[] trucks) {
		boolean run = true;
		while (run) {
			if (numOfTrucks >= 5) {
				System.out.println("The truck list is full.");
				run = false;
				break;
			} else {
				System.out.println("What is the name of the truck? (Enter \"Quit\" to quit.");
				String name = kb.next();
				if (name.toLowerCase().contentEquals("quit")) {
					run = false;
					break;
				}
				System.out.println("What kind of food does it serve?");
				String food = kb.next();
				System.out.println("How would you rate it?");
				int rate = kb.nextInt();
				trucks[numOfTrucks] = new FoodTruck(numOfTrucks, name, food, rate);
				numOfTrucks++;
			}
		}

	}

	private void averageTrucks(FoodTruck[] trucks) {
		double counter = 0;
		double total = 0.0;
		for (FoodTruck foodTruck : trucks) {
			if (foodTruck != null) {
				total += foodTruck.getRating();
				counter++;
			}
		}
		total /= counter;
		if(trucks[0] != null) {
		System.out.printf("The average rating of all entered trucks is %.2f\n", total);
		}

	}

	private void highestTruck(FoodTruck[] trucks) {
		double highest = 0;
		int counter = 0;
		FoodTruck[] sorter = new FoodTruck[numOfTrucks];
		FoodTruck[] ultimate = new FoodTruck[numOfTrucks];
		for (FoodTruck foodTruck : trucks) {
			if (foodTruck != null) {
				if (highest <= foodTruck.getRating()) {
					highest = foodTruck.getRating();
					sorter[counter] = foodTruck;
					counter++;
					continue;
				}
			} else {
				break;
			}
		}
		int reverseCounter = ultimate.length - 1;
		for (FoodTruck foodTruck : sorter) {
			if (foodTruck != null) {
				if (highest <= foodTruck.getRating()) {
					highest = foodTruck.getRating();
					ultimate[reverseCounter] = foodTruck;
					reverseCounter--;
					continue;
				}
			} else {
				break;
			}
		}
		
		if(ultimate.length > 0) {
		System.out.println("The highest rated truck(s):");
		listTrucks(ultimate);
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
			System.out.println("==================================");
			System.out.println("|     -What would you like?-     |");
			System.out.println("|  1: Add trucks to the list     |");
			System.out.println("|  2: Average truck score        |");
			System.out.println("|  3: Show highest rated trucks  |");
			System.out.println("|  4: Show all listed trucks     |");
			System.out.println("|  5: Quit the application       |");
			System.out.println("==================================");
			String selection = kb.next();
			switch (selection) {
			case "1":
				addTruck(kb, trucks);
				break;
			case "2":
				averageTrucks(trucks);
				break;
			case "3":
				highestTruck(trucks);
				break;
			case "4":
				listTrucks(trucks);
				break;
			case "5":
				run = false;
				System.out.println("Ok fine, bye.");
				break;
			default:
				System.out.println(
						"That wasn't a valid option. It's okay though, we all make happy little mistakes sometimes.");
			}

		}

	}

}
