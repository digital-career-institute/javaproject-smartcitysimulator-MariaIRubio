package main.java;

import java.util.Random;

public class Sensor {
	private String sensorType;
	private double currentValue;

	public Sensor(String sensorType) {
		this.sensorType = sensorType;
		this.currentValue = 0.0;
	}

	public void measure() {
		// Simulate measuring data by generating random values
		Random rand = new Random();

		if ("Air Quality".equals(sensorType)) {
			currentValue = rand.nextDouble() * 100; // Random value between 0 and 100
			if (currentValue <= 50) {
				System.out.println("Air Quality is good: " + currentValue + " units");
			} else if (currentValue <= 101) {
				System.out.println("Air Quality is moderated: " + currentValue + " units");
			} else if (currentValue <= 150) {
				System.out.println("Air Quality is not good for sentitive Groups: " + currentValue + " units");
			} else if (currentValue <= 200) {
				System.out.println("Air Quality is bad: " + currentValue + " units");
			} else if (currentValue <= 300) {
				System.out.println("Air Quality is very bad: " + currentValue + " units");
			} else if (currentValue > 300) {
				System.out.println("Air Quality is dangerous: " + currentValue + " units");
			}
		} else if ("Noise Level".equals(sensorType)) {
			currentValue = rand.nextDouble() * 120; // Random value between 0 and 120 (in decibels)
			if (currentValue <= 65) {
				System.out.println("Noise Level is low: " + currentValue + " decibels");
			} else if (currentValue >= 80) {
				System.out.println("Noise Level is too high: " + currentValue + " decibels");
			}
		} else if ("Temperature".equals(sensorType)) {
			currentValue = rand.nextDouble() * 40 - 10; // Random value between -10 and 30 degrees Celsius
			if (currentValue <= 0) {
				System.out.println("Temperature is -0°." + currentValue + "°C");
			} else if (currentValue >= 40) {
				System.out.println("Temperature is over 40°." + currentValue + "°C");
			}
		} else if ("Brightness".equals(sensorType)) {
			// Random value between 0 and 1000 lux que determina la claridad
			if (SmartLighting.nightOrDay()) {
				currentValue = rand.nextDouble() * 50;
				System.out.println("It is too dark: " + currentValue + " lux");
				// System.out.println("It is night: " + currentValue + " lux");
			} else {
				currentValue = rand.nextDouble() * 1000;
				System.out.println("It is bright: " + currentValue + " lux");
			}
		}
	}

	public double getCurrentValue() {
		return currentValue;
	}

	public String getSensorType() {
		return sensorType;
	}

	public void setCurrentValue(double currentValue) {
		this.currentValue = currentValue;
	}

	@Override
	public String toString() {
		// to do
		return "\nSensor Type: " + sensorType + "\nCurrent Value: " + currentValue;
	}
}
