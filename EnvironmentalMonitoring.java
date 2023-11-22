package main.java;

public class EnvironmentalMonitoring implements Runnable {
    public void run() {
        // Implement environmental monitoring logic
        // Monitor air quality, noise levels, temperature, etc.
    	
    	Sensor airSensor = new Sensor("Air Quality");
    	Sensor noiseSensor = new Sensor("Noise Level");
    	Sensor tempSensor = new Sensor("Temperature");
    	//Sensor brightSensor = new Sensor("Brightness");
    	
    	System.out.println("\nSensors Info: ");
    	airSensor.measure();
    	noiseSensor.measure();
    	tempSensor.measure();
    	//brightSensor.measure();
    }
}

