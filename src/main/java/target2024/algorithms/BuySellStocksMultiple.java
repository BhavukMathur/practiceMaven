package target2024.algorithms;

public class BuySellStocksMultiple {
	public static void main(String[] args) {
		BuySellStocksMultiple bs = new BuySellStocksMultiple();
//		int[] prices = {7,1,5,3,6,4};
		int[] prices = {3, 3};
		System.out.println(bs.maxProfit(prices));
	}

	public int maxProfit(int[] prices) {
		int i=0;

//		int[] prices = {7,1,5,3,6,4};
		int buy, sell, profit = 0;
		while((i+1) < prices.length) {
			while((i+1 < prices.length) && (prices[i+1] <= prices[i])) {
				i++;
			}
			buy = prices[i];

			while((i+1 < prices.length) && (prices[i+1] >= prices[i])) {
				i++;
			}
			sell = prices[i];
			profit = profit + (sell - buy);
		}
		return profit;
	}
}
