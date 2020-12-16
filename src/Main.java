/*==============================================================================
*                                                                              *
* Vamos a Las Vegas Slot Simulator version 1.0.0                               *
* Copyrights (C) 2020 Velbazhd Software LLC                                    *
*                                                                              *
* developed by Todor Balabanov ( todor.balabanov@gmail.com )                   *
* Sofia, Bulgaria                                                              *
*                                                                              *
* This program is free software: you can redistribute it and/or modify         *
* it under the terms of the GNU General Public License as published by         *
* the Free Software Foundation, either version 3 of the License, or            *
* (at your option) any later version.                                          *
*                                                                              *
* This program is distributed in the hope that it will be useful,              *
* but WITHOUT ANY WARRANTY; without even the implied warranty of               *
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the                *
* GNU General Public License for more details.                                 *
*                                                                              *
* You should have received a copy of the GNU General Public License            *
* along with this program. If not, see <http://www.gnu.org/licenses/>.         *
*                                                                              *
==============================================================================*/

/**
 * Single entry point class.
 * 
 * @author Todor Balabanov
 */
public class Main {
	/**
	 * List of symbols names.
	 */
	private static String[] symbolsNames = { "Sign", "Stripper", "Dealer", "Cards", "Dice", "Roulette", "Black chips",
			"Green chips", "Red chips", "Blue chips", "Cirque", "Siegfried and Roy", "Celine Dion", "Jubilee",
			"Donny and Marie", "Penn and Teller", "Frank Marino", "Chippendales", "Blue Man Group", };

