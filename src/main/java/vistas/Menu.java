package vistas;

import java.util.Scanner;

import modelo.Categoria;
import modelo.CategoriaEnum;
import servicio.ArchivoServicio;
import servicio.ClienteServicio;
import servicio.ExportadorCsv;
import servicio.ExportadorTxt;
import utilidades.Utilidad;

public class Menu extends MenuTemplate {

	// atributos
	private ClienteServicio clienteServicio = new ClienteServicio();
	private ExportadorCsv exportadorCsv = new ExportadorCsv();
	private ExportadorTxt exportadorTxt = new ExportadorTxt();
	private ArchivoServicio archivoServicio = new ArchivoServicio(exportadorTxt, exportadorCsv);
	private String fileName = "Clientes";
	private String fileName1 = "DBClientes.csv";
	private Scanner sc = new Scanner(System.in);
	private Utilidad ut = new Utilidad();

	public void iniciarMenu() {
		int opcion = 0;
		do {
			System.out.println("1. Listar Clientes");
			System.out.println("2. Agregar Cliente");
			System.out.println("3. Editar Cliente");
			System.out.println("4. Cargar Datos");
			System.out.println("5. Exportar Datos");
			System.out.println("6. Salir");
			System.out.println("Ingrese una opción: ");
			opcion = sc.nextInt();

			switch (opcion) {
			case 1:
				listarClientes();
				break;
			case 2:
				agregarCliente();
				break;
			case 3:

				break;
			case 4:
				importarDatos();
				break;
			case 5:
				exportarDatos();
				break;
			case 6:
				terminarPrograma();
				break;

			default:
				System.out.println("La opción ingresada no es válida");
				break;
			}
		} while (opcion != 6);

	}

	@Override
	public void listarClientes() {
		System.out.println("-------------Datos del Cliente-------------");
		System.out.println();
		clienteServicio.retornarListarClientes();
		System.out.println("-------------------------------------------");
	}

	@Override
	public void agregarCliente() {
		System.out.println("-------------Crear Cliente-------------");
		System.out.println();
		System.out.println("Ingresar RUN del Cliente: ");
		String run = sc.next();
		System.out.println();
		System.out.println("Ingresar Nombre del Cliente: ");
		String nom = sc.next();
		System.out.println();
		System.out.println("Ingresar Apellido del Cliente: ");
		String ape = sc.nextLine();
		sc.nextLine();
		System.out.println();
		System.out.println("Ingresar años como Cliente: ");
		String anios = sc.next();
		Categoria cat = new Categoria(CategoriaEnum.Activo);
		System.out.println();
		System.out.println("---------------------------------------");
		clienteServicio.agregarCliente(run, nom, ape, anios, cat);
	}

	@Override
	public void editarCliente() {

	}

	@Override
	public void importarDatos() {
		archivoServicio.cargarDatos(fileName1);
	}

	@Override
	public void exportarDatos() {
		archivoServicio.exportar(fileName, clienteServicio.getListaClientes());
	}

	@Override
	public void terminarPrograma() {
		ut.limpiar();
	}

}
