package com.example.rentalService.web;

import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class RentalWebService {

    Logger logger = LoggerFactory.getLogger(RentalWebService.class);
    private List<Car> cars = new ArrayList<>(List.of(
        new Car("Toyota", "Corolla", "ABC-123", false),
        new Car("Honda", "Civic", "XYZ-987", false),
        new Car("Ford", "Mustang", "LMN-456", false)
    ));

    @GetMapping("/bonjour")
    public String disBonjour() {
        return "Bonjour !";
    }

    @GetMapping("/cars")
    public List<Car> get_cars() {
        return cars;
    }

    @GetMapping(value = "/cars/{plateNumber}")
    public ResponseEntity<Car> get_cars(@PathVariable("plateNumber") String plateNumber) {
        // Search for the car with the matching plate number
        for (Car car : cars) {
            if (car.getPlateNumber().equals(plateNumber)) {
                // Return the car details with HTTP status 200 OK
                return ResponseEntity.ok(car);
            }
        }
        // If no car is found, return 404 Not Found
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PostMapping(value = "/cars")
    public ResponseEntity<String> addCar(@RequestBody Car newCar) {
        // Check if the car with the same plate number already exists
        for (Car car : cars) {
            if (car.getPlateNumber().equals(newCar.getPlateNumber())) {
                String message = "Car with plate number " + newCar.getPlateNumber() + " already exists.";
                logger.warn(message);
                return ResponseEntity.status(HttpStatus.CONFLICT).body(message);
            }
        }

        // Add the new car to the list
        cars.add(newCar);
        logger.info("Car added successfully: " + newCar);
        return ResponseEntity.status(HttpStatus.CREATED).body("Car added successfully.");
    }

    @PutMapping(value = "/cars/{plateNumber}")
    public ResponseEntity<String> rent(
            @PathVariable("plateNumber") String plateNumber,
            @RequestParam(value = "rent", required = true) boolean rent,
            @RequestBody Dates dates) {

        logger.info("===========================================================");
        logger.info("PlateNumber: " + plateNumber);
        logger.info("Rent: " + rent);
        logger.info("Dates: " + dates);
        logger.info("===========================================================");

        // Search for the car with the given plate number
        for (Car car : cars) {
            if (car.getPlateNumber().equals(plateNumber)) {
                // Update the rental status of the car
                if (rent && !car.isRented()) {
                    car.setRented(true); // Rent the car
                    logger.info("Car rented successfully.");
                    return ResponseEntity.ok("Car rented successfully from " 
                        + dates.getBegin() + " to " + dates.getEnd());
                } else if (!rent && car.isRented()) {
                    car.setRented(false); // Return the car
                    logger.info("Car returned successfully.");
                    return ResponseEntity.ok("Car returned successfully.");
                } else {
                    String message = rent ? "Car is already rented." : "Car is not currently rented.";
                    logger.warn(message);
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
                }
            }
        }

        // If no car is found with the given plate number, return 404
        String errorMessage = "Car with plate number " + plateNumber + " not found.";
        logger.error(errorMessage);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
    }
}
