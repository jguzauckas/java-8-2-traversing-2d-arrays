public class NotesMaximum1 {
    public static double findMaximum(double[] vals) {
        double maximum = vals[0];
        for (double val : vals) {
            if (val > maximum) {
                maximum = val;
            }
        }
        return maximum;
    }
    
    public static double findMaximum(double[][] arr) {
        double maximum = arr[0][0];
        for (double[] row : arr) {
            for (double val : row) {
                if (val > maximum) {
                    maximum = val;
                }
            }
        }
        return maximum;
    }
}
