package com.skilldistillery.foodproject;

public class FoodTruck {
	private static int truckCount;
	private String foodType;
	private double rating;
	private String name;
	private int truckID;
	
	
	public FoodTruck(String name, String foodType, double rating) {
		this.truckID = truckCount;
		this.name = name;
		this.foodType = foodType;
		this.rating = rating;
		truckCount++; 
	}
	
	public FoodTruck() {
		
	}
	
	public String toString() {
		String info = getTruckID() + 1 + ": " + getName() + " serves "
				+ getFoodType() + " and has a rating of " + getRating();
		return info;
	}

	public int getTruckID() {
	return truckID;
	}
	
	public void setTruckID(int truckID) {
		this.truckID = truckID;
	}
	
	public String getFoodType() {
		return foodType;
	}
	
	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}
	
	public double getRating() {
		return rating;
	}
	
	public void setRating(double rating) {
		this.rating = rating;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}
