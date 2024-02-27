# Traversing 2D Arrays

---

## Traversing 1D Arrays

Given a 1D array of values, we already have the skills to traverse it using loops. Here is a sample from the `Notes1DTraverse1.java` file:

```java
int[] nums = new int[] {3, 5, 1, 8, 9, 2, 3};

for (int i = 0; i < nums.length; i++) {
    System.out.println("Index: " + i + ", Value: " + nums[i]);
}

int index = 0;
while (index < nums.length) {
    System.out.println("Index: " + index + ", Value: " + nums[index]);
    index++;
}
```

This sample shows a `for` and `while` loop accomplishing the same result, printing out every element and their value. In that same loop we could have been doing any number of things: counting the number of values that meet a criteria, keeping track of a running total, modifying certain values, etc.

We also had an alternative way to traverse 1D arrays with the use of a `for-each` loop. Here is a sample from the `Notes1DTraverse2.java` file:

```java
int[] nums = new int[] {3, 5, 1, 8, 9, 2, 3};

for (int num : nums) {
    System.out.println("Value: " + num);
}
```

We had also addressed some shortcomings/drawbacks to `for-each` loops, including their lack of index and inability to modify elements. The header of a `for-each` loop is important, as it utilizes the type of element being stored (in this case `int`), a temporary variable for each copied value from the array (in this case `num`), a colon `:`, and the array we are traversing (in this case `nums`).

The basic skills of traversing 1D arrays are critical to being able to traverse 2D arrays.

---

## Approaches to Traversing 2D Arrays

When it came to 1D arrays, our "approach" options were limited. All we could really do was go forwards or backwards through the array. With 2D arrays, the idea of how we "approach" traversing it, or what order we should go through the elements, is more open. To see the potential considerations, consider the following table. In this table, the values are numbered in the order they are gone through (as opposed to actual values). We would start with the cell marked `0`, then `1` and so on.

```
|-------|----------|----------|----------|----------|----------|
|       | Column 0 | Column 1 | Column 2 | Column 3 | Column 4 |
|-------|----------|----------|----------|----------|----------|
| Row 0 |    0     |    1     |    2     |    3     |    4     |
|-------|----------|----------|----------|----------|----------|
| Row 1 |    5     |    6     |    7     |    8     |    9     |
|-------|----------|----------|----------|----------|----------|
| Row 2 |    10    |    11    |    12    |    13    |    14    |
|-------|----------|----------|----------|----------|----------|
| Row 3 |    15    |    16    |    17    |    18    |    19    |
|-------|----------|----------|----------|----------|----------|
| Row 4 |    20    |    21    |    22    |    23    |    24    |
|-------|----------|----------|----------|----------|----------|
```

This approach starts at the top left cell and goes across each row, then moves down a row, and continues. This in effect gets us all of the values in the array in what is known as a **row-major order** traversal, meaning that the rows are prioritized (the values in a row are done together before we move on to another row).

As you'd might expect, we can do a similar version with columns:

```
|-------|----------|----------|----------|----------|----------|
|       | Column 0 | Column 1 | Column 2 | Column 3 | Column 4 |
|-------|----------|----------|----------|----------|----------|
| Row 0 |    0     |    5     |    10    |    15    |    20    |
|-------|----------|----------|----------|----------|----------|
| Row 1 |    1     |    6     |    11    |    16    |    21    |
|-------|----------|----------|----------|----------|----------|
| Row 2 |    2     |    7     |    12    |    17    |    22    |
|-------|----------|----------|----------|----------|----------|
| Row 3 |    3     |    8     |    13    |    18    |    23    |
|-------|----------|----------|----------|----------|----------|
| Row 4 |    4     |    9     |    14    |    19    |    24    |
|-------|----------|----------|----------|----------|----------|
```

When we go through each column, then move across to the next column, and continue, we refer to the traversal as **column-major order**, meaning that the columns are prioritized (the values in columns are done together before we move on to another column).

While you can decide to go through forwards or backwards, all traversals are going to fall into one of these two forms, as they will have to either group the rows or group the columns.

---

## Traversing 2D Arrays with `for` Loops

