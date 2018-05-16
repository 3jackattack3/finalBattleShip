/*
    Jack Defay
    Board.java
    5/15/2018
*/

import java.util.ArrayList;

public class Board {
    private int[][] board;  //this is the hidden board that we use

    private static int BOARD_SIZE;

    private ArrayList<Ship> ships;

    public Board(int size){  //could also write a default case with a default board size...
        BOARD_SIZE = size;

        board = new int[BOARD_SIZE][BOARD_SIZE];

        ships = new ArrayList<Ship>(1);

        //IMPORTANT:
        //Lets decide what code to use for the board,
        //I was thinking a . if nothing is there
        //an X if a ship was hit
        //and an 0 for a miss
        //and an s for a hidden ship
    }

    public int getBoardSize(){
        return board.length;
    }

    public int numShips(){
        //just a placeholder for now, not sure if we need this method
        return ships.size();  //return number of ships
    }


}
