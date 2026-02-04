class Player {
    String name;
    Player next;
    Player(int id, String name) {
        this.name = name;
    }

    Player(int id, String name) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}

class CircularLinkedList {
    private Player head = null;

    public void addPlayer(String name) {
        Player newPlayer = new Player(id, name);
        if (head == null) {
            head = newPlayer;
            head.next = head;
        } else {
            Player temp = head;
            while (temp.next != head) temp = temp.next;
            temp.next = newPlayer;
            newPlayer.next = head;
        }
    }

    public void removePlayer(String name) {
        if (head == null) return;
        Player current = head, prev = null;
        do {
            if (current.name.equals(name)) {
                if (prev != null) prev.next = current.next;
                else {
                    // removing head
                    Player temp = head;
                    while (temp.next != head) temp = temp.next;
                    head = current.next;
                    temp.next = head;
                }
                System.out.println(name + " is eliminated!");
                break;
            }
            prev = current;
            current = current.next;
        } while (current != head);
    }

    public void startGame(int rounds) throws InterruptedException {
        Player current = head;
        for (int i = 0; i < rounds; i++) {
            System.out.println("Passing potato to " + current.name);
            Thread.sleep(500); // simulate time delay
            current = current.next;
        }
        System.out.println("🔥 Potato explodes on " + current.name);
        removePlayer(current.name);
    }

    public boolean hasWinner() {
        return head != null && head.next == head;
    }

    public void showPlayers() {
        if (head == null) return;
        Player temp = head;
        do {
            System.out.print(temp.name + " -> ");
            temp = temp.next;
        } while (temp != head);
        System.out.println("(back to " + head.name + ")");
    }
}

public class GameMultiExample {
    public static void main(String[] args) throws InterruptedException {
        CircularLinkedList game = new CircularLinkedList();
        game.addPlayer("Rudra");
        game.addPlayer("Arjun");
        game.addPlayer("Kriti");
        game.addPlayer("Aman");

        game.showPlayers();

        while (!game.hasWinner()) {
            int randomRounds = (int)(Math.random() * 10 + 1);
            System.out.println("\nPassing potato " + randomRounds + " times...");
            game.startGame(randomRounds);
            game.showPlayers();
        }

        System.out.println("🏆 Winner is " + game.head.name + "!");
    }
}
