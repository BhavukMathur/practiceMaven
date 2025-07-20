package target2024.arraysstrings;

public class MedianOfSortedArrays {

	public static void main(String[] args) {
        int[] arr1 = {1, 3, 4};
        int[] arr2 = {2, 5};
        double result = findMedian(arr1, arr2);
        System.out.println(result);
	}
	
    private static double findMedian(int[] arr1, int[] arr2) {
        int size1 = arr1.length;
        int size2 = arr2.length;
        int medIndex; //right index for even median

        medIndex = (size1 + size2) / 2;
        //Even --> 3 + 3 = 6 = 3
        //Odd --> 2 + 3 = 5 = 2

        int i=0,j=0, sumInd=0;

        while(i < arr1.length && j < arr2.length) {
            sumInd = (i+j);

            //Reached median
            if(sumInd == medIndex) {
                //return from here
                if((size1 + size2)%2 != 0) {
                    //Odd
                    return Math.min(arr1[i], arr2[j]);
                } else {
                	//Even - TODO: Fix the logic
                    //[1, 2, 3, 4, 5, 6]
                    //[4, 5]
                    double val1, val2;

                    if(arr1[i] < arr2[j]) {
                    	val1 = arr1[i];
                    } else {
                    	val1 = arr2[j];
                    }
                	i--;
                	j--;
                	val2 = Math.max(arr1[i], arr2[j]);
                    
                    return ((val1 + val2)) / 2;
                }
                    
            }

            if(arr1[i] < arr2[j]) {
                i++;
            } else {
                j++;
            }
        }
        return -1;
    }	
}
