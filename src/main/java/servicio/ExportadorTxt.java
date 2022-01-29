package servicio;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;

import modelo.Cliente;

public class ExportadorTxt extends Exportador {
	private Scanner sc = new Scanner (System.in);

	@Override
	public void exportar(String fileName, Map<String, Cliente> listaClientes) {
		try {
			System.out.println("Ingrese su nombre de usuario de su equipo");
			String us = sc.next();

			String path = "C://Users/" + us + "/Desktop/";
			File directorio;
			File fichero;
			
			directorio = new File(path);
			fichero = new File(path + fileName +".txt");
			
				if (!directorio.exists()) {
					directorio.mkdirs();
						System.out.println("Directorio creado");
						try {
							fichero.createNewFile();
							FileWriter fileW = new FileWriter(fichero);
							BufferedWriter bW = new BufferedWriter(fileW);
							for (Entry<String, Cliente> cliente: listaClientes.entrySet()) {
								bW.write("Datos Cliente: ");
								bW.newLine();
								bW.write("Run Cliente: " + cliente.getValue().getRunCliente());
								bW.newLine();
								bW.write("Nombre Cliente: " + cliente.getValue().getNombreCliente());
								bW.newLine();
								bW.write("Apellido Cliente: " + cliente.getValue().getApellidoCliente());
								bW.newLine();
								bW.write("Años como Cliente: " + cliente.getValue().getAniosCliente());
								bW.newLine();
								bW.write("Categoría Cliente: " + String.valueOf(cliente.getValue().getNombreCategoria()));
								bW.newLine();
							}
							bW.close();
							
							System.out.println("Fichero creado");

							
						} catch (NullPointerException e) {
							System.out.println("no se aceptan nulos en la creación de archivos");
						}
					    catch (SecurityException e) {
							System.out.println("no tienes acceso para crear o modificar el fichero");
						}
					}
				else {
					System.out.println("Directorio ya esta creado");
					try {
						fichero.createNewFile();
						FileWriter fileW = new FileWriter(fichero);
						BufferedWriter bW = new BufferedWriter(fileW);
						for (Entry<String, Cliente> cliente: listaClientes.entrySet()) {
							bW.write("Datos Cliente: ");
							bW.newLine();
							bW.write("Run Cliente: " + cliente.getValue().getRunCliente());
							bW.newLine();
							bW.write("Nombre Cliente: " + cliente.getValue().getNombreCliente());
							bW.newLine();
							bW.write("Apellido Cliente: " + cliente.getValue().getApellidoCliente());
							bW.newLine();
							bW.write("Años como Cliente: " + cliente.getValue().getAniosCliente());
							bW.newLine();
							bW.write("Categoría Cliente: " + String.valueOf(cliente.getValue().getNombreCategoria()));
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
