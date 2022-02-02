package tests;

import java.util.logging.Logger;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import modelo.CategoriaEnum;
import servicio.ClienteServicio;

@DisplayName("Test de agregar clientes")
public class ClienteServicioTest {
	private static ClienteServicio cliServ;
	private static Logger logger;
	
	@BeforeAll
	public static void setup() {
		cliServ = mock(ClienteServicio.class);
		logger = Logger.getLogger("cl.nooc.Sistema_De_Clientes.servicio.ClienteServicio");
		logger.info("Before all");
	}
	
	@BeforeEach
	public void init()
	{
		//Se ejecuta antes de CADA prueba
		logger.info("Before Each");
	}
	
	@AfterEach
	public void tearDown()
	{
		//Se ejecuta después de CADA prueba
		logger.info("After Each");
	}
	
	@AfterAll
	public static void done()
	{
		//se ejecuta después de TODAS las pruebas
		logger.info("After All");
	}	

	/**
	 * Verifica el funcionamiento de agregar cliente
	 */
	@Test
	public void agregarClienteTest() {
		
		cliServ.agregarCliente("11.111.111-1", "Pepito", "PagaDoble", "3 anios", CategoriaEnum.Activo);
		verify(cliServ).agregarCliente("11.111.111-1", "Pepito", "PagaDoble", "3 anios", CategoriaEnum.Activo);
		
	}
	
	/**
	 * Verifica el funcionamiento en caso de recibir nulos
	 */
	@Test
	public void agregarClienteNullTest() {
		cliServ.agregarCliente(null, null, null, null, null);
		verify(cliServ).agregarCliente(null, null, null, null, null);
	}
}
