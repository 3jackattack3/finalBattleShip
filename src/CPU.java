/*
    Jack Defay
    CPU.java
    5/6/2018
*/

import java.util.Random;

public class CPU {

    private Board computerBoard;  //this might be an issue cuz this isn't currently updated as the computer board takes hits from the player

    private int[] listOfShipLengths;

    //private int difficulty;

    public CPU(Board computerBoard){
        this.computerBoard = computerBoard;
        //this.listOfShipLengths = listOfShipLengths;  //should prob write a method to do this...
    }

    public String pickTarget(Board userBoard, int numDestroyedShips){
        int numShipsOnBoard = numShipsOnBoard(userBoard);

        if(numDestroyedShips == userBoard.size() - numShipsOnBoard){  //changed this without thinking is it right?
            return randomSelection();
        }

        else{
            return selectNextToShip(userBoard);
        }
    }

    public int numShipsOnBoard(Board userBoard){  //what syntax are we gonna use for the board? periods and x's? 0's and 1's?
        return userBoard.size();
    }

    private String randomSelection(){
        Random rand = new Random();

        int[] intCoords = {rand.nextInt(this.computerBoard.getSizeOfBoard()), rand.nextInt(this.computerBoard.getSizeOfBoard())+1};

        return convertCoordinates(intCoords); //return a random coordinate in the form {capital letter,number}
    }

    private String convertCoordinates(int[] intCoordinates){
        int firstCoord = intCoordinates[0] + 'A';

        char firstCoordChar = (char) firstCoord;

        String stringCoords = firstCoordChar + Integer.toString(intCoordinates[1]);

        return stringCoords; //reads in two integer coordinates and converts to the form {capital letter, number}
    }

    private String selectNextToShip(Board userBoard){
        //loops through horizontally, then vertically
        //if it finds a line of hits, assumes thats a ship
        //if it finds a single, then checks the spaces just above and just below the space to see if its a single or a line
        //if its a single, pick a random direction, or we could prioritize the direction further away from the wall
        //if it has a direction then pick randomly between the two possible directions
        //of course if there is a space next to a wall, then ignore it
        //can also add modifiers for the types of ships. It could keep track of the different types of ships to figure out which ones are destroyed already

        return convertCoordinates(new int[] {0,0});  //searches the board for likely incomplete ships, then selects a space in line that is most likely to hit
    }
}
