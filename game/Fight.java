import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

/**
 * @ClassName Fight
 * @Description It is the class for the fight
 * @Author Andy Sheng
 * @Date 2021/11/06
 */

public class Fight {
	/**
	 * the hero team
	 */
	private ArrayList<Hero> heros;
	/**
	 * the monster team
	 */
	private ArrayList<Monster> monsters;
	/**
	 * monster list for generation
	 */
	private Enemy enemy;
	/**
	 * round counter
	 */
	private int roundNum;
	/**
	 * fight is over or not
	 */
	private boolean isGG;

	private Random random;
	private Scanner scan = new Scanner(System.in);

	public Fight(ArrayList<Hero> heros)
	{
		this.heros = heros;
		this.monsters = new ArrayList<>();
		this.enemy = new Enemy();
		this.roundNum = 0;
		this.isGG = false;
		this.random = new Random();
	}

	// the main function of battle
	public void battle(){
		generateMonster(heros.size());
		round();
	}


	// each round of the fight
	public void round(){
		int res = 0;
		roundNum += 1;
		System.out.println("Round " + roundNum + " of the fight");
		// show information before each round of the fight
		showHeroInfo(heros);
		showMonsterInfo(monsters);

		// heros take turns to choose an action
		for (int i = 0; i < heros.size(); i++){
			if(!heros.get(i).getIsFaint()){
				action(i);
			}
		}
		// check if the battle is over
		battleIsOver();

		// monsters take turns to attack back
		for (int m = 0; m < monsters.size(); m++){
			if (!monsters.get(m).getIsFaint()) {
				int monsterTarget = m;
				// get the attack target
				if(!heros.get(monsterTarget).getIsFaint()){
					monsters.get(m).attack(heros.get(monsterTarget));
				}else{
					for (int j = 0; j < heros.size(); j++){
						if (!heros.get(j).getIsFaint()) {
							monsterTarget = j;
							break;
						}
					}
					monsters.get(m).attack(heros.get(monsterTarget));
				}
			}
		}
		// check if the battle is over
		battleIsOver();

		if (isGG){
			return;
		}

		// heros recover some hp and mana after each round
		else{
			for (Hero h: heros){
				if(!h.getIsFaint()){
				 	h.setHp((int)(h.getHp()*1.1));
					h.setMana((int)(h.getMana()*1.1));
				}
			}
			// proceed to the next round
			round();
		}
	}

	// This function is responsible for checking whether the battle is over and update everything after each round
	public void battleIsOver(){
		isGG = true;
		boolean lose = true;

		// check whether heros are faint
		for(Hero h:heros) {
			if(!h.getIsFaint()) {
				lose = false;
				break;
			}
			// game over if all heros faint
			System.out.println("All heros are faint! Game Over!");
			System.exit(0);
		}

		// check whether monsters is killed
		for(Monster m:monsters) {
			if(!m.getIsFaint()) {
				if(!lose) {
					isGG = false;
				}
			}
		}

		// if team hero win
		if(!lose && isGG) {
			System.out.println("Team Hero wins!");
			// hero gain experience and money after victory
			for (Hero h: heros){
				h.setExp(h.getExp() + 2);
				h.setMoney(h.getLevel()*100);
				// hero can level up by accumulating experience
				if(h.getExp() >= (h.getLevel()*10)){
					h.levelUp();
				}
			}
		}
	}

