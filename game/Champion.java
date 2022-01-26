import java.util.ArrayList;

/**
 * @ClassName Market
 * @Description It is the class for the champions
 * @Author Andy Sheng
 * @Date 2021/11/03
 */
public class Champion {
	private ArrayList<Hero> champions;

	public Champion()
	{
		this.champions = new ArrayList<>();

		// construct the paladin list
		champions.add(new Hero("Parzival", 1, 0, 300, 750, 650, 700, 2500, 7, "paladin"));
		champions.add(new Hero("Sehanie_Moonbow", 1, 0, 300, 750, 700, 700, 2500, 7, "paladin"));
		champions.add(new Hero("Skoraeus_Stonebones", 1, 0, 250, 650, 600, 350, 2500, 4, "paladin"));
		champions.add(new Hero("Garl_Glittergold", 1, 0, 100, 600, 500, 400, 2500, 5, "paladin"));
		champions.add(new Hero("Amaryllis_Astra", 1, 0, 500, 500, 500, 500, 2500, 5, "paladin"));
		champions.add(new Hero("Caliber_Heist", 1, 0, 400, 400, 400, 400, 2500, 8, "paladin"));

		// construct the sorcerer list
		champions.add(new Hero("Rillifane_Rallathil", 1, 0, 1300, 750, 450, 500, 2500, 9, "sorcerer"));
		champions.add(new Hero("Segojan_Earthcaller", 1, 0, 900, 800, 500, 650, 2500, 5, "sorcerer"));
		champions.add(new Hero("Reign_Havoc", 1, 0, 800, 800, 800, 800, 2500, 8, "sorcerer"));
		champions.add(new Hero("Reverie_Ashels", 1, 0, 900, 800, 700, 400, 2500, 7, "sorcerer"));
		champions.add(new Hero("Kalabar", 1, 0, 800, 850, 400, 600, 2500, 6, "sorcerer"));
		champions.add(new Hero("Skye_Soar", 1, 0, 1000, 700, 400, 500, 2500, 5, "sorcerer"));

		// construct the warrior list
		champions.add(new Hero("Gaerdal_Ironhand", 1, 0, 100, 700, 500, 600, 1354, 7, "warrior"));
		champions.add(new Hero("Sehanine_Monnbow", 1, 0, 600, 700, 800, 500, 2500, 8, "warrior"));
		champions.add(new Hero("Muamman_Duathall", 1, 0, 300, 900, 500, 750, 2546, 6, "warrior"));
		champions.add(new Hero("Flandal_Steelskin", 1, 0, 200, 750, 650, 700, 2500, 7, "warrior"));
		champions.add(new Hero("Undefeated_Yoj", 1, 0, 400, 800, 400, 700, 2500, 7, "warrior"));
		champions.add(new Hero("Eunoia_Cyn", 1, 0, 400, 700, 800, 600, 2500, 6, "warrior"));
	}

	// get the champion list
	public ArrayList<Hero> getChampions() {return champions;}

	// print the hero list of the game
	public void printChampion(){
		System.out.println("+----------------------------------------------------------------------------------------+");
		System.out.println("No |        Name       | Strenght | Agility | Dexterity | Money | experience | Type");
		for (int i = 0; i < champions.size(); i++){
			System.out.printf("%-3s %-22s",(i+1), champions.get(i).getName());
			System.out.printf("%-10s",champions.get(i).getStrength());
			System.out.printf("%-10s",champions.get(i).getAgility());
			System.out.printf("%-11s",champions.get(i).getDexterity());
			System.out.printf("%-12s",champions.get(i).getMoney());
			System.out.printf("%-10s",champions.get(i).getExp());
			System.out.printf("%-10s",champions.get(i).getType());
			System.out.println();
		}
		System.out.println("+----------------------------------------------------------------------------------------+");
	}

}
