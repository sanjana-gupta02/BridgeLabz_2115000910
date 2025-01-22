import java.util.Scanner;
public class CalculateHeight{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		double heightInCms = sc.nextInt();
		double inInches =  heightInCms*(1/2.54);
		double inFeet = inInches*(1/12);
		System.out.println("Your Height in cm is " +heightInCms+ " while in feet is " +inFeet+ " and inches is " +inInches);
		}
	}
