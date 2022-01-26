import java.util.ArrayList;

/**
 * @ClassName Market
 * @Description It is the class for the monster list
 * @Author Andy Sheng
 * @Date 2021/11/03
 */
public class Enemy {
	private ArrayList<Monster> enemy;

	public Enemy()
	{
		this.enemy = new ArrayList<>();

		// construct the dragon list
		enemy.add(new Monster("Desghidorrah", 3, 300, 400, 0.35, "dragon"));
		enemy.add(new Monster("Chrysophylax", 2, 200, 500, 0.20, "dragon"));
		enemy.add(new Monster("BunsenBurner", 4, 400, 500, 0.45, "dragon"));
		enemy.add(new Monster("Natsunomeryu", 1, 100, 200, 0.10, "dragon"));
		enemy.add(new Monster("TheScaleless", 7, 700, 600, 0.75, "dragon"));
		enemy.add(new Monster("Kas-Ethelinh", 5, 600, 500, 0.60, "dragon"));
		enemy.add(new Monster("Alexstraszan", 10, 1000, 9000, 0.55, "dragon"));
		enemy.add(new Monster("Phaarthurnax", 6, 600, 700, 0.60, "dragon"));
		enemy.add(new Monster("D-Maleficent", 9, 900, 950, 0.85, "dragon"));
		enemy.add(new Monster("TheWeatherbe", 8, 800, 900, 0.80, "dragon"));
		enemy.add(new Monster("Igneel", 6, 600, 400, 0.60, "dragon"));
		enemy.add(new Monster("BlueEyesWhite", 9, 900, 600, 0.75, "dragon"));


		// construct the exoskeleton list
		enemy.add(new Monster("Cyrrollalee", 7, 700, 800, 0.75, "exoskeleton"));
		enemy.add(new Monster("Brandobaris", 3, 350, 450, 0.30, "exoskeleton"));
		enemy.add(new Monster("BigBad-Wolf", 1, 150, 250, 0.15, "exoskeleton"));
		enemy.add(new Monster("WickedWitch", 2, 250, 350, 0.25, "exoskeleton"));
		enemy.add(new Monster("Aasterinian", 4, 400, 500, 0.45, "exoskeleton"));
		enemy.add(new Monster("Chronepsish", 6, 650, 750, 0.60, "exoskeleton"));
		enemy.add(new Monster("Kiaransalee", 8, 850, 950, 0.85, "exoskeleton"));
		enemy.add(new Monster("St-Shargaas", 5, 550, 650, 0.55, "exoskeleton"));
		enemy.add(new Monster("Merrshaullk", 10, 1000, 900, 0.55, "exoskeleton"));
		enemy.add(new Monster("St-Yeenoghu", 9, 950, 850, 0.90, "exoskeleton"));
		enemy.add(new Monster("DocOck", 6, 600, 600, 0.55, "exoskeleton"));
		enemy.add(new Monster("Exodia", 10, 1000, 1000, 0.50, "exoskeleton"));


		// construct the spirit list
		enemy.add(new Monster("Andrealphus", 2, 600, 500, 0.40, "spirit"));
		enemy.add(new Monster("ABlinky", 1, 450, 350, 0.35, "spirit"));
		enemy.add(new Monster("Andromalius", 3, 550, 450, 0.25, "spirit"));
		enemy.add(new Monster("Chiang-shih", 4, 700, 600, 0.40, "spirit"));
		enemy.add(new Monster("FallenAngel", 5, 800, 700, 0.50, "spirit"));
		enemy.add(new Monster("Ereshkigall", 6, 950, 450, 0.35, "spirit"));
		enemy.add(new Monster("Melchiresas", 7, 350, 150, 0.75, "spirit"));
		enemy.add(new Monster("Jormunngand", 8, 600, 900, 0.20, "spirit"));
		enemy.add(new Monster("Rakkshasass", 9, 550, 600, 0.35, "spirit"));
		enemy.add(new Monster("Taltecuhtli", 10, 300, 200, 0.50, "spirit"));
		enemy.add(new Monster("Casper", 1, 100, 100, 0.50, "spirit"));
		enemy.add(new Monster("Andrealphus", 2, 600, 500, 0.40, "spirit"));
	}

	public ArrayList<Monster> getEnemy(){return enemy; }

	// print the monster list of the game
	public void printEnemy(){
		System.out.println("+-------------------------------------------------------------------------------+");
		System.out.println("No |      Name     | Level  |  Damage  |  Defense | Dodge_Chance | Type");
		System.out.println("+-------------------------------------------------------------------------------+");
		for (int i = 0; i < enemy.size(); i++){
			System.out.printf("%-3s %-20s",(i+1), enemy.get(i).getName());
			System.out.printf("%-10s",enemy.get(i).getLevel());
			System.out.printf("%-10s",enemy.get(i).getDamage());
			System.out.printf("%-10s",enemy.get(i).getDefense());
			System.out.printf("%-12s",enemy.get(i).getDodge());
			System.out.printf("%-14s",enemy.get(i).getType());
			System.out.println();
		}
		System.out.println("+-------------------------------------------------------------------------------+");
	}

}
