package main.java;

import java.util.Random;

public class Vehicle {
	
	private String vehicleType;
	private String registrationNumber;
	private double currentSpeed;
	
	static Random random = new Random();

	public Vehicle(String vehicleType, String registrationNumber) {
		// to do
		this.vehicleType = vehicleType;
		this.registrationNumber = registrationNumber;
		this.currentSpeed = random.nextDouble() * 50;
	}

	public void accelerate(double speedIncrease) {
		// to do
		double maxSpeed = 50;
		//speedIncrease = random.nextDouble() *50;
		if (getCurrentSpeed() >= maxSpeed) {
			currentSpeed = maxSpeed;
			System.out.println("\nMaximun speed reached. Not possible to accelerate");
		} else if ((getCurrentSpeed() + speedIncrease) < maxSpeed) {
			currentSpeed += speedIncrease;
			//System.out.println("\n" + vehicleType +" acceleraing " + speedIncrease + "Km/h\nCurrent Speed: "
					//+ currentSpeed + "Km/h");
		}
	}

	public void brake(double speedDecrease) {
		// to do
		double minSpeed = 0.0;
		//speedDecrease = random.nextDouble() *50;
		if (getCurrentSpeed() == minSpeed) {
			System.out.println("\nVehicle is not moving. Not possible to decrease speed.");
		} else if((getCurrentSpeed() - speedDecrease) > minSpeed) {
			currentSpeed -= speedDecrease;
			//System.out.println(
					//"\n" + vehicleType + " braking " + speedDecrease + "km/h\nCurrent Speed: " + currentSpeed + "Km/h");
		}
	}

	public double getCurrentSpeed() {
		return currentSpeed;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	@Override
	public String toString() {
		// to do
		return "\nVehicle Type: " + vehicleType + "\nRegistration Number: " + registrationNumber;
	}
}
