package shop;

import java.util.Arrays;

public class Inventory {
	private ClothingItem[] items;
	private static int itemLength;
	private final int MAX_SIZE;

	public Inventory(int mAX_SIZE) {
		super();
		MAX_SIZE = mAX_SIZE;
		itemLength = 0;
		items = new ClothingItem[mAX_SIZE];
	}
	
	

	public ClothingItem[] getItems() {
		return items;
	}



	public void setItems(ClothingItem[] items) {
		this.items = items;
	}



	public static int getItemLength() {
		return itemLength;
	}



	public static void setItemLength(int itemLength) {
		Inventory.itemLength = itemLength;
	}



	public int getMAX_SIZE() {
		return MAX_SIZE;
	}

	public int getItemCount() {
		return itemLength;
	}

	public void addItem(ClothingItem item) {
		if (itemLength < MAX_SIZE) {
			for(int i = 0; i < items.length; i++) {
				if(items[i] == null) {
					items[i] = item;
					this.itemLength++;	
					return;
				}
			}	
		} else {
			System.out.println("El inventario está lleno!");
		}
	}

	public int checkStock(String name, char size) {
		int num = 0;
		for (int i = 0; i < MAX_SIZE; i++) {
			if (items[i] != null && items[i].getName().equals(name) && items[i].getSize() == size) {
				num++;
			}
		}
		return num;
	}

	public int getPosItem(String name, char size) {
		int pos = -1;
		for (int i = 0; i < items.length; i++) {
			if (items[i] != null && items[i].getName().equals(name) && items[i].getSize() == size) {
				pos = i;
			}
		}
		return pos;
	}

	public void reorderItems() {
		int index = 0;
		for (int i = 0; i < items.length; i++) {
			if (items[i] != null) {
				items[index++] = items[i];
			}
		}
		items[itemLength] = null;
	}

	public void removeItem(String name, char size) {
		int num = checkStock(name, size);
		if (num > 0) {
			int pos = getPosItem(name, size);
			if (pos != -1) {
				items[pos] = null;
				this.itemLength--;
				reorderItems();
			}
		}
	}

	public ClothingItem extractItem(String name, char size) {

		int num = checkStock(name, size);
		if (num > 0) {
			int pos = getPosItem(name, size);
			if (pos != -1) {
				ClothingItem item = items[getPosItem(name, size)];
				removeItem(name, size);
				return item;
			}else {
				return null;
			}
		
		} else {
			return null;
		}

	}

	@Override
	public String toString() {
		String inventario="Inventario: => itemLength="+ this.getItemCount() + ", MAX_SIZE="+this.MAX_SIZE +" \n"
				+ "Nombre \t\t\t Precio \t\t Talla \n"
				+ "------------------------------------------------------- \n";
		for(int i = 0; i < this.getItemCount(); i++) {
//			if(items[i] != null) {
				inventario += items[i] + "\n";
//			}
		}
		return inventario;
	}
	
	
}
