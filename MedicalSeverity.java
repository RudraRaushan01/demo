import java.util.*;


public class MedicalSeverity {
    public static void main(String[] args) {
        Comparator<Patient> patientComparator = (p1, p2) -> {
            if (p2.severity != p1.severity) {
                return p2.severity - p1.severity; 
            } else {
                return p1.orderNo - p2.orderNo;  
            }
        };

        PriorityQueue<Patient> queue = new PriorityQueue<>(patientComparator);

        queue.add(new Patient("John", 5, 1));
        queue.add(new Patient("Emma", 8, 2));
        queue.add(new Patient("Lucas", 8, 3));
        queue.add(new Patient("Sophia", 3, 4));
        queue.add(new Patient("Mike", 5, 5));

        System.out.println("Order of treatment:");
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }
}

class Patient {
    String name;
    int severity;
    int orderNo;

    public Patient(String name, int severity, int orderNo) {
        this.name = name;
        this.severity = severity;
        this.orderNo = orderNo;
    }

    @Override
    public String toString() {
        return name + " (Severity: " + severity + ", Arrival Order: " + orderNo + ")";
    }
}
