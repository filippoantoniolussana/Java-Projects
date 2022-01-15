import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Driver {

    // instance variables (add more as needed)
    private static ArrayList<Ship> shipList = new ArrayList();
    private static ArrayList<Cruise> cruiseList = new ArrayList();
    private static ArrayList<Passenger> passengerList = new ArrayList();


    public static void main(String[] args) {
    	
    	Scanner scnr = new Scanner(System.in);
    	char menuSelection = 's';

        initializeShipList();       // initial ships
        initializeCruiseList();     // initial cruises
        initializePassengerList();  // initial passengers
        

        // Display the system menu until 'x' is entered
        while (menuSelection != 'x') {
        	 
        	// Call the method to display the system menu
        	 displayMenu();
        	 menuSelection = scnr.next().charAt(0);
        	 
        	// Map a method to each menu selection
        	if (menuSelection == '1') {
        		addShip();
        	} else if (menuSelection == '2') {
        		editShip();
        	} else if (menuSelection == '3') {
        		addCruise();
        	} else if (menuSelection == '4') {
        		editCruise();
        	} else if (menuSelection == '5') {
        		addPassenger();
        	} else if (menuSelection == '6') {
        		editPassenger();
        	} else if (menuSelection == 'A') {
        		printShipList("name");
        	} else if (menuSelection == 'B') {
        		printShipList("active");
        	} else if (menuSelection == 'C') {
        		printShipList("full");
        	} else if (menuSelection == 'D') {
        		printCruiseList("list");
        	} else if (menuSelection == 'E') {
        		printCruiseList("details");
        	} else if (menuSelection == 'F') {
        		printPassengerList();
        	} else if (menuSelection == 'x') {
        		System.out.println("Exited from system menu...");
        		break; 
        	} else {
        		// Display a message if there are no options available for the entered menu selection
        		System.out.println("No option available for menu selection [" + menuSelection + "]. Please try again!");
        	}
        	
        }
        	
     }
     

    // hardcoded ship data for testing
    // Initialize ship list
    public static void initializeShipList() {
        add("Candy Cane", 20, 40, 10, 60, true);
        add("Peppermint Stick", 10, 20, 5, 40, true);
        add("Bon Bon", 12, 18, 2, 24, false);
        add("Candy Corn", 12, 18, 2, 24, false);
        add("Royal Caribbean", 12, 18, 2, 24, true);
    }

    // hardcoded cruise data for testing
    // Initialize cruise list
    public static void initializeCruiseList() {
        Cruise newCruise = new Cruise("Southern Swirl", "Candy Cane", "Miami", "Cuba", "Miami");
        Cruise newCruise2 = new Cruise("Italian Holiday", "Peppermint Stick", "New Jersey", "Venice", "New Jersey");
        cruiseList.add(newCruise);
        cruiseList.add(newCruise2);
    }

    // hardcoded cruise data for testing
    // Initialize passenger list
    public static void initializePassengerList() {
        Passenger newPassenger1 = new Passenger("Neo Anderson", "Southern Swirl", "STE");
        passengerList.add(newPassenger1);

        Passenger newPassenger2 = new Passenger("Trinity", "Southern Swirl", "STE");
        passengerList.add(newPassenger2);

        Passenger newPassenger3 = new Passenger("Morpheus", "Southern Swirl", "BAL");
        passengerList.add(newPassenger3);
    }

    // custom method to add ships to the shipList ArrayList
    public static void add(String tName, int tBalcony, int tOceanView,
                           int tSuite, int tInterior, boolean tInService) {
        Ship newShip = new Ship(tName, tBalcony, tOceanView, tSuite, tInterior, tInService);
        shipList.add(newShip);
    }


    public static void printShipList(String listType) {
        // printShipList() method prints list of ships from the
        // shipList ArrayList. There are three different outputs
        // based on the listType String parameter:
        // name - prints a list of ship names only
        // active - prints a list of ship names that are "in service"
        // full - prints tabbed data on all ships

        if (shipList.size() < 1) {
            System.out.println("\nThere are no ships to print.");
            return;
        }
        if (listType == "name") {
            System.out.println("\n\nSHIP LIST - Name");
            for (int i = 0; i < shipList.size(); i++) {
                System.out.println(shipList.get(i));
            }
            
        } else if (listType == "active") {
            System.out.println("\n\nSHIP LIST - Active");
            
            // Display a message if there are no ships in the shipList array
            if (shipList.size() < 1) {
                System.out.println("\nThere are no ships to print.");  
            } else {
            	// For loop to find and display all the in service ships
            	for (Ship ships: shipList) {
              	  if (ships.getInService()  == true) {
            		  System.out.println(ships);
            	  }
            	}
        	}
 
        } else if (listType == "full") {
            System.out.println("\n\nSHIP LIST - Full");
            System.out.println("-----------------------------------------------");
            System.out.println("                    Number of Rooms     In");
            System.out.print("SHIP NAME           Bal OV  Ste Int     Service");
            System.out.println("\n-----------------------------------------------");
            for (Ship eachShip: shipList)
                eachShip.printShipData();

        } else
            System.out.println("\n\nError: List type not defined.");
    }

    public static void printCruiseList(String listType) {
        if (cruiseList.size() < 1) {
            System.out.println("\nThere are no cruises to print.");
            return;
        }
        if (listType == "list") {
            System.out.println("\n\nCRUISE LIST");
            for (int i=0; i < cruiseList.size(); i++) {
                System.out.println(cruiseList.get(i));
            }
        } else if (listType == "details") {
            System.out.println("\n\nCRUISE LIST - Details");
            System.out.println("------------------------------------------------------------------------------------------");
            System.out.println("                                      |----------------------PORTS-----------------------|");
            System.out.print("CRUISE NAME         SHIP NAME           DEPARTURE           DESTINATION         RETURN");
            System.out.println("\n-----------------------------------------------------------------------------------------");
            for (Cruise eachCruise: cruiseList)
                eachCruise.printCruiseDetails();
        } else
            System.out.println("\n\nError: List type not defined.");
    }

    public static void printPassengerList() {
        if (passengerList.size() < 1) {
            System.out.println("\nThere are no passengers to print.");
            return;
        }
        System.out.println("\n\nPASSENGER LIST");
        System.out.println("-----------------------------------------------------");
        System.out.print("PASSENGER NAME      CRUISE              ROOM TYPE");
        System.out.println("\n-----------------------------------------------------");
        for (Passenger eachPassenger: passengerList)
            eachPassenger.printPassenger();
    }

    // display text-based menu
    public static void displayMenu() {

        System.out.println("\n\n");
        System.out.println("\t\t\tLuxury Ocean Cruise Outings");
        System.out.println("\t\t\t\t\tSystem Menu\n");
        System.out.println("[1] Add Ship            [A] Print Ship Names");
        System.out.println("[2] Edit Ship           [B] Print Ship In Service List");
        System.out.println("[3] Add Cruise          [C] Print Ship Full List");
        System.out.println("[4] Edit Cruise         [D] Print Cruise List");
        System.out.println("[5] Add Passenger       [E] Print Cruise Details");
        System.out.println("[6] Edit Passenger      [F] Print Passenger List");
        System.out.println("[x] Exit System");
        System.out.println("\nEnter a menu selection: ");
    }

    // Add a New Ship
    public static void addShip() {
    	
    	Scanner newShipInput = new Scanner(System.in);

    		try {
    			
    			// Prompt the user for the ship's name
    			System.out.println("Enter the new ship's name: ");
    			String newShipName = newShipInput.nextLine();
    			// Validate ship's name
    			if (newShipName.isEmpty() || newShipName.isBlank() || isANumber(newShipName) == true) {
    				System.out.println("Invalid input. Exiting to menu...");
    				return;
    			}

    			// Ensure the new ship does not already exist in the system
    			for (Ship ships: shipList) {
    				if (ships.getShipName().equalsIgnoreCase(newShipName)) {
    					System.out.println("The ship: " + newShipName + " is already in the system. Exiting to menu...");
    					return;
    				}
    			}
    			
    			
    			// Prompt the user for the number of room with balcony
    			System.out.println("Enter the number of room with balcony on the ship: ");
    			int shipRoomBalcony = newShipInput.nextInt();
    			// Validate room with balcony input
    			if (shipRoomBalcony < 0) {
    				System.out.println("Invalid input. Exiting to menu...");
    				return;
    			}
    			
        
    			// Prompt the user for the number of room with ocean view 
    			System.out.println("Enter the number of room with ocean view on the ship: ");
    			int shipRoomOceanView = newShipInput.nextInt();
    			// Validate room with ocean view input
    			if (shipRoomOceanView < 0) {
    				System.out.println("Invalid input. Exiting to menu...");
    				return;
    			}
        
    			
    			// Prompt the user for the number of suite room
    			System.out.println("Enter the number of suite room on the ship: ");
    			int shipRoomSuite = newShipInput.nextInt();
    			// Validate suite room input
    			if (shipRoomSuite < 0) {
    				System.out.println("Invalid input. Exiting to menu...");
    				return;
    			}
        
    			
    			// Prompt the user for the number of interior room
    			System.out.println("Enter the number of interior room on the ship: ");
    			int shipRoomInterior = newShipInput.nextInt();
    			// Validate interior room input
    			if (shipRoomInterior < 0) {
    				System.out.println("Invalid input. Exiting to menu...");
    				return;
    			}
        
    			// Instantiate a new ship object using the full ship constructor
    			// inService variable set to be true by default
    			Ship newShip = new Ship(newShipName, shipRoomBalcony, shipRoomOceanView, shipRoomSuite, shipRoomInterior, true);
    			
    			// Add the new ship object to the array shipList
    			shipList.add(newShip);
    			System.out.println("Ship successfully added! Exiting to menu...");
        
    		} catch (Exception exct) {
    			// Display an error message if an exception is caught
    			System.out.println("An error occured. Exiting to menu...");
    		}

    }

    // Edit an existing ship
    public static void editShip() {

        // This method does not need to be completed
        System.out.println("The \"Edit Ship\" feature is not yet implemented.");

    }

    // Add a New Cruise
    public static void addCruise() {

    	Scanner newCruiseInput = new Scanner(System.in);
    	int shipInList = 0;  // Variable used to count the occurrence of a ship in the array shipList
    		
    		try {
    			
    			// Prompt the user for the cruise's name
    			System.out.println("Enter the new cruise's name: ");
    			String newCruiseName = newCruiseInput.nextLine();
    			// Validate cruise's name
    			if (newCruiseName.isEmpty() || newCruiseName.isBlank() || isANumber(newCruiseName) == true) {
    				System.out.println("Invalid input. Exiting to menu...");
    				return;
    			}

    			// Ensure the new cruise does not already exists in the system
    			for (Cruise eachCruise: cruiseList) {
    				if (eachCruise.getCruiseName().equalsIgnoreCase(newCruiseName)) {
    					System.out.println("The cruise " + newCruiseName + " is already in the system. Exiting to menu...");
    					return; 
    				}
    			}
    			
    			
    			// Prompt the user for the ship's name
    			System.out.println("Enter the ship's name: ");
    			String cruiseShipName = newCruiseInput.nextLine();
    			// Validate ship's name
    			if (cruiseShipName.isEmpty() || cruiseShipName.isBlank() || isANumber(cruiseShipName) == true) {
    				System.out.println("Invalid input. Exiting to menu...");
    				return;
    			}
    			
    			// Ensure the ship is in service
    			for (Ship eachShip: shipList) {
    				if (eachShip.getShipName().equalsIgnoreCase(cruiseShipName) && eachShip.getInService() == false) {
    					System.out.println(cruiseShipName + " is not in service. Exiting to menu...");
    					return; 
    				} else if (eachShip.getShipName().equalsIgnoreCase(cruiseShipName)) {
    					shipInList++; // Increase shipInList value if the ship is found in shipList
    				}
    			}
    			
    			// Display a message if the ship is not found in the array shipList
    			if (shipInList == 0) {
    				System.out.println("Ship " + cruiseShipName + " is not in the system. Exiting to menu...");
    				return;
    			}
    			
    	  		// Ensure the ship is not assigned to another cruise
    			for (Cruise eachCruise: cruiseList) {
    				if (eachCruise.getCruiseShipName().equalsIgnoreCase(cruiseShipName)) {
    					System.out.println(cruiseShipName + " is already assigned to cruise: " + eachCruise.getCruiseName() + ". Exiting to menu...");
    					return;
    				}
    			}
    		
    
    			// Prompt the user for the cruise's departure port 
    			System.out.println("Enter cruise's departure port: ");
    			String cruiseDeparturePort = newCruiseInput.nextLine();
    			// Validate departure port input
    			if (cruiseDeparturePort.isEmpty() || cruiseDeparturePort.isBlank() || isANumber(cruiseDeparturePort) == true) {
    				System.out.println("Invalid input. Exiting to menu...");
    				return;
    			}
    			
    			
    			// Prompt the user for the cruise's departure port
    			System.out.println("Enter cruise's destination: ");
    			String cruiseDestination = newCruiseInput.nextLine();
    			// Validate departure port input
    			if (cruiseDestination.isEmpty() || cruiseDestination.isBlank() || isANumber(cruiseDestination) == true) {
    				System.out.println("Invalid input. Exiting to menu...");
    				return;
    			}
    			
    			
    			// Prompt the user for the cruise's return port
    			System.out.println("Enter cruise's return port: ");
    			String cruiseReturnPort = newCruiseInput.nextLine();
    			// Validate return port input
    			if (cruiseReturnPort.isEmpty() || cruiseReturnPort.isBlank() || isANumber(cruiseReturnPort) == true) {
    				System.out.println("Invalid input. Exiting to menu...");
    				return;
    			}
   
    			
       			// Instantiate a new cruise object using the full cruise constructor
    			Cruise newCruise = new Cruise(newCruiseName, cruiseShipName, cruiseDeparturePort, cruiseDestination, cruiseReturnPort);
    			
    			// Add the cruise to the array cruiseList
    			cruiseList.add(newCruise);
    			System.out.println("Cruise successfully added! Exiting to menu...");
    			
        
    		} catch (Exception exct) {
    			// Display an error message if an exception is caught
    			System.out.println("An error occured. Exiting to menu...");
    		}

        
    }

    // Edit an existing cruise
    public static void editCruise() {

        // This method does not need to be completed
        System.out.println("The \"Edit Cruise\" feature is not yet implemented.");

    }

    // Add a New Passenger
    public static void addPassenger() {

        Scanner newPassengerInput = new Scanner(System.in);
        int cruiseInList = 0;  //Variable used to count the occurrence of a cruise in the array cruiseList
        
        
        System.out.println("Enter the new passenger's name: ");
        String newPassengerName = newPassengerInput.nextLine();

        // ensure new passenger name does not already exist
        for (Passenger eachPassenger: passengerList) {
            if (eachPassenger.getPassengerName().equalsIgnoreCase(newPassengerName)) {
                System.out.println("That passenger is already in the system. Exiting to menu...");
                return; // quits addPassenger() method processing
            }
        }

        // get cruise name for passenger
        System.out.println("Enter cruise name: ");
        String newCruiseName = newPassengerInput.nextLine();

        // ensure cruise exists
        for (Cruise eachCruise: cruiseList) {
            if (eachCruise.getCruiseName().equalsIgnoreCase(newCruiseName)) {
            	cruiseInList++;
            }
        }
        
        // Display a message if cruise does not exist
        if (cruiseInList == 0) {
        	 System.out.println("That cruise does not exist in the system. Exiting to menu...");
             return; // quits addPassenger() method processing
        }
            	
    

        // get room type
        System.out.println("Enter Room Type (BAL, OV, STE, or INT: ");
        String room = newPassengerInput.nextLine();
        // validate room type
        if ((room.equalsIgnoreCase("BAL")) || (room.equalsIgnoreCase("OV")) ||
                (room.equalsIgnoreCase("STE")) || (room.equalsIgnoreCase("INT"))) {
            // validation passed - add passenger
            Passenger newPassenger = new Passenger(newPassengerName, newCruiseName, room.toUpperCase());
            passengerList.add(newPassenger);
            
        } else {
            System.out.println("Invalid input. Exiting to menu...");
            return; // quits addPassenger() method processing
        }
    }

    // Edit an existing passenger
    public static void editPassenger() {

        // This method does not need to be completed
        System.out.println("The \"Edit Passenger\" feature is not yet implemented.");

    }

    // Method to check if input is a number
    public static boolean isANumber(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i)) == false)
                return false;
        }
        return true;
    }

}
