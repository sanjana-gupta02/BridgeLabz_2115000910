import java.util.Scanner;
public class CheckLargest{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		int num3 = sc.nextInt();

		if((num1>num2) && (num1>num3)){
			System.out.println("Is the first number the largest? " + "Yes\n" + "Is the second number the largest? " + "No\n" + "Is the third number the largest? " + "No");
		}
		else if((num2>num1) && (num2>num3)){
			System.out.println("Is the first number the largest? " + "No\n" + "Is the second number the largest? " + "Yes\n" + "Is the third number the largest? " + "No");
		}
		else{
			System.out.println("Is the first number the largest? " + "No\n" + "Is the second number the largest? " + "No\n" + "Is the third number the largest? " + "Yes");
		}
	}
}
