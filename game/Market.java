import java.util.ArrayList;
import java.util.Scanner;

/**
 * @ClassName Market
 * @Description It is the class for the Market
 * @Author Andy Sheng
 * @Date 2021/11/03
 */
public class Market {

	/**
	 * armors in the market
	 */
	private ArrayList<Armory> armors;

	/**
	 * weapons in the market
	 */
	private ArrayList<Weaponry> weapons;

	/**
	 * potions in the market
	 */
	private ArrayList<Potion> potions;

	/**
	 * spells in the market
	 */
	private ArrayList<Spell> spells;

	private Scanner scan = new Scanner(System.in);

	// constructor
	public Market() {
		this.armors = new ArrayList<>();
		this.weapons = new ArrayList<>();
		this.potions = new ArrayList<>();
		this.spells = new ArrayList<>();

		// construct armor list
		armors.add(new Armory("Platinum_Sheild", 150, 1, 200));
		armors.add(new Armory("Breastplate", 350, 3, 600));
		armors.add(new Armory("Full_Body_Armor", 1000, 8, 1100));
		armors.add(new Armory("Wizard_Shield", 1200, 10, 1500));
		armors.add(new Armory("Guradian_Angel", 1000, 10, 1000));

		// constructor weaponry list
		weapons.add(new Weaponry("Sword", 500, 1, 800, 1));
		weapons.add(new Weaponry("Bow", 300, 2, 500, 2));
		weapons.add(new Weaponry("Scythe", 1000, 6, 1100, 2));
		weapons.add(new Weaponry("Axe", 550, 5, 850, 1));
		weapons.add(new Weaponry("TSwords", 1400, 8, 1600, 2));
		weapons.add(new Weaponry("Dagger", 200, 1, 250, 1));

		// construct potion list
		potions.add(new Potion("Healing_Potion", 250, 1, 100, "Health"));
		potions.add(new Potion("Strength_Potion", 200, 1, 75, "Strength"));
		potions.add(new Potion("Magic_Potion", 350, 2, 100, "Mana"));
		potions.add(new Potion("Luck_Elixir", 500, 4, 65, "Agility"));
		potions.add(new Potion("Mermaid_Tears", 850, 5, 100, "H/M/S/A(the above four)"));
		potions.add(new Potion("Ambrosia", 1000, 8, 150, "H/M/S/A/Dexterity/Defense"));

		// construct fire-spell list
		spells.add(new Spell("Flame_Tornada", 700, 4, 850, 300, "fire"));
		spells.add(new Spell("Breath_of_Fire", 350, 1, 450, 100, "fire"));
		spells.add(new Spell("Heat_Wave", 450, 2, 600, 150, "fire"));
		spells.add(new Spell("Lava_Comet", 800, 7, 1000, 550, "fire"));
		spells.add(new Spell("Hell_Storm", 600, 3, 950, 600, "fire"));

		// construct ice-spell list
		spells.add(new Spell("Snow_Cannon", 500, 2, 650, 250, "ice"));
		spells.add(new Spell("Ice_Blade", 250, 1, 450, 100, "ice"));
		spells.add(new Spell("Frost_Blizzard", 750, 5, 850, 350, "ice"));
		spells.add(new Spell("Arctic_Storm", 700, 6, 800, 300, "ice"));

		// construct lightning-spell list
		spells.add(new Spell("Lighting_Dagger", 400, 1, 500, 150, "lighting"));
		spells.add(new Spell("Thunder_Blast", 750, 4, 950, 400, "lighting"));
		spells.add(new Spell("Electric_Arrows", 550, 5, 650, 200, "lighting"));
		spells.add(new Spell("Spark_Needles", 500, 2, 600, 200, "lighting"));
	}


	public ArrayList<Armory> getArmors() {return armors;}

	public ArrayList<Potion> getPotions() {return potions;}

	public ArrayList<Spell> getSpells() {return spells;}

	public ArrayList<Weaponry> getWeapons() {return weapons;}

	public void setArmors(ArrayList<Armory> armors) {this.armors = armors;}

