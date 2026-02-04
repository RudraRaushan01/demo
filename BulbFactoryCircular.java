import java.util.Scanner;

public class BulbFactoryCircular {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of machines: ");
        int n = sc.nextInt();

        System.out.println("Enter bulb counts:");
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Node head = createCircularLinkedList(arr);
        int maxBulbs = getMaxBulbs(head, n);

        System.out.println("Maximum bulbs Jasleen can collect: " + maxBulbs);
    }

    public static Node createCircularLinkedList(int[] arr) {
        Node head = new Node(arr[0]);
        Node curr = head;
        for (int i = 1; i < arr.length; i++) {
            curr.next = new Node(arr[i]);
            curr = curr.next;
        }
        curr.next = head;  // Circular link
        return head;
    }

    public static int getMaxBulbs(Node head, int n) {
        int maxBulbs = 0;
        Node start = head;

        for (int i = 0; i < n; i++) {
            Node curr = start;
            int minBulbs = curr.bulbs;

            for (int len = 1; len <= n; len++) {
                minBulbs = Math.min(minBulbs, curr.bulbs);
                int total = minBulbs * len;
                maxBulbs = Math.max(maxBulbs, total);
                curr = curr.next;
            }

            start = start.next;
        }

        return maxBulbs;
    }
}

// Node class
class Node {
    int bulbs;
    Node next;

    Node(int bulbs) {
        this.bulbs = bulbs;
        this.next = null;
    }
}
