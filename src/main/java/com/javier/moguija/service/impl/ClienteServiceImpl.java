package com.javier.moguija.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.javier.moguija.domain.Cliente;
import com.javier.moguija.repository.ClienteRepository;
import com.javier.moguija.service.ClienteService;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public Cliente guardar(Cliente cliente) {

        if (cliente.getNombre() == null || cliente.getNombre().equals("")) {
            throw new IllegalArgumentException("Complete el campo nombre");
        }

        if (cliente.getApellido() == null || cliente.getApellido().equals("")) {
            throw new IllegalArgumentException("Complete el campo apellido");
        }

        if (cliente.getDireccion() == null || cliente.getDireccion().equals("")) {
            throw new IllegalArgumentException("Complete el campo direccion");
        }

        if (cliente.getTelefono() == null || cliente.getTelefono().equals("")) {
            throw new IllegalArgumentException("Complete el campo telefono");
        }

        return clienteRepository.save(cliente);
    }

    @Override
    public List<Cliente> buscarTodos() {
        return clienteRepository.findAll();
    }
}
