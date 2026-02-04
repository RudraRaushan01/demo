import java.util.Scanner;


public class GameExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CircularLinkedList game = new CircularLinkedList();
        int n=7;

        for (int i = 1; i <= n; i++) {
            System.out.print("Enter name for player " + i + ": ");
            String name = sc.nextLine();
            game.addPlayer(i, name);
        }

        System.out.println(" Game Starts!");
        game.showPlayers();

        while (!game.hasWinner()) {
            System.out.print("\nEnter player ID to eliminate: ");
            int id = sc.nextInt();
            game.removePlayer(id);
            game.showPlayers();
        }

        Player winner = game.getWinner();
        System.out.println("The winner is " + winner.name + " (ID: " + winner.id + ")");
    }
}


class Player {
    int id;
    String name;
    Player next;

    public Player(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

class CircularLinkedList {
    private Player head = null;

    public void addPlayer(int id, String name) {
        Player newPlayer = new Player(id, name);
        if (head == null) {
            head = newPlayer;
            head.next = head;
        } else {
            Player temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newPlayer;
            newPlayer.next = head;
        }
        System.out.println("Player added: " + name + " (ID: " + id + ")");
    }

    public void showPlayers() {
        if (head == null) {
            System.out.println("No players left!");
            return;
        }
        System.out.print("Players: ");
        Player temp = head;
        do {
            System.out.print("[" + temp.id + ": " + temp.name + "] -> ");
            temp = temp.next;
        } while (temp != head);
        System.out.println("(back to head)");
    }

    public void removePlayer(int id) {
        if (head == null) {
            System.out.println("No players to remove.");
            return;
        }

        Player current = head, prev = null;
        boolean found = false;

        do {
            if (current.id == id) {
                found = true;
                break;
            }
            prev = current;
            current = current.next;
        } while (current != head);

        if (!found) {
            System.out.println("Player ID " + id + " not found!");
            return;
        }

        if (current == head && current.next == head) {
            head = null; 
        } else if (current == head) {
            Player temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            head = head.next;
            temp.next = head;
        } else {
            prev.next = current.next;
        }

        System.out.println("Player " + current.name + " (ID: " + current.id + ") eliminated!");
    }

    public boolean hasWinner() {
        return head != null && head.next == head;
    }

    public Player getWinner() {
        return head;
    }
}

