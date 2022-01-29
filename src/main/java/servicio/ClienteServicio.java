package servicio;

import java.util.HashMap;
import java.util.Map;

import modelo.CategoriaEnum;
import modelo.Cliente;

public class ClienteServicio {
	// atributos
	private Map<String, Cliente> listaClientes = new HashMap<>();

	public void setListaClientes(Map<String, Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}

	public Map<String, Cliente> getListaClientes() {
		return listaClientes;
	}

	// constructor
	public ClienteServicio() {

		this.listaClientes = new HashMap<String, Cliente>();
	}

	public void retornarListarClientes() {
		this.listaClientes.entrySet().forEach(entry -> {
			Cliente cliente = entry.getValue();
			System.out.println("El RUN del Cliente es: " + cliente.getRunCliente());
			System.out.println("El nombre del Cliente es: " + cliente.getNombreCliente());
			System.out.println("El apellido del Cliente es: " + cliente.getApellidoCliente());
			System.out.println("Ha sido cliente hace: " + cliente.getAniosCliente());
			System.out.println("El estado del Cliente es: " + cliente.getNombreCategoria());
		});
	}

	public void agregarCliente(String runCliente, String nombreCliente, String apellidoCliente, String aniosCliente,
			CategoriaEnum Activo) {
		Cliente cliente = new Cliente(runCliente, nombreCliente, apellidoCliente, aniosCliente,
				CategoriaEnum.Activo);
		this.listaClientes.put(runCliente, cliente);
	}
	
	public Cliente editarEstado(Cliente cliente, String estado) {
		if (listaClientes.entrySet().) {
			
		}
		if (estado.equals("Activo")) {
			cliente.setNombreCategoria(CategoriaEnum.Activo);
		}else if (estado.equals("Inactivo")) {
			cliente.setNombreCategoria(CategoriaEnum.Inactivo);
		}else {
			System.out.println("La opción ingresada no es válida");
		}
		
		return cliente;
	}

	public void editarCliente(String runCliente, String nombreCliente, String apellidoCliente, String aniosCliente,
			CategoriaEnum Activo) {

	}

}
