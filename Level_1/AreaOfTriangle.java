import java.util.Scanner;
public class AreaOfTriangle{
	public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
		double base = sc.nextDouble();
		double height = sc.nextDouble();
		double area = 0.5*base*height;
		System.out.println("Area of Triangle is " +area);
		}
	}