	// This function is in charge of heros' action in each round
	public void action(int heroIndex){
		System.out.println("It's hero " + heros.get(heroIndex).getName() + "'s turn!");
		System.out.println("Below are the operations you can choose during the fight:");
		System.out.println("+---------------------------------------+");
		System.out.print("1: Attack" + "           ");
		System.out.println("2: Change Weapon");
		System.out.print("3: Change Armor" + "     ");
		System.out.println("4: Use a potion");
		System.out.print("5: Cast a spell" + "     ");
		System.out.println("6: Quit.");
		System.out.println("+---------------------------------------+");

		// get hero's target
		int heroTarget = heroIndex;
		if (!monsters.get(heroIndex).getIsFaint()){
			heroTarget = heroIndex;
		}else{
			for (int i = 0; i < monsters.size(); i++){
				if (!monsters.get(i).getIsFaint()) {
					heroTarget = i;
					break;
				}
			}
		}

		int temp = 0;
		while(true) {
			String input = scan.nextLine();
			if (input.equals("q")) {
				System.out.println("Goodbye! See you next time!");
				System.exit(0);
			}
			try {
				temp = Integer.parseInt(input);
				// input is not an integer
			} catch (Exception e) {
				System.out.println("Invalid input. Must be an integer.");
				continue;
			}
			// input out of index
			if (temp < 0 && temp > 6) {
				System.out.println("Invalid input. Must between 1 and 6.");
				continue;
			}
			break;
		}
		switch(temp)
		{
			// hero chooses to attack
			case 1:
				System.out.println("Hero " + heros.get(heroIndex).getName() + " chooses to attack!");
				heros.get(heroIndex).attack(monsters.get(heroTarget));
				break;
				// hero chooses to change weapon
			case 2:
				System.out.println("Hero " + heros.get(heroIndex).getName() + " chooses to change weapon!");
				heros.get(heroIndex).changeWeapon();
				break;
				// hero chooses to change armor
			case 3:
				System.out.println("Hero " + heros.get(heroIndex).getName() + " chooses to change armor!");
				heros.get(heroIndex).changeArmor();
				break;
				// hero chooses to use a potion
			case 4:
				System.out.println("Hero " + heros.get(heroIndex).getName() + " chooses to use a potion!");
				heros.get(heroIndex).potion();
				break;
				// hero chooses to cast a spell
			case 5:
				System.out.println("Hero " + heros.get(heroIndex).getName() + " chooses to cast a spell!");
				heros.get(heroIndex).spell(monsters.get(heroTarget));
				break;
				// quit button
			case 6:
				System.out.println("Goodbye! See you next time!");
				System.exit(0);
		}
	}

	// This function is in charge of randomly generating monsters
	public void generateMonster(int size){
		System.out.println("***********FIGHT*********** \n Your team encountered monster(s)! Take care!");
		System.out.println("The profile of the monster(s) is shown below");
		while (monsters.size() < size){
			int i = random.nextInt(size);
			monsters.add(enemy.getEnemy().get(i));
		}
		showMonsterInfo(monsters);
	}

	// This function is in charge of showing monster's information
	public void showMonsterInfo(ArrayList<Monster> monsters){
		System.out.println("\u001B[32m" + "Monster Information");
		System.out.println("+-----------------------------------------------------------------------------------+");
		System.out.println("No |      Name     | HP | Level  |  Damage  |  Defense | Dodge_Chance | Type | Status");
		for (int i = 0; i < monsters.size(); i++){
			System.out.printf("%-3s %-20s",(i+1), enemy.getEnemy().get(i).getName());
			System.out.printf("%-10s",monsters.get(i).getHp());
			System.out.printf("%-10s",monsters.get(i).getLevel());
			System.out.printf("%-10s",monsters.get(i).getDamage());
			System.out.printf("%-10s",monsters.get(i).getDefense());
			System.out.printf("%-10s",monsters.get(i).getDodge());
			System.out.printf("%-10s",monsters.get(i).getType());
			System.out.printf("%-10s",monsters.get(i).getLevel());
			System.out.println();
		}
		System.out.println("+-----------------------------------------------------------------------------------+" + "\u001B[0m");
	}

	// This function is in charge of showing hero's information
	public void showHeroInfo(ArrayList<Hero> heros){
		int num = 0;
		System.out.println("\u001B[34m" + "Hero Information");
		System.out.println("+------------------------------------------------------------------------------------------------------+");
		System.out.println("+------------------------------------------------------------------------------------------------------+");
		System.out.println("No |        Name       | HP | Mana | Strenght | Agility | Dexterity | Money | experience | Type | Status");
		for (Hero h:heros){
			System.out.printf("%-4s %-22s",(++num), h.getName());
			System.out.printf("%-10s",h.getHp());
			System.out.printf("%-10s",h.getMana());
			System.out.printf("%-10s",h.getStrength());
			System.out.printf("%-10s",h.getAgility());
			System.out.printf("%-10s",h.getDexterity());
			System.out.printf("%-10s",h.getMoney());
			System.out.printf("%-10s",h.getExp());
			System.out.printf("%-10s",h.getType());
			System.out.printf("%-10s",h.getIsFaint());
			System.out.println();
		}
		System.out.println("+------------------------------------------------------------------------------------------------------+" + "\u001B[0m");
	}
}
