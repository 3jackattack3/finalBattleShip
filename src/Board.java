import java.util.ArrayList;
import java.util.Arrays;

/*
    Yuval and Jack
    Board.java
    5/15/2018
*/

public class Board {
    private int[][] board;  //this is the hidden board that we use

    private static int BOARD_SIZE;

    private ArrayList<Ship> ships;

    public Board(int size){  //could also write a default case with a default board size...
        BOARD_SIZE = size;
        board = new int[BOARD_SIZE][BOARD_SIZE];
//        Arrays.fill(board, 0);

        
        for(int row = 0; row < BOARD_SIZE; row++) {
            for (int col = 0; col < BOARD_SIZE; col++) {
                board[row][col] = 0;
            }
        }

        
        ships = new ArrayList<Ship>(0);

        

        //IMPORTANT:  //ignore this, we have a system now, see random comment in cpu class
        //Lets decide what code to use for the board,
        //I was thinking a . if nothing is there //or 0, seem more resnable. //are you sure about that?
        //an X if a ship was hit, okay- than numbers and x-es for farster manipulation.
        //and an 0 for a miss
        //and an s for a hidden ship
    }

    public Board(ArrayList<Ship> newShips, int size) {
        

        BOARD_SIZE = size;
        board = new int[BOARD_SIZE][BOARD_SIZE];
        Arrays.fill(board, 0);
        ships = new ArrayList<Ship>(0);

        for(Ship ship : newShips) {
        	addShip(ship.getFirstCoordinantes(), ship.getLength() , ship.getDirection());
        }
     }

    public void  addShip(int[] startingCoords, int length, int[] direction){
        if(isValid(startingCoords, direction, length)) {
            ships.add(new Ship(startingCoords, length, direction));

            int x, y;

            for (int i = 0; i < length; i++) {
                x = startingCoords[0] + i * direction[0];
                y = startingCoords[1] + i * direction[1];
                board[x][y] = 1;
            }
        }

        else System.out.print("you can't place a ship there!");  //just developer feedback, should prob take out later

//        int row = startingCoords[0];
//        int endRow = startingCoords[0] + length -1;
//
//        int col = startingCoords[0];
//        int endCol = startingCoords[0] + length -1;
//
//        for(; row < endRow; row++)
//            for(; col < endCol; col ++) {
//                board[row][col] = 1;
//            }
    }

    //can ship be places in chosen locations?
    public boolean isValid(int[] startingCoords, int[] direction, int length){
        int x;
        int y;

        for(int i = 0; i < length; i++){  //want to also check one space to either end of the ship, because a ship cannot be placed directly next to one another
            x = startingCoords[0] + i * direction[0];
            y = startingCoords[1] + i * direction[1];

            if(x<0 || y<0 || x>board.length || y>board.length || board[x][y] != 0) return false;

            if((y+1 < board.length && y-1 > 0 && startingCoords[0]-1 > 0 && startingCoords[0] + length < board.length) && (direction[0] == 1 || direction[0] == -1) && (board[x][y+1] != 0 || board[x][y-1] != 0 || board[startingCoords[0]-1][y] != 0 || board[startingCoords[0] + length][y] != 0)) return false;  //to make sure there is a space above/below a horizontal ship
            else if((x+1 < board.length && x-1 > 0 && startingCoords[1]-1 > 0 && startingCoords[1] + length < board.length) && (direction[1] == 1 || direction[1] == -1) && (board[x+1][y] != 0 || board[x-1][y] != 0 || board[x][startingCoords[1]-1] != 0 || board[x][startingCoords[1] + length] != 0)) return false;  //to make sure there is a space left/right of a vertical ship

        }

        return true;
    }

    //ships that had not been placed yet
    public ArrayList<Ship> placeableShips(){
        ArrayList<Ship> ships = new ArrayList<Ship>();

        return ships;
    }

    public ArrayList<Ship> getShips(){
        return ships;
    }

    public int getBoardSize(){
        return board.length;
    }

    //just a placeholder for now, not sure if we need this method
    public int numShips(){  return ships.size(); } //return number of ships

    // "I think... that you are my favorite type of loop :)" -JD
    public boolean checkHit(int[] coords) {
       for(int i = 0; i < ships.size(); i++){
           if(ships.get(i).checkHit(coords)) {
               this.board[coords[0]][coords[1]] = 2;
               return true;
           }
//           else System.out.print("\nno ship at " + coords[0] + ", " + coords[1] + "\n");
       }

       this.board[coords[0]][coords[1]] = 3;
       return false;
    }

    public int[][] getBoard(){
        return board;
    }

    //jack, I want to change the "life" part somehow? maybe?
//why direction as a direction vector? -- nevermind, actually a very good idea!
//can cordinantes be an arrayList?
//3D array, instead? this is the same thing...


}