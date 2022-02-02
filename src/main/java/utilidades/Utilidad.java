package utilidades;

public class Utilidad {

	/**
	 * Genera espacios en blanco para simular que se limpia la consola
	 */
	public void limpiar() {
		try {
			System.out.println("Saliendo en:");
			System.out.println("3");
			Thread.sleep(900);
			System.out.println("2");
			Thread.sleep(900);
			System.out.println("1");
			Thread.sleep(900);
			for (int i = 0; i < 1000; i++) {
				System.out.println(" ");
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * muestra por consola un mensaje para decir que se salió del programa
	 */
	public void mensajePrograma() {
		System.out.println("Ha salido exitosamente del programa");
	}

	/**
	 * muestra por consola un mensaje para decir que se salió al menú principal
	 */
	public void mensajeMenu() {
		System.out.println("Ha vuelto exitosamente al menú");
	}
}
