/**
 * @ClassName Weaponry
 * @Description It is the class for weapons
 * @Author Andy Sheng
 * @Date 2021/11/02
 */
public class Weaponry extends Product{
    /**
     * the damage caused by the spell
     */
    private int damage;

    /**
     * the number of hands required for the weapon
     */
    private int reqHand;

    // constructor
    public Weaponry(String name, int price, int reqLevel, int damage, int reqHand){
        super(name, price, reqLevel);
        this.damage = damage;
        this.reqHand = reqHand;
    }

    // get the damage caused by the weapon
    public int getDamage() {return damage;}

    // get the number of hands required for the weapon
    public int getReqHand() {return reqHand;}

    // set the weapon's damage
    public void setDamage(int damage) {this.damage = damage;}

    // set the hands required for the weapon
    public void setReqHand(int reqHand) {this.reqHand = reqHand;}

    // print the information of the weapon
    public void showInfo(){
        System.out.println("+-------------------------------------------------------------------------------+");
        System.out.println("    Name     | Price  |  Level  |  Damage | Required_Hands");
        System.out.println("+-------------------------------------------------------------------------------+");
        System.out.printf("%-20s",getName());
        System.out.printf("%-10s",getPrice());
        System.out.printf("%-10s",getLevel());
        System.out.printf("%-10s",getDamage());
        System.out.printf("%-12s",getReqHand());
        System.out.println();
        System.out.println("+----------------------------------------------------------+");
    }
}