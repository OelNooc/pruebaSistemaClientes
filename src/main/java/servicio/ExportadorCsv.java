package servicio;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import modelo.Cliente;

public class ExportadorCsv extends Exportador {

	@Override
	public void exportar(String fileName, List<Cliente> listaClientes) {
		try {
			System.out.println("Ingrese su sistema operativo (windows, mac, o linux: ");
			@SuppressWarnings("resource")
			Scanner sc = new Scanner (System.in);
			String so = sc.next();
			File directorio;
			File fichero;
			if (so.equals("windows")) {
				directorio = new File("C://usuario/equipo/Desktop");
				fichero = new File("C://usuario/equipo/Desktop/clientes.csv");
			} else {
				directorio = new File("home/usuario/Desktop");
				fichero = new File("home/usuario/Desktop/clientes.csv");
			}		
			
				if (!directorio.exists()) {
					directorio.mkdirs();
						System.out.println("Directorio creado");
						try {
							fichero.createNewFile();
							FileWriter fileW = new FileWriter(fichero);
							BufferedWriter bW = new BufferedWriter(fileW);
							for (Cliente cliente: listaClientes) {
								String cli = String.format("%s, %s, %s, %s años, %s", cliente.getRunCliente(),
										cliente.getNombreCliente(), cliente.getApellidoCliente(), cliente.getAniosCliente(),
										String.valueOf(cliente.getNombreCategoria()));
								bW.write(cli);
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
						for (Cliente cliente: listaClientes) {
							String cli = String.format("%s, %s, %s, %s años, %s", cliente.getRunCliente(),
									cliente.getNombreCliente(), cliente.getApellidoCliente(), cliente.getAniosCliente(),
									String.valueOf(cliente.getNombreCategoria()));
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

