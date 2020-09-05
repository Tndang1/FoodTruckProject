package com.skilldistillery.foodproject;

public class FoodTruck {
	private int truckID;
	private String foodType;
	private double rating;
	private String name;
	
	
	public FoodTruck(int truckID, String name, String foodType, double rating) {
		this.truckID = truckID;
		this.name = name;
		this.foodType = foodType;
		this.rating = rating;
	}
	
	public FoodTruck() {
		
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
