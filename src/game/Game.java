package game;

import java.util.*;
import java.io.*;

public class Game {

	// dice design
	public static int random() {

		return (int) ((Math.random() * (6 - 1)) + 1);
	}

	// board design
	public static List<Integer> board() {

		LinkedList<Integer> board = new LinkedList<>();

		// board initial design
		for (int i = 0; i <= 110; i++) {
			board.add(i);
		}

		// board with ladders
		board.set(4, 0);
		board.set(10, 0);
		board.set(18, 0);
		board.set(30, 0);
		board.set(57, 0);
		board.set(4, 0);

		// board with snakes
		board.set(33, -1);
		board.set(46, -1);
		board.set(64, -1);
		board.set(86, -1);
		board.set(91, -1);
		board.set(96, -1);
		board.set(98, -1);

		return board;
	}

	public static void main(String args[]) throws NumberFormatException, IOException {

		InputStreamReader r = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(r);

		System.out.println("****Snakes And Ladders****");

		System.out.println("\n\ntype start to start\n");

		String choice = br.readLine();

		boolean mode = true;

		if (choice.equals("start")) {

			System.out.println("\n\nGame started (max 4 players allowed)");

			int n = Integer.parseInt(br.readLine());

			int p = 0;

			while (mode) {
				// start of for loop
				if (n > 4) {
					System.out.println("\nInvalid input");
					mode = false;

					break;
				} else {

					for (int i = 1; i <= n; i++) {

						System.out.println("\n\nplayer " + i + " chance");

						System.out.println("\n\n To play type p to resign type r\n");

						String ch = br.readLine();

						if (ch.equals("p")) {

							System.out.print("\n\n Dice:" + random() + "\n");

							int v = random();

							// game starts
                           
							p+=v;
							
							if (board().get(p) == 0) {
								p+= 4;
							} else if (board().get(p) == -1) {
								p -= 8;
							}


							System.out.print("player " + i + " position is " + Math.abs(board().get(p)));

							if (p >= 100) {
								System.out.println("\n\nplayer " + i + " wins!");
								mode = false;
								break;
							}

						} else if (ch.equals("r")) {

							System.out.println("\n\nResigned! Game over!");

							mode = false;
							break;

						}
					} // end of for loop

				}

				// System.out.println(random());

			}

		} else {

			System.out.println("\n\nput valid input!");

		}

	}

}