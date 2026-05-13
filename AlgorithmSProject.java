package algorithm.s.project;

public class AlgorithmSProject {

    public static void main(String[] args) {
    
    int[] arr = {-10,-10,2,5,7,8,8,6,10};
    int optimal_value = non_recursive(arr);
    System.out.println("non_recursive algorithm result = " + optimal_value);
    int optimal_value2 = recursive(arr);
    System.out.println("recursive algorithm result = " + optimal_value2);
}
static int maxResult = Integer.MIN_VALUE;

public static void Max(int[] nums, int index, int count, int currentProduct) {
    
    if (count == 3) {
        maxResult = Math.max(maxResult, currentProduct);
        return;
    }
    
    if (index == nums.length) {
        return; 
    }


    Max(nums, index + 1, count + 1, currentProduct * nums[index]);

    Max(nums, index + 1, count, currentProduct);
}

public static int recursive(int[] nums) {
    maxResult = Integer.MIN_VALUE;
    Max(nums, 0, 0, 1); 
    return maxResult;
}
    public static int non_recursive(int[] nums){
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;

        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;

        for (int n : nums) {

            if (n > max1) {
                max3 = max2;
                max2 = max1;
                max1 = n;
            } else if (n > max2) {
                max3 = max2;
                max2 = n;
            } else if (n > max3) {
                max3 = n;
            }

            if (n < min1) {
                min2 = min1;
                min1 = n;
            } else if (n < min2) {
                min2 = n;
            }
        }

        int option1 = max1 * max2 * max3;
        int option2 = min1 * min2 * max1;

        return Math.max(option1, option2);
    }
}
