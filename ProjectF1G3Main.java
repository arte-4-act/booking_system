package aug24.project;
import java.util.Scanner;

public class ProjectF1G3Main {
    // Array to store the room objects
    private ProjectF1G3Room[] rooms;
    private double totalCharge =0.0;

    public ProjectF1G3Main() {
        rooms = new ProjectF1G3Room[5];
        // Initialize with 5 default rooms
        rooms[0] = new ProjectF1G3Room("1", 2, 100); // Room number, capacity, and charge
        rooms[1] = new ProjectF1G3Room("2", 4, 200);
        rooms[2] = new ProjectF1G3Room("3", 5, 250);
        rooms[3] = new ProjectF1G3Room("4", 6, 300);
        rooms[4] = new ProjectF1G3Room("5", 8, 500);
    }

    public void mainMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice; // User's choice for menu options
        
        do {
            // Display the main menu options to the user
            System.out.println("1. Add Room");
            System.out.println("2. Show Records");
            System.out.println("3. Book Room");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            
            // Validate that the user input is an integer
            while (!scanner.hasNextInt()) {
                System.out.print("Invalid input! Please enter a number: ");
                scanner.next();
            }
            choice = scanner.nextInt();

            // Execute user choice based on input
            switch (choice) {
                case 1 -> AddRoom(scanner); // Add a new room
                case 2 -> ShowRecords(); // Show records of all rooms
                case 3 -> BookRoom(scanner); // Book a room
                case 4 -> {
                    System.out.println("---------------------------------");
                    System.out.println("Exiting...");
                    System.out.println("Total charge for all bookings: RM" + totalCharge);
                    System.out.println("---------------------------------");
                }
                default -> {
                    // Handle invalid menu choices
                    System.out.println("---------------------------------");
                    System.out.println("Invalid choice! Please try again.");
                    System.out.println("---------------------------------");
                }
            }
        } while (choice != 4); // Exit the program
        
        
        scanner.close(); // Close the scanner to release resources
    }

    private void AddRoom(Scanner scanner) {
    
        String roomNo = null; // New room number
        int capacity; // Capacity of new room
        double roomCharge; // Charge for booking new room
        boolean isUnique = false; // Flag to check if room number is unique
        
        
        int roomNumber;
        do {
            System.out.print("Enter Room No: ");
            
            while (!scanner.hasNextInt()) {
                
                System.out.print("Invalid input! Room number must be a positive integer: ");
                scanner.next();
            }
            
        roomNumber = scanner.nextInt();
        
        if (roomNumber <= 0) {
            System.out.println("ERROR! Room number must be a positive integer.");
            continue;
        }
        
        roomNo = Integer.toString(roomNumber); // Convert to String for compatibility
        isUnique = true;
        
        // Check if the entered room number is unique
        for (ProjectF1G3Room room : rooms) {
            if (room.getRoomNo().equals(roomNo)) {
                System.out.println("Room number already exists. Please enter a unique room number.");
                isUnique = false;
                break;
            }
        }
        
    } while (!isUnique || roomNumber <= 0);
        
        
        
        
         do {
              System.out.print("Enter Capacity (max 50): ");
              
            while (!scanner.hasNextInt()) {
                System.out.print("Invalid input! Please enter an integer value for capacity: ");
                scanner.next();
            }
            
        capacity = scanner.nextInt();

        if (capacity <= 0 || capacity > 50) {
            System.out.println("ERROR! Capacity must be between 1 and 50.");
        }
        
    } while (capacity <= 0 || capacity > 50);

         
    // Check for valid room charge (positive value)
        do {
            System.out.print("Enter Room Charge: ");
            
        while (!scanner.hasNextDouble()) {
            System.out.print("Invalid input! Please enter a valid number for room charge: ");
            scanner.next();
        }
        
        roomCharge = scanner.nextDouble();

        if (roomCharge <= 0) {
            System.out.println("ERROR! Room charge must be a positive value.");
        }
        
    } while (roomCharge <= 0);
        

        
        // Create a new room and add it to the rooms array
        ProjectF1G3Room newRoom = new ProjectF1G3Room(roomNo, capacity, roomCharge);
        ProjectF1G3Room[] newRooms = new ProjectF1G3Room[rooms.length + 1];
        System.arraycopy(rooms, 0, newRooms, 0, rooms.length); // Copy existing rooms to the new array
        newRooms[rooms.length] = newRoom; // Add the new room to the array
        rooms = newRooms; // Update the rooms reference to the new array

        System.out.println("\n\n\n\nRoom added successfully!"); //to clear the above texts



    }

 private void ShowRecords(){
    //array slot time for user
    String[] slotTimes ={
        "12pm - 2pm", 
        "2pm - 4pm", 
        "4pm - 6pm", 
        "6pm - 8pm", 
        "8pm - 10pm", 
        "10pm - 12am"
    };
    
    System.out.println("\n|      Slot\t| Time\t\t|");
    System.out.println("---------------------------------");
    
    for (int i=0; i<slotTimes.length; i++) {
        System.out.println("|\t"+(i+1)+"\t| "+slotTimes[i]+"\t|");
    }
    
        System.out.println("---------------------------------\n");


    
    //Availability status
        System.out.println("Availability Status:\n");
        System.out.println("Slot 1 \t\t| Slot 2\t| Slot 3\t| Slot 4\t| Slot 5\t| Slot 6\t| Room No\t| Room Capacity\t| Charge");
        System.out.println("-------------------------------------------------------------"
                + "----------------------------------------------------------------------------"
                + "---");
        
        //declaration of arrays for avaibility,roomnumber,capcity and charge
        String[] availabilityStatus = new String[slotTimes.length];
        int[] roomNumber = new int[rooms.length];
        int[] capacity = new int[rooms.length];
        double[] charge = new double[rooms.length];
        
        //display room details in array
        for (int roomIndex = 0; roomIndex < rooms.length; roomIndex++) {
            ProjectF1G3Room room = rooms[roomIndex];
        
        //store details
        roomNumber[roomIndex] = Integer.parseInt(room.getRoomNo());
        capacity[roomIndex] = room.getCapacity();
        charge[roomIndex] = room.getRoomCharge();
        
        //list of availability of the slot
        for (int i = 0; i < slotTimes.length; i++) {
            availabilityStatus[i] = room.isAvailable(i) ? "Available\t" : "Booked\t\t";
            System.out.print(availabilityStatus[i] + "|");
        }
        
        //display the Charge, Room number and capacity
        System.out.println("\t"+roomNumber[roomIndex]+"\t|\t"+capacity[roomIndex]+"\t| RM"+charge[roomIndex]);
        
    }

        System.out.println("-------------------------------------------------------------"
                + "-----------------------------------------------------------------------------"
                + "---");
}
    
    
private void BookRoom(Scanner scanner) {
    //array for slot time
    String[] slotTimes = {
        "12pm - 2pm", 
        "2pm - 4pm", 
        "4pm - 6pm", 
        "6pm - 8pm", 
        "8pm - 10pm", 
        "10pm - 12am"
    };
    
    boolean continueBooking = false;
    int[] availableRooms = new int[rooms.length]; //array for available room
    int[] slotSelections = new int[slotTimes.length]; //array for slot selection
    int roomCount;

    do {
        int headCount;
        
        //check guest count
        do {
            System.out.print("Enter the number of guests (max 50): ");
            while (!scanner.hasNextInt()){
                
                System.out.print("Invalid input! Please enter a positive integer value for guests: ");
                scanner.next();
            }
            
            headCount = scanner.nextInt();
            if (headCount<=0 || headCount>50){
                
                System.out.println("ERROR! The number of guests must be between 1 and 50.");
            }
            
        } while (headCount<=0 || headCount>50);

        int maxCapacity= getMaxRoomCapacity();
        
        if (headCount>maxCapacity){
            System.out.println("ERROR! The number of guests exceeds the maximum room capacity of " + maxCapacity);
            continue;
        }

        //display slot time
        System.out.println("\n|      Slot\t| Time\t\t|");
        System.out.println("---------------------------------");
        for (int i=0;  i<slotTimes.length; i++) {
         System.out.println("|\t"+(i+1)+"\t| "+slotTimes[i]+"\t|");
        }
        System.out.println("---------------------------------\n");

        //display availabiltiy in table
        roomCount = 0;
        System.out.println("Availability Status:\n");
        System.out.println("Slot 1 \t\t| Slot 2\t| Slot 3\t| Slot 4\t| Slot 5\t| Slot 6\t| Room No\t| Room Capacity\t| Charge");
        System.out.println("-------------------------------------------------------------"
                + "-------------------------------------------------------------------------------");

        for (int i=0; i<rooms.length; i++){
            if (rooms[i].getCapacity() >= headCount){
                
                availableRooms[roomCount++] = i; //store available room in array

                //display room available
                for (int j=0; j<slotTimes.length; j++) {
                    System.out.print((rooms[i].isAvailable(j) ? " Available\t":" Booked\t")+"|");
                }
                
                System.out.println("\t"+rooms[i].getRoomNo()+"\t|\t"+rooms[i].getCapacity()+"\t| RM"+rooms[i].getRoomCharge());
            }
        }
        
       System.out.println("-------------------------------------------------------------"
                + "-------------------------------------------------------------------------------");

        if (roomCount == 0){
            System.out.println("No rooms available for the given number of guests\n\n");
            return;
        }

        //room select and checking
        System.out.print("Enter Room No to book: ");
        String roomNo = scanner.next();
        ProjectF1G3Room selectedRoom = null;

        for (int i=0; i<roomCount; i++){
            if (rooms[availableRooms[i]].getRoomNo().equals(roomNo)){
                
                selectedRoom = rooms[availableRooms[i]];
                break;
            }
        }

        if (selectedRoom == null){
            System.out.println("Room not found!\n\n\n\n");
            return;
        } 
        
        else if (selectedRoom.getCapacity() < headCount){
            System.out.println("Invalid! The selected room capacity is less than the number of guest " + headCount + ". Please choose another room.");
            continue;
        }

        //slot select
        int slot;
        
        do {
            System.out.print("Enter slot number to book (1-6): ");
            
            while (!scanner.hasNextInt()){
                System.out.print("Invalid slot number! Please enter a number between 1 and 6: ");
                scanner.next();
            }
            
            slot = scanner.nextInt();
            if (slot<1 || slot>6){
                
                System.out.println("Invalid slot number!\n");
            } 
            
            else if (!selectedRoom.isAvailable(slot - 1)){
                System.out.println("Slot already booked!\n");
                slot = -1;
            } 
            
            else {
                slotSelections[slot-1] = slot; //store selected slot
                selectedRoom.bookSlot(slot-1);
                System.out.println("Slot "+slot+"("+slotTimes[slot-1]+") booked successfully for Room "+selectedRoom.getRoomNo());
                System.out.println("Room charge: RM"+selectedRoom.getRoomCharge()+"\n");
                totalCharge +=selectedRoom.getRoomCharge();
            }
            
        } while (slot == -1);

        //continue or exit
        System.out.print("Do you want to book another room? (yes/no): ");
        String response= scanner.next();
        continueBooking= response.equalsIgnoreCase("yes");

    } while (continueBooking);

    System.out.println("Returning to main menu\n\n");
}


//checking function that assist the checking for the capacity
private int getMaxRoomCapacity(){
    int maxCapacity= 0;
    
    for (ProjectF1G3Room room : rooms){
        
        if (room.getCapacity() > maxCapacity){
            maxCapacity = room.getCapacity();
        }
    }
    
    return maxCapacity;
}
    

    public static void main(String[] args) {
        // Create an instance of the main class and display the menu
        ProjectF1G3Main main= new ProjectF1G3Main();
        main.mainMenu();
    }
    
    
    
    
    
}