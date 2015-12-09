# Randp Program
Author: Jerry Huang

This program defines the class Randp which is used to produce a random number between 1 and a specified number. The Randp class keeps track of which numbers have been used so that there are be no repeats. The Randp class contains a nextInt() method which is used to return one random number between 1 and the specified number. Once all the numbers have been selected, the method will be return 0. Randp does NOT extend Random, but uses Math.random().