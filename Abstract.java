class Abstract{
    public static void main(String[] args) {
        Dog d=new Dog(); 

        
    }
}
    abstract class Animal {
      Animal() {
            System.out.println("Zzzzzz....");
        }
    }
    class Dog extends Animal {
        Dog() {
            System.out.println("Barking...");
        }
    }
