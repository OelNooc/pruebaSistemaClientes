package servicio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import modelo.CategoriaEnum;
import modelo.Cliente;
import utilidades.Utilidad;

public class ArchivoServicio extends Exportador {
	private Scanner sc = new Scanner(System.in);
	private ExportadorTxt et = new ExportadorTxt();
	private ExportadorCsv ec = new ExportadorCsv();
	private Utilidad ut = new Utilidad();

	public ArchivoServicio(ExportadorTxt et, ExportadorCsv ec) {

		this.et = et;
		this.ec = ec;
	}

	public Map<String, Cliente> cargarDatos(String fileName) {

		File archivo;
		Map<String, Cliente> listaCliente = new HashMap<String, Cliente>();
		
		System.out.println("Ingrese su nombre de usuario de su equipo");
		String us = sc.next();

		String path = "C://Users/" + us + "/Desktop/" + fileName;

		archivo = new File(path);
		if (archivo.exists()) {

			try {
				FileReader fR = new FileReader(archivo);
				BufferedReader lector = new BufferedReader(fR);
				String data = lector.readLine();
				while (data != null) {
					String[] datos = data.split(",");
					Cliente cli = new Cliente();
//					if (datos[4].equals("Activo")) {
//						cli.getNombreCategoria().setEstado(CategoriaEnum.Activo);
//					} else {
//						cli.getNombreCategoria().setEstado(CategoriaEnum.Inactivo);
//					}
					cli.setRunCliente(datos[0]);
					cli.setNombreCliente(datos[1]);
					cli.setApellidoCliente(datos[2]);
					cli.setAniosCliente(datos[3]);
					cli.setNombreCategoria(CategoriaEnum.Activo);
					listaCliente.put(datos[0], cli);
					data = lector.readLine();
				}
			} catch (NullPointerException e) {
				System.out.println("No se aceptan nulos");
			} catch (IOException e) {
				// TODO: handle exception
			}
			System.out.println("Datos cargados correctamente");

		}else {
			System.out.println("El archivo no existe");
		}

		return listaCliente;
	}

	@Override
	public void exportar(String fileName, Map<String, Cliente> listaClientes) {
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
				ut.limpiar();
				ut.mensajeMenu();
				
				break;
			default:
				break;
			}
		} while (op != 3);

	}

}
