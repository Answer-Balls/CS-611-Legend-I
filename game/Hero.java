import java.util.ArrayList;
import java.util.Scanner;
import java.lang.Math;
import java.util.Random;

/**
 * @ClassName Market
 * @Description It is the class for the heros in this game
 * @Author Andy Sheng
 * @Date 2021/11/03
 */
public class Hero extends Creature {
	/**
	 * Hero's mana
	 */
	private int mana;
	/**
	 * Hero's strength
	 */
	private int strength;
	/**
	 * Hero's agility
	 */
	private int agility;
	/**
	 * Hero's dexterity
	 */
	private int dexterity;
	/**
	 * Hero's money
	 */
	private int money;
	/**
	 * Hero's exp
	 */
	private int exp;
	/**
	 * Hero's spare hand
	 */
	private int hand = 2;
	/**
	 * Hero's type
	 */
	private String type;
	/**
	 * Hero's current weapon
	 */
	private Weaponry weapon;
	/**
	 * Hero's current armor
	 */
	private Armory armor;
	/**
	 * Hero's armor inventory
	 */
	private ArrayList<Armory> armors;
	/**
	 * Hero's weapon inventory
	 */
	private ArrayList<Weaponry> weapons;
	/**
	 * Hero's potion inventory
	 */
	private ArrayList<Potion> potions;
	/**
	 * Hero's spell inventory
	 */
	private ArrayList<Spell> spells;

	private Scanner scan = new Scanner(System.in);

	// constructor
	public Hero(String name, int level, int defense,
				int mana, int strength, int agility, int dexterity, int money, int exp, String type)
	{
		super(name, level, defense);
		this.mana = mana;
		this.strength = strength;
		this.agility = agility;
		this.dexterity = dexterity;
		this.money = money;
		this.exp = exp;
		this.type = type;
		this.weapon = null;
		this.armor = null;

		armors = new ArrayList<>();
		weapons = new ArrayList<>();
		potions = new ArrayList<>();
		spells = new ArrayList<>();
	}

	// get the hero's mana
	public int getMana() {return mana;}

	// get the hero's strength
	public int getStrength() {return strength;}

	// get the hero's agility
	public int getAgility() {return agility;}

	// get the hero's dexterity
	public int getDexterity() {return dexterity;}

	// get the hero's money
	public int getMoney() {return money;}

	// get the hero's experience
	public int getExp() {return exp;}

	// get the hero's spare hand
	public int getHand() {return hand;}

	// get the hero's type
	public String getType() {return type;}

	// get the hero's current weapon
	public Weaponry getWeapon() {return weapon;}

	// get the hero's current armor
	public Armory getArmor() {return armor;}

	// set the hero's mana
	public void setMana(int mana) {this.mana = mana;}

	// set the hero's strength
	public void setStrength(int strength) {this.strength = strength;}

	// set the hero's agility
	public void setAgility(int agility) {this.agility = agility;}

	// set the hero's dexterity
	public void setDexterity(int dexterity) {this.dexterity = dexterity;}

	// set the hero's money
	public void setMoney(int money) {this.money = money;}

	// set the hero's experience
	public void setExp(int exp) {this.exp = exp;}

	// set the hero's spare hand
	public void setHand(int hand) {this.hand = hand;}

	// set the hero's current weapon
	public void setWeapon(Weaponry weapon) {this.weapon = weapon;}

	// set the hero's current armor
	public void setArmor(Armory armor) {this.armor = armor;}

	// set the hero's type
	public void setType(String type) {this.type = type;}

	public ArrayList<Armory> getArmory()
	{
		return armors;
	}
	public ArrayList<Weaponry> getWeaponry()
	{
		return weapons;
	}
	public ArrayList<Potion> getPotions()
	{
		return potions;
	}
	public ArrayList<Spell> getSpells()
	{
		return spells;
	}

	public void setArmory(ArrayList<Armory> armors) {this.armors = armors;}
	public void setPotions(ArrayList<Potion> potions) {this.potions = potions;}
	public void setSpells(ArrayList<Spell> spells) {this.spells = spells;}
	public void setWeaponry(ArrayList<Weaponry> weapons) {this.weapons = weapons;}

	// heros can level up by accumulating exp
	public void levelUp()
	{
		mana = (int) Math.floor(mana*1.1);
		exp = 0;
		if(type.equals("paladins"))
		{
			strength = (int) Math.round(strength*1.3);
			agility = (int) Math.round(agility*1.3);
			dexterity = (int) Math.round(dexterity*1.1);
		}
		if(type.equals("sorcerer"))
		{
			strength = (int) Math.round(strength*1.1);
			agility = (int) Math.round(agility*1.3);
			dexterity = (int) Math.round(dexterity*1.3);
		}
		if(type.equals("warrior"))
		{
			strength = (int) Math.round(strength*1.3);
			agility = (int) Math.round(agility*1.1);
			dexterity = (int) Math.round(dexterity*1.3);
		}
	}

