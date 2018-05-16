/*
    Jack Defay
    Ship.java
    5/15/2018
*/

import java.util.ArrayList;

public class Ship {
    private ArrayList<Integer[]> coordinates;

    //private lives

    public Ship(int[] startingCoords, int length, int[] direction){
        coordinates = new ArrayList<Integer[]>();
        Integer[] temp = new Integer[2];

        for(int i = 0; i < length; i++){
            temp[0] = new Integer(startingCoords[0] + i * direction[0]);
            temp[1] = new Integer(startingCoords[1] + i * direction[1]);
            coordinates.add(temp);
        }
    }

    //check hit
    //check destroyed
}
