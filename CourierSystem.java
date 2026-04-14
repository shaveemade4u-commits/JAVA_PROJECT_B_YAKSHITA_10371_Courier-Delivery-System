import java.util.Scanner;

class Parcel {
    String parcelId;
    String status;

    // Constructor
    Parcel(String parcelId) {
        this.parcelId = parcelId;
        this.status = "Dispatched"; // default status
    }

    // Getter methods
    String getParcelId() {
        return parcelId;
    }

    String getStatus() {
        return status;
    }

    // Update status
    void updateStatus(String newStatus) {
        this.status = newStatus;
    }
}


public class CourierSystem {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Store multiple parcels (array)
        Parcel[] parcels = new Parcel[4];

        // Adding sample parcels
        parcels[0]=(new Parcel("P101"));
        parcels[1]=(new Parcel("P102"));
        parcels[2]=(new Parcel("P103"));
        parcels[3]=(new Parcel("P104"));

        // Update some statuses
        parcels[0].updateStatus("In Transit");
        parcels[1].updateStatus("Delivered");
        parcels[2].updateStatus("Out for Delivery");
        parcels[3].updateStatus("Dispatched");

        int choice;

        do {
            System.out.println("\n===== Courier Tracking System =====");
            System.out.println("1. Track Parcel");
            System.out.println("2. Update Parcel Status");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {

                case 1:
                    System.out.println("Enter Parcel ID: ");
                    String searchId = sc.nextLine();

                    boolean found = false;

                    for (Parcel p : parcels) {
                        if (p.getParcelId().equalsIgnoreCase(searchId)) {
                            System.out.println("Status: " + p.getStatus());
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Parcel not found!");
                    }
                    break;

                case 2:
                    System.out.print("Enter Parcel ID: ");
                    String updateId = sc.nextLine();

                    boolean updated = false;

                    for (Parcel p : parcels) {
                        if (p.getParcelId().equalsIgnoreCase(updateId)) {
                            System.out.print("Enter new status: ");
                            String newStatus = sc.nextLine();
                            p.updateStatus(newStatus);
                            System.out.println("Status updated successfully!");
                            updated = true;
                            break;
                        }
                    }

                    if (!updated) {
                        System.out.println("Parcel not found!");
                    }
                    break;

                case 3:
                    System.out.println("Exiting system...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 3);
 
        sc.close();
    }
}