	public void setPotions(ArrayList<Potion> potions) {this.potions = potions;}

	public void setSpells(ArrayList<Spell> spells) {this.spells = spells;}

	public void setWeapons(ArrayList<Weaponry> weapons) {this.weapons = weapons;}

	// print the armory on sale
	public void printArmory(){
		System.out.println("\u001B[33m" + "Armory");
		System.out.println("+----------------------------------------------------------------+");
		System.out.println("No |      Name     |  Cost  |  Required_Level  |  Damage_Reduction");
		for (int i = 0; i < armors.size(); i++){
			System.out.printf("%-3s %-18s",(i+1), armors.get(i).getName());
			System.out.printf("%-14s",armors.get(i).getPrice());
			System.out.printf("%-18s",armors.get(i).getLevel());
			System.out.printf("%-16s",armors.get(i).getRedValue());
			System.out.println();
		}
		System.out.println("+----------------------------------------------------------------+");
		System.out.println("\u001B[0m");
	}

	// print the potions on sale
	public void printPotion(){
		System.out.println("\u001B[35m" + "Potion");
		System.out.println("+--------------------------------------------------------------------------------------------+");
		System.out.println("No |      Name     |  Cost  |  Required_Level  |  Attribute_Increase    |   Attribute_Affect");
		for (int i = 0; i < potions.size(); i++){
			System.out.printf("%-3s %-18s",(i+1), potions.get(i).getName());
			System.out.printf("%-14s",potions.get(i).getPrice());
			System.out.printf("%-16s",potions.get(i).getLevel());
			System.out.printf("%-28s",potions.get(i).getAttribute());
			System.out.printf("%-16s",potions.get(i).getValue());
			System.out.println();
		}
		System.out.println("+--------------------------------------------------------------------------------------------+");
		System.out.println("\u001B[0m");
	}

	// print the weapons on sale
	public void printWeaponry(){
		System.out.println("\u001B[31m" + "Weaponry");
		System.out.println("+------------------------------------------------------------------------+");
		System.out.println("No |      Name     |  Cost  |  Required_Level  |  Damage  |  Required_Hand");
		for (int i = 0; i < weapons.size(); i++){
			System.out.printf("%-3s %-18s",(i+1), weapons.get(i).getName());
			System.out.printf("%-14s",weapons.get(i).getPrice());
			System.out.printf("%-16s",weapons.get(i).getLevel());
			System.out.printf("%-14s",weapons.get(i).getDamage());
			System.out.printf("%-16s",weapons.get(i).getReqHand());
			System.out.println();
		}
		System.out.println("+------------------------------------------------------------------------+");
		System.out.println("\u001B[0m");
	}

	// // print the spells on sale
	public void printSpell(){
		System.out.println("\u001B[34m" + "Spell");
		System.out.println("+--------------------------------------------------------------------------------+");
		System.out.println("No |      Name     |  Cost  |  Required_Level  |  Damage  |  Mana_Cost  |  Type");
		for (int i = 0; i < spells.size(); i++){
			System.out.printf("%-3s %-18s",(i+1), spells.get(i).getName());
			System.out.printf("%-14s",spells.get(i).getPrice());
			System.out.printf("%-16s",spells.get(i).getLevel());
			System.out.printf("%-12s",spells.get(i).getDamage());
			System.out.printf("%-10s",spells.get(i).getManaCost());
			System.out.printf("%-14s",spells.get(i).getType());
			System.out.println();
		}
		System.out.println("+--------------------------------------------------------------------------------+");
		System.out.println("\u001B[0m");
	}


