import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

/**
 * @ClassName Game
 * @Description It is the class running the whole process of the game.
 * @Author Andy Sheng
 * @Date 2021/11/03
 */
public class Game {
	/**
	 * The market in the game
	 */
	private Market market;
	/**
	 * The world of the game
	 */
	private World world;
	/**
	 * The hero list for choosing
	 */
	private Champion champion;
	/**
	 * The team of heros
	 */
	private ArrayList<Hero> heros;
	/**
	 * The fight of the game
	 */
	private Fight fight;

	private Scanner scan = new Scanner(System.in);
	private Random random = new Random();

	public Game() {
		this.market = new Market();
		this.world = new World(8);
		this.champion = new Champion();
		this.heros = new ArrayList<>();
		this.fight = new Fight(heros);
	}


	// the main function of the game
	public void play() {
		// welcome messages
		System.out.println("\u001B[32m" + "Welcome to the game: 'Legends: Heros and Monsters'!" + "\u001B[0m" + "\n");
		System.out.println("In this game, players can choose to have 1-3 heros as a team to explore the world." + "\n");
		System.out.println("In the game world, 'X' is the inaccessible spot, 'M' is the market, " +
				"'H' is heros' position, and others are blank spots." + "\n");
		System.out.println("Player can buy or sell items in the market, and fight with monster, which has a probability " +
				"to show up in the black spot." + "\n");
		System.out.println("Below are the operations player can choose in the game:" + "\n");
		System.out.println("+---------------------------------------+");
		System.out.print("W/w: Move up." + "            ");
		System.out.println("S/s: Move down.");
		System.out.print("A/a: Move left." + "          ");
		System.out.println("D/d: Move right");
		System.out.print("I/i: Show information." + "   ");
		System.out.println("Q/q: Quit.");
		System.out.println("+---------------------------------------+");
		System.out.println("\n" + "Have fun!");

		// set the scale of hero team
		setHeroNum();

		// initialize the world
		world.worldInit();

		// print the world
		world.printWorld();

		// player decides what to do
		while(true){
			System.out.println("Press i to show information or m to move your team!");
			String input = scan.nextLine();

			// player chooses to move the team
			if (input.equalsIgnoreCase("m")){
				int res = move();
				// if team is in market
				if (res == 1){
					for (Hero h: heros) {
						market.trade(h);
					}
				}
				// if team encounters monster
				else if (res == 2){
					fight.battle();
				}
				// move is invalid, choose another direction
				else if (res == -1){
					move();
				}
			}
			// show information
			else if (input.equalsIgnoreCase("i")){
				showInfo(heros);
			}
			// quit button
			else if (input.equalsIgnoreCase("q")){
				System.out.println("Goodbye! See you next time!");
				System.exit(0);
			}
		}
	}

	// This function is in charge of the team movement
	public int move(){
		int res = -1;
		System.out.println("Please choose a direction to move:");
		System.out.println("+---------------------------------------+");
		System.out.print("W/w: Move up." + "            ");
		System.out.println("S/s: Move down.");
		System.out.print("A/a: Move left." + "          ");
		System.out.println("D/d: Move right");
		System.out.println("+---------------------------------------+");
		// print the map before every move
		world.printWorld();
		String input = scan.nextLine();

		// choose to move up
		if (input.equals("W") || input.equals("w")) {
			if (world.getXlabel() == 0) {
				System.out.println("End of the road! Please try another direction.");
			} else {
				// can't move into the inaccessible area
				if (world.board[world.getXlabel() - 1][world.getYlabel()].getType() == 'X') {
					System.out.println("Inaccessible area! Please try another direction.");
				}
				// move into the market
				else if (world.board[world.getXlabel() - 1][world.getYlabel()].getType() == 'M') {
					// update team's position
					world.board[world.getXlabel()][world.getYlabel()].setContent(' ');
					world.board[world.getXlabel() - 1][world.getYlabel()].setContent('T');
					res = 1;
					world.setXlabel(world.getXlabel() - 1);
				}
				else if (world.board[world.getXlabel() - 1][world.getYlabel()].getType() == ' ') {
					// update team's position
					world.board[world.getXlabel()][world.getYlabel()].setContent(' ');
					world.board[world.getXlabel() - 1][world.getYlabel()].setContent('T');
					world.setXlabel(world.getXlabel() - 1);
					// the team has a probability of 0.3 to encounter monsters in blank space
					int i = random.nextInt(10);
					if (i < 3) {
						res = 2;
					}else{
						res = 0;
					}
				}
			}
		}

		// choose to move left
		else if (input.equals("A") || input.equals("a")) {
			if (world.getYlabel() == 0) {
				System.out.println("End of the road! Please try another direction.");
			} else {
				// can't move into the inaccessible area
				if (world.board[world.getXlabel()][world.getYlabel() - 1].getType() == 'X') {
					System.out.println("Inaccessible area! Please try another direction.");
				}
				else if (world.board[world.getXlabel()][world.getYlabel() - 1].getType() == 'M') {
					// update team's position
					world.board[world.getXlabel()][world.getYlabel()].setContent(' ');
					world.board[world.getXlabel()][world.getYlabel() - 1].setContent('T');
					res = 1;
					world.setYlabel(world.getYlabel()-1);
				}
				else if (world.board[world.getXlabel()][world.getYlabel() - 1].getType() == ' ') {
					// update team's position
					world.board[world.getXlabel()][world.getYlabel()].setContent(' ');
					world.board[world.getXlabel()][world.getYlabel() - 1].setContent('T');
					world.setYlabel(world.getYlabel() - 1);
					// the team has a probability of 0.3 to encounter monsters in blank space
					int i = random.nextInt(10);
					if (i < 3) {
						res = 2;
					}else{
						res = 0;
					}
				}
			}
		}

		// choose to move down
		else if (input.equals("S") || input.equals("s")) {
			if (world.getXlabel() == (world.getBoardSize() - 1)) {
				System.out.println("End of the road! Please try another direction.");
			} else {
				// can't move into the inaccessible area
				if (world.board[world.getXlabel() + 1][world.getYlabel()].getType() == 'X') {
					System.out.println("Inaccessible area! Please try another direction.");
				}
				else if (world.board[world.getXlabel() + 1][world.getYlabel()].getType() == 'M') {
					// update team's position
					world.board[world.getXlabel()][world.getYlabel()].setContent(' ');
					world.board[world.getXlabel() + 1][world.getYlabel()].setContent('T');
					res = 1;
					world.setXlabel(world.getXlabel()+1);

				}
				else if (world.board[world.getXlabel() + 1][world.getYlabel()].getType() == ' ') {
					// update team's position
					world.board[world.getXlabel()][world.getYlabel()].setContent(' ');
					world.board[world.getXlabel() + 1][world.getYlabel()].setContent('T');
					world.setXlabel(world.getXlabel() + 1);
					// the team has a probability of 0.3 to encounter monsters in blank space
					int i = random.nextInt(10);
					if (i < 3) {
						res = 2;
					}else{
						res = 0;
					}
				}
			}
		}

		// choose to move right
		else if (input.equals("D") || input.equals("d")) {
			if (world.getYlabel() == (world.getBoardSize() - 1)) {
				System.out.println("End of the road! Please try another direction.");
			} else {
				// can't move into the inaccessible area
				if (world.board[world.getXlabel()][world.getYlabel() + 1].getType() == 'X') {
					System.out.println("Inaccessible area! Please try another direction.");
				}
				else if (world.board[world.getXlabel()][world.getYlabel() + 1].getType() == 'M') {
					// update team's position
					world.board[world.getXlabel()][world.getYlabel()].setContent(' ');
					world.board[world.getXlabel()][world.getYlabel() + 1].setContent('T');
					res = 1;
					world.setYlabel(world.getYlabel() + 1);
				}
				else if (world.board[world.getXlabel()][world.getYlabel() + 1].getType() == ' ') {
					// update team's position
					world.board[world.getXlabel()][world.getYlabel()].setContent(' ');
					world.board[world.getXlabel()][world.getYlabel() + 1].setContent('T');
					world.setYlabel(world.getYlabel() + 1);
					// the team has a probability of 0.3 to encounter monsters in blank space
					int i = random.nextInt(10);
					if (i < 3) {
						res = 2;
					}else{
						res = 0;
					}
				}
			}
		}
		return res;
	}


