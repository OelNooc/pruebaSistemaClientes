package servicio;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

import modelo.Cliente;

public class ExportadorCsv extends Exportador {
	private Scanner sc = new Scanner(System.in);

	/**
	 * Exporta una lista (mapa) en formato .csv
	 *
	 * @param fileName:      es el nombre del archivo
	 * @param listaClientes: la lista a exportar
	 */
	@Override
	public void exportar(String fileName, Map<String, Cliente> listaClientes) {
		try {
			System.out.println("Ingrese su nombre de usuario de su equipo");
			String us = sc.next();

			String path = "C://Users/" + us + "/Desktop/";
			File directorio;
			File fichero;

			directorio = new File(path);
			fichero = new File(path + fileName + ".csv");

			if (!directorio.exists()) {
				directorio.mkdirs();
				System.out.println("Directorio creado");
				try {
					fichero.createNewFile();
					FileWriter fileW = new FileWriter(fichero);
					BufferedWriter bW = new BufferedWriter(fileW);
					for (Entry<String, Cliente> cliente : listaClientes.entrySet()) {
						String cli = String.format("%s, %s, %s, %s, %s", cliente.getValue().getRunCliente(),
								cliente.getValue().getNombreCliente(), cliente.getValue().getApellidoCliente(),
								cliente.getValue().getAniosCliente(),
								String.valueOf(cliente.getValue().getNombreCategoria()));
						bW.write(cli);
						bW.newLine();
					}
					bW.close();

					System.out.println("Fichero creado");

				} catch (NullPointerException e) {
					System.out.println("no se aceptan nulos en la creación de archivos");
				} catch (SecurityException e) {
					System.out.println("no tienes acceso para crear o modificar el fichero");
				}
			} else {
				System.out.println("Directorio ya esta creado");
				try {
					fichero.createNewFile();
					FileWriter fileW = new FileWriter(fichero);
					BufferedWriter bW = new BufferedWriter(fileW);
					for (Entry<String, Cliente> cliente : listaClientes.entrySet()) {
						String cli = String.format("%s, %s, %s, %s, %s", cliente.getValue().getRunCliente(),
								cliente.getValue().getNombreCliente(), cliente.getValue().getApellidoCliente(),
								cliente.getValue().getAniosCliente(),
								String.valueOf(cliente.getValue().getNombreCategoria()));
						bW.write(cli);
						bW.newLine();
					}
					bW.close();

					System.out.println("Fichero creado");

				} catch (SecurityException e) {
					System.out.println("no tienes acceso para crear o modificar el fichero");
				}

			}
		} catch (IOException e) {
			System.out.println("no se pudo crear el fichero");
		}

	}

}
