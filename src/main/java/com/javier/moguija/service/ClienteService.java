package com.javier.moguija.service;

import java.util.List;

import com.javier.moguija.domain.Cliente;

public interface ClienteService {

	Cliente guardar(Cliente cliente);

	List<Cliente> buscarTodos();
}