	// heros purchase item in the market
	public void purchase(Hero hero){
		while(true) {
			System.out.println("Which type of items do you want to buy: 0(back) 1(Armory), 2(Weaponry), 3(Potion), 4(Spell)");
			int buyType = scan.nextInt();
			if (buyType < 0 || buyType > 4){
				System.out.println("Invalid input! Must between 0 and 4.");
				continue;
			}
			int buyItem;
			switch (buyType){
					// back to the menu
				case 0:
					return;

					// purchase an armor
				case 1:
					System.out.println("Choose the armor you want to buy:(enter n to buy the nth item)");
					printArmory();
					buyItem = scan.nextInt();

					if(hero.getMoney() < armors.get(buyItem-1).getPrice()){
						System.out.println("Sorry! Your balance is insufficient.");
					}
					else if(hero.getLevel() < armors.get(buyItem-1).getLevel()){
						System.out.println("Sorry! Your hero's level is too low.");
					}
					else{
						ArrayList<Armory> temp = hero.getArmory();
						temp.add(armors.get(buyItem-1));
						hero.setArmory(temp);
						hero.setMoney(hero.getMoney() - armors.get(buyItem-1).getPrice());
						System.out.println("Transaction Complete! Purchase Confirmation: " + armors.get(buyItem-1).getName());
					}
					break;

					// purchase a weapon
				case 2:
					System.out.println("Choose the weapon you want to buy:(enter n to buy the nth item)");
					printWeaponry();
					buyItem = scan.nextInt();

					if(hero.getMoney() < weapons.get(buyItem-1).getPrice()){
						System.out.println("Sorry! Your balance is insufficient.");
					}
					else if(hero.getLevel() < weapons.get(buyItem-1).getLevel()){
						System.out.println("Sorry! Your hero's level is too low.");
					}

					else{
						ArrayList<Weaponry> temp = hero.getWeaponry();
						temp.add(weapons.get(buyItem-1));
						hero.setWeaponry(temp);
						hero.setMoney(hero.getMoney() - weapons.get(buyItem-1).getPrice());
						System.out.println("Transaction Complete! Purchase Confirmation: " + weapons.get(buyItem-1).getName());
					}
					break;

					// purchase a potion
				case 3:
					System.out.println("Choose the potion you want to buy:(enter n to buy the nth item)");
					printPotion();
					buyItem = scan.nextInt();

					if(hero.getMoney() < potions.get(buyItem-1).getPrice()){
						System.out.println("Sorry! Your balance is insufficient.");
					}
					else if(hero.getLevel() < potions.get(buyItem-1).getLevel()){
						System.out.println("Sorry! Your hero's level is too low.");
					}
					else{
						ArrayList<Potion> temp = hero.getPotions();
						temp.add(potions.get(buyItem-1));
						hero.setPotions(temp);
						hero.setMoney(hero.getMoney() - potions.get(buyItem-1).getPrice());
						System.out.println("Transaction Complete! Purchase Confirmation: " + potions.get(buyItem-1).getName());
					}
					break;

					// purchase a spell
				case 4:
					System.out.println("Choose the spell you want to buy:(enter n to buy the nth item)");
					printSpell();
					buyItem = scan.nextInt();

					if(hero.getMoney() < spells.get(buyItem-1).getPrice()){
						System.out.println("Sorry! Your balance is insufficient.");
					}
					else if(hero.getLevel() < spells.get(buyItem-1).getLevel()){
						System.out.println("Sorry! Your hero's level is too low.");
					}
					else{
						ArrayList<Spell> temp = hero.getSpells();
						temp.add(spells.get(buyItem-1));
						hero.setSpells(temp);
						hero.setMoney(hero.getMoney() - spells.get(buyItem-1).getPrice());
						System.out.println("Transaction Complete! Purchase Confirmation: " + spells.get(buyItem-1).getName());
					}
					break;
			}
		}
	}

