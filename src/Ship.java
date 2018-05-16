/*
    Jack Defay
    Ship.java
    5/15/2018
*/

import java.util.ArrayList;

public class Ship {
    private int[][] coordinates;

    public Ship(int[] startingCoords, int length, int[] direction){
        coordinates = new int[length][3];  //initializes the coordinate array
        int[] temp = new int[3];

        for(int i = 0; i < length; i++){
            temp[0] = startingCoords[0] + i * direction[0];  //the x coordinate + the direction vector
            temp[1] = startingCoords[1] + i * direction[1];  //the y coordinate + the direction vector
            temp[2] = 1; //every space starts out with one life
            coordinates[i] = temp;
        }
    }

    public int[][] getCoordinates(){
        return coordinates;
    }

    public int getTotalLives(){  //since this array also stores the locations of the hits, this method gets the total number of lives remaining.
        int sum = 0;
        for(int[] row : coordinates){   //loops through the array
            sum+=row[2];  //only pays attention to the 3rd column where the number of lives are stored: 1 for alive, 0 for hit
        }
        return sum;
    }

    public boolean checkHit(int[] target){
        for(int[] row : coordinates){
            if(row[0] == target[0] && row[1] == target[1] && row[2] == 1){  //loops through, checking each location if it matches the target coordinates, and if that space has been hit already
                row[2] = 0;  //if it is right, then set that space to hit, and return that the target was successful
                return true;
            }
        }
        return false;
    }

    public boolean checkDestroyed(){
        return getTotalLives() == 0;
    }
}
