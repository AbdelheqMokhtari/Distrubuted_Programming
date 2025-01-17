package com.example.rentalService.web;

public class Car {
    private String make;
    private String brand;
    private String plateNumber;
    private boolean rented;

        // Constructor
        public Car(String make, String brand,  String plateNumber, boolean rented) {
            this.make = make;
            this.brand = brand;
            this.plateNumber = plateNumber;
            this.rented = rented;
    }

    // Getters and Setters
    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getbrand() {
        return brand;
    }

    public void setbrand(String model) {
        this.brand = model;
    }


    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public boolean isRented() {
        return rented;
    }

    public void setRented(boolean rented) {
        this.rented = rented;
    }
}