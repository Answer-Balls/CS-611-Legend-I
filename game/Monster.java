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
public class Monster extends Creature {
	/**
	 * monster's attack
	 */
	private int damage;

	/**
	 * monster's agility
	 */
	private int agility;

	/**
	 * monster's dodge chance
	 */
	private double dodge;

	/**
	 * monster's type
	 */
	private String type;

	// constructor
	public Monster(String name, int level, int damage, int defense, double dodge, String type)
	{
		super(name, level, defense);
		this.damage = damage;
		this.dodge = dodge;
		this.type = type;
	}

	// get the monster's damage
	public int getDamage() {return damage;}

	// get the monster's dodge chance
	public double getDodge() {return dodge;}

	// get the monster's type
	public String getType() {return type;}

	// set the damage of the monster
	public void setDamage(int damage) {this.damage = damage;}

	// set the dodge chance of the monster
	public void setDodge(double dodge) {this.dodge = dodge;}

	// get the type of the monster
	public void setType(String type) {this.type = type;}

	// monster attack a hero
	public void attack(Hero hero) {
		// the corresponding hero deals with the attack
		int effect = hero.defense(damage);
		if (effect != 0) {
			System.out.println("Monster " + name + " has caused " + damage + " damage to hero " + hero.getName() + " .");
		}
	}

	// monster get attacked by a hero
	public int defense(int damage){
		int effect = 0;
		Random random = new Random();
		int temp = random.nextInt(10) + 1;
		// monster has a probability to dodge the attack
		if (temp < (int) (dodge*0.1)){
			System.out.println("The attack to monster " + name + " is missed!");
			return effect;

			// attack is successful, damage taken
		} else{
			hp -= damage;
			// the monster is killed by the attack
			if(hp <= 0){
				setIsFaint();
				System.out.println("Monster " + name + " has been slain. Congratulations!");
			}
		}
		return effect;
	}

}
