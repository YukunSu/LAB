import java.util.Arrays;


public class ThreeSumClosestMain {

    public static void main(String[] args) {
        int[] test1 = new int[] {1, 2, 4, 8, 16, 32, 64, 128};
        int target1 = 82;
        int result = threeSumClosest(test1, target1);
        System.out.println(result);

    }
    
    public static int threeSumClosest(int[] num, int target) {
        int result = num[0] + num[1] + num[num.length - 1];
        Arrays.sort(num);
        for (int i = 0; i < num.length - 2; i++) {
            int start = i + 1, end = num.length - 1;
            while (start < end) {
                int sum = num[i] + num[start] + num[end];
                if (sum > target) {
                    end--;
                } else {
                    start++;
                }
                if (Math.abs(sum - target) < Math.abs(result - target)) {
                    result = sum;
                }
            }
        }
        return result;
    }

}
