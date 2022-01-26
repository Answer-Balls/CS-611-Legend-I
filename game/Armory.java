/**
 * @ClassName Armour
 * @Description It is the class for Armour
 * @Author Andy Sheng
 * @Date 2021/11/02
 */
public class Armory extends Product{
    /**
     * Armour's reduction value
     */
    private int redValue;

    // constructor
    public Armory(String name, int price, int reqLevel, int redValue){
        super(name, price, reqLevel);
        this.redValue = redValue;
    }

    // get the reduction value
    public int getRedValue() {return redValue;}

    // set the reduction value
    public void setRedValue(int redValue) {this.redValue = redValue;}


    // print the information of the armor
    public void showInfo(){
        System.out.println("+--------------------------------------------------------+");
        System.out.println("    Name     | Price  |  Level  |  Damage_Reduction ");
        System.out.println("+--------------------------------------------------------+");
        System.out.printf("%-20s",getName());
        System.out.printf("%-10s",getPrice());
        System.out.printf("%-10s",getLevel());
        System.out.printf("%-10s",getRedValue());
        System.out.println();
        System.out.println("+----------------------------------------------------------+");
    }
}
