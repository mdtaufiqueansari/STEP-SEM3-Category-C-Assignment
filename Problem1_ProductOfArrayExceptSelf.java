import java.util.Scanner;
import java.util.Arrays;

public class Problem1_ProductOfArrayExceptSelf {

    static int[] productExceptSelf(int[] nums) {

        int[] answer = new int[nums.length];

        // Forward pass: store product of elements to the left
        int prefixProduct = 1;

        for (int i = 0; i < nums.length; i++) {

            answer[i] = prefixProduct;

            prefixProduct = prefixProduct * nums[i];
        }

        // Backward pass: multiply by product of elements to the right
        int suffixProduct = 1;

        for (int i = nums.length - 1; i >= 0; i--) {

            answer[i] = answer[i] * suffixProduct;

            suffixProduct = suffixProduct * nums[i];
        }

        return answer;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter array elements:");

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int[] result = productExceptSelf(nums);

        System.out.println(
                "Result: " + Arrays.toString(result)
        );

        sc.close();
    }
}