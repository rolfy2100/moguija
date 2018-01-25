package com.javier.moguija.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javier.moguija.domain.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{	
	
}
