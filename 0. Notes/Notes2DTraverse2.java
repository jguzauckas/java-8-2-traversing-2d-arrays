public class Notes2DTraverse2 {
    public static void main(String[] args) {
        int[][] arr = new int[][] {{0, 5, 10, 15, 20},
                           {1, 6, 11, 16, 21},
                           {2, 7, 12, 17, 22},
                           {3, 8, 13, 18, 23},
                           {4, 9, 14, 19, 24}};
        for (int i = 0; i < arr[0].length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.println("Row: " + j + ", Column: " + i + ", Value: " + arr[j][i]);
            }
        }
    }
}
