public class EarthVolume{
	public static void main(String[] args){
		double radius = 6378;
		double volume = (4/3)*3.14*(Math.pow(radius,3));
		double volInMiles = volume*1.6;
		System.out.println("The volume of earth in cubic kilometers is " +volume+ " and cubic miles is  " +volInMiles);
		}
	} 
