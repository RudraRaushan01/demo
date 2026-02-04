public class RailManagement {
    public static void main(String[] args) {
        SinglyLinkedList R=new SinglyLinkedList();
        // Scanner sc=new Scanner(System.in);
        // String stationName=sc.nextLine();
        R.insert("Varanasi");
        R.insert("TRV");
        R.insert("SVH");
        R.insert("NVR");
         R.insert("Ghaziabad");
        R.insert("Delhi");
       

        R.display();
    }  
}
class Train{
    String coach;
    Train next;

    Train(String coach){
        this.coach=coach;
        this.next=null;
    }
}
 class SinglyLinkedList{
    Train head;
    public void insert(String coach){
        Train newCoach=new Train(coach);
        if(head == null){
            head = newCoach;
            return;
        }
        Train tempCoach=head;
        while(tempCoach.next!=null){
            tempCoach=tempCoach.next;
        }
        tempCoach.next=newCoach;
    }
    public void display(){
        Train tempCoach=head;
        while(tempCoach!=null){
            System.out.print(tempCoach.coach+" -> ");
            tempCoach=tempCoach.next;
        }
        System.out.println("null");
    }
}


