public class Notes1DTraverse1 {
    public static void main(String[] args) {
        int[] nums = new int[] {3, 5, 1, 8, 9, 2, 3};

        for (int i = 0; i < nums.length; i++) {
            System.out.println("Index: " + i + ", Value: " + nums[i]);
        }

        int index = 0;
        while (index < nums.length) {
            System.out.println("Index: " + index + ", Value: " + nums[index]);
            index++;
        }
    }
}
