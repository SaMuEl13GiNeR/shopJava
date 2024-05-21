package shop;

public class ClothingItem {
	private String name;
	private double price;
	private char size;

	public ClothingItem(String name, double price, char size) throws Exception {
		super();
		this.name = name;
		this.price = price;

		if (size != 'S' && size != 'M' && size != 'L') {
			throw new Exception("La talla debe ser S/M/L");
		} else {
			this.size = size;
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public char getSize() {
		return size;
	}

	public void setSize(char size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return this.getName() + " \t\t\t " + this.getPrice()+" \t\t\t " + this.getSize();
	}

}
