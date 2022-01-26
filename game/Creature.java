/**
 * @ClassName World
 * @Description It is the abstract class for the creatures in the game
 * @Author Andy Sheng
 * @Date 2021/11/03
 */
public abstract class Creature {
	/**
	 * the name of the creature
	 */
	protected String name;

	/**
	 * the level of the creature
	 */
	protected int level;

	/**
	 * the HP of the creature
	 */
	protected int hp;

	/**
	 * the defense of the creature
	 */
	protected int defense;

	/**
	 * whether the creature is faint
	 */
	protected boolean isFaint;

	// constructor
	public Creature(String name, int level, int defense)
	{
		this.name = name;
		this.level = level;
		this.hp = (level*100);
		this.defense = defense;
		this.isFaint = false;
	}

	// get the creature's name
	public String getName() {return name;}

	// get the creature's level
	public int getLevel() {return level;}

	// get the creature's HP
	public int getHp() {return hp;}

	// get the creature's defense
	public int getDefense() {return defense;}

	// get the creature's living status
	public boolean getIsFaint() {return isFaint;}

	// set the name of the creature
	public void setName(String name) {
		this.name = name;
	}

	// set the level of the creature
	public void setLevel(int level) {
		this.level = level;
	}

	// set the HP of the creature
	public void setHp(int hp) {
		this.hp = hp;
	}

	// set the defense of the creature
	public void setDefense(int defense) {this.defense = defense;}

	// set the living status of the creature
	public void setIsFaint() {isFaint = true;}

}
