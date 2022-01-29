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
		System.out.println("-------------Editar Cliente-------------");
		System.out.println("Seleccione qué desea hacer: ");
		System.out.println("1.- Cambiar el estado del Cliente");
		System.out.println("2.- Editar los datos ingresados del Cliente");
		System.out.println("3.- Salir");
		System.out.println();
		System.out.println("Ingrese su opción: ");
		int opt = 0;
		String run = "";
		boolean existe;
		do {
			opt = sc.nextInt();
			System.out.println("---------------------------------------");
			switch (opt) {
			case 1:
				System.out.println("Ingrese el run del Cliente a editar");
				run = sc.next();
				existe = clienteServicio.buscarCliente(run);
				if (existe == true) {
//					clienteServicio.getListaClientes().stream().filter(c -> c.getRunCliente()).findFirst();
				}
				break;
			case 2:

				break;
			case 3:
				System.out.println("Saliendo");
				break;

			default:
				break;
			}
		} while (opt != 3);

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
