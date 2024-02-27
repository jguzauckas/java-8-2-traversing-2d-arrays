public class Understanding {
    public static void main (String[] args){
        int[][] table = multiplicationTable((int) (Math.random() * 8 + 2), (int) (Math.random() * 8 + 2));
        for (int i = 0; i < table[0].length; i++) {
            System.out.print("\t" + (i + 1));
        }
        System.out.println();
        for (int i = 0; i < table.length; i++) {
            System.out.print((i + 1) + "\t");
            for (int j = 0; j < table[i].length; j++) {
                System.out.print(table[i][j] + "\t");
            }
            System.out.println();
        }
    }

    // Your work goes here!
}