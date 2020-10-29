/**
 * 
 */
package es.Studium.ListaCompra;

/**
 * @author Alvca
 *
 */
public class ArticuloAComprar {
//Declaramos las variables
	private String descripcion;
	private Double cantidad;
	private String unidad;
	
	public ArticuloAComprar() {
		
		descripcion = "";
		cantidad = 0.0;
		unidad = "";
	}
	public ArticuloAComprar(String d, Double c, String u) {
		
		descripcion = d;
		cantidad = c;
		unidad = u;
	}
	//Generemos los Getter and setter
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Double getCantidad() {
		return cantidad;
	}
	public void setCantidad(Double cantidad) {
		this.cantidad = cantidad;
	}
	public String getUnidad() {
		return unidad;
	}
	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}
}
