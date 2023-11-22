package main.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class TrafficManagement implements Runnable {
	private List<Vehicle> vehicles;

	public TrafficManagement() {
		this.vehicles = new ArrayList<>();
	}

	/*
	 * Sensor brightSensor = new Sensor("Brightness"); Sensor noiseSensor = new
	 * Sensor("Noise Level"); Sensor airSensor = new Sensor("Air Quality"); Sensor
	 * tempSensor = new Sensor("Temperature");
	 */

	public void run() {
		// Read traffic data from CSV
		readTrafficData();
		// Implement traffic management logic using collections

		simulateTraffic();
		// Handle exceptions for I/O operations
	}

	private void readTrafficData() {

		try {
			// getClass().getClassLoader() gets the ClassLoaser asociatted with the current
			// class
			// getResourceAsStream() looks for the file in the directory of the proyect
			// this is store in a InputStream type varuable that represents the flow of the
			// bytes from the file
			InputStream inputStream = getClass().getClassLoader().getResourceAsStream("resources/traffic_data2.csv");

			// if inputStream is not null means it was found
			if (inputStream != null) {
				// from the inputStream we create a InputStreamReader to read the content from
				// bytes into characters
				InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
				// from the inputStreamReader we create a BufferedReader that allows to read all
				// the line of the file
				BufferedReader br = new BufferedReader(inputStreamReader);
				String line;

				while ((line = br.readLine()) != null) {
					String[] data = line.split(",");
					if (data.length >= 2) {
						String vehicleType = data[0];
						String registrationNumber = data[1];
						Vehicle vehicle = new Vehicle(vehicleType, registrationNumber);
						vehicles.add(vehicle);
						// System.out.println("Vehicle added to the list");
					} else {
						System.out.println("Invalid line format: " + line);
					}
				}
				br.close();
			} else {
				System.out.println("File not found");
			}

		} catch (IOException e) {
			System.out.println("File couldn't be read. Error reading traffic data: " + e.getMessage());
		}

	}

	private void simulateTraffic() {
		Random random = new Random();
		//create a list of vehicle indexes
		List<Integer> vehicleIndexes = new ArrayList<>();
		
		for(int i = 0; i< vehicles.size(); i++) {
			vehicleIndexes.add(i);
		}
		
		//Collections.shuffle uses the list of vehicle indexes and mix them in a random way
		Collections.shuffle(vehicleIndexes, random);
		
		for (int time = 0; time < 6; time++) {

			for (int i = 0; i < vehicleIndexes.size(); i++) {
				int vehicleIndex = vehicleIndexes.get(i);
				Vehicle vehicle = vehicles.get(vehicleIndex);
				
				//Simulate vehicles apearing
				System.out.println("\nVehicle Type: " + vehicle.getVehicleType() + " " + (i + 1)
						+ "\nRegistration Number: " + vehicle.getRegistrationNumber() + "\nCurrent Speed: "
						+ vehicle.getCurrentSpeed() + " Km/h");
				
				try {
					Thread.sleep(15000);
				} catch (InterruptedException e) {

					e.printStackTrace();
				}
				
				//Simulate vehicles accelerating
				double randomAccelerateSpeed = random.nextDouble() * 50;
				vehicle.accelerate(randomAccelerateSpeed);
				System.out.println("\n" + vehicle.getVehicleType() + " " + (i + 1) +" accelerating " + randomAccelerateSpeed + " Km/h\nCurrent Speed: "
						+ vehicle.getCurrentSpeed() + " Km/h");
				
				try {
					Thread.sleep(15000);
				} catch (InterruptedException e) {

					e.printStackTrace();
				}
				
				//Simulate vehicles braking
				double randomBrakingSpeed = random.nextDouble() * 20;
				vehicle.brake(randomBrakingSpeed);
				System.out.println("\n" + vehicle.getVehicleType() + " " + (i + 1) + " braking " + randomBrakingSpeed + " Km/h\nCurrent Speed: "
						+ vehicle.getCurrentSpeed() + " Km/h");
			

			}
			//mix them again for the next itiration
			Collections.shuffle(vehicleIndexes, random);
			
			//simulates a pausa between itirations
			try {
				Thread.sleep(15000);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}

	}
}
