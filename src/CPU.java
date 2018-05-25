/*
    Jack Defay and Yuval Amitay
    CPU.java
    5/6/2018
*/

import java.util.Random;

public class CPU {

    public CPU(){
    }

    //see new picktarget method a few down, don't delete this though

    public int[] pickTarget(Board userBoard){
        int numShipsOnBoard = userBoard.numShips();

//        if(findHit(userBoard)[0] == -1){  //changed this without thinking is it right?
            return (randomSelection(userBoard));
//        }

//        else{
//            return (selectNextToShip(userBoard, findHit(userBoard)));
//        }
    }

    private int[] randomSelection(Board userBoard){
        Random rand = new Random();

        int[] intCoords = {rand.nextInt(userBoard.getBoardSize()), rand.nextInt(userBoard.getBoardSize())};

        return intCoords;//convertCoordinates(intCoords); //return a random coordinate in the form {capital letter,number}
    }

    public String convertCoordinates(int[] intCoordinates){
        int firstCoord = intCoordinates[0] + 'A';

        char firstCoordChar = (char) firstCoord;

        String stringCoords = firstCoordChar + Integer.toString(intCoordinates[1]);

        return stringCoords; //reads in two integer coordinates and converts to the form {capital letter, number}
    }

    private int[] findHit(Board userBoard){
        for(int row = 0; row < userBoard.getBoardSize(); row++) {
            for (int col = 0; col < userBoard.getBoardSize(); col++) {
                if(userBoard.getBoard()[row][col] == 2){
                    int[] temp = {row, col};
                    return temp;
                }
            }
        }

        int[] temp = {-1, -1};
        return temp;
    }

    //0 is a space, 1 is a hidden ship, 2 is a hit, 3 is a miss, 4 is a destroyed ship  **@JACK START HERE

    private int[] findPartial(Board userBoard){
        for(int row = 0; row < userBoard.getBoardSize(); row++){
            for(int col = 0; col < userBoard.getBoardSize(); col++){
                if(userBoard.getBoard()[row][col] == 2 && checkIfPartial(userBoard, row, col)){
                    int[] temp = {row, col};
                    return temp;
                }
            }
        }
        return new int[] {-1,-1};
    }


    private boolean checkIfPartial(Board userBoard, int x, int y){
        if(userBoard.getBoard()[x][y] != 2 || x < 0 || y < 0 || x > userBoard.getBoardSize() || y > userBoard.getBoardSize()) return false;

        if(x+1 > userBoard.getBoardSize() && userBoard.getBoard()[x+1][y] == 2) return true;
        if(x-1 > 0 && userBoard.getBoard()[x-1][y] == 2) return true;
        if(y+1 > userBoard.getBoardSize() && userBoard.getBoard()[x][y+1] == 2) return true;
        if(y-1 > 0 && userBoard.getBoard()[x][y-1] == 2) return true;

        //should we include "smarter" detection of partial ships?
        if(x+2 > userBoard.getBoardSize() && userBoard.getBoard()[x+1][y] != 3 && userBoard.getBoard()[x+2][y] == 2) return true;
        if(x-2 > 0 && userBoard.getBoard()[x-1][y] != 3 && userBoard.getBoard()[x-2][y] == 2) return true;
        if(y+2 > userBoard.getBoardSize() && userBoard.getBoard()[x][y+1] != 3 && userBoard.getBoard()[x][y+2] == 2) return true;
        if(y-2 > 0 && userBoard.getBoard()[x][y-1] != 3 && userBoard.getBoard()[x][y-2] == 2) return true;

        return false;
    }

    public int[] selectNextToShip(Board userBoard, int[] coords){

//        Random rand = new Random();
//
//        int randomDirection = rand.nextInt(4);
        //0 = up, 1 = right, 2 = down, 3 = left

        int[] target = new int[2];
        target[0] = coords[0];
        target[1] = coords[1];

//        int iterationCounter = 0;

        //looks for the end of the ship. this must be generalized for all 4 directions and any length of ship.
        //really should make the cpu smarter by giving it the ability to identify the long direction of a ship if there are more than 2 spaces that could be used to extrapolate the direction. It should then prioritize this direction over the "short" directions that cannot possibly be part of the ship
//        while(iterationCounter < 5 && (target[0] < userBoard.getBoardSize() && target[0] > 0 && target[1] < userBoard.getBoardSize() && target[0] > 0) || userBoard.getBoard()[target[0]][target[1]] == 0){

//            iterationCounter++;  //makes sure it only loops a max of 4 times

            //not ideal structure I know, but increments the direction and resets the location if, for example, the target picked is off of the board or if it has already been tried
//            if((target[0] < userBoard.getBoardSize() && target[0] > 0 && target[1] < userBoard.getBoardSize() && target[0] > 0) || userBoard.getBoard()[target[0]][target[1]] == 0){
//                randomDirection++;
//                randomDirection%=4;  //to allow for it to rotate around all 4 options, nomatter where it started.
//                target[0] = coords[0];
//                target[1] = coords[1];
//            }

//            switch (randomDirection) {  //picks the next location over
//                case 0:
        while(target[1] < userBoard.getBoardSize() && userBoard.getBoard()[target[0]][target[1]] == 2) {  //2 is code for a hit
            target[1]++;
        }
        if((target[0] < userBoard.getBoardSize() && target[0] > 0 && target[1] < userBoard.getBoardSize() && target[0] > 0) || userBoard.getBoard()[target[0]][target[1]] == 0){
            target[0] = coords[0] ;
            target[1] = coords[1];
        }
//                    break;
//                case 1:
        while (target[0] < userBoard.getBoardSize() && userBoard.getBoard()[target[0]][target[1]] == 2) {  //2 is code for a hit
            target[0]++;
        }
        if((target[0] < userBoard.getBoardSize() && target[0] > 0 && target[1] < userBoard.getBoardSize() && target[0] > 0) || userBoard.getBoard()[target[0]][target[1]] == 0){
            target[0] = coords[0] ;
            target[1] = coords[1];
        }
//                    break;
//                case 2:
        while (target[1] > 0 && userBoard.getBoard()[target[0]][target[1]] == 2) {  //2 is code for a hit
            target[1]--;
        }
        if((target[0] < userBoard.getBoardSize() && target[0] > 0 && target[1] < userBoard.getBoardSize() && target[0] > 0) || userBoard.getBoard()[target[0]][target[1]] == 0){
            target[0] = coords[0] ;
            target[1] = coords[1];
        }
//                    break;
//                case 3:
        while (target[0] > 0 && userBoard.getBoard()[target[0]][target[1]] == 2) {  //2 is code for a hit
            target[0]--;
        }
        if((target[0] < userBoard.getBoardSize() && target[0] > 0 && target[1] < userBoard.getBoardSize() && target[0] > 0) || userBoard.getBoard()[target[0]][target[1]] == 0){
            target[0] = coords[0] ;
            target[1] = coords[1];
        }
//                    break;
//            }
//        }

        //loops through horizontally, then vertically
        //if it finds a line of hits, assumes thats a ship
        //if it finds a single, then checks the spaces just above and just below the space to see if its a single or a line
        //if its a single, pick a random direction, or we could prioritize the direction further away from the wall
        //if it has a direction then pick randomly between the two possible directions
        //of course if there is a space next to a wall, then ignore it
        //can also add modifiers for the types of ships. It could keep track of the different types of ships to figure out which ones are destroyed already

        return target;//convertCoordinates(target);  //searches the board for likely incomplete ships, then selects a space in line that is most likely to hit
    }


}
