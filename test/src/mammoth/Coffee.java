package mammoth;

public  class Coffee extends Drink {

	protected int SYRUP_PRICE = 500;
	protected int SHOT_PRICE = 500;
	protected int shotAmount = 0;
	protected int syrupAmount = 0;

	public Coffee(int SYRUP_PRICE,int SHOT_PRICE , int shotAmount, int syrupAmount) {
		super(getName(), getPrice());
		this.SYRUP_PRICE = SYRUP_PRICE;
		this.SHOT_PRICE = SYRUP_PRICE;
		this.shotAmount = shotAmount;
		this.syrupAmount = syrupAmount;
	}

	public int getSYRUP_PRICE() {
		return SYRUP_PRICE;
	}

	public void setSYRUP_PRICE(int SYRUP_PRICE) {
		this.SYRUP_PRICE = SYRUP_PRICE;
	}

	public int getSHOT_PRICE() {
		return SHOT_PRICE;
	}

	public void setSHOT_PRICE(int SHOT_PRICE) {
		this.SHOT_PRICE = SHOT_PRICE;
	}

	public int getShotAmount() {
		return shotAmount;
	}

	public void setShotAmount(int shotAmount) {
		this.shotAmount = shotAmount;
	}

	public int getSyrupAmount() {
		return syrupAmount;
	}

	public void setSyrupAmount(int syrupAmount) {
		this.syrupAmount = syrupAmount;
	}
	
	int syrupPrice(int SYRUP_PRICE, int syrupAmount) {
		return price = SYRUP_PRICE * syrupAmount;
	}
	int shotPrice(int SHOT_PRICE, int shotAmount) {
		return price = SHOT_PRICE * shotAmount;
	}

}