With our approaches in tow, how do we actually traverse a 2D array? It all comes down to our two dimensions. With one dimension, we needed one loop to appropriately traverse the index values. With two dimensions, we will need two loops to appropriately traverse the row index with one loop and traverse the column index with the other.

To start this, let's look at a row-major order traversal, which is the more standard traversal of the two types. Let's look at the diagram again and focus more on the indices:

```
|-------|----------|----------|----------|----------|----------|
|       | Column 0 | Column 1 | Column 2 | Column 3 | Column 4 |
|-------|----------|----------|----------|----------|----------|
| Row 0 |    0     |    1     |    2     |    3     |    4     |
|-------|----------|----------|----------|----------|----------|
| Row 1 |    5     |    6     |    7     |    8     |    9     |
|-------|----------|----------|----------|----------|----------|
| Row 2 |    10    |    11    |    12    |    13    |    14    |
|-------|----------|----------|----------|----------|----------|
| Row 3 |    15    |    16    |    17    |    18    |    19    |
|-------|----------|----------|----------|----------|----------|
| Row 4 |    20    |    21    |    22    |    23    |    24    |
|-------|----------|----------|----------|----------|----------|
```

Our traversal needs to go across each row, then move to a new row each time. Notice the row and column indices for the values we need to traverse across:

```
   Row Index:   0   0   0   0   0   1   1   1   1   1   2
Column Index:   0   1   2   3   4   0   1   2   3   4   0
       Value:   0   1   2   3   4   5   6   7   8   9   10
```

Using this as a guide, we need to pick a row index, and hold it constant while we iterate through the column indices, then move onto a new row index and restart our column indices and go again.

Since the row indices need to be held constant while we iterate over the column, the rows should be handled by the outer loop. Since the column indices are iterated for each row, the columns should be handled by the inner loop.

Essentially in our traversal, the outer loop is going to select a row, and the inner loop is going to go through each column for that row, then repeat for the next row and so on.

That means our outer loop has to go through all of the rows based on their indices. The first row index will always be `0`, but the last row index can change depending on how big our 2D array is. This is where our work with `length` from Unit 8 Section 1 comes into play. We discussed then that asking a 2D array for its length will provide us with the number of rows (or 1D arrays) in the 2D array.

Here is our basic setup for the outer loop with a 2D array `arr` then: `for (int i = 0; i < arr.length; i++)`

Now for the columns. The inner loop has to go through all of the columns based on their indices. The first column index will always be `0`, but the last column index can change depending on how big our 2D array is. This is where our work with `length` from Unit 8 Section 1 comes into play again. We discussed then that to get the number of columns in a 2D array, we need to ask one of it's 1D arrays for its length. Fortunately, since we are in the inner loop, our outer loop will have selected a row (at index `i`) for us to look at, which is a 1D array.

Here is our basic setup for the inner loop with a 2D array `arr` then: `for (int j = 0; j < arr[i].length; j++)`

`arr[i].length` will get the 1D array located at row index `i`, and ask for its `length`, which for us represents the number of columns.

With these two loops in place, we now have variables `i` and `j` to represent row index and column index respectively. This means that inside of those two loops, we can access the element at row `i` and column `j` to accomplish the purpose of our traversal (which could be to print, to evaluate, etc.).

Here is what this looks like all put together from the `Notes2DTraverse1.java` file:

```java
int[][] arr = new int[][] {{0, 1, 2, 3, 4},
                           {5, 6, 7, 8, 9},
                           {10, 11, 12, 13, 14},
                           {15, 16, 17, 18, 19},
                           {20, 21, 22, 23, 24}};
for (int i = 0; i < arr.length; i++) {
    for (int j = 0; j < arr[i].length; j++) {
        System.out.println("Row: " + i + ", Column: " + j + ", Value: " + arr[i][j]);
    }
}
```

Notice that the 2D array `arr` is filled in with the values from our table above, so we can tell that our program works correctly if the printed value perfectly counts up.

With this example, we will be able to see the row index held constant while all columns are accessed, then move onto the next row and so on.

As mentioned earlier, row-major order is the typical/preferred way to traverse a 2D array, but some problems might require you to go in column-major order. This follows much the same setup as before, but now our outer loop will have to go through the columns, and our inner loop will have to go through rows.

