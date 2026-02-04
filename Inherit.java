public class Inherit {
    public static void main(String[] args) {
        Dog d=new Dog();
        d.bark(76,87,89);
        d.sleep();
        System.out.println("Parent class.");
        Animal a=new Animal();
        a.eat(76,54);
        a.sleep();   
    }  
}
class Animal{
    void eat(int a,int b){
        System.out.println("Animal is eating.");
    }
    void sleep(){
        System.out.println("Animal is sleeping.");
    }
}
class Dog extends Animal{
    void bark(int a,int b,int c){
        System.out.println("Dog is barking.");
        int sum=a+b+c;
        System.out.println(sum);
    }
}


