/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this temporarylate file, choose Tools | Templates
 * and open the temporarylate in the editor.
 */
package theknighttour;

/**
 *
 * @author Algharabeh
 */
public class Board {

    public final int Avaliable = 10;
    public final int Taken = 14;
    public final int NotAvaliable = 11;
    private final int[][] board = new int[8][8];
    public long StartTime;
    public long EndTime;
    public int Row;
    public int Column;
    private final DrawTheBoard DrawtheBoard;

    public Board(DrawTheBoard DrawtheBoard) {  // Constructer 
        this.DrawtheBoard = DrawtheBoard;
        for (int[] theboard : board) {
            for (int i = 0; i < theboard.length; i++) {
                theboard[i] = Avaliable;
            }
        }
    }

    public void dotheColumn(int newColumn) { // Method that sets the colunm
        this.Column = newColumn;
    }

    public int taketheColumn() { // Method that gets the colunm
        return this.Column;
    }

    public void dotheRow(int newRow) { // Method that sets the row
        this.Row = newRow;
    }

    public int taketheRow() { // Method that gets the row
        return this.Row;
    }

    public void fixIntialLocation(int row, int column) { // method that set the intial position
        this.Row = row;
        this.Column = column;
        this.board[row][column] = NotAvaliable;
    }

    public void fixLocation(int row, int column, int thekindofmove) {  // method that sets the position
        this.Row = row;
        this.Column = column;
        this.board[row][column] = thekindofmove;
    }

    public int[] PossibleMovesCount(int row, int column) { // A method that checks which moves will be possible for the knight to visit

        int counter=1;

        if ((row - 2 >= 0) && ((column - 1) >= 0) && board[row - 2][column - 1] == Avaliable) {
            counter++;
        }
        if ((column + 2 < board.length) && (row + 1 < board.length) && board[row + 1][column + 2] == Avaliable) {
            counter++;
        }

        if ((column + 2 < board.length) && (row - 1 >= 0) && board[row - 1][column + 2] == Avaliable) {
            counter++;
        }
        if ((row + 2 < board.length) && (column - 1 >= 0) && board[row + 2][column - 1] == Avaliable) {
            counter++;
        }

        if ((row + 2 < board.length) && (column + 1 < board.length) && board[row + 2][column + 1] == Avaliable) {
            counter++;
        }
        if ((column - 2 >= 0) && (row - 1 >= 0) && board[row - 1][column - 2] == Avaliable) {
            counter++;
        }

        if ((row - 2 >= 0) && (column + 1 < board.length) && board[row - 2][column + 1] == Avaliable) {
            counter++;
        }

        if ((column - 2 >= 0) && (row + 1 < board.length) && board[row + 1][column - 2] == Avaliable) {
            counter++;
        }

        return new int[]{counter, row, column};
    }

    public void FindTheWay(int row, int column) {// A method that gives the knight the direction
        board[row][column] = NotAvaliable;
        DrawtheBoard.SetTheBoard(row,column);
        int MinimumRow = 0;
        int MinimumColumn = 0;
        int Minimum = 8;
        boolean doable = false;
        int[][] CountingTheMoves = new int[8][8];
        int[] temporary = new int[10];

        if (row - 2 >= 0 && column + 1 < board.length && board[row - 2][column + 1] == Avaliable) {
            temporary = PossibleMovesCount(row - 2, column + 1);
            CountingTheMoves[0][0] = temporary[0];
            CountingTheMoves[0][1] = temporary[1];
            CountingTheMoves[0][2] = temporary[2];
        }

        if (row - 1 >= 0 && column + 2 < board.length && board[row - 1][column + 2] == Avaliable) {
            temporary = PossibleMovesCount(row - 1, column + 2);
            CountingTheMoves[1][0] = temporary[0];
            CountingTheMoves[1][1] = temporary[1];
            CountingTheMoves[1][2] = temporary[2];
        }

        if (row + 1 < board.length && column + 2 < board.length && board[row + 1][column + 2] == Avaliable) {
            temporary = PossibleMovesCount(row + 1, column + 2);
            CountingTheMoves[2][0] = temporary[0];
            CountingTheMoves[2][1] = temporary[1];
            CountingTheMoves[2][2] = temporary[2];
        }

        if (row + 2 < board.length && column + 1 < board.length && board[row + 2][column + 1] == Avaliable) {
            temporary = PossibleMovesCount(row + 2, column + 1);
            CountingTheMoves[3][0] = temporary[0];
            CountingTheMoves[3][1] = temporary[1];
            CountingTheMoves[3][2] = temporary[2];
        }

        if (row + 2 < board.length && column - 1 >= 0 && board[row + 2][column - 1] == Avaliable) {
            temporary = PossibleMovesCount(row + 2, column - 1);
            CountingTheMoves[4][0] = temporary[0];
            CountingTheMoves[4][1] = temporary[1];
            CountingTheMoves[4][2] = temporary[2];
        }

        if (row + 1 < board.length && column - 2 >= 0 && board[row + 1][column - 2] == Avaliable) {
            temporary = PossibleMovesCount(row + 1, column - 2);
            CountingTheMoves[5][0] = temporary[0];
            CountingTheMoves[5][1] = temporary[1];
            CountingTheMoves[5][2] = temporary[2];
        }

        if (row - 1 >= 0 && column - 2 >= 0 && board[row - 1][column - 2] == Avaliable) {
            temporary = PossibleMovesCount(row - 1, column - 2);
            CountingTheMoves[6][0] = temporary[0];
            CountingTheMoves[6][1] = temporary[1];
            CountingTheMoves[6][2] = temporary[2];
        }
        if (row - 2 >= 0 && column - 1 >= 0 && board[row - 2][column - 1] == Avaliable) {
            temporary = PossibleMovesCount(row - 2, column - 1);
            CountingTheMoves[7][0] = temporary[0];
            CountingTheMoves[7][1] = temporary[1];
            CountingTheMoves[7][2] = temporary[2];
        }

        for (int[] CountingTheMove : CountingTheMoves) {
            if ((CountingTheMove[0] < Minimum) && !(CountingTheMove[0] == 0 && CountingTheMove[1] == 0 && CountingTheMove[2]== 0)) {
                MinimumRow = CountingTheMove[1];
                MinimumColumn = CountingTheMove[2];
                Minimum = CountingTheMove[0];
                doable = true;
            }
        }
        if (doable) {  // boolean
            FindTheWay(MinimumRow, MinimumColumn);
        } else {
            EndTime = System.currentTimeMillis();
            System.out.println("The Average Time Taken is : " + (EndTime - StartTime) + "ms");
        }
    }

    public void TheStartTime() { // A method that marks the start time
        StartTime = System.currentTimeMillis();
    }
}
