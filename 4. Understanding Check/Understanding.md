# Understanding Check

A multiplication table is a mathematical tool that allows us to see many possible combinations of multiplying numbers. Each entry in the table is the result of multiplying the header of its row (the left-most row value) and the header of its column (the top-most column value).

For our sake, the headers of the rows and columns are filling the places where traditionally we would write the indices (AKA these values are not stored in the multiplication table, we just know what they are on the outside).

Here is a sample multiplication table:

```
|---|----|----|----|----|----|
|   | 1  | 2  | 3  | 4  | 5  |
|---|----|----|----|----|----|
| 1 | 1  | 2  | 3  | 4  | 5  |
|---|----|----|----|----|----|
| 2 | 2  | 4  | 6  | 8  | 10 |
|---|----|----|----|----|----|
| 3 | 3  | 6  | 9  | 12 | 15 |
|---|----|----|----|----|----|
| 4 | 4  | 8  | 12 | 16 | 20 |
|---|----|----|----|----|----|
| 5 | 5  | 10 | 15 | 20 | 25 |
|---|----|----|----|----|----|
| 6 | 6  | 12 | 18 | 24 | 30 |
|---|----|----|----|----|----|
```

You are going to write the method `multiplicationTable`, which returns a 2D array of `int` values that make up a multiplication table. The method has an two `int` parameters `row` and `col` the largest value that the rows should go up to (this would have been `6` for the table above) and the largest value that the columns go up to (this would have been `5` for the table above)

Ultimately, this method creates a 2D `int` array of the right size, and calculates the correct values for each cell. Once it has filled in all of the values, it returns the 2D array as your answer.

There is existing code in the `Understanding.java` file that will call `multiplicationTable` with random values each time it is run, and print out the table so you can see if it is working correctly.

Note: the multiplication table starts at `1`, but your index starts at `0`. You will need to look out for this!

The header for this method should look like this: `public static int[][] multiplicationTable(int row, int col)`

Once you have gotten to just warnings, save the Java file and commit and push your changes via GitHub Desktop.
