package rushhour;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class RushHour {
    public final static int UP = 0;
    public final static int DOWN = 1;
    public final static int LEFT = 2;
    public final static int RIGHT = 3;

    public final static int SIZE = 6;
    public char[][] board = new char[6][6];

    /**
     * @param fileName Reads a board from file and creates the board
     * @throws Exception if the file not found or the board is bad
     */
    public RushHour(String fileName) throws Exception {

        File file = new File(fileName);
        Scanner reader = new Scanner(file);

        int row = 0;

        while(reader.hasNextLine()) {
            String temp = reader.nextLine();
            char[] array = temp.toCharArray();
            if(temp.length() != 6)
                throw new Exception("Bad file");
            board[row] = array;
            row++;
        }

        // Close the file
        reader.close();
    }

    /**
     * @param carName
     * @param dir
     * @param length  Moves car with the given name for length steps in the given direction
     * @throws IllegalMoveException if the move is illegal
     */
    public void makeMove(char carName, int dir, int length) throws IllegalMoveException {

        if (dir > 3 || dir < 0)
            throw new IllegalMoveException("No such direction");

        int positionRow1 = -1 , positionCol1 = -1, positionRow2 = -1, positionCol2 = -1;
        boolean position;
		/*
		true = vertical, false = horizontal
		*/

        int count = 0;

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (board[i][j] == carName && count == 0) {
                    positionRow1 = i;
                    positionCol1 = j;
                    count++;
                } else if (board[i][j] == carName && count == 1) {
                    positionRow2 = i;
                    positionCol2 = j;
                }
            }
        }
        int carSize = 0;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (board[i][j] == carName) {
                    carSize++;
                }
            }
        }
        if(positionCol1 == -1)
            throw new IllegalMoveException("No 1 block car");
        else if (positionCol1 == positionCol2)
            position = true;
        else
            position = false;

        int counter;

        if (position) { // vertical
            if (dir != 0 && dir != 1)
                throw new IllegalMoveException("Vertical cars can only move up/down");

            switch (dir) {
                case 0: //move up
                    counter = 0;
                    for (int i = 0; i < 6; i++) {
                        for (int j = 0; j < 6; j++) {
                            if (board[i][j] == carName) {
                                if (notOverlapped(dir, i, j, board, length, carName)&& counter != carSize) {
                                    board[i][j] = '.';
                                    board[i - length][j] = carName;
                                    counter++;
                                }
                                else if (counter == 0) {
                                    throw new IllegalMoveException("Overlapped while moving up");
                                }
                            }
                        }
                    }
                    break;
                case 1: //move down
                    counter = 0;
                    for (int i = 5; i >= 0; i--) {
                        for (int j = 5; j >= 0; j--) {
                            if (board[i][j] == carName) {
                                if (notOverlapped(dir, i, j, board, length, carName)&& counter != carSize) {
                                    char temp = board[i][j];
                                    board[i][j] = '.';
                                    board[i + length][j] = temp;
                                    counter++;
                                }
                                else if (counter == 0) {
                                    throw new IllegalMoveException("Overlapped while moving down");
                                }
                            }
                        }
                    }
                    break;
            }
        }
        if (position == false) { //horizontal
            if (dir != 2 && dir != 3)
                throw new IllegalMoveException("Horizontal cars can only move left/right");
            switch (dir) {
                case 2: //move left
                    counter = 0;
                    for (int i = 0; i < 6; i++) {
                        for (int j = 0; j < 6; j++) {
                            if (board[i][j] == carName) {
                                if (notOverlapped(dir, i, j, board, length, carName)&& counter != carSize) {
                                    board[i][j] = '.';
                                    board[i][j - length] = carName;
                                    counter++;
                                }
                                else if (counter == 0) {
                                    throw new IllegalMoveException("Overlapped while moving to the left");
                                }
                            }
                        }
                    }
                    break;
                case 3: //move right
                    counter = 0;
                    for (int i = 5; i >= 0; i--) {
                        for (int j = 5; j >= 0; j--) {
                            if (board[i][j] == carName) {
                                if (notOverlapped(dir, i, j, board, length, carName)&& counter != carSize) {
                                    char temp = board[i][j];
                                    board[i][j] = '.';
                                    board[i][j + length] = temp;
                                    counter++;
                                }
                                else if (counter == 0) {
                                    throw new IllegalMoveException("Overlapped while moving to the right");
                                }
                            }
                        }
                    }
                    break;
            }
        }


    }


    /**
     * @return true if and only if the board is solved,
     * i.e., the XX car is touching the right edge of the board
     */
    public boolean isSolved() {
        for (int i = 0; i < 6; i++) {
            if(board[i][5] == 'X')
                return true;
        }
        return false;
    }

    public boolean notOverlapped(int dir, int I, int J, char[][] array, int length, char carName) throws IllegalMoveException{ // I,J is current position

        if (dir == 0) {
            if (I - length < 0) // move up
                return false;
            for (int i = I; i >= I - length; i--) {
                if (array[i][J] == '.' || array[i][J] == carName)
                    continue;
                else{
                    return false;
                }
            }
            return true;
        } else if (dir == 1) {
            if (length + I > 5) // move down
                return false;
            for (int i = I; i <= length + I; i++) {
                if (array[i][J] == '.' || array[i][J] == carName)
                    continue;
                else
                    return false;
            }
            return true;
        } else if (dir == 2) {
            if (J - length < 0) // move left
                return false;
            for (int j = J; j >= J - length; j--) {
                if (array[I][j] == '.' || array[I][j] == carName)
                    continue;
                else
                    return false;
            }
            return true;
        } else if (dir == 3) {
            if (length + J > 5) // move right
                return false;
            for (int j = J; j <= length + J; j++) {
                if (array[I][j] == '.' || array[I][j] == carName)
                    continue;
                else
                    return false;
            }
            return true;
        } else {
            return false;
        }
    }

    public void print(){

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                System.out.println(board[i][j] + " ");
            }
        }
    }

}


