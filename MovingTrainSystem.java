import java.util.Scanner;

// Class for Station Node (Linked List Node)
class Station {
    String stationName;
    Station next;

    Station(String name) {
        this.stationName = name;
        this.next = null;
    }
}

// Class for Train
class Train {
    Station currentStation;

    void startJourney(Station head) {
        if (head == null) {
            System.out.println(" No Stations on the Line!");
            return;
        }
        currentStation = head;
        System.out.println("🚆 Train Starting Journey from " + currentStation.stationName);
    }

    void moveNext() {
        if (currentStation == null) {
            System.out.println("❌ Train hasn't started yet!");
        } else if (currentStation.next == null) {
            System.out.println("🏁 Train has reached the final station: " + currentStation.stationName);
        } else {
            currentStation = currentStation.next;
            System.out.println("🚆 Train arrived at " + currentStation.stationName);
        }
    }

    void displayCurrentStation() {
        if (currentStation == null)
            System.out.println("❌ Train hasn't started journey yet.");
        else
            System.out.println("📍 Train is at: " + currentStation.stationName);
    }
}

// Main Class
public class MovingTrainSystem {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);

        // Create Stations
        Station head = new Station("Delhi");
        head.next = new Station("Ghaziabad");
        head.next.next = new Station("Meerut");
        head.next.next.next = new Station("Muzaffarnagar");
        head.next.next.next.next = new Station("Saharanpur");

        Train train = new Train();
        boolean running = true;

        while (running) {
            System.out.println("\n==== Railway Management Menu ====");
            System.out.println("1. Start Train Journey");
            System.out.println("2. Move to Next Station");
            System.out.println("3. Show Current Station");
            System.out.println("4. Move Automatically with Delay");
            System.out.println("5. Exit");
            System.out.print("Enter Choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    train.startJourney(head);
                    break;
                case 2:
                    train.moveNext();
                    break;
                case 3:
                    train.displayCurrentStation();
                    break;
                case 4:
                    while (train.currentStation != null && train.currentStation.next != null) {
                        train.moveNext();
                        Thread.sleep(2000);  // Sleep for 2 seconds
                    }
                    System.out.println("🚩 Train completed its journey!");
                    break;
                case 5:
                    System.out.println("👋 Exiting Railway System...");
                    running = false;
                    break;
                default:
                    System.out.println("⚠️ Invalid choice!");
            }
        }
        sc.close();
    }
}
