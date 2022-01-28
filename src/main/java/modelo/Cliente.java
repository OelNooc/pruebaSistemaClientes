package modelo;

public class Cliente {
	//atributos
	private String runCliente;
	private String nombreCliente;
	private String apellidoCliente;
	private String aniosCliente;
	private Categoria nombreCategoria;
	
	//constructor con parámetros
	public Cliente(String runCliente, String nombreCliente, String apellidoCliente, String aniosCliente,
			Categoria nombreCategoria) {
		
		this.runCliente = runCliente;
		this.nombreCliente = nombreCliente;
		this.apellidoCliente = apellidoCliente;
		this.aniosCliente = aniosCliente;
		this.nombreCategoria = nombreCategoria;
	}
	
	//getters
	public String getRunCliente() {
		return runCliente;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public String getApellidoCliente() {
		return apellidoCliente;
	}

	public String getAniosCliente() {
		return aniosCliente;
	}

	public Categoria getNombreCategoria() {
		return nombreCategoria;
	}
	
	//setters
	public void setRunCliente(String runCliente) {
		this.runCliente = runCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public void setApellidoCliente(String apellidoCliente) {
		this.apellidoCliente = apellidoCliente;
	}

	public void setAniosCliente(String aniosCliente) {
		this.aniosCliente = aniosCliente;
	}

	public void setNombreCategoria(Categoria nombreCategoria) {
		this.nombreCategoria = nombreCategoria;
	}
	
	//toString
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("Run del Cliente: %s\n", getRunCliente()));
		sb.append(String.format("Nombre del Cliente: %s\n", getNombreCliente()));
		sb.append(String.format("Apellido del Cliente: %s\n", getApellidoCliente()));
		sb.append(String.format("Años como Cliente: %s\n", getAniosCliente()));
		sb.append(String.format("Categoría del Cliente: %s\n", getNombreCategoria()));
		return sb.toString();
	}
	
	
}
