import java.util.ArrayList;
import java.util.Scanner;

public class Driver {

    public static void main(String[] args) {

        // Instance variables
    	ArrayList<Dog> dogList = new ArrayList<Dog>();          // ArrayList for dogs
    	ArrayList<Monkey> monkeyList = new ArrayList<Monkey>(); // ArrayList for monkeys
    	Scanner scnr = new Scanner(System.in);
    	char selectOperation;                                   // char to select desired operation
    	String animalType;                                      // user desired animal type
    	String userCountry;                     
    	boolean reservationStatus = false;                      // variable to check reservation status



        // Dog and monkey objects initialized with only a few values to test the method
        // Create New Dog
    	Dog Kira = new Dog();
    	Kira.setName("Kira");
    	Kira.setType("dog");
    	Kira.setInServiceCountry("South Korea");
    	Kira.setReserved(false);
    	dogList.add(Kira);
    	
    	Dog Shana = new Dog();
    	Shana.setName("Shana");
    	Shana.setType("dog");
    	Shana.setInServiceCountry("Japan");
    	Shana.setReserved(false);
    	dogList.add(Shana);

        // Create New Monkey
    	Monkey Paul = new Monkey();
    	Paul.setName("Chunky");
    	Paul.setType("monkey");
    	Paul.setInServiceCountry("Greece");
    	Paul.setReserved(false);
    	monkeyList.add(Paul);
    	
    	Monkey George = new Monkey();
    	George.setName("George");
    	George.setType("monkey");
    	George.setInServiceCountry("Madagascar");
    	George.setReserved(false);
    	monkeyList.add(George);
    	
    	
    
    	// If statement to select the desired operation
    	System.out.println("Select desired operation: (a)Process new request, "
    			                                   + "(b)Update animals information, "
    			                                   + "(c)Display animals location and status, "
    			                                   + "(d)Add new animals , "
    			                                   + "(e)Process animals transfer, "
    			                                   + "(f)Display in-service animals, "
    			                                   + "(g)Process animals death/retirement.");
    	selectOperation = scnr.nextLine().charAt(0);
    	
    			                                                                       
    	// Method to process request for a rescue animal
    	if (selectOperation == 'a') {
    	System.out.println("Enter requested type of animal: (dog or monkey)");
    	animalType = scnr.nextLine();
    	System.out.println("Enter user country:");
    	userCountry = scnr.nextLine();
    	
    	if (animalType.equals("dog")) {
    		// For loop to check if a dog is available
    		for(Dog str: dogList){
    			if (str.getInServiceCountry().equals(userCountry) && (str.getReserved() == false)) {
    				str.setReserved(true);
    				reservationStatus = true;
    				System.out.println("Dog successfully reserved. Dog name: " + str.getName());
    			}
    			break; // Stop the loop once one available dog is found
    		}
    		// If statement that print a message if no dogs are available
    		if (reservationStatus == false) {
    			System.out.println("No dogs currently available.");
    		}	
    	}
    	
    	if (animalType.equals("monkey")) {
    		// For loop to check if a monkey is available
    		for(Monkey str: monkeyList){
    			if (str.getInServiceCountry().equals(userCountry) && (str.getReserved() == false)) {
    				str.setReserved(true);
    				reservationStatus = true;
    				System.out.println("Monkey successfully reserved. Monkey name: " + str.getName());
    			}
    			break; // Stop the loop once one available monkey is found
    		}
    		// If statement that print a message if no monkeys are available
    		if (reservationStatus == false) {
    			System.out.println("No monkeys currently available.");
    		}	
    	}
    	scnr.close();
    	}
    	else if (selectOperation == 'b') {
    		// Method(s) to update information on existing animals
    		System.out.println("FIX ME");
    	}
    	else if (selectOperation == 'c') {
    		// Method to display matrix of animals based on location and status/training phase
        	System.out.println("FIX ME");
        }
    	else if (selectOperation == 'd') {
    		// Method to add animals
    		System.out.println("FIX ME");
    	}
    	else if (selectOperation == 'e') {
    		 // Method to out process animals for the farm or in-service placement
    		System.out.println("FIX ME");	
    	}
    	else if (selectOperation == 'f') {
    		// Method to display in-service animals
    		System.out.println("FIX ME");
    	}
    	else if (selectOperation == 'g') {
    		// Process reports from in-service agencies reporting death/retirement
    		System.out.println("FIX ME");
    	}


    }
}
