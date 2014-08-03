package Logica;

public class Producto {

	private String nombre;
	private int precio;
	private String url;
	private int cantidad;

	public Producto(String nombre, int precio, String url) {
		this.nombre = nombre;
		this.precio = precio;
		this.url = url;
		this.cantidad = 1;

		// TODO Auto-generated constructor stub
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad += cantidad;
	}

	public void printAtributes() {
		System.out.println("Nombre: " + this.nombre);
		System.out.println("Precio: " + Integer.toString(this.precio));
		System.out.println("Url: " + this.url);

	}

}
