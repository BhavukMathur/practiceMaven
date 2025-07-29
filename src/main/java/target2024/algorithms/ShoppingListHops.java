package target2024.algorithms;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ShoppingListHops {

    public static void main(String[] args) {
        String[][] products = {
            {"apple", "fresh"},
            {"banana", "fresh"},
            {"milk", "dairy"},
            {"bread", "bakery"},
            {"cheese", "dairy"}
        };

        List<String> shoppingList = Arrays.asList("apple", "milk", "banana");

        int additionalHops = calculateAdditionalHops(products, shoppingList);
        System.out.println("Additional hops: " + additionalHops);
    }
    
    private static int calculateAdditionalHops(String[][] products, List<String> shoppingList) {
    	//Create hashmap [product --> department]
    	
    	Map<String, String> productToDept = new HashMap<>();
    	for(String[] product: products) {
    		productToDept.put(product[0], product[1]);
    	}

    	//Approach1: Go to each department and get the items per department
    	Set<String> dept = new HashSet<>();
    	for(String item: shoppingList) {
    		dept.add(productToDept.get(item));
    	}
    	int size1 = dept.size(); //lesser
    	
    	
    	//Approach2: Go to each dept in order of shopping list
    	String lastDept = "";
    	int size2=0;
    	for(String item: shoppingList) {
    		if(productToDept.get(item).equals(lastDept)) {
    			//Already on that dept, do nothing
    		} else {
    			size2++;
    			lastDept = productToDept.get(item);
    		}
    	}
    	
    	return (size2 - size1);
    }
}
