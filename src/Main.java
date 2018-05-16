/*
    Jack Defay
    Main.java
    5/15/2018
*/

public class Main {
    public static void main(String args[]) {
        int[] temp1 = {0,0};
        int[] temp2 = {1,0};
        Ship myShip = new Ship(temp1, 2, temp2);

        System.out.print(myShip.getCoordinates());
    }
}
