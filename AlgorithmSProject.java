package algorithm.s.project;

public class AlgorithmSProject {

    public static void main(String[] args) {
    
    int[] arr = {-12,-10,2,5,15,8,8,11,13};
    int optimal_value = non_recursive(arr);
    System.out.println("non_recursive algorithm result = " + optimal_value);
    int optimal_value2 = recursive(arr);
    System.out.println("recursive algorithm result = " + optimal_value2);
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
    public static int recursive(int[] A) {
        heapSort(A);
        
        int n = A.length;
        int option1 = A[n-1] * A[n-2] * A[n-3];
        int option2 = A[0] * A[1] * A[n-1];
        
        return Math.max(option1, option2);
    }
    public static void heapSort(int[] A) {
        int heapSize = A.length;
        buildMaxHeap(A, heapSize);
        
        for (int i = A.length - 1; i >= 1; i--) {
            int temp = A[0];
            A[0] = A[i];
            A[i] = temp;
            
            heapSize--;
            maxHeapify(A, 0, heapSize);
        }
    }

    public static void buildMaxHeap(int[] A, int heapSize) {
        for (int i = (A.length / 2) - 1; i >= 0; i--) {
            maxHeapify(A, i, heapSize);
        }
    }

    public static void maxHeapify(int[] A, int i, int heapSize) {
        int l = 2 * i + 1; 
        int r = 2 * i + 2; 
        int largest = i;

        if (l < heapSize && A[l] > A[i]) {
            largest = l;
        }
        
        if (r < heapSize && A[r] > A[largest]) {
            largest = r;
        }
        
        if (largest != i) {
            int temp = A[i];
            A[i] = A[largest];
            A[largest] = temp;
            maxHeapify(A, largest, heapSize);
        }
    }
    
}
