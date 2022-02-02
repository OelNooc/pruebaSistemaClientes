package vistas;

import java.util.Scanner;

import modelo.CategoriaEnum;
import modelo.Cliente;
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

	/**
	 * Muestra cada uno de los clientes en la lista actual
	 */
	@Override
	public void listarClientes() {
		System.out.println("-------------Datos del Cliente-------------");
		System.out.println();
		clienteServicio.retornarListarClientes();
		System.out.println("-------------------------------------------");
	}

	/**
	 * Agrega un cliente a la lista actual
	 */
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
		System.out.println();
		System.out.println("---------------------------------------");
		clienteServicio.agregarCliente(run, nom, ape, anios, CategoriaEnum.Activo);
	}

	/**
	 * Edita los datos del cliente diferenciando entre el estado y el resto de datos
	 */
	@Override
	public void editarCliente() {

		int opt = 0;
		String run = "";

		do {
			System.out.println("-------------Editar Cliente-------------");
			System.out.println("Seleccione qué desea hacer: ");
			System.out.println("1.- Cambiar el estado del Cliente");
			System.out.println("2.- Editar los datos ingresados del Cliente");
			System.out.println("3.- Salir");
			System.out.println();
			System.out.println("Ingrese su opción: ");

			opt = sc.nextInt();
			System.out.println("---------------------------------------");
			switch (opt) {
			case 1:
				System.out.println("Ingrese el RUN del Cliente a editar");
				run = sc.next();
				clienteServicio.editarEstado(clienteServicio.getListaClientes().get(run));
				System.out.println("---------------------------------------");
				break;
			case 2:
				System.out.println("Ingrese el RUN del Cliente a editar");
				run = sc.next();
				Cliente cl = clienteServicio.getListaClientes().get(run);
				clienteServicio.editarCliente(run, cl.getNombreCliente(), cl.getApellidoCliente(), cl.getAniosCliente(),
						cl.getNombreCategoria());

				break;
			case 3:
				ut.limpiar();
				ut.mensajeMenu();
				break;

			default:
				break;
			}
		} while (opt != 3);

	}

	/**
	 * Importa la lista desde un archivo externo (DBClientes.csv) que ha de estar
	 * ubicado en el escritorio
	 */
	@Override
	public void importarDatos() {

		clienteServicio.setListaClientes(archivoServicio.cargarDatos(fileName1));
	}

	/**
	 * Exporta la lista actual al escritorio Se puede escoger entre el formato .txt
	 * o .csv
	 */
	@Override
	public void exportarDatos() {
		archivoServicio.exportar(fileName, clienteServicio.getListaClientes());
	}

	/**
	 * Termina la ejecución del programa "Limpiando" la consola y mostrando un
	 * mensaje
	 */
	@Override
	public void terminarPrograma() {
		ut.limpiar();
		ut.mensajePrograma();
	}

}
