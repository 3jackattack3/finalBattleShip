/*
    Jack Defay
    Ship.java
    5/15/2018
*/

import java.util.ArrayList;

public class Ship {
    private int[][] coordinates;

    //private lives

    public Ship(int[] startingCoords, int length, int[] direction){
        coordinates = new int[length][2];
        int[] temp = new int[2];

        for(int i = 0; i < length; i++){
            temp[0] = startingCoords[0] + i * direction[0];
            temp[1] = startingCoords[1] + i * direction[1];
            coordinates[i] = temp;
        }
    }

    public int[][] getCoordinates(){
        return coordinates;
    }

    //check hit
    //check destroyed
}
