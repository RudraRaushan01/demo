public class Customer {
    public static void main(String[] args) {
        BankCustomer bank=new BankCustomer("Rajesh",987654332);
        BankCustomer bankc=new BankCustomer("Pushpendra", 1234567890);
        bank.display();
        bankc.display();   
    }
}
class BankCustomer{
    String name;
    int accno;
    BankCustomer(String name,int accno){
        this.name=name;
        this.accno=accno;
    }
    void display(){
        System.out.println("Customer: "+this.name);
        System.out.println("Account No.: "+this.accno);
    }
}

