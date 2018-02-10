package com.javier.moguija.controller;

import com.javier.moguija.domain.Venta;
import com.javier.moguija.service.ClienteService;
import com.javier.moguija.service.ProductoService;
import com.javier.moguija.service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class VentaController {

    @Autowired
    private VentaService ventaService;
    @Autowired
    private ProductoService productoService;
    @Autowired
    private ClienteService clienteService;

    @GetMapping("/venta/alta")
    public String verVenta(Model model) {
        model.addAttribute("clientes", clienteService.buscarTodos());
        model.addAttribute("productos", productoService.buscarTodos());
        return "guardarVenta";
    }

    @PostMapping("/venta")
    public String guardar(Venta venta) {
        ventaService.guardar(venta);
        return "redirect:/venta/alta";
    }
}
