public class FindPens{
	public static void main(String[] args){
		int totalPens = 14;
		int noOfStudents = 3;
		int penPerStudent = totalPens/noOfStudents;
		int remainingPens =  totalPens%noOfStudents;
		System.out.println("The Pen Per Student is "+penPerStudent+ " and the remaining pen not distributed is " +remainingPens);
		}
	}
