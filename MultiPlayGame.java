import java.util.Scanner;

public class MultiPlayGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PlayerCircle circle = new PlayerCircle();

        System.out.print("Enter number of players: ");
        int num = sc.nextInt();
        sc.nextLine(); 

        for (int i = 1; i <= num; i++) {
            System.out.print("Enter name for Player " + i + ": ");
            String name = sc.nextLine();
            circle.addPlayer(name);
        }
        while (circle.getSize() > 1) {
            System.out.print("Enter number of moves: ");
            int moves;
            try {
                moves = Integer.parseInt(sc.nextLine());
                if (moves <= 0) {
                    System.out.println("Please enter a positive number.");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            Player eliminated = circle.moveAndEliminate(moves);
            System.out.println("Eliminated: " + eliminated.name);
            System.out.println("maining Players: " + circle.getPlayerNames());
        }

        System.out.println(" Winner is: " + circle.getHead().name);
    }
}

// Node class
class Player {
    String name;
    Player next;

    public Player(String name) {
        this.name = name;
    }
}

// Circular Linked List
class PlayerCircle {
     Player head = null;
     Player tail = null;
     int size = 0;

    public void addPlayer(String name) {
        Player newPlayer = new Player(name);
        if (head == null) {
            head = newPlayer;
            tail = newPlayer;
            newPlayer.next = head;
        } else {
            tail.next = newPlayer;
            tail = newPlayer;
            tail.next = head;
        }
        size++;
    }

    public Player getHead() {
        return head;
    }

    public int getSize() {
        return size;
    }

    public Player moveAndEliminate(int moves) {
        if (size <= 1) return null;

        Player prev = tail;
        Player curr = head;

        // Move through the list `moves` times
        for (int i = 0; i < moves; i++) {
            prev = curr;
            curr = curr.next;
            System.out.println("Passing to: " + curr.name);
            try {
                Thread.sleep(200); // for realism
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        // Eliminate current player
        prev.next = curr.next;

        if (curr == head) head = curr.next;
        if (curr == tail) tail = prev;

        size--;
        return curr;
    }

    public String getPlayerNames() {
        if (head == null) return "[None]";
        StringBuilder names = new StringBuilder("[");
        Player current = head;
        do {
            names.append(current.name).append(" → ");
            current = current.next;
        } while (current != head);
        return names.substring(0, names.length() - 3) + "]";
    }
}
