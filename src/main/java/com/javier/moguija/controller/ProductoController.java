/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javier.moguija.controller;

import com.javier.moguija.domain.Producto;
import com.javier.moguija.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @PostMapping("/producto")
    public String guardarProducto(Producto producto) {
        productoService.guardar(producto);

        return "guardar_producto";
    }

    @GetMapping("/producto/alta")
    public String ver() {
        return "guardar_producto";
    }

    @GetMapping("/producto")
    public String buscarTodos(Model model) {
        model.addAttribute("productos", productoService.buscarTodos());

        return "productos";
    }

}
