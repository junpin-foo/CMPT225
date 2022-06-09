assignment1
Part 1 [50 points] - Integer Iterator IntegerIterator represents a sequence (finite or infinite) of integers a 0 ,a 1 ,a 2 .... The interface has the following public methods:

public boolean hasNext() : Returns true if the sequence has more elements, and returns false otherwise. If the sequence is infinite, has Next() always returns true.

public int getNext() : Returns the next element in the sequence.

public void reset(): Resets the iterator to the initial element of the sequence, i.e., to a 0 .

The interface is provided with the assignment under the package myiterators. Your goal is to write the following 3 classes implementing this interface:

ArrayIterator [15 points] The class has one constructor that gets an array of ints. public ArrayIterator( int [] ar) The iterator iterates through the elements of the array.

RangeIterator [15 points] The class has three constructors:

public RangeIterator( int n) The iterator iterates through the elements 0,1...n-1. If n<0, then the sequence is empty.

public RangeIterator( int a0, int n) Defines the sequence a 0 , a 0 +1, a 0 +2,...n-1. If n<a 0 , then the sequence is empty.

public RangeIterator( int a0, int n, int diff) Defines the sequence a 0 , a 0 +diff, a 0 +2diff,..., a 0 +kdiff, where k is the maximal integer such that a 0 +kdiff<n. If n<a 0 , then the sequence is empty.

FibonacciIterator [20 points] The Fibonacci sequence is defined as a 0 =0,a 1 =1, and a n = a n-1 +a n-2 for all n>1. More generally , given the initial values of a 0 and a 1 we define the sequence as a n = a n-1 +a n-2 for all n>1. The class implements the infinite Fibonacci sequence. It has two constructors:

public FibonacciIterator() Defines the Fibonacci sequence with a 0 =0,a 1 =1.

public FibonacciIterator( int a0, int a1) Defines the more general Fibonacci sequence with a 0 and a 1 given as arguments to the constructor.

Part 2 [50 points] - Rush Hour RushHour is a class representing the game RushHour. See wiki page for the description https://en.wikipedia.org/wiki/Rush_Hour_(puzzle) Find the game online and play it. Your goal in this part is to read an initial board from a file, and move the cars on the board. The file is expected to have 6 rows with 6 chars in each row.

A dot represents an empty cell.
Each car is represented by a letter.
Each car can go either only horizontally or only vertically. The allowed direction of a car is defined by the longer side of the car.
Vehicles can only be moved along a straight line on the grid; rotation is forbidden
The red car (the one we need to get to the exit) is denoted by X.
The goal is to bring the red car, denoted by X to the right edge of the board.
You may assume that the file always represents a legal board. See board1.txt for an example. Write the class RushHour with the following constructor and three public methods:
public RushHour(String fileName) throws FileNotFoundException The constructor gets a name of a file as an argument. It reads the file and initializes the board.

public void makeMove( char carName, int direction, int length) throws IllegalMoveException

The method moves the car in the car for length steps in the given direction. If the move is illegal the method throws IllegalMoveException. The move can be illegal because the direction is incorrect or because some cells on the way are occupied. The class IllegalMoveException is provided with the assignment. It is very simple, it just inherits from Exception.

public boolean isSolved() Returns true if and only if the car X touches the right edge of the board.
Remarks : The provided class RushHour has several constants: UP, DOWN, LEFT, RIGHT, and SIZE. They are provided for your convenience. You may use them , but you don’t have to. You may add additional private methods if needed. You may also add new classes if needed. For example, you may want to consider creating a class Car to represent a car on the board.
