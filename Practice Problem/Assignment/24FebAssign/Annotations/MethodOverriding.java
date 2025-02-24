class Animal{
    void makeSound(){
        System.out.println("Parent Method Executed");
    }
    void sound(){
        System.out.println("Call me");
    }
}

class Dog extends Animal{
    @Override
    void makeSound() {
        System.out.println("Dog is barking");
    }
}


public class MethodOverriding {
    public static void main(String[] args){
        Dog obj = new Dog();
        obj.makeSound();



    }
}
