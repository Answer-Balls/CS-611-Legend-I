/**
 * @ClassName Spell
 * @Description It is the class for Spell
 * @Author Andy Sheng
 * @Date 2021/11/02
 */
public class Spell extends Product{

    /**
     * spell's type(fire/ice/lighting)
     */
    private String type;

    /**
     * the damage caused by the spell
     */
    private int damage;

    /**
     * the mana cost of the spell
     */
    private int manaCost;

    // constructor
    public Spell(String name, int price, int reqLevel, int damage, int manaCost, String type){
        super(name, price, reqLevel);
        this.damage = damage;
        this.manaCost = manaCost;
        this.type = type;
    }

    // get the spell's type
    public String getType() {return type;}

    // get the spell's damage
    public int getDamage() {return damage;}

    // get the mana cost of the spell
    public int getManaCost() {return manaCost;}

    // set the spell's type
    public void setType(String type) {this.type = type;}

    // set the spell's damage
    public void setDamage(int damage) {this.damage = damage;}

    // set the mana cost of the spell
    public void setManaCost(int manaCost) {this.manaCost = manaCost;}

    // print the information of the spell
    public void showInfo(){
        System.out.println("+----------------------------------------------------------+");
        System.out.println("    Name     | Price  |  Level  |  Damage | Mana_Cost | Type");
        System.out.println("+----------------------------------------------------------+");
        System.out.printf("%-20s",getName());
        System.out.printf("%-10s",getPrice());
        System.out.printf("%-10s",getLevel());
        System.out.printf("%-10s",getDamage());
        System.out.printf("%-10s",getManaCost());
        System.out.printf("%-10s",getType());
        System.out.println();
        System.out.println("+----------------------------------------------------------+");
    }
}