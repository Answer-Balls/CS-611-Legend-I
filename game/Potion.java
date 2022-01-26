/**
 * @ClassName Potion
 * @Description It is the class for Potion
 * @Author Andy Sheng
 * @Date 2021/11/02
 */
public class Potion extends Product{

    /**
     * potion's enhanced attribute
     */
    private String attribute;

    /**
     * potion's enhanced value
     */
    private int value;


    // constructor
    public Potion(String name, int price, int reqLevel, int value, String attribute){
        super(name, price, reqLevel);
        this.attribute = attribute;
        this.value = value;
    }

    // get the enhanced attribute
    public String getAttribute() {return attribute;}

    // get the enhanced value
    public int getValue() {return value;}

    // set the enhanced attribute
    public void setAttribute(String attribute) {this.attribute = attribute;}

    // set the enhanced value
    public void setValue(int value) {this.value = value;}


    // print the information of the potion
    public void showInfo(){
        System.out.println("+-----------------------------------------------------------------------+");
        System.out.println("    Name     | Price  |  Level  |  Increased_Value | Increased_Attribute ");
        System.out.println("+-----------------------------------------------------------------------+");
        System.out.printf("%-20s",getName());
        System.out.printf("%-10s",getPrice());
        System.out.printf("%-10s",getLevel());
        System.out.printf("%-10s",getValue());
        System.out.printf("%-10s",getAttribute());
        System.out.println();
        System.out.println("+----------------------------------------------------------+");
    }
}