public class OnlinePay {

    public static void main(String[] args) {
        Payment P1=new CreditCardPayment(5000.75);
        P1.makePayment();
        //P1.generateReceipt();
        Payment P2=new UPIPayment(3000.50);
        P2.makePayment();
        //P2.generateReceipt();
        
    }
    
}
abstract class Payment{
    double amount;
    Payment(double amount) {
        this.amount = amount;
    }
    abstract void makePayment();
    void generateReceipt() {
        System.out.println("Receipt generated for amount: rupeesh " + amount);
    }
}

class CreditCardPayment extends Payment{
    double tax=0;
    CreditCardPayment(double amount) {
        super(amount);
}
//@Override
    void makePayment(){
        
        
        System.out.println("Paying "+ amount + " using Credit Card.");
        double tax=5;
        double result=(amount*tax)/100;
        amount+=result;
        System.out.println("Discount: "+result);
        System.out.println("After Discount of 5% : "+amount);


        generateReceipt();
    }
}
    class UPIPayment extends Payment{
         UPIPayment(double amount) {
            super(amount);
        }
        //@Override
        void makePayment() {
            
            System.out.println("Paying " + amount + " using UPI.");
            double discount=5;
            double result=(amount*discount)/100;
            amount-=result;
            System.out.println("After Deducting 5% Tax: " + amount);
            generateReceipt();
        }
    }


