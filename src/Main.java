/*
    Yuval and Jack
    Ship.java
    5/15/2018
*/

import java.util.Scanner;

public class Main {

	 public static void main(String[] args) {
		 
//		 createBoard(5);
//		 Game game = new Game();

		 Board board = new Board(8);

		 debugPrintBoard(board);


		 board.addShip(new int[] {0,7}, 5, new int[] {0,-1});

		 board.addShip(new int[] {3,3}, 3, new int[] {1,0});

		 CPU testCpu = new CPU();

		 System.out.println();
		 debugPrintBoard(board);
		 
//		 Scanner read = new Scanner(System.in);
//
//
//		 int[] coords = new int[2];
//		 coords = game.getCoordsPressed();
//
//		 int exit = 0;
//		 while(exit == 0) {
//			 System.out.println("out? " );
//			 exit = read.nextInt();
//
//			 int[] cord = game.getCoordsPressed();
//
//			 System.out.println (cord[0] + " " + cord[1]);
//
//		 }
		 int[] target = new int[2];

		 for(int i = 0; i < 20; i++){
//		 	if(board.checkHit(new int[] {0,2})) System.out.print("\nHit!\n");

			 target = testCpu.pickTarget(board);
		 	 if(board.checkHit(target)) System.out.print("\nHit!\n");
		 	 else System.out.print("\nMiss! At location " + target[0] + ", " + target[1] + "\n");

			 System.out.println();
			 debugPrintBoard(board);
		 }

//		 System.out.println(testCpu.convertCoordinates(testCpu.pickTarget(board, 0)));
		 System.out.println();
		 debugPrintBoard(board);


//		 System.out.print(board.getShips().get(0).getFirstCoordinantes()[0] + board.getShips().get(0).getFirstCoordinantes()[1]);
	 }
	 
//	 public static void createBoard(int size) {
//		 Board board = new Board(size);
//
//		 board.addShip(new int[] {0,0}, 5, new int[] {1,0});
//
//		 board.addShip(new int[] {1,1}, 4, new int[] {0,-1});		//change coords expression!!
//
//	 }

	 public static void debugPrintBoard(Board board){

	 	for(int i = 0; i < board.getBoard()[0].length; i++){
	 		for(int j = 0; j < board.getBoard().length; j++){
	 			System.out.print(board.getBoard()[j][board.getBoard().length - i - 1] + " ");
			}
			System.out.println();
		}

//	 	for(int[] row : board.getBoard()){
//	 		for(int item : row){
//	 			System.out.print(item + " ");
//			}
//			System.out.println();
//		}
	 }
}
