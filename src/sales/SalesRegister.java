package sales;

import shop.ClothingItem;
import shop.Inventory;

public class SalesRegister {
	private static long totalSalesCount = 0;
	private static double totalSalesAmount = 0;

	public static ClothingItem processSale(Inventory inventory, String name, char size) {
		ClothingItem item = inventory.extractItem(name, size);
		if(item == null) {
			System.out.println("Item no encontrado en el inventario.");
		} else {
			totalSalesCount++;
			totalSalesAmount+=item.getPrice();
		}
		return item;
	}

	public static long getTotalSalesCount() {
		return totalSalesCount;
	}

	public static double getTotalSalesAmount() {
		return totalSalesAmount;
	}

	public static String getBalance() {
		return "Hay " + getTotalSalesAmount() + " ventas, Hay " + getTotalSalesCount() + " artículos.";

	}

	public static void resetTotalSalesCount() {
		totalSalesCount = 0;
	}

	public static void resetTotalSalesAmount() {
		totalSalesAmount = 0;
	}
}


