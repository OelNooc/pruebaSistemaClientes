package servicio;

import java.util.ArrayList;
import java.util.List;

import modelo.Categoria;
import modelo.Cliente;

public class ClienteServicio {
	//atributos
	private List<Cliente> listaClientes;

	public List<Cliente> getListaClientes() {
		return listaClientes;
	}

	//constructor
	public ClienteServicio() {
		
		this.listaClientes = new ArrayList<Cliente>();
	}
	
	public void retornarListarClientes() {
		this.listaClientes.stream().forEach(System.out::println);
	}
	
	public void agregarCliente(String runCliente, String nombreCliente, String apellidoCliente, String aniosCliente,
			Categoria Activo) {
		Cliente cliente = new Cliente(runCliente, nombreCliente, apellidoCliente, aniosCliente, Activo);
		this.listaClientes.add(cliente);
	}
	
	public void editarCliente(String runCliente, String nombreCliente, String apellidoCliente, String aniosCliente,
			Categoria Activo) {
		
	}

}
