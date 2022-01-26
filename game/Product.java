/**
 * @ClassName Product
 * @Description It is the abstract class for products in the market
 * @Author Andy Sheng
 * @Date 2021/11/02
 */
public abstract class Product{
	/**
	 * Product's name
	 */
	protected String name;

	/**
	 * Product's price
	 */
	protected int price;

	/**
	 * Product's required level
	 */
	protected int reqLevel;

	// constructor
	public Product(String name, int price, int reqLevel){
		this.name = name;
		this.price = price;
		this.reqLevel = reqLevel;
	}

	// get the name
	public String getName() {return name;}

	// get the price
	public int getPrice() {return price;}

	// get the required level
	public int getLevel() {return reqLevel;}

	// set the name
	public void setName(String name){
		this.name = name;
	}

	// set the price
	public void setPrice(int price){
		this.price = price;
	}

	// set the required level
	public void setLevel(int reqLevel){
		this.reqLevel = reqLevel;
	}

}