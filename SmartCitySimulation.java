package main.java;

public class SmartCitySimulation {
    public static void main(String[] args) {
    	
        TrafficManagement trafficManagement = new TrafficManagement();
        SmartLighting smartLighting = new SmartLighting();
        EnvironmentalMonitoring environmentalMonitoring = new EnvironmentalMonitoring();

        // Start simulation components using multithreading
        Thread trafficThread = new Thread(() -> {
        	try {
        	trafficManagement.run();
        	}catch(Exception e) {
        		System.out.println("Error in TrafficManagement: " + e.getMessage());
        	}
        });
        
        Thread lightingThread = new Thread(()->{
        	try {
        		smartLighting.run();
        	}catch(Exception e) {
        		System.out.println("Error in SmartLighting: " + e.getMessage());
        	}
        });
        
        Thread monitoringThread = new Thread(() -> {
        	try {
        	environmentalMonitoring.run();
        	}catch(Exception e) {
        		System.out.println("Error in EnvironmentalMonitoring: " + e.getMessage());
        	}
        	});

        trafficThread.start();
        lightingThread.start();
        monitoringThread.start();

        // Add exception handling for each component
        try {
            trafficThread.join();
            lightingThread.join();
            monitoringThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


