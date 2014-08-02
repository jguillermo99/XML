package Logica;

public class Producto {

	private final String nombre;
	private final int precio;
	private final String url;

	public Producto(String nombre, int precio, String url) {
		this.nombre = nombre;
		this.precio = precio;
		this.url = url;

		// TODO Auto-generated constructor stub
	}

	public void printAtributes() {
		System.out.println("Nombre: " + this.nombre);
		System.out.println("Precio: " + Integer.toString(this.precio));
		System.out.println("Url: " + this.url);

	}

}
