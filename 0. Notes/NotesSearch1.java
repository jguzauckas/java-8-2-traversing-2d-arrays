public class NotesSearch1 {
    public static void main(String[] args) {
        int[] arr = new int[] {2, 5, 6, 3, 8, 7, 6, 4, 3};
        int target = 3;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                System.out.println(target + " was found at index " + i);
            }
        }
    }
}
