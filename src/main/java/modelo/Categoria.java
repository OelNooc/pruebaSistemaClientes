package modelo;

public class Categoria {
private CategoriaEnum estado;

public Categoria(CategoriaEnum estado) {
	super();
	this.estado = estado;
}

public Categoria() {
	
}

public CategoriaEnum getEstado() {
	return estado;
}

public void setEstado(CategoriaEnum estado) {
	this.estado = estado;
}

}
