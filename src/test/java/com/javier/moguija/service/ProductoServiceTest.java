package com.javier.moguija.service;

import com.javier.moguija.MoguijaApplicationTests;
import com.javier.moguija.domain.Producto;
import com.javier.moguija.repository.ProductoRepository;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ProductoServiceTest extends MoguijaApplicationTests {

    @Autowired
    private ProductoService productoService;

    @Autowired
    private ProductoRepository productoRepository;

    @Test
    public void guardar_conDatosCorrectos_guardarProducto() {
        Producto productoEsperado = new Producto();
        productoEsperado.setMarca("Samsung");
        productoEsperado.setModelo("j7");
        productoEsperado.setPrecioCosto(3500.00);
        productoEsperado.setPorcentajeIncrementoPrecioCosto(20.00);

        productoService.guardar(productoEsperado);
        Producto productoPersistido = productoRepository.findOne(0L);

        assertEquals(productoEsperado.getMarca(), productoPersistido.getMarca());
        assertEquals(productoEsperado.getModelo(), productoPersistido.getModelo());
        assertEquals(productoEsperado.getPrecioCosto(), productoPersistido.getPrecioCosto());
        assertEquals(productoEsperado.getPorcentajeIncrementoPrecioCosto(), productoPersistido.getPorcentajeIncrementoPrecioCosto());
    }

    @Test(expected = IllegalArgumentException.class)
    public void guardar_conMarcaNulo_lanzaException() {
        Producto productoEsperado = new Producto();
        productoEsperado.setMarca(null);
        productoEsperado.setModelo("j7");
        productoEsperado.setPrecioCosto(3500.00);
        productoEsperado.setPorcentajeIncrementoPrecioCosto(20.00);

        productoService.guardar(productoEsperado);
    }

    @Test(expected = IllegalArgumentException.class)
    public void guardar_conMarcaVacio_lanzaException() {
        Producto productoEsperado = new Producto();
        productoEsperado.setMarca("");
        productoEsperado.setModelo("j7");
        productoEsperado.setPrecioCosto(3500.00);
        productoEsperado.setPorcentajeIncrementoPrecioCosto(20.00);

        productoService.guardar(productoEsperado);
    }

    @Test(expected = IllegalArgumentException.class)
    public void guardar_conModeloNulo_lanzaException() {
        Producto productoEsperado = new Producto();
        productoEsperado.setMarca("Samsung");
        productoEsperado.setModelo(null);
        productoEsperado.setPrecioCosto(3500.00);
        productoEsperado.setPorcentajeIncrementoPrecioCosto(20.00);

        productoService.guardar(productoEsperado);
    }

    @Test(expected = IllegalArgumentException.class)
    public void guardar_conModeloVaacio_lanzaException() {
        Producto productoEsperado = new Producto();
        productoEsperado.setMarca("Samsung");
        productoEsperado.setModelo("");
        productoEsperado.setPrecioCosto(3500.00);
        productoEsperado.setPorcentajeIncrementoPrecioCosto(20.00);

        productoService.guardar(productoEsperado);
    }

    @Test(expected = IllegalArgumentException.class)
    public void guardar_conPrecioCostoNulo_lanzaException() {
        Producto productoEsperado = new Producto();
        productoEsperado.setMarca("Samsung");
        productoEsperado.setModelo("J7");
        productoEsperado.setPrecioCosto(null);
        productoEsperado.setPorcentajeIncrementoPrecioCosto(20.00);

        productoService.guardar(productoEsperado);
    }

    @Test(expected = IllegalArgumentException.class)
    public void guardar_conPrecioCostoIgualCero_lanzaException() {
        Producto productoEsperado = new Producto();
        productoEsperado.setMarca("Samsung");
        productoEsperado.setModelo("J7");
        productoEsperado.setPrecioCosto(0.0);
        productoEsperado.setPorcentajeIncrementoPrecioCosto(20.00);

        productoService.guardar(productoEsperado);
    }

    @Test(expected = IllegalArgumentException.class)
    public void guardar_conPrecioCostoConValorNegativo_lanzaException() {
        Producto productoEsperado = new Producto();
        productoEsperado.setMarca("Samsung");
        productoEsperado.setModelo("J7");
        productoEsperado.setPrecioCosto(-1.0);
        productoEsperado.setPorcentajeIncrementoPrecioCosto(20.00);

        productoService.guardar(productoEsperado);
    }

    @Test(expected = IllegalArgumentException.class)
    public void guardar_conPorcentajeIncrementoPrecioCostoIgualACero_lanzaExcepcion() {
        Producto productoEsperado = new Producto();
        productoEsperado.setMarca("Samsung");
        productoEsperado.setModelo("J7");
        productoEsperado.setPrecioCosto(4700.00);
        productoEsperado.setPorcentajeIncrementoPrecioCosto(0.0);

        productoService.guardar(productoEsperado);
    }

    @Test(expected = IllegalArgumentException.class)
    public void guardar_conPorcentajeIncrementoPrecioCostoConValorNegativo_lanzaException() {
        Producto productoEsperado = new Producto();
        productoEsperado.setMarca("Samsung");
        productoEsperado.setModelo("J7");
        productoEsperado.setPrecioCosto(4700.00);
        productoEsperado.setPorcentajeIncrementoPrecioCosto(-1.0);

        productoService.guardar(productoEsperado);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void guardar_conPorsentajeIncrementoPrecioCostoValorNull_lanzaExeption(){
        Producto productoEsperado = new Producto();
        productoEsperado.setMarca("Nokia");
        productoEsperado.setModelo("Lumia");
        productoEsperado.setPrecioCosto(2000.00);
        productoEsperado.setPorcentajeIncrementoPrecioCosto(null);
        
        productoService.guardar(productoEsperado);
    }
}
