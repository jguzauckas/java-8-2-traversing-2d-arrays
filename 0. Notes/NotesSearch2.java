public class NotesSearch2 {
    public static void main(String[] args) {
        int[][] arr = new int[][] {{3, 7, 2, 11, 4},
                                   {1, 5, 8, 15, 13},
                                   {1, 2, 6, 5, 12},
                                   {2, 5, 7, 23, 9},
                                   {12, 10, 3, 5, 3}};
        int target = 3;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == target) {
                    System.out.println(target + " was found at row index " + i + " and column index " + j);
                }
            }
        }
    }
}
