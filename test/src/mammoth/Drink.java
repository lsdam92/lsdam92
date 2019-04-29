package mammoth;
enum IceType{
	HOT, ICE
}
public abstract class Drink implements Food{
	
	protected static int price;
	protected static String name;
	protected int totalPrice;
	protected IceType iceType;
	
	public Drink(String name, int price) {
		this.name=name;
		this.price=price;
	}

	public static int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public IceType getIceType() {
		return iceType;
	}

	public void setIceType(IceType iceType) {
		this.iceType = iceType;
	}

	public static String getName() {
		return name;
	}

	public static void setName(String name) {
		Drink.name = name;
	}
	
	int sumPrice() {
		return totalPrice +=price;
			
	}
	

	
}