	// heros can attack a monster
	public void attack(Monster monster){
		int damage = 0;
		// hero with a weapon will have extra damage
		if (weapon != null){
			damage = (int) ((weapon.getDamage() + strength) * 0.05);
		} else{
			damage = (int) (strength * 0.05);
		}
		// target monster deals with the attack
		int effect = monster.defense(damage);
		System.out.println("Hero " + name + " has caused " + damage + " damage to monster " + monster.getName() + " .");
	}

	// heros can take an attack from a monster
	public int defense(int damage){
		int effect = 0;
		Random random = new Random();
		int temp = random.nextInt(10) + 1;

		// hero's agility will get a chance to dodge the attack
		if (temp < (int) (agility*0.002)){
			System.out.println("The attack to hero " + name + " is missed!");
			return effect;
			// attack is successful, hero takes the damage
		} else{
			effect = (int) (damage - armor.getRedValue()*0.01);
			if (effect >= 0){
				hp -= effect;
			}
			// hero is killed by the damage
			if(hp <= 0){
				setIsFaint();
				System.out.println("Hero " + name + " has been slain! R.I.P");
			}
		}
		return effect;
	}

	// heros can change their weapon
	public void changeWeapon(){
		if (weapons.size() == 0){
			System.out.println("You have no weapon! Go get one in the market!");
		}else{
			System.out.println("Below is your weapon list. Choose one to equip.");
			// print the weapon inventory of the hero
			for (Weaponry w: weapons){
				w.showInfo();
			}
			System.out.println("Enter the index of the weapon to equip with. (1 to " + weapons.size() + ")");
			int num = scan.nextInt();
			// hero does not have spare hands to hold the weapon
			if(hand < weapons.get(num-1).getReqHand()){
				System.out.println("Sorry! Your hero does not have spare hands to hold it.");
			}else {
				// hero changes the weapon successfully
				weapon = weapons.get(num-1);
				System.out.println("Your current weapon is " + weapon.getName() + " now!");
			}
		}
	}

	// heros can change their armor
	public void changeArmor(){
		if (armors.size() == 0){
			System.out.println("You have no armor! Go get one in the market!");
		}else{
			System.out.println("Below is your armor list. Choose one to equip.");
			// print the armor inventory of the hero
			for (Armory a: armors){
				a.showInfo();
			}
			System.out.println("Enter the index of the armor to equip with. (1 to " + armors.size() + ")");
			int num = scan.nextInt();
			// hero changes the armor successfully
			armor = armors.get(num-1);
			System.out.println("Your current armor is " + armor.getName() + " now!");
		}
	}

	// heros can use a potion
	public void potion(){
		if (potions.size() == 0){
			System.out.println("You have no potion! Go get one in the market!");
		}else{
			System.out.println("Below is your potion list. Choose one to use.");
			// print the potion inventory of the hero
			for (Potion p: potions){
				p.showInfo();
			}
			System.out.println("Enter the index of the potion to use. (1 to " + potions.size() + ")");
			int num = scan.nextInt();

			// deal with the effect of the potion
			if (potions.get(num-1).getAttribute().contains("Health")) {
				hp += potions.get(num-1).getValue();
			}
			if (potions.get(num-1).getAttribute().contains("Strength")) {
				strength += potions.get(num-1).getValue();
			}
			if (potions.get(num-1).getAttribute().contains("Mana")) {
				mana += potions.get(num-1).getValue();
			}
			if (potions.get(num-1).getAttribute().contains("Agility")) {
				agility += potions.get(num-1).getValue();
			}
			if (potions.get(num-1).getAttribute().contains("Dexterity")) {
				dexterity += potions.get(num-1).getValue();
			}
			if (potions.get(num-1).getAttribute().contains("Defense")) {
				defense += potions.get(num-1).getValue();
			}

			// hero uses the potion successfully
			System.out.println("Your " + potions.get(num-1).getName() + " potion has come into effect!");
			potions.remove(potions.get(num-1));
		}
	}

	// heros can cast a spell
	public void spell(Monster monster) {
		if (spells.size() == 0) {
			System.out.println("You have no spell! Go get one in the market!");
		} else {
			System.out.println("Below is your spell list. Choose one to use.");
			// print the spell inventory of the hero
			for (Spell s : spells) {
				s.showInfo();
			}
			int num = scan.nextInt();
			if (spells.get(num-1).getManaCost() > mana){
				System.out.println("You don't have enough mana to cast the spell");
			}else{
				mana -= spells.get(num-1).getManaCost();

				// different spells have different special effect
				if (spells.get(num-1).getType().equals("fire")){
					monster.setDamage((int)(monster.getDamage()*0.8));
				}
				else if(spells.get(num-1).getType().equals("ice"))
					monster.setDefense((int)(monster.getDefense()*0.8));
				else
					monster.setDodge((int)(monster.getDodge()*0.8));

				// spell will cause damage to target monster
				int effect = (int) (spells.get(num-1).getDamage()*(1 + dexterity / 10000));
				monster.defense(effect);
				System.out.println("You have used spell " + spells.get(num-1).getName() + " to monster " + monster.getName() + " !");
				spells.remove(spells.get(num-1));
			}
		}
	}
}
