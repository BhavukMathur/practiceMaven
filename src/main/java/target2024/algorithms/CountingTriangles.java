package target2024.algorithms;

import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//https://www.metacareers.com/profile/coding_practice_question/?problem_id=720422605157879&c=1373057600385980&psid=275492097255885&practice_plan=0&b=0111122
class Sides{
	int a;
	int b;
	int c;
	Sides(int a,int b,int c){
		this.a = a;
		this.b = b;
		this.c = c;
	}
}

public class CountingTriangles {
	public static void main(String[] args) {
		CountingTriangles ct = new CountingTriangles();
		int[][] arr = {{2, 2, 3}, {3, 2, 2}, {2, 5, 6}};
		ArrayList<Sides> tList = new ArrayList<>();
		for(int i=0; i<arr.length; i++) {
			Sides triangle = new Sides(arr[i][0], arr[i][1], arr[i][2]);
			tList.add(triangle);
		}
		System.out.println(ct.countDistinctTriangles(tList));
	}


	int countDistinctTriangles(ArrayList<Sides> arr) {
		Set<String> hashSet = new HashSet<>();
		int tCount = 0;

		for(Sides side: arr) {
			int[] sarr = new int[3];
			sarr[0] = side.a;
			sarr[1] = side.b;
			sarr[2] = side.c;
			Arrays.sort(sarr);
			String result = sarr[0] + "-" + sarr[1] + "-" + sarr[2];
			if(hashSet.contains(result)) {
				System.out.println("skipping " + result);
			} else {
				tCount++;
				hashSet.add(result);
			}
		}
		return tCount;
	}

}
