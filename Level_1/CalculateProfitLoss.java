public class CalculateProfitLoss{
	public static void main(String[] args){
		double costPrice = 129;
		double sellPrice = 191;
		double profit = sellPrice - costPrice;
		double profitPercent = (profit/costPrice)*100;
		System.out.println("The Cost Price is INR " +costPrice+ " and Selling Price is INR "+sellPrice +"\n" + "The Profit is INR " +profit+ " and the Profit Percentage is " +profitPercent);
		}
	}
