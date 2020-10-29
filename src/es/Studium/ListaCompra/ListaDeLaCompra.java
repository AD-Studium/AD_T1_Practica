package es.Studium.ListaCompra;
//Importamos las librerias usadas ctl+shift+o
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class ListaDeLaCompra {
	private String nombreLista;	
	//Creamos el constructor por defecto
	public ListaDeLaCompra() {
		//Damos un valor por defecto al nombre de la lista.
		this.nombreLista=".\\lista.txt";
	}
	//Creamos el constructor que recibe el nombre de la lista
	public ListaDeLaCompra(String nombreLista) {
		this.nombreLista = ".\\"+nombreLista+".txt";
	}
	//Creamos el metodo crearListaDeLaCompra
	public void crearListaDeLaCompra(ListaDeLaCompra nombreLista) {
		//Creamos el archivo
		try {
			FileWriter archivo = new FileWriter(this.nombreLista, true);
			archivo.close();
		}
		catch(IOException error) {
			//Imprimimos por consola el mensaje de error
			System.err.println("Error "+ error.getMessage() );
		}
	}
	//Agregamos productos a la lista
	public void agregarProductoAComprar( ArticuloAComprar art) {
		String linea = art.getDescripcion() + "-"+Double.toString(art.getCantidad())+"-"+art.getUnidad();

		try {
			FileWriter salida = new FileWriter(nombreLista, true);
			salida.write(linea +"\n");
			salida.close();
		}catch (IOException error) {
			System.err.println("Error "+ error.getMessage());
		}
	}
	//Mostramos la lista
	public void mostrarLista (String nomLista) {
		try {
			String lista;
			//leemos el fichero
			FileReader archivo = new FileReader(nomLista);
			BufferedReader leerFichero = new BufferedReader(archivo);
			//Leemos el fichero y vamos imprimiendo las lineas
			while ((lista=leerFichero.readLine()) !=null) {
				System.out.println(lista);
			}
			leerFichero.close();//cerramos
		}
		catch(IOException error) {
			//Mensaje de error si no encontramos el archivo
			System.err.println("Error: "+error.getMessage());
		}
		System.out.println("Volviendo al menu principal");
		System.out.println("");
	}
	//Eliminamos un articulo de la lista
	public void eliminarArticulo (String rutaAlFichero, String cadena){
		try {
			Path path = Paths.get(rutaAlFichero);
			//Creamos un arraylist con todas las lineas del fichero
			List<String> lineas = Files.readAllLines(path);
			//comprobamos si las lineas contienen la cadena, si no lo tiene lo ponemos en el array
			lineas = lineas.stream()
					.filter(linea->!linea.contains(cadena))
					.collect(Collectors.toList());
			//Escribimos en el fichero las lineas que no tienen la cadena
			Files.write(path, lineas);
		}
		catch(IOException error) {
			System.err.println("Error: "+error.getMessage());
		}
	}

	public static List<String> getArticulos(String rutaAlFichero){
		List<String> Lista = null;
		try{
			Path path = Paths.get(rutaAlFichero);
			Lista = Files.readAllLines(path);
		}
		catch (IOException error){
			System.err.println("Error: "+ error.getMessage());
		}
		System.out.println(""+Lista);
		return Lista;
	}
	public String getNombreLista() {
		return nombreLista;
	}
	public void setNombreLista(String nombreLista) {
		this.nombreLista = nombreLista;
	}
}
