package servicio;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import modelo.CategoriaEnum;
import modelo.Cliente;

public class ClienteServicio {
	// atributos
	private Map<String, Cliente> listaClientes = new HashMap<>();
	private Scanner sc = new Scanner(System.in);

	/**
	 * Define una lista de clientes como un mapa, a modo de poder acceder fácilmente
	 * mediante el run y evitar duplicados
	 * 
	 * @param listaClientes
	 */
	public void setListaClientes(Map<String, Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}

	/**
	 * @return devuelve la lista de clientes
	 */
	public Map<String, Cliente> getListaClientes() {
		return listaClientes;
	}

	// constructor
	/**
	 * Permite instanciar el mapa
	 */
	public ClienteServicio() {

		this.listaClientes = new HashMap<String, Cliente>();
	}

	/**
	 * Muestra los datos contenidos en listaClientes
	 */
	public void retornarListarClientes() {
		this.listaClientes.entrySet().forEach(entry -> {
			Cliente cliente = entry.getValue();
			System.out.println("El RUN del Cliente es: " + cliente.getRunCliente());
			System.out.println("El nombre del Cliente es: " + cliente.getNombreCliente());
			System.out.println("El apellido del Cliente es: " + cliente.getApellidoCliente());
			System.out.println("Ha sido cliente hace: " + cliente.getAniosCliente());
			System.out.println("El estado del Cliente es: " + cliente.getNombreCategoria());
			System.out.println("---------------------------------------");
			System.out.println();

		});
	}

	/**
	 * Agrega un cliente a la lista verificando previamente que no sea null
	 * 
	 * @param runCliente:      se espera en formato "11.111.111-1"
	 * @param nombreCliente:   se espera en formato "Pepito"
	 * @param apellidoCliente: se espera en formato "Perez"
	 * @param aniosCliente:    se espera en formato "9"
	 * @param Activo:          vendrá activo por defecto.
	 */
	public void agregarCliente(String runCliente, String nombreCliente, String apellidoCliente, String aniosCliente,
			CategoriaEnum Activo) {
		if (listaClientes.get(runCliente) == null) {
			Cliente cliente = new Cliente(runCliente, nombreCliente, apellidoCliente, aniosCliente,
					CategoriaEnum.Activo);
			this.listaClientes.put(runCliente, cliente);
		} else {
			System.out.println("El cliente específicado ya existe, revise el RUN entregado");
		}

	}

	/**
	 * Permite cambiar el estado del cliente de Activo a Inactivo y viceversa
	 * 
	 * @param cliente: el cliente que necesita la modificación
	 */
	public void editarEstado(Cliente cliente) {

		if (listaClientes.containsKey(cliente.getRunCliente())) {

			Cliente cli = listaClientes.get(cliente.getRunCliente());

			System.out.println("-----Actualizando estado del Cliente----");
			System.out.printf("El estado actual del Cliente es: %s\n", String.valueOf(cli.getNombreCategoria()));
			System.out.println("1.-Si desea cambiar el estado del Cliente a Inactivo");
			System.out.println("2.-Si desea cambiar el estado del Cliente a Activo");
			System.out.println("Ingrese opción: ");
			int opx = sc.nextInt();

			if (opx == 1) {
				cli.setNombreCategoria(CategoriaEnum.Inactivo);
				listaClientes.replace(cli.getRunCliente(), cli);
				System.out.printf("El estado del cliente %s se ha modificado exitosamente \n", cli.getNombreCliente());
			} else if (opx == 2) {
				cli.setNombreCategoria(CategoriaEnum.Activo);
				listaClientes.replace(cli.getRunCliente(), cli);
				System.out.printf("El estado del cliente %s se ha modificado exitosamente \n", cli.getNombreCliente());
			} else {
				System.out.println("La opción ingresada no es válida");
			}
		}

	}

	/**
	 * Permite editar los datos del cliente a excepción del estado.
	 * 
	 * @param runCliente:      se espera en formato "11.111.111-1"
	 * @param nombreCliente:   se espera en formato "Pepito"
	 * @param apellidoCliente: se espera en formato "Perez"
	 * @param aniosCliente:    se espera en formato "9"
	 * @param Activo:          puede ser Activo o Inactivo según venga desde el cliente.
	 */
	public void editarCliente(String runCliente, String nombreCliente, String apellidoCliente, String aniosCliente,
			CategoriaEnum Activo) {
		Cliente cli = listaClientes.get(runCliente);
		System.out.println("-----Actualizando estado del Cliente----");
		System.out.printf("1.-El RUN del Cliente es: %s\n", runCliente);
		System.out.printf("2.-El Nombre del Cliente es: %s\n", nombreCliente);
		System.out.printf("3.-El Apellido del Cliente es: %s\n", apellidoCliente);
		System.out.printf("4.-Los años como cliente son: %s\n", aniosCliente);
		System.out.println("Ingrese opción a editar de los datos del cliente:");
		int opx = sc.nextInt();
		System.out.println("---------------------------------------");
		switch (opx) {
		case 1:
			System.out.println("1.-Ingrese el nuevo RUN del Cliente:");
			String run = sc.next();
			System.out.println("---------------------------------------");
			cli.setRunCliente(run);
			listaClientes.put(cli.getRunCliente(), cli);
			listaClientes.remove(runCliente);
			System.out.println("Datos cambiados con éxito");
			break;
		case 2:
			System.out.println("2.-Ingrese el nuevo Nombre del Cliente:");
			String nom = sc.next();
			System.out.println("---------------------------------------");
			cli.setNombreCliente(nom);
			listaClientes.put(cli.getRunCliente(), cli);
			System.out.println("Datos cambiados con éxito");
			break;
		case 3:
			System.out.println("3.-Ingrese el nuevo Apellido del Cliente:");
			String ape = sc.next();
			System.out.println("---------------------------------------");
			cli.setApellidoCliente(ape);
			listaClientes.put(cli.getRunCliente(), cli);
			System.out.println("Datos cambiados con éxito");
			break;
		case 4:
			System.out.println("4.-Ingrese años correctos que ha sido Cliente:");
			String anios = sc.next() + " anios";
			System.out.println("---------------------------------------");
			cli.setAniosCliente(anios);
			listaClientes.put(cli.getRunCliente(), cli);
			System.out.println("Datos cambiados con éxito");
			break;

		default:
			System.out.println("La opción ingresada no es válida");
			break;
		}
	}

}
