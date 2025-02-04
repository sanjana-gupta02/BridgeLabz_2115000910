import java.util.Scanner;

public class Number {
    public int check(int n){
        if(n>0){
            return 1;
        } else if (n<0) {
            return -1;
        }
        else{
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int n = sc.nextInt();
        Number obj = new Number();
        System.out.println(obj.check(n));


    }
}
