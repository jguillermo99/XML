package Logica;

import java.io.StringReader;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class XMLClass {

	private String cadenaXml = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>"
			+ "<etiqueta>"
			+ "<nombre>Televisor Led Sony </nombre>"
			+ "<precio>900000</precio>"
			+ "<url>http://www.sony.com.co/electronics/televisores/w950b-series</url>"
			+ "</etiqueta>";

	private final Document doc;
	private Producto prod;
	private NodeList nodosRaiz;
	private final ArrayList<Producto> productos = new ArrayList<Producto>();

	public XMLClass() {
		// TODO Auto-generated constructor stub
		doc = convertStringToDocument(cadenaXml);
		buildObject();
	}

	public String getCadenaXml() {
		return cadenaXml;
	}

	public void setCadenaXml(String cadenaXml) {
		this.cadenaXml = cadenaXml;
	}

	public Document convertStringToDocument(String xmlStr) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		try {
			builder = factory.newDocumentBuilder();
			Document doc = builder.parse(new InputSource(new StringReader(
					xmlStr)));
			return doc;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void buildObject() {

		doc.getDocumentElement().normalize();
		nodosRaiz = doc.getDocumentElement().getChildNodes();
		Node nodo = nodosRaiz.item(0);
		String nombre = nodo.getTextContent();
		nodo = nodosRaiz.item(1);
		int precio = Integer.parseInt(nodo.getTextContent());
		nodo = nodosRaiz.item(2);
		String url = nodo.getTextContent();

		prod = new Producto(nombre, precio, url);

		if (validateProduct(prod))
			prod.setCantidad(1);
		else
			productos.add(prod);

		prod.printAtributes();

	}

	public boolean validateProduct(Producto producto) {
		// Si el producto ya existe retorna verdadero
		for (int i = 0; i < productos.size(); i++) {
			if (producto.getNombre() == productos.get(i).getNombre())
				return true;
		}

		return false;
	}

}
