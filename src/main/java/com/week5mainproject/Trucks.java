package com.week5mainproject;

public class Trucks {
	
	private int truckID = 0;
	private String driver = null;
	private String truckMake = null;
	private String truckModel = null;
	private double truckFuel = 0.0d;
	
	public Trucks(int truckID, String driver, String truckMake, String truckModel, double truckFuel) {
		super();
		this.truckID = truckID;
		this.driver = driver;
		this.truckMake = truckMake;
		this.truckModel = truckModel;
		this.truckFuel = truckFuel;
	}
	

	public Trucks() {
		super();
	}


	public int getTruckID() {
		return truckID;
	}

	public void setTruckID(int truckID) {
		this.truckID = truckID;
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getTruckMake() {
		return truckMake;
	}

	public void setTruckMake(String truckMake) {
		this.truckMake = truckMake;
	}

	public String getTruckModel() {
		return truckModel;
	}

	public void setTruckModel(String truckModel) {
		this.truckModel = truckModel;
	}

	public double getTruckFuel() {
		return truckFuel;
	}

	public void setTruckFuel(double truckFuel) {
		this.truckFuel = truckFuel;
	}


	@Override
	public String toString() {
		return "Trucks [truckID=" + truckID + ", driver=" + driver + ", truckMake=" + truckMake + ", truckModel="
				+ truckModel + ", truckFuel=" + truckFuel + "]";
	}
	
	
}
