package app;

import java.util.Scanner;

import sales.SalesRegister;
import shop.ClothingItem;
import shop.Inventory;
import test.TestClothingItem;
import test.TestInventory;
import test.TestSalesRegister;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static Inventory inventory = new Inventory(10);
	
	public static void main(String[] args) throws Throwable {
		
		//TEST CLOTHINGITEM
//		ClothingItem item1 = new ClothingItem("Camisa", 25.99, 'M');
//		if(item1 != null) {
//			TestClothingItem.checkClass(item1.getClass());
//		}
		
		//TEST INVENTORY
//		Inventory inventory = new Inventory(100);
//		if(inventory != null) {
//			TestInventory.checkClass(inventory.getClass());
//		}
		
		//TEST SALESREGISTER
//		TestSalesRegister.checkSalesRegister();
	
		
		
//		Inventory inventory1 = new Inventory(5);
//		ClothingItem item1 = new ClothingItem("Camisa1", 12.12, 'M');
//		ClothingItem item2 = new ClothingItem("Camisa2", 12.22, 'M');
//		ClothingItem item3 = new ClothingItem("Camisa3", 12.32, 'M');
//		ClothingItem item4 = new ClothingItem("Camisa4", 12.32, 'M');
//		ClothingItem item5 = new ClothingItem("Camisa5", 12.32, 'M');
//		ClothingItem item6 = new ClothingItem("Camisa6", 12.32, 'M');
//		inventory1.addItem(item1);
//		inventory1.addItem(item2);
//		inventory1.addItem(item3);
//		inventory1.addItem(item4);
//		inventory1.addItem(item5);
//		inventory1.addItem(item6);
//		System.out.println(inventory1);
//		inventory1.removeItem("Camisa4", 'M');
//		System.out.println(inventory1);
//		inventory1.extractItem("Camisa2", 'M');
//		System.out.println(inventory1);
		
		
		int opcion;
	
		
		do{
			
			menu();
			opcion = getOpcion();
			
		
			switch(opcion) {
			case 1:
				agregarNuevaPrendaAlInventario();
				break;
				
			case 2:
					mostrarInventario();
				break;
				
			case 3:
					procesarVenta();
				break;
				
			case 4:
					mostrarEstadisticasDeVentas();
				break;
				
			case 5:
				System.out.println("\nSALIR");
				break;
			default:
				System.out.println("Escribe un número del 1-5");
				break;		
			}
		}while(opcion != 5);
	}
	
	public static int getOpcion() {
		int opcion = scanner.nextInt();
		if(opcion < 1 || opcion > 5) return -1;
		else return opcion;
	}
	
	public static void menu() {
		System.out.println("\n*** Bienvenido a Strafalarius *** \n "
				+ "Seleccione opción: \n"
				+ "1. Agregar nueva prenda al inventario \n"
				+ "2. Mostrar inventario \n"
				+ "3. Procesar venta \n"
				+ "4. Mostrar estadísticas de ventas \n"
				+ "5. Salir \n"
				+ "Seleccione una opción (1-5):");
	}
	
	public static void agregarNuevaPrendaAlInventario() throws Exception {
		System.out.print("Ingrese los detalles de la prenda: \n"
				+ "Nombre: ");
		scanner.nextLine();
		String nombre = scanner.nextLine();
		System.out.print("Precio: ");
		double precio = Double.parseDouble(scanner.nextLine());
		System.out.print("Talla(S/M/L): ");
		char talla = scanner.nextLine().charAt(0);

		
		ClothingItem item = new ClothingItem(nombre, precio, talla);
		inventory.addItem(item);
		
		System.out.println("\nPrenda añadida al inventario correctamente.");
	}
	
	public static void mostrarInventario() {
		System.out.println(inventory.toString());
	}
	
	public static void procesarVenta() {
		System.out.print("Ingrese los detalles de la prenda: \n"
				+ "Nombre: ");
		scanner.nextLine();
		String nombre = scanner.nextLine();
		System.out.print("Talla(S/M/L): ");
		char talla = scanner.nextLine().charAt(0);
		ClothingItem item =SalesRegister.processSale(inventory, nombre, talla);
		if(item != null) {
			System.out.println("\nClothing item '"+ item.getName() + "' (Size " + item.getSize()
			+ ") exctracted from inventory. ");
			System.out.println("Venta procesada. Artículo vendido: " + item.toString());
		}
	}
	
	public static void mostrarEstadisticasDeVentas() {
		System.out.println(SalesRegister.getBalance());
	}
}
