package com.javier.moguija.service;

import com.javier.moguija.domain.Producto;
import java.util.List;

public interface ProductoService {

    Producto guardar(Producto producto);

    List<Producto> buscarTodos();
}
