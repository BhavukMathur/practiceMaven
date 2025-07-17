package target2024.algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;


class RandomizedSet {

	ArrayList<Integer> valList;
	Map<Integer, Integer> valIndex;

	public RandomizedSet() {
		valList = new ArrayList<>();
		valIndex = new HashMap();
	}

	public boolean insert(int val) {
		if(valIndex.get(val) == null) {
			valList.add(val);
			valIndex.put(val, valList.size()-1);
			return true;
		} else {
			return false;
		}
	}

	public boolean remove(int val) {
		if(valIndex.get(val) == null) {
			return false;
		} else {
			int ind = valIndex.get(val);
			//Swap with the last element
			int lastElement = valList.get(valList.size() - 1);
			valList.set(ind, lastElement);
			valList.remove(valList.size() - 1);

			valIndex.put(lastElement, ind);
			valIndex.remove(val);
			return true;
		}
	}

	public int getRandom() {
		int size = valList.size();
		int ind = (int)(Math.random() * size);
		return valList.get(ind);
	}
}

class RandomizedSetDemo{
	public static void main(String[] args) {
		RandomizedSet rs = new RandomizedSet();
		rs.insert(0);
		rs.insert(1);
		rs.remove(0);
		rs.insert(2);
		rs.remove(1);
		System.out.println(rs.getRandom());
	}
}



/**
 * Your RandomizedSetDemo object will be instantiated and called as such:
 * RandomizedSetDemo obj = new RandomizedSetDemo();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */

/**
 * Your RandomizedSetDemo object will be instantiated and called as such:
 * RandomizedSetDemo obj = new RandomizedSetDemo();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */