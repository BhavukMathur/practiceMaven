package target2024.algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

//https://leetcode.com/problems/stock-price-fluctuation/

class StockPrice {
	TreeMap<Integer, Integer> treeMap;
	TreeMap<Integer, Integer> priceMap;
	
    public StockPrice() {
    	treeMap = new TreeMap<>();
    	priceMap = new TreeMap<>();
    }
    
    public void update(int timestamp, int price) {
    	Integer oldPrice = treeMap.get(timestamp);
    	if(oldPrice == null) {
    		//Insertion and not update
    		treeMap.put(timestamp,  price);
    		priceMap.put(price, priceMap.getOrDefault(price, 0) + 1);
    	} else {
    		treeMap.put(timestamp,  price);
    		priceMap.put(price, priceMap.getOrDefault(price, 0) + 1);
    		
    		if(priceMap.get(oldPrice) == 1) {
    			priceMap.remove(oldPrice);
    		} else {
    			priceMap.put(oldPrice, priceMap.get(oldPrice) - 1);    		
    		}
    	}
    }
    
    public int current() {
        return treeMap.get(treeMap.lastKey());
    }
    
    public int maximum() {
    	return priceMap.lastKey();
    }
    
    public int minimum() {
    	return priceMap.firstKey();
    }
}


public class StockPriceFluctuations {
	public static void main(String[] args) {
	       StockPrice sp = new StockPrice();

	        // Input operations
	        String[] operations = {"StockPrice", "update", "update", "current", "maximum", "update", "maximum", "update", "minimum"};
	        int[][] values = { {}, {1, 10}, {2, 5}, {}, {}, {1, 3}, {}, {4, 2}, {} };

	        List<Object> output = new ArrayList<>();

	        for (int i = 0; i < operations.length; i++) {
	            switch (operations[i]) {
	                case "StockPrice":
	                    sp = new StockPrice();
	                    output.add(null);
	                    break;
	                case "update":
	                    sp.update(values[i][0], values[i][1]);
	                    output.add(null);
	                    break;
	                case "current":
	                    output.add(sp.current());
	                    break;
	                case "maximum":
	                    output.add(sp.maximum());
	                    break;
	                case "minimum":
	                    output.add(sp.minimum());
	                    break;
	            }
	        }

	        System.out.println(output);
	        // Expected: [null, null, null, 5, 10, null, 5, null, 2]
	    }
}
