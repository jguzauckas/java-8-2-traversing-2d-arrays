public class NotesMinimum1 {
    public static double findMinimum(double[] arr) {
        double minimum = arr[0];
        for (double val : arr) {
            if (val < minimum) {
                minimum = val;
            }
        }
        return minimum;
    }
    
    public static double findMinimum(double[][] arr) {
        double minimum = arr[0][0];
        for (double[] row : arr) {
            for (double val : row) {
                if (val < minimum) {
                    minimum = val;
                }
            }
        }
        return minimum;
    }
}
