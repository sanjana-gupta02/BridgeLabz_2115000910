import java.util.Scanner;
public class CheckSmallest{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		int num3 = sc.nextInt();

		if((num1<num2) && (num1<num3)){
			System.out.println("Is the first number the smallest? " + "Yes");
		}
		else{
			System.out.println("Is the first number the smallest? " + "No");
		}
	}
}
