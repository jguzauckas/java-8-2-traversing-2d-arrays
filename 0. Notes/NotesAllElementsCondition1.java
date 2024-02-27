public class NotesAllElementsCondition1 {
    public static boolean allNegative(int[] nums) {
        for (int num : nums) {
            if (num >= 0) {
                return false;
            }
        }
        return true;
    }
    
    public static boolean allNegative(int[][] nums) {
        for (int[] row : nums) {
            for (int num : row) {
                if (num >= 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
