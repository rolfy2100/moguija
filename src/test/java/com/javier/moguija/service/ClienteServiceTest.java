package com.javier.moguija.service;

import com.javier.moguija.MoguijaApplicationTests;
import com.javier.moguija.domain.Cliente;
import com.javier.moguija.repository.ClienteRepository;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ClienteServiceTest extends MoguijaApplicationTests {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ClienteRepository clienteRepository;

    @Test
    public void guardar_conDatosCorrectos_guardaCliente() {
        Cliente clienteEsperado = new Cliente();
        clienteEsperado.setNombre("Gabriel");
        clienteEsperado.setApellido("Montenegro");
        clienteEsperado.setDireccion("urdinenea 4608");
        clienteEsperado.setTelefono("1133244740");
        clienteEsperado.setTelefonoAlternativo("4698-9815");

        clienteService.guardar(clienteEsperado);

        Cliente clientePersistido = clienteRepository.findOne(2L);

        assertEquals(clienteEsperado.getNombre(), clientePersistido.getNombre());
        assertEquals(clienteEsperado.getApellido(), clientePersistido.getApellido());
        assertEquals(clienteEsperado.getDireccion(), clientePersistido.getDireccion());
        assertEquals(clienteEsperado.getTelefono(), clientePersistido.getTelefono());
        assertEquals(clienteEsperado.getTelefonoAlternativo(), clientePersistido.getTelefonoAlternativo());
    }

    @Test(expected = IllegalArgumentException.class)
    public void guardar_conNombreNulo_lanzaExcepcion() {
        Cliente clienteEsperado = new Cliente();
        clienteEsperado.setNombre(null);
        clienteEsperado.setApellido("Montenegro");
        clienteEsperado.setDireccion("urdinenea 4608");
        clienteEsperado.setTelefono("1133244740");
        clienteEsperado.setTelefonoAlternativo("4698-9815");

        clienteService.guardar(clienteEsperado);
    }

    @Test(expected = IllegalArgumentException.class)
    public void guardar_conNombreVacio_lanzaException() {
        Cliente clienteEsperado = new Cliente();
        clienteEsperado.setNombre("");
        clienteEsperado.setApellido("Montenegro");
        clienteEsperado.setDireccion("urdinenea 4608");
        clienteEsperado.setTelefono("1133244740");
        clienteEsperado.setTelefonoAlternativo("4698-9815");

        clienteService.guardar(clienteEsperado);
    }

    @Test(expected = IllegalArgumentException.class)
    public void guardar_conApellidoNull_lanzaException() {
        Cliente clienteEsperado = new Cliente();
        clienteEsperado.setNombre("Gabriel");
        clienteEsperado.setApellido(null);
        clienteEsperado.setDireccion("urdinenea 4608");
        clienteEsperado.setTelefono("1133244740");
        clienteEsperado.setTelefonoAlternativo("4698-9815");

        clienteService.guardar(clienteEsperado);

    }

    @Test(expected = IllegalArgumentException.class)
    public void guardar_conApellidoVacio_lanzaException() {
        Cliente clienteEsperado = new Cliente();
        clienteEsperado.setNombre("Gabriel");
        clienteEsperado.setApellido("");
        clienteEsperado.setDireccion("urdinenea 4608");
        clienteEsperado.setTelefono("1133244740");
        clienteEsperado.setTelefonoAlternativo("4698-9815");

        clienteService.guardar(clienteEsperado);

    }

    @Test(expected = IllegalArgumentException.class)
    public void guardar_conDireccionNull_lanzaException() {
        Cliente clienteEsperado = new Cliente();
        clienteEsperado.setNombre("Gabriel");
        clienteEsperado.setApellido("Montenegro");
        clienteEsperado.setDireccion(null);
        clienteEsperado.setTelefono("1133244740");
        clienteEsperado.setTelefonoAlternativo("4698-9815");

        clienteService.guardar(clienteEsperado);

    }

    @Test(expected = IllegalArgumentException.class)
    public void guardar_conDireccionVacio_lanzaException() {
        Cliente clienteEsperado = new Cliente();
        clienteEsperado.setNombre("Gabriel");
        clienteEsperado.setApellido("Montenegro");
        clienteEsperado.setDireccion("");
        clienteEsperado.setTelefono("1133244740");
        clienteEsperado.setTelefonoAlternativo("4698-9815");

        clienteService.guardar(clienteEsperado);

    }

    @Test(expected = IllegalArgumentException.class)
    public void guardar_conTelefonoNull_lanzaException() {
        Cliente clienteEsperado = new Cliente();
        clienteEsperado.setNombre("Gabriel");
        clienteEsperado.setApellido("Montenegro");
        clienteEsperado.setDireccion("Urdininea 4680");
        clienteEsperado.setTelefono(null);
        clienteEsperado.setTelefonoAlternativo("4698-9815");

        clienteService.guardar(clienteEsperado);

    }

    @Test(expected = IllegalArgumentException.class)
    public void guardar_conTelefonoVacio_lanzaException() {
        Cliente clienteEsperado = new Cliente();
        clienteEsperado.setNombre("Gabriel");
        clienteEsperado.setApellido("Montenegro");
        clienteEsperado.setDireccion("Urdininea 4680");
        clienteEsperado.setTelefono("");
        clienteEsperado.setTelefonoAlternativo("4698-9815");

        clienteService.guardar(clienteEsperado);
    }

    @Test
    public void guardar_conTelefonoAlternativoNulo_guardarTelefonoAlternativo() {
        Cliente clienteEsperado = new Cliente();
        clienteEsperado.setNombre("Gabriel");
        clienteEsperado.setApellido("Montenegro");
        clienteEsperado.setDireccion("Urdininea 4680");
        clienteEsperado.setTelefono("1533244740");
        clienteEsperado.setTelefonoAlternativo(null);

        clienteService.guardar(clienteEsperado);
        Cliente clientePersistido = clienteRepository.findOne(1L);

        assertEquals(clienteEsperado.getNombre(), clientePersistido.getNombre());
        assertEquals(clienteEsperado.getTelefonoAlternativo(), clientePersistido.getTelefonoAlternativo());
    }

    @Test
    public void guardar_conTelefonoAlternativoVacio_guardarTelefonoAlternativo() {
        Cliente clienteEsperado = new Cliente();
        clienteEsperado.setNombre("Gabriel");
        clienteEsperado.setApellido("Montenegro");
        clienteEsperado.setDireccion("Urdininea 4680");
        clienteEsperado.setTelefono("1533244740");
        clienteEsperado.setTelefonoAlternativo("");

        clienteService.guardar(clienteEsperado);
        Cliente clientePersistido = clienteRepository.findOne(0L);

        assertEquals(clienteEsperado.getNombre(), clientePersistido.getNombre());
        assertEquals(clienteEsperado.getTelefonoAlternativo(), clientePersistido.getTelefonoAlternativo());
    }
}