	/**
	 * Base game and free spins pay table.
	 */
	private static int[][] paytable = { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 10, 3, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 100, 50, 40, 30, 30, 20, 15, 15, 10, 10, 50, 40, 30, 30, 20, 15, 15, 10, 10 },
			{ 500, 200, 150, 100, 100, 75, 50, 50, 25, 25, 200, 150, 100, 100, 75, 50, 50, 25, 25 },
			{ 5000, 1000, 500, 300, 300, 200, 100, 100, 50, 50, 1000, 500, 300, 300, 200, 100, 100, 50, 50 }, };

	/**
	 * Wild symbol index in the pay table.
	 */
	private static int wildIndex = 0;

	/**
	 * Base game reels as text.
	 */
	private static String baseGameReelsText = "Blue chips	Dealer	Roulette	Dice	Red chips\n"
			+ "Roulette	Casino	Black chips	Tickets	Wild\n" + "Red chips	Cards	Stripper	Cards	Green chips\n"
			+ "Wild	Blue chips	Cards	Wild	Red chips\n"
			+ "Blue chips	Red chips	Green chips	Dice	Blue chips\n"
			+ "Black chips	Roulette	Black chips	Casino	Cards\n"
			+ "Red chips	Black chips	Blue chips	Dealer	Red chips\n"
			+ "Roulette	Green chips	Dealer	Dice	Black chips\n"
			+ "Tickets	Red chips	Green chips	Red chips	Dice\n"
			+ "Black chips	Tickets	Roulette	Blue chips	Blue chips\n"
			+ "Dice	Roulette	Black chips	Casino	Stripper\n"
			+ "Green chips	Blue chips	Green chips	Roulette	Tickets\n"
			+ "Blue chips	Dice	Casino	Black chips	Green chips\n"
			+ "Stripper	Black chips	Stripper	Red chips	Stripper\n"
			+ "Dealer	Roulette	Roulette	Casino	Cards\n"
			+ "Green chips	Green chips	Black chips	Cards	Dealer\n"
			+ "Red chips	Dealer	Blue chips	Roulette	Red chips\n"
			+ "Stripper	Tickets	Red chips	Black chips	Green chips\n"
			+ "Green chips	Black chips	Green chips	Dice	Blue chips\n"
			+ "Blue chips	Blue chips	Black chips	Red chips	Dice\n" + "Cards	Green chips	Dice	Wild	Cards\n"
			+ "Red chips	Wild	Roulette	Roulette	Blue chips\n"
			+ "Dice	Roulette	Red chips	Black chips	Stripper\n"
			+ "Blue chips	Black chips	Tickets	Cards	Black chips\n"
			+ "Cards	Blue chips	Dealer	Red chips	Blue chips\n"
			+ "Dealer	Stripper	Blue chips	Green chips	Red chips\n"
			+ "Green chips	Casino	Red chips	Blue chips	Green chips\n"
			+ "Dice	Wild	Casino	Red chips	Dealer\n" + "Blue chips	Blue chips	Tickets	Black chips	Roulette\n"
			+ "Red chips	Cards	Wild	Stripper	Black chips\n"
			+ "Dealer	Casino	Roulette	Red chips	Dice\n" + "Dice	Black chips	Red chips	Cards	Blue chips\n"
			+ "Stripper	Dice	Dice	Tickets	Roulette\n"
			+ "Red chips	Green chips	Green chips	Green chips	Black chips\n"
			+ "Roulette	Stripper	Dealer	Dice	Wild\n"
			+ "Green chips	Blue chips	Cards	Blue chips	Blue chips\n"
			+ "Cards	Red chips	Red chips	Dealer	Roulette\n"
			+ "Black chips	Dice	Stripper	Dice	Red chips\n"
			+ "Roulette	Green chips	Blue chips	Blue chips	Blue chips\n"
			+ "Blue chips	Cards	Red chips	Cards	Cards\n" + "Cards	Blue chips	Dice	Green chips	Dealer\n"
			+ "Dice	Roulette	Black chips	Roulette	Tickets\n"
			+ "Green chips	Cards	Blue chips	Dice	Green chips\n"
			+ "Cards	Black chips	Cards	Blue chips	Stripper\n"
			+ "Red chips	Green chips	Wild	Red chips	Red chips\n"
			+ "Wild	Red chips	Blue chips	Casino	Dice\n" + "Roulette	Cards	Cards	Blue chips	Green chips\n"
			+ "Black chips	Dealer	Stripper	Black chips	Black chips\n"
			+ "Blue chips	Blue chips	Blue chips	Red chips	Red chips\n"
			+ "Cards	Red chips	Casino	Roulette	Dealer\n"
			+ "Black chips	Black chips	Red chips	Green chips	Dice\n"
			+ "Red chips	Dice	Blue chips	Blue chips	Green chips\n"
			+ "Stripper	Stripper	Casino	Stripper	Red chips\n"
			+ "Green chips	Casino	Black chips	Green chips	Roulette\n"
			+ "Dealer	Blue chips	Roulette	Dealer	Cards\n"
			+ "Red chips	Black chips	Dealer	Cards	Blue chips\n"
			+ "Green chips	Red chips	Dice	Black chips	Red chips\n"
			+ "Roulette	Green chips	Cards	Red chips	Green chips\n"
			+ "Black chips	Dice	Roulette	Stripper	Roulette\n"
			+ "Green chips	Dealer	Red chips	Blue chips	Red chips\n"
			+ "Dice	Blue chips	Dice	Black chips	Dice\n" + "Red chips	Red chips	Blue chips	Roulette	Cards\n"
			+ "Tickets	Roulette	Red chips	Blue chips	Roulette\n"
			+ "Dealer	Black chips	Green chips	Green chips	Green chips\n";

	/**
	 * Free spins reels as text.
	 */
	private static String freeSpinsReelsText = "Siegfried and Roy	Siegfried and Roy	Blue Man Group	Limousine	Jubilee\n"
			+ "Celine Dion	Frank Marino	Jubilee	Celine Dion	Limousine\n"
			+ "Frank Marino	Penn and Teller	Frank Marino	Cirque	Blue Man Group\n"
			+ "Donny and Marie	Limousine	Chippendales	Penn and Teller	Cirque\n"
			+ "Chippendales	Chippendales	Donny and Marie	Limousine	Jubilee\n"
			+ "Frank Marino	Frank Marino	Blue Man Group	Siegfried and Roy	Chippendales\n"
			+ "Blue Man Group	Blue Man Group	Chippendales	Chippendales	Donny and Marie\n"
			+ "Penn and Teller	Celine Dion	Jubilee	Frank Marino	Penn and Teller\n"
			+ "Jubilee	Jubilee	Limousine	Siegfried and Roy	Limousine\n"
			+ "Blue Man Group	Donny and Marie	Blue Man Group	Celine Dion	Chippendales\n"
			+ "Chippendales	Blue Man Group	Chippendales	Blue Man Group	Blue Man Group\n"
			+ "Frank Marino	Chippendales	Penn and Teller	Chippendales	Donny and Marie\n"
			+ "Blue Man Group	Limousine	Donny and Marie	Siegfried and Roy	Frank Marino\n"
			+ "Chippendales	Jubilee	Blue Man Group	Blue Man Group	Celine Dion\n"
			+ "Celine Dion	Chippendales	Celine Dion	Donny and Marie	Limousine\n"
			+ "Frank Marino	Cirque	Frank Marino	Frank Marino	Blue Man Group\n"
			+ "Blue Man Group	Penn and Teller	Penn and Teller	Chippendales	Frank Marino\n"
			+ "Penn and Teller	Siegfried and Roy	Blue Man Group	Penn and Teller	Penn and Teller\n"
			+ "Donny and Marie	Blue Man Group	Celine Dion	Donny and Marie	Cirque\n"
			+ "Chippendales	Frank Marino	Siegfried and Roy	Blue Man Group	Blue Man Group\n"
			+ "Blue Man Group	Donny and Marie	Penn and Teller	Penn and Teller	Penn and Teller\n"
			+ "Penn and Teller	Jubilee	Cirque	Jubilee	Chippendales\n"
			+ "Chippendales	Frank Marino	Chippendales	Cirque	Donny and Marie\n"
			+ "Blue Man Group	Chippendales	Donny and Marie	Blue Man Group	Siegfried and Roy\n"
			+ "Penn and Teller	Jubilee	Limousine	Chippendales	Chippendales\n"
			+ "Siegfried and Roy	Cirque	Chippendales	Jubilee	Blue Man Group\n"
			+ "Chippendales	Chippendales	Siegfried and Roy	Penn and Teller	Celine Dion\n"
			+ "Cirque	Donny and Marie	Frank Marino	Celine Dion	Chippendales\n"
			+ "Penn and Teller	Blue Man Group	Jubilee	Chippendales	Penn and Teller\n"
			+ "Blue Man Group	Frank Marino	Celine Dion	Frank Marino	Frank Marino\n"
			+ "Frank Marino	Penn and Teller	Frank Marino	Celine Dion	Siegfried and Roy\n"
			+ "Donny and Marie	Donny and Marie	Chippendales	Penn and Teller	Blue Man Group\n"
			+ "Siegfried and Roy	Chippendales	Siegfried and Roy	Blue Man Group	Frank Marino\n"
			+ "Chippendales	Celine Dion	Donny and Marie	Chippendales	Penn and Teller\n"
			+ "Celine Dion	Blue Man Group	Blue Man Group	Penn and Teller	Donny and Marie\n"
			+ "Jubilee	Penn and Teller	Frank Marino	Blue Man Group	Chippendales\n"
			+ "Blue Man Group	Limousine	Celine Dion	Chippendales	Jubilee\n"
			+ "Chippendales	Donny and Marie	Penn and Teller	Frank Marino	Blue Man Group\n"
			+ "Frank Marino	Penn and Teller	Chippendales	Donny and Marie	Penn and Teller\n"
			+ "Celine Dion	Blue Man Group	Cirque	Jubilee	Donny and Marie\n"
			+ "Donny and Marie	Donny and Marie	Celine Dion	Chippendales	Blue Man Group\n"
			+ "Penn and Teller	Chippendales	Blue Man Group	Blue Man Group	Chippendales\n"
			+ "Frank Marino	Celine Dion	Penn and Teller	Frank Marino	Penn and Teller\n"
			+ "Blue Man Group	Frank Marino	Jubilee	Penn and Teller	Blue Man Group\n"
			+ "Jubilee	Blue Man Group	Cirque	Donny and Marie	Celine Dion\n"
			+ "Chippendales	Siegfried and Roy	Blue Man Group	Chippendales	Chippendales\n"
			+ "Donny and Marie	Frank Marino	Frank Marino	Frank Marino	Jubilee\n"
			+ "Jubilee	Chippendales	Chippendales	Penn and Teller	Siegfried and Roy\n"
			+ "Blue Man Group	Siegfried and Roy	Penn and Teller	Chippendales	Blue Man Group\n"
			+ "Chippendales	Cirque	Frank Marino	Frank Marino	Frank Marino\n"
			+ "Frank Marino	Chippendales	Blue Man Group	Blue Man Group	Celine Dion\n"
			+ "Penn and Teller	Blue Man Group	Penn and Teller	Donny and Marie	Chippendales\n"
			+ "Cirque	Penn and Teller	Siegfried and Roy	Chippendales	Frank Marino\n"
			+ "Siegfried and Roy	Jubilee	Chippendales	Jubilee	Donny and Marie\n"
			+ "Jubilee	Blue Man Group	Blue Man Group	Blue Man Group	Cirque\n"
			+ "Blue Man Group	Penn and Teller	Donny and Marie	Donny and Marie	Jubilee\n"
			+ "Cirque	Celine Dion	Chippendales	Penn and Teller	Celine Dion\n"
			+ "Chippendales	Chippendales	Jubilee	Frank Marino	Frank Marino\n"
			+ "Donny and Marie	Blue Man Group	Penn and Teller	Donny and Marie	Chippendales\n"
			+ "Blue Man Group	Celine Dion	Frank Marino	Celine Dion	Blue Man Group\n"
			+ "Penn and Teller	Frank Marino	Donny and Marie	Blue Man Group	Frank Marino\n"
			+ "Donny and Marie	Blue Man Group	Limousine	Jubilee	Penn and Teller\n"
			+ "Celine Dion	Penn and Teller	Frank Marino	Frank Marino	Chippendales\n"
			+ "Chippendales	Chippendales	Penn and Teller	Blue Man Group	Siegfried and Roy\n";

	/**
	 * Single entry point method.
	 * 
	 * @param args Command line arguments.
	 */
	public static void main(String[] args) {
	}

}