	// This function is in charge of setting the team size
	public void setHeroNum() {
		int heroNum;
		while (true) {
			System.out.println("Please enter the number of heros:(1-3)");
			String input = scan.nextLine();
			// quit button
			if (input.equals("q")) {
				System.out.println("Goodbye! See you next time!");
				System.exit(0);
			}
			try {
				heroNum = Integer.parseInt(input);
				// Input is not an integer
			} catch (Exception e) {
				System.out.println("Invalid input. Must be an integer.");
				continue;
			}
			if (heroNum < 1 || heroNum > 3) {        // Input size out of index
				System.out.println("Invalid input. Must between 1 and 3.");
				continue;
			}
			break;
		}
		System.out.println("There are " + heroNum + " hero(s) in your team! Good luck!");
		chooseHero(heroNum);
	}

	// This function is in charge of choosing heroes to form the team
	public void chooseHero(int heroNum){
		System.out.println("Please choose " + heroNum + " hero(s) to form your team!");
		// print the hero list for player to choose
		champion.printChampion();
		int temp = 0;

		// choose heros to form the team
		for(int i = 0; i < heroNum; i++){
			while (true) {
				System.out.println("Please enter the index of heros:(1-18)");
				String input = scan.nextLine();
				if (input.equals("q")) {
					System.out.println("Goodbye! See you next time!");
					System.exit(0);
				}
				try {
					temp = Integer.parseInt(input);
					// Input size is not an integer
				} catch (Exception e) {
					System.out.println("Invalid input. Must be an integer.");
					continue;
				}
				heros.add(champion.getChampions().get(temp));
				break;
			}
		}

		// print the hero informatino after the team is formed
		showInfo(heros);
	}

	// This function is in charge of showing hero information
	public void showInfo(ArrayList<Hero> hero){
		int num = 0;
		System.out.println("+-------------------------------------------------------------------------------------------+");
		System.out.println("No |        Name       | Strenght | Agility | Dexterity | Money | experience | Type | Status");
		System.out.println("+-------------------------------------------------------------------------------------------+");
		for (Hero h:hero){
			System.out.printf("%-4s %-22s",(++num), h.getName());
			System.out.printf("%-10s",h.getStrength());
			System.out.printf("%-10s",h.getAgility());
			System.out.printf("%-11s",h.getDexterity());
			System.out.printf("%-12s",h.getMoney());
			System.out.printf("%-10s",h.getExp());
			System.out.printf("%-10s",h.getType());
			System.out.printf("%-10s",h.getIsFaint());
			System.out.println();

			if (h.getArmor() != null) {
				System.out.println("\u001B[33m" + "Below is the Armors it has.");
				h.getArmor().showInfo();
				System.out.println("\u001B[0m");
			}else{
				System.out.println("It has no Armor!" + "\u001B[0m");
			}

			if (h.getWeapon() != null) {
				System.out.println("\u001B[31m" + "Below is the Weapons it has.");
				h.getWeapon().showInfo();
				System.out.println("\u001B[0m");
			}else{
				System.out.println("It has no Weapon!" + "\u001B[0m");
			}
		}
	}
}

