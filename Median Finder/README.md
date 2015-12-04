# Median Finder Program
Author: Jerry Huang

This program finds the median of an array through recursion. It works by categorizing every element inside myArray into one of the three ArrayLists - bigger, smaller, or same. The program then determines whether there are more values above or below the pivot point. It then partitions the array correspondingly. Values that are removed when the array is partitioned are stored in either the numsAbove or the numsBelow variable. These variables are necessary because they account for the elements that are not in the current myArray but were removed in previous recursive steps.

---

Note: The program only works with arrays with an odd number of elements. When an array with an even number of elements is used, the program will return the higher of the two median values. I tried to fix this problem, but I couldn’t find a way for the program to average out the two middle values because of the recursion that is occurring in my program.