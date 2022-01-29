package servicio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import modelo.CategoriaEnum;
import modelo.Cliente;

public class ArchivoServicio extends Exportador {
	private Scanner sc = new Scanner(System.in);
	private ExportadorTxt et = new ExportadorTxt();
	private ExportadorCsv ec = new ExportadorCsv();

	public ArchivoServicio(ExportadorTxt et, ExportadorCsv ec) {

		this.et = et;
		this.ec = ec;
	}

	public List<Cliente> cargarDatos(String fileName) {

		File archivo;
		List<Cliente> listaCliente = new ArrayList<Cliente>();

		System.out.println("Ingrese la ruta donde se encuentra el archivo: ");

		String ruta = sc.next();
		String path = String.format("%s//%s", ruta, fileName);

		archivo = new File(ruta);
		if (archivo.exists()) {

			try {
				FileReader fR = new FileReader(archivo);
				BufferedReader lector = new BufferedReader(fR);
				String data = lector.readLine();
				while (data != null) {
					String[] datos = data.split(",");
					Cliente cli = new Cliente(datos[0], datos[1], datos[2], datos[3], null);
					if (datos[4].equals("Activo")) {
						cli.getNombreCategoria().setEstado(CategoriaEnum.Activo);
					} else {
						cli.getNombreCategoria().setEstado(CategoriaEnum.Inactivo);
					}
					listaCliente.add(cli);
					data = lector.readLine();
				}
			} catch (FileNotFoundException e) {
				System.out.println("no se pudo encontrar el archivo");
			} catch (IOException e) {
				// TODO: handle exception
			}

		}

		return listaCliente;
	}

	@Override
	public void exportar(String fileName, List<Cliente> listaClientes) {
		int op = 0;
		do {
			System.out.println("¿Cómo desea exportar?");
			System.out.println("1.- Como .txt");
			System.out.println("2.- Como .csv");
			System.out.println("3.- Salir");
			System.out.println("Seleccione su número de opción:");
			op = sc.nextInt();
			switch (op) {
			case 1:
				et.exportar(fileName, listaClientes);
				break;
			case 2:
				ec.exportar(fileName, listaClientes);
				break;
			case 3:
				System.out.println("Saliendo");
				break;
			default:
				break;
			}
		} while (op != 3);

	}

}
