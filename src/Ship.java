/*
    Yuval and Jack
    Ship.java
    5/15/2018
*/

import java.util.ArrayList;

public class Ship {
    private int[][] coordinates;
    private boolean placed;
    private int[] direction;
    private int length;

    public Ship(int[] startingCoords, int length, int[] direction){
        coordinates = new int[length][3];  //initializes the coordinate array
//        int[] temp = new int[3];
        this.direction = direction;
        this.length = length;

        for(int i = 0; i < length; i++){
            coordinates[i][0] = startingCoords[0] + i * direction[0];  //the x coordinate + the direction vector
            coordinates[i][1] = startingCoords[1] + i * direction[1];  //the y coordinate + the direction vector
            coordinates[i][2] = 1; //every space starts out with one life
//            coordinates[i] = temp;
        }

        placed = true;
    }

    public Ship(int length){
        coordinates = new int[length][3];  //initializes the coordinate array
        placed = false;
    }

    public void addCoords(int[] startingCoords, int[] direction)
    {
        this.direction = direction;
        
        int[] temp = new int[3];
        for(int i = 0; i < length; i++){
            temp[0] = startingCoords[0] + i * direction[0];  
            temp[1] = startingCoords[1] + i * direction[1];  
            temp[2] = 1; //every space starts out with one life
            coordinates[i] = temp;
        }

        placed = true;
    }

    public void move(int[] increment )
    {
        for(int i = 0; i < length; i++){
            coordinates[i][0] +=  increment[0];  
            coordinates[i][1] += increment[1];  //moving the ship's row and col by a certain value
        }
    }



    public int[][] getCoordinates(){
        return coordinates;
    }
    
    public int[] getFirstCoordinantes() {
    	int[] temp = new int[2];
    	temp[0] = coordinates[0][0];		//row
    	temp[1] =  coordinates[0][1];		//col
    	
    	return temp;
    }
    
    public int getLength() {
    	return length;
    }
    
    public int[] getDirection() {
    	return direction;
    }

    private boolean getPlaced(){//placed on board?
        return placed;
    }



    public int getTotalLives(){  //since this array also stores the locations of the hits, this method gets the total number of lives remaining.
        int sum = 0;
        for(int[] row : coordinates){   //loops through the array
            sum+=row[2];  //only pays attention to the 3rd column where the number of lives are stored: 1 for alive, 0 for hit
        }
        return sum;
    }

    public boolean checkHit(int[] target){
        for(int i = 0; i < coordinates.length; i++){
            if(coordinates[i][0] == target[0] && coordinates[i][1] == target[1] && coordinates[i][2] == 1){  //loops through, checking each location if it matches the target coordinates, and if that space has been hit already
                coordinates[i][2] = 0;  //if it is right, then set that space to hit, and return that the target was successful
                return true;
            }
        }
        return false;
    }

    public boolean checkDestroyed(){
        return getTotalLives() == 0;
    }
}