package target2024.algorithms;

public class BuySellStocksSingle {
	public static void main(String[] args) {
		BuySellStocksSingle bs = new BuySellStocksSingle();
//		int[] prices = {7,1,5,3,6,4};
		int[] prices = {5, 4, 3, 2, 1, 0};
		System.out.println(bs.maxProfit(prices));
	}

	public int maxProfit(int[] prices) {
		int[] brr = new int[prices.length];
		int[] srr = new int[prices.length];

		brr[0] = prices[0];
		for(int i=1; i<prices.length; i++) {
			brr[i] = Math.min(brr[i-1], prices[i]);
		}
		//7, 1, 1, 1, 1, 1

		srr[prices.length - 1] = prices[prices.length-1];
		for(int i=prices.length-2; i>=0; i--) {
			srr[i] = Math.max(srr[i+1], prices[i]);
		}
		//7, 6, 6, 6, 6, 4

		int profit = 0;
		for(int i=0; i<prices.length; i++) {
			profit = Math.max(profit, srr[i] - brr[i]);
		}
		return profit;
	}

}
