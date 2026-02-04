import java.util.*;


public class PatientPriority {
    public static void main(String[] args) {
        System.out.println("Hospital");
        PatientPriorityComparator p=new PatientPriorityComparator();

        PriorityQueue<Patient> prior = new PriorityQueue<>(p);
        Scanner sc=new Scanner(System.in);
        for(int i=0;i<5;i++){
            System.out.println("Enter Patient name: ");
            String pname=sc.nextLine();
            System.out.println("Enter Patient Priority: ");
            String Priority=sc.nextLine();
            prior.add(new Patient(pname,Priority));
        }
        while (!prior.isEmpty()) {
            Patient current = prior.poll();
            System.out.println("Processed: " + current);
        }
    }
}
class Patient {
     String patientName;
     String patientPriority;

    Patient(String patientName, String patientPriority) {
        this.patientName = patientName;
        this.patientPriority = patientPriority;
    }

    public String getPatientName() {
        return patientName;
    }

    public String getPatientPriority() {
        return patientPriority;
    }
    @Override
    public String toString() {
        return "Patient name: " + patientName + ", Priority: " + patientPriority;
    }
}
class PatientPriorityComparator implements Comparator<Patient> {
    public int compare(Patient p1, Patient p2) {
        int p1PriorityRank = getPriorityRank(p1.getPatientPriority());
        int p2PriorityRank = getPriorityRank(p2.getPatientPriority());
        return Integer.compare(p2PriorityRank, p1PriorityRank); // Higher rank = higher priority
    }

    private int getPriorityRank(String priority) {
        return switch (priority.toLowerCase()) {
            case "critical" -> 4;
            case "high" -> 3;
            case "medium" -> 2;
            case "low" -> 1;
            default -> 0;
        };
    }
}
