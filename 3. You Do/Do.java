public class Do {
    public static void main (String[] args){
        int[][] testInts = new int[(int) (Math.random() * 10 + 2)][(int) (Math.random() * 10 + 2)];
        System.out.println("Values of arr for rowContains:");
        for (int i = 0; i < testInts.length; i++) {
            for (int j = 0; j < testInts[i].length; j++) {
                testInts[i][j] = (int) (Math.random() * 10);
                System.out.print(testInts[i][j] + "\t");
            }
            System.out.println();
        }
        int row = (int) (Math.random() * testInts.length);
        int target = (int) (Math.random() * 10);
        boolean answer1 = rowContains(testInts, row, target);
        System.out.println("\nCall to rowContains with row " + row + " and target " + target + " is " + answer1);
        
        double[][] testDubs = new double[(int) (Math.random() * 10 + 2)][(int) (Math.random() * 10 + 2)];
        System.out.println("\nValues of arr for rowContains:");
        for (int i = 0; i < testDubs.length; i++) {
            for (int j = 0; j < testDubs[i].length; j++) {
                testDubs[i][j] = Math.random() * 100;
                System.out.print(testDubs[i][j] + "\t");
            }
            System.out.println();
        }
        int answer2 = maxColumnAverage(testDubs);
        System.out.println("\nCall to maxColumnAverage says that column " + answer2 + " has the highest average");
    }

    public static boolean rowContains(int[][] arr, int row, int target) {
        // Your work goes here.
    }

    public static int maxColumnAverage(double[][] arr) {
        // Your work goes here.
    }
}
