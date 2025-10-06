package com.pluralsight;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    //Array of Vehicles
    private static Vehicle[] inventory = new Vehicle[20];
    private static int quantityOfVehicle;

    public static void main(String[] args) {

        inventory[0] = new Vehicle(101121,"Ford Explorer","Red",45000,13500);
        inventory[1] = new Vehicle(101122,"Toyota Camry","Blue",60000,11000);
        inventory[2] = new Vehicle(101123,"Chevrolet Malibu","Black",50000,9700);
        inventory[3] = new Vehicle(101124,"Honda Civic","White",70000,7500);
        inventory[4] = new Vehicle(101125,"Subaru Outback","Green",55000,14500);
        inventory[5] = new Vehicle(101126,"Jeep Wrangler","Yellow",30000,16000);

        quantityOfVehicle = 9;

        int command;


        while(true){

            System.out.println("What do you want to do?");
            System.out.println("  1 - List all vehicles");
            System.out.println("  2 - Search by make/model");
            System.out.println("  3 - Search by price range");
            System.out.println("  4 - Search by color");
            System.out.println("  5 - Add a vehicle");
            System.out.println("  6 - Quit");

            command = Inputcollector.promptForInt("enter your command");

            switch(command) {
                case 1:
                    listAllVehicles();
                    break;
                case 2:
                    findVehiclesByMakeModel();
                    break;
                case 3:
                    findVehiclesByPrice();
                    break;
                case 4:
                    findVehiclesByColor();
                    break;
                case 5:
                    addAVehicle();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Invalid command - please choose valid command.");
                    break;
            }
        }
    }


    private static void findVehiclesByColor() {
        String colorToSearch = Inputcollector.promptForString("Please enter color to search for");
        for (Vehicle car : inventory){
            if(car == null ){
                continue;
            }if(car.getColor().equalsIgnoreCase(colorToSearch)){
                displayVehicle(car);
            }
        }
    }

    private static void findVehiclesByMakeModel() {
        //prompt for what we want to search
        String makeModelToSearch = Inputcollector.promptForString("Please enter make/model to search for: ");
        System.out.println("Finding Vehicle by Make/Model... ");
        for ( Vehicle car : inventory){
            if (car == null){
                continue;
            }if (car.getMakeModel().toLowerCase().contains(makeModelToSearch.toLowerCase())){
                displayVehicle(car);
            }
        }
    }

    public static void displayVehicle(Vehicle car){
        System.out.println(car.getVehicleID() + " " + car.getColor() + " " + car.getMakeModel());

    }

    private static void listAllVehicles() {

        System.out.print("Listing all vehicles...");
        System.out.println();
        for(Vehicle car : inventory ){
            if (car == null){
                continue;
            }displayVehicle(car);
        }
    }

    private static void findVehiclesByPrice() {
        float priceToSearch = Inputcollector.promptForFloat("Please enter price to search for");
        for ( Vehicle car : inventory ){
            if (car == null){
                continue;
            }if (car.getPrice() >= priceToSearch){  // Find cars at or below this price range
                displayVehicle(car);
            }
        }

    }

    private static void addAVehicle() {

        long vehicleID = Inputcollector.promptForLong("What is the vehicle ID");
        String makeModel = Inputcollector.promptForString("What is the make and model");
        String color = Inputcollector.promptForString("What is the vehicle color");
        int odometerReading = Inputcollector.promptForInt("What is the Mileage on the vehicle");
        float price = Inputcollector.promptForFloat("What is the cost of the Vehicle");

        Vehicle newVehicle = new Vehicle(vehicleID, makeModel, color,odometerReading,price);
        inventory[quantityOfVehicle]= newVehicle;
        quantityOfVehicle++;


    }
}


