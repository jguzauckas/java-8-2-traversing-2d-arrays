# You Do

Sometimes with 2D arrays, problems can ask questions that require different techniques or algorithms to answer. Here are a couple of sample questions:
1. Does a given row contain a value?
2. Which column has the maximum average value?

We are going to tackle these modified algorithms for this assignment.

## Does a given row contain a value?

You are going to write the `rowContains` method, which has three parameters: a 2D `int` array `arr`, an `int` value `row`, and an `int` value `target`.

The problem requires you to traverse just the row at index `row` in `arr`, and see if it contains the value `target`, returning `true` if it does, and `false` if it does not. It is possible for the value `target` to be present in other rows of the array `arr`, but this question only wants to know if it is in the given row.

To solve this, you need to iterate just over the provided `row`, getting each of its columns, which will require only one loop.

## Which column has the maximum average value?

You are going to write the `maxColumnAverage` method, which has one parameter: a 2D `double` array `arr`.

The problem requires you to independently average the values in each of the columns of `arr`, and meanwhile keep track of which column had the largest (or maximum) average.

When complete, the method should return the `int` value representing the index of the column that had the highest average.

To solve this, you need to traverse the array `arr` in column-major order. As you traverse, perform an average calculation using the inner loop (which will go through all the values in a column). Each time the inner loop ends, check if this column has the new largest average (almost like you are using the outer loop to do a maximum algorithm).

Once you have gotten to just warnings, save the Java file and commit and push your changes via GitHub Desktop.