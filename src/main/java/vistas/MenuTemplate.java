package vistas;

import java.util.Scanner;

public abstract class MenuTemplate {

	private Scanner sc = new Scanner(System.in);

	public abstract void listarClientes();

	public abstract void agregarCliente();

	public abstract void editarCliente();

	public abstract void importarDatos();

	public abstract void exportarDatos();

	public abstract void terminarPrograma();

	/**
	 * Muestra el menú con todas las opciones y ejecuta el método correspondiente
	 */
	public final void iniciarMenu() {
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
				editarCliente();
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
}
