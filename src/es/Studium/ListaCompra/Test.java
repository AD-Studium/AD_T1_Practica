package es.Studium.ListaCompra;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
//Importamos las librerias usadas ctl+shift+o
import java.util.Scanner;

public class Test {
	static ListaDeLaCompra nombre;
	Scanner menus = new Scanner(System.in);
	Scanner teclado = new Scanner(System.in);
	int menu;
	String listaNombre;
	String articulo;
	double cantidad=0.0;	
	String unidad;
	String SiNo;
	static BufferedReader br;
	static String contenedor="";
	static String borrar="";
	String archivo="";
	public Test() {
		do {
			//Creamos un menu para realizar las pruebas.
			System.out.println("Seleccione que desea hacer, introduzca el numero elegido:");
			System.out.println("1- Crear Lista");
			System.out.println("2- Mostrar Lista");
			System.out.println("3- Eliminar articulo de una lista");
			System.out.println("Introduzca 0 para salir.");

			menu=menus.nextInt();

			if(menu==1) {
				crearListaDeLaCompra();
			}else if(menu==2) {
				mostrarLista();
			}else if(menu==3) {
				eliminarArticulo ();
			}
		}
		while(menu!=0);
		System.out.println("Saliendo del Programa");
		teclado.close();
		menus.close();
	}
	private void crearListaDeLaCompra() {
		System.out.println("Introduce el nombre de la lista");
		listaNombre=teclado.next();
		//Usamos el constructor con nombre, para crear la lista con el nombre deseado
		ListaDeLaCompra nombreLista = new ListaDeLaCompra(listaNombre);
		//Podriamos usar el constructor sin parametro asi
		//ListaDeLaCompra lista1=new ListaDeLaCompra();
		SiNo="S";
		do {
			//Si respuesta = s hacer (Ignora mayusculas o minusculas)
			if (SiNo.equalsIgnoreCase("S")) {
				//Pedimos el articulo
				System.out.println("Introduzca la descripcion del articulo");
				articulo=teclado.next();
				System.out.println("Introduzca la cantidad, medida o peso del articulo");
				cantidad=teclado.nextDouble();
				System.out.println("Introduzca la unidad de medida del articulo(Unidad, Metros, Kg, g, ...)");
				unidad=teclado.next();
				//Creamos e introducimos el articulo la lista
				ArticuloAComprar articulos = new ArticuloAComprar(articulo, cantidad, unidad);
				//
				nombreLista.agregarProductoAComprar(articulos);

				//lista1.agregarProductoAComprar(); //Con esto utilizariamos el constructor sin parametro
				//Preguntamos si qqueremos continuar.

				System.out.println("¿Añadir mas articulos a la lista? Escriba S / N");
				SiNo=teclado.next();
			}
			else {

				SiNo = "N";
			}
		}
		while(SiNo.equalsIgnoreCase("S"));
		System.out.println("Se ha creado la lista correctamente");
		System.out.println("Volviendo al menu principal");
		System.out.println();
		System.out.println();
	}
	private void mostrarLista() {
		// TODO Auto-generated method stub
		System.out.println("Indique el nombre de la lista que quiere consultar:");
		archivo=teclado.next()+".txt";
		new ListaDeLaCompra().mostrarLista(archivo);
	}
	private void mostrarLista(String nombre) {
		// TODO Auto-generated method stub
		archivo=nombre;
		new ListaDeLaCompra().mostrarLista(archivo);
	}
	private void eliminarArticulo () {
		try {
			BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Introduzca el nombre del archivo");
			archivo=teclado.readLine()+".txt";
			System.out.println("Indique el artículo que desea eliminar de la lista");
			articulo=teclado.readLine();
			FileReader entrada = new FileReader(archivo);
			br = new BufferedReader(entrada);
			while ((contenedor=br.readLine())!=null) {	
				if (contenedor.equalsIgnoreCase(articulo)) {	
					borrar = articulo;
				}
			}
			System.out.println(borrar);
			br.close();
		}catch(IOException error) {
			System.err.println("Error: "+ error.getMessage());
		}
		new ListaDeLaCompra().eliminarArticulo (archivo, articulo);
		mostrarLista(archivo);
	}
	public static void main(String[] args) {
		new Test();
	}
}