If our outer loop is going through columns, we need to be able to tell how many columns there are. With row-major order, columns were easier as the inner loop because we had access to an index `i` to get a row that we could get the `length` of. This time though, columns are the outer loop so we don't have that luxury.

Our solution then is built on a very important premise: rectangular arrays. We are assuming in this course that our 2D arrays are rectangular, that is, all rows have the same number of columns. This is not a given in Java, as we can make non-rectangular or jagged 2D arrays, but we will not be worrying about them here.

Since our 2D arrays are rectangular, every row has the same `length`, so if we just ask the first row for its `length`, we can assume that it will work for all the other rows as well.

Here is our basic setup for the outer loop with a 2D array `arr` then: `for (int i = 0; i < arr[0].length; i++)`

Note that the only change from row-major order is that it is now `arr[0].length` instead of `arr.length` to track column indices instead of row indices.

The inner loop goes through an opposite change. It now needs to know the number of rows instead of number of columns, so it utilizes `arr.length`.

Here is our basic setup for the inner loop with a 2D array `arr` then: `for (int j = 0; j < arr.length; j++)`

With the loops set up, there is one final note we need to be aware of. When we access an element, we provide the row index and column index, in that order. Our row index is now represented by the inner loop, which utilizes `j`, and the column index is now represented by the outer loop, which utilizes `i`. So our access is now at row `j` and column `i`, which feels backwards, but will get us the column-major order we want.

Here is what this looks like all put together from the `Notes2DTraverse2.java` file:

```java
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
```

Notice that this time the 2D array `arr` is filled in with the values from column-major order table, so we can tell that our program works correctly if the printed value perfectly counts up.

With this example, we will be able to see the column index held constant while all rows are accessed, then move onto the next column and so on.

---

## Traversing 2D Arrays with `for-each` Loops

Just like we could use `for-each` loops to traverse 1D arrays, we can also use them to traverse 2D arrays. The same drawbacks are present: we won't have the indices (row or column) and we can't modify values. Regardless, some problems don't require that and this could be a simpler way to traverse.

A new drawback is present though: we can only do row-major order traversals. If for any reason a problem requires column-major order traversal, we have to use a traditional `for` loop. Why can't we do column-major order with `for-each` loops?

It all comes down to how `for-each` loops operate. A `for-each` loop takes each object from an array and copies it. Since a 2D array is just a 1D array of 1D arrays, a `for-each` loop will start by just taking a 1D array object (a row) from the 2D array) for each iteration.

Due to this behavior, we will still require two loops like we had above, even if both are now `for-each` loops.

The outer loop will access each row, and the inner loop will access the values of that row (going through its columns).

Since a row of a 2D array is a 1D array, this shows up in our notation for our `for-each` loop, since we need to specify the type of information being stored.

For a 2D array of `int` values called `arr`, it would look like this: `for (int[] row : arr)`

The type is `int[]` because one row of a 2D array of `int` values is a 1D `int` array. From then on, `row` represents a 1D array of the values of the current row.

Now the inner loop needs to go through all of the values stored in the 1D array `row`, which looks exactly like our traditional `for-each` loops with arrays, as each value in this 1D array is an `int` value.

For a 1D array of `int` values called `row`, it would look like this: `for (int value : row)`

So inside of the inner loop, the variable `value` will end up representing a copy of every value in the 2D array in row-major order.

Here is what this looks like all put together from the `Notes2DTraverse3.java` file:

```java
int[][] arr = new int[][] {{0, 1, 2, 3, 4},
                           {5, 6, 7, 8, 9},
                           {10, 11, 12, 13, 14},
                           {15, 16, 17, 18, 19},
                           {20, 21, 22, 23, 24}};
for (int[] row : arr) {
    for (int value : row) {
        System.out.println("Value: " + value);
    }
}
```

This obviously is much more concise than our traditional `for` loops, at the cost of the drawbacks of a `for-each` loop. If those drawbacks don't affect what we were trying to do (i.e. just printing in this case), it can simplify a problem a lot.

Notice that the 2D array `arr` is filled in with the values from the row-major order table, so we can tell that our program works correctly if the printed value perfectly counts up.

