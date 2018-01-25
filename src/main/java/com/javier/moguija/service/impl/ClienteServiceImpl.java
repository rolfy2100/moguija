package com.javier.moguija.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.javier.moguija.domain.Cliente;
import com.javier.moguija.repository.ClienteRepository;
import com.javier.moguija.service.ClienteService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteService {

	private ClienteRepository clienteRepository;

	@Override
	public Cliente guardar(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	@Override
	public List<Cliente> buscarTodos() {
		return clienteRepository.findAll();
	}
}