	// heros sell item in the market
	public void sell(Hero hero){
		while(true){
			System.out.println("Which type of items do you want to sell:0(leave) 1(Armory), 2(Weaponry), 3(Potion), 4(Spell)");
			int sellType = scan.nextInt();
			if (sellType < 0 || sellType > 4){
				System.out.println("Invalid input! Must between 0 and 4.");
				continue;
			}
			int sellItem;
			switch (sellType) {
					// back to the menu
				case 0:
					return;

					// sell an armor
				case 1:
					if (hero.getArmory().isEmpty()) {
						System.out.println("Sorry! You have no armory to sell.");
					} else {
						System.out.println("Choose the armor you want to sell:(enter n to sell the nth item)");
						for (Armory a:hero.getArmory()) {
							System.out.println(a.getName());
						}
						sellItem = scan.nextInt();
						ArrayList<Armory> temp = hero.getArmory();
						temp.remove(hero.getArmory().get(sellItem - 1));
						hero.setArmory(temp);
						hero.setMoney(hero.getMoney() + armors.get(sellItem - 1).getPrice());
						System.out.println("Transaction Complete! Sale Confirmation: " + armors.get(sellItem - 1).getName());
					}
					break;

					// sell a weapon
				case 2:
					if (hero.getWeaponry().isEmpty()) {
						System.out.println("Sorry! You have no weapon to sell.");
					} else {
						System.out.println("Choose the weapon you want to sell:(enter n to sell the nth item)");
						for (Weaponry w:hero.getWeaponry()) {
							System.out.println(w.getName());
						}
						sellItem = scan.nextInt();
						ArrayList<Weaponry> temp = hero.getWeaponry();
						temp.remove(hero.getWeaponry().get(sellItem - 1));
						hero.setWeaponry(temp);
						hero.setMoney(hero.getMoney() + weapons.get(sellItem - 1).getPrice());
						System.out.println("Transaction Complete! Sale Confirmation: " + weapons.get(sellItem - 1).getName());
					}
					break;

					// sell a potion
				case 3:
					if (hero.getPotions().isEmpty()) {
						System.out.println("Sorry! You have no potion to sell.");
					} else {
						System.out.println("Choose the potion you want to sell:(enter n to sell the nth item)");
						for (Potion p:hero.getPotions()) {
							System.out.println(p.getName());
						}
						sellItem = scan.nextInt();
						ArrayList<Potion> temp = hero.getPotions();
						temp.remove(hero.getPotions().get(sellItem - 1));
						hero.setPotions(temp);
						hero.setMoney(hero.getMoney() + potions.get(sellItem - 1).getPrice());
						System.out.println("Transaction Complete! Sale Confirmation: " + potions.get(sellItem - 1).getName());
					}
					break;

					// sell a spell
				case 4:
					if (hero.getSpells().isEmpty()) {
						System.out.println("Sorry! You have no spell to sell.");
					} else {
						System.out.println("Choose the spell you want to sell:(enter n to sell the nth item)");
						for (Spell s:hero.getSpells()) {
							System.out.println(s.getName());
						}
						sellItem = scan.nextInt();
						ArrayList<Spell> temp = hero.getSpells();
						temp.remove(hero.getSpells().get(sellItem - 1));
						hero.setSpells(temp);
						hero.setMoney(hero.getMoney() + spells.get(sellItem - 1).getPrice());
						System.out.println("Transaction Complete! Sale Confirmation: " + spells.get(sellItem - 1).getName());
					}
					break;
			}
		}
	}

	// heros walk in the market and make a trade(purchase/sell)
	public void trade(Hero hero){
		int chooseBS;

		System.out.println("For " + hero.getName() + ": Welcome to the market. You can buy/sell items here, or press 0 to leave.");
		while(true) {
			System.out.println("Do you want to buy or sell:(0 leave/1 buy/2 sell)");
			String input = scan.nextLine();
			if (input.equals("q")) {
				System.out.println("Goodbye! See you next time!");
				System.exit(0);
			}
			try {
				chooseBS = Integer.parseInt(input);
				// input size is not an integer
			} catch (Exception e) {
				System.out.println("Invalid input. Must be an integer.");
				continue;
			}
			// input out of index
			if (chooseBS < 0 && chooseBS > 2) {
				System.out.println("Invalid input. Must be 1 or 2.");
				continue;
			}
			break;
		}

		// leave the market
		if (chooseBS == 0){
			System.out.println("Thanks for coming! See you next time~~");
		}

		// purchase items
		if (chooseBS == 1){
			purchase(hero);
		}

		// sell items
		else if (chooseBS == 2){
			sell(hero);
		}
	}
}
