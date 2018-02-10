/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javier.moguija.service.impl;

import com.javier.moguija.domain.Producto;
import com.javier.moguija.repository.ProductoRepository;
import com.javier.moguija.service.ProductoService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public Producto guardar(Producto producto) {
        if (producto.getMarca() == null || producto.getMarca().equals("")) {
            throw new IllegalArgumentException("Complete el campo marca");
        }
        if (producto.getModelo() == null || producto.getModelo().equals("")) {
            throw new IllegalArgumentException("Complete el campo modelo");
        }
        if (producto.getPrecioCosto() == null || producto.getPrecioCosto() <= 0) {
            throw new IllegalArgumentException("Complete el campo precio de costo");
        }

        if (producto.getPorcentajeIncrementoPrecioCosto() == null || producto.getPorcentajeIncrementoPrecioCosto() <= 0) {
            throw new IllegalArgumentException("El porcentaje de ganancia no puede ser cero, negativo o estar vacio");
        }
        
        return productoRepository.save(producto);
    }

    @Override
    public List<Producto> buscarTodos() {
        return productoRepository.findAll();
    }

}
