package aug24.project;

public class ProjectF1G3Room {
    // Unique room number identifier
    private String roomNo;
    // Maximum number of guests allowed in the room
    private int capacity;
    // Cost of booking the room
    private double roomCharge;
    // Availability status for each of the 6 booking slots
    private boolean[] availability;

    
    public ProjectF1G3Room(String roomNo, int capacity, double roomCharge) {
        this.roomNo = roomNo; // Initialize room number
        this.capacity = capacity; // Initialize room capacity
        this.roomCharge = roomCharge; // Initialize room charge
        this.availability = new boolean[6]; // Initialize availability for 6 slots
        for (int i = 0; i < 6; i++) {
            availability[i] = true; // All slots are available initially
        }
    }

    //setter for RoomNo
    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    //setter for Capacity
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    //setter for RoomNo
    public void setRoomCharge(double roomCharge) {
        this.roomCharge = roomCharge;
    }

    //setter for RoomNo
    public void setAvailability(boolean[] availability) {
        this.availability = availability;
    }

    
    // Getter for room number
    public String getRoomNo() {
        return roomNo;
    }

    // Getter for room capacity
    public int getCapacity() {
        return capacity;
    }

    // Getter for room charge
    public double getRoomCharge() {
        return roomCharge;
    }

    //Show Record
    public void ShowRecord() {
        System.out.println("Room No: " + roomNo + ", Capacity: " + capacity + ", Charge: " + roomCharge);
        for (int i = 0; i < 6; i++) {
            System.out.println("Slot " + (i + 1) + ": " + (availability[i] ? "Available" : "Booked"));
        }
    }
    
    //Add Room
    public boolean isAvailable(int slot){
        return availability[slot];
    }

    //Book Room
    public void bookSlot(int slot){
        availability[slot] = false;
    }
    
    
    
    
    
    
    
    
    
    
    
    
}