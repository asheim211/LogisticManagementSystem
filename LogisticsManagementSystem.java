import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Shipment {
    private String shipmentId;
    private String source;
    private String destination;
    private double weight;

    public Shipment(String shipmentId, String source, String destination, double weight) {
        this.shipmentId = shipmentId;
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    public String getShipmentId() {
        return shipmentId;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    public double getWeight() {
        return weight;
    }
}

public class LogisticsManagementSystem {
    private List<Shipment> shipments;

    public LogisticsManagementSystem() {
        shipments = new ArrayList<>();
    }

    public void addShipment(Shipment shipment) {
        shipments.add(shipment);
    }

    public void displayShipments() {
        System.out.println("Shipment List:");
        System.out.println("---------------");
        for (Shipment shipment : shipments) {
            System.out.println("Shipment ID: " + shipment.getShipmentId());
            System.out.println("Source: " + shipment.getSource());
            System.out.println("Destination: " + shipment.getDestination());
            System.out.println("Weight: " + shipment.getWeight() + " kg");
            System.out.println("--------------------");
        }
    }

    public static void main(String[] args) {
        LogisticsManagementSystem lms = new LogisticsManagementSystem();
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("Logistics Management System");
            System.out.println("1. Add Shipment");
            System.out.println("2. Display Shipments");
            System.out.println("3. Quit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter shipment ID: ");
                    String shipmentId = scanner.nextLine();
                    System.out.print("Enter source: ");
                    String source = scanner.nextLine();
                    System.out.print("Enter destination: ");
                    String destination = scanner.nextLine();
                    System.out.print("Enter weight (in kg): ");
                    double weight = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline character
                    Shipment shipment = new Shipment(shipmentId, source, destination, weight);
                    lms.addShipment(shipment);
                    System.out.println("Shipment added successfully!");
                    break;
                case 2:
                    lms.displayShipments();
                    break;
                case 3:
                    isRunning = false;
                    System.out.println("Exiting Logistics Management System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
            System.out.println();
        }

        scanner.close();
    }
}
