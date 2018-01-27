package com.javier.moguija.controller;

import com.javier.moguija.domain.Cliente;
import com.javier.moguija.service.ClienteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/")
    public String home() {

        return "index";
    }

    @PostMapping("/cliente")
    public String guardarCliente(Cliente cliente) {
        clienteService.guardar(cliente);
        return "redirect:/";
    }

    @GetMapping("/cliente")
    public String verClientes(Model model) {

        List<Cliente> clientes = clienteService.buscarTodos();
        model.addAttribute("clientes", clientes);
        return "clientes";
    }
    
}
