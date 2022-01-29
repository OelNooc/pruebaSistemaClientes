package servicio;

import java.util.Map;

import modelo.Cliente;

public abstract class Exportador {
	
public abstract  void exportar(String fileName, Map<String, Cliente> listaClientes);
}
