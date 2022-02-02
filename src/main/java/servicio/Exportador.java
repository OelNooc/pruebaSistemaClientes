package servicio;

import java.util.Map;

import modelo.Cliente;

public abstract class Exportador {

	/**
	 * Base para crear los métodos exportar necesarios.
	 * 
	 * @param fileName:      nombre del archivo
	 * @param listaClientes: lista a exportar
	 */
	public abstract void exportar(String fileName, Map<String, Cliente> listaClientes);
}
