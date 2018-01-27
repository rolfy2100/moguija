/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javier.moguija.service.impl;

import com.javier.moguija.domain.Producto;
import com.javier.moguija.repository.ProductoRepository;
import com.javier.moguija.service.ProductoService;
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

        try {
            if (producto.getPrecioCosto() == 0) {
                throw new IllegalArgumentException("Complete el campo precio costo");
            }
        } catch (NullPointerException precioCostoNulo) {
            throw new IllegalArgumentException("Complete el campo precio costo", precioCostoNulo);
        }
        try {
            if (producto.getPrecioVenta() == 0) {
                throw new IllegalArgumentException("Complete el campo precio venta");
            }
        } catch (NullPointerException precioCostoNulo) {
            throw new IllegalArgumentException("Complete el campo precio venta", precioCostoNulo);
        }

        return productoRepository.save(producto);
    }

}