---

## Searching in a 2D Array

In Unit 7 Section 5 we discussed the general process for a **linear search** in an `ArrayList` (which for our use here can be considered equivalent to a 1D array). Essentially, we just go through the values in order and check if each one matches what we are looking for. If we ever find the value we are looking for, we can state the index of that value.

Here is what this would look like with a 1D array from the `NotesSearch1.java` file:

```java
int[] arr = new int[] {2, 5, 6, 3, 8, 7, 6, 4, 3};
int target = 3;
for (int i = 0; i < arr.length; i++) {
    if (arr[i] == target) {
        System.out.println(target + " was found at index " + i);
    }
}
```

This produces the following output:

```
3 was found at index 3
3 was found at index 8
```

This implementation just prints out the index whenever it finds the value (and therefore can find the value more than once if it is present more than once). We are not going to worry about how we would implement a method that returns the index instead of printing it for the sake of our 2D array case.

Notice that we could not have used a `for-each` loop here, as we need to know the index to answer the question.

What would have to change about this to work for a 2D array `arr` instead of a 1D array? At the end of the day, we just need to go through every value. Since it doesn't matter to this problem, we would lean towards row-major order, being the more standard of the two orders.

If we just change the traversal, otherwise this structure should otherwise work, we just have to put our `if` statement inside of the inner loop.

Here is what this would look like with a 2D array from the `NotesSearch2.java` file:

```java
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
```

This produces the following output:

```
3 was found at row index 0 and column index 0
3 was found at row index 4 and column index 2
3 was found at row index 4 and column index 4
```

This is considered a basic linear search for a 2D array because it looks through every value (in some order) to find the target.

---

## 2D Array Algorithms

Just like our modification of a linear search algorithm above, all of our basic algorithms from Unit 6 Section 4 for 1D arrays, can be similarly changed to work for 2D arrays. For the most part, it just requires replacement of the single loop traversal with a double loop traversal.

For each of the algorithms below, the 1D and 2D array versions are shown for comparison.

### Minimum

From the `NotesMinimum1.java` file:

```java
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
```

### Maximum

From the `NotesMaximum1.java` file:

```java
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
```

### Sum

From the `NotesSum1.java` file:

```java
public static int sumAges(Person[] people) {
    int sum = 0;
    for (Person person : people) {
        sum += person.getAge();
    }
    return sum;
}

public static int sumAges(Person[][] people) {
    int sum = 0;
    for (Person[] row : people) {
        for (Person person : row) {
            sum += person.getAge();
        }
    }
    return sum;
}
```

### Average

From the `NotesAverage1.java` file:

```java
public static double findAverage(int[] nums) {
    int sum = 0;
    for (int num : nums) {
        sum += num;
    }
    return (double) sum / nums.length;
}

public static double findAverage(int[][] nums) {
    int sum = 0;
    for (int[] row : nums) {
        for (int num : row) {
            sum += num;
        }
    }
    return (double) sum / (nums.length * nums[0].length);
}
```

### An Element with a Property

From the `NotesOneElementCondition1.java` file:

```java
public static boolean containsEven(int[] nums) {
    for (int num : nums) {
        if (num % 2 == 0) {
            return true;
        }
    }
    return false;
}

public static boolean containsEven(int[][] nums) {
    for (int[] row : nums) {
        for (int num : row) {
            if (num % 2 == 0) {
                return true;
            }
        }
    }
    return false;
}
```

### All Elements with a Property

From the `NotesAllElementsCondition1.java` file:

```java
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
```

### Determine the Number of Elements Meeting Criteria

From the `NotesNumberCriteria1.java` file:

```java
public static int howManyOldPeople(Person[] people) {
    int count = 0;
    for (Person person : people) {
        if (person.getAge() > 60) {
            count++;
        }
    }
    return count;
}

public static int howManyOldPeople(Person[][] people) {
    int count = 0;
    for (Person[] row : people) {
        for (Person person : row) {
            if (person.getAge() > 60) {
                count++;
            }
        }
    }
    return count;
}
```

---

## Assignment

Now that you have gone through the notes for this section, you can check out the `Try.md` and `Try.java` files to try a short assignment using this material.
