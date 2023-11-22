package main.java;

import java.time.LocalTime;

public class SmartLighting implements Runnable {

	static Sensor brightSensor = new Sensor("Brightness");
	static boolean lightsOn = false;

	public void run() {
		// Implement smart lighting logic
		// Adjust street light brightness based on time and sensor data

		lights();
	}

	static boolean nightOrDay() {

		LocalTime localTime = LocalTime.now();
		int hour = localTime.getHour();
		System.out.println("\nLights Info: ");
		if ((hour >= 16 || hour <= 6)) {
			System.out.println(hour + "h - Night Time");
			return true;
		} else {
			System.out.println(hour + "h - Day time Time");
			return false;
		}
	}

	static void lights() {

		boolean isNight = nightOrDay();
		brightSensor.measure();
		if (!isNight) {
			lightsOn = true;
			System.out.println("Lights are on");
		} else if(isNight) {
			lightsOn = true;
			System.out.println("Lights are on");
		} else {
			lightsOn = false;
			System.out.println("Lights are off");
		}
	}

}
