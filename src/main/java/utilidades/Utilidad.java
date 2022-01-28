package utilidades;

public class Utilidad {
	
 public void limpiar() {
		try {
			System.out.println("Saliendo en:");
			Thread.sleep(900);
			System.out.println("3");
			Thread.sleep(900);
			System.out.println("2");
			Thread.sleep(900);
			System.out.println("1");
			for (int i = 0; i <1000; i++) {
				System.out.println(" ");
			}
			System.out.println("Ha salido exitosamente del programa");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
 }
}
