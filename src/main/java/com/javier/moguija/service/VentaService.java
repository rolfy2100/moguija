/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javier.moguija.service;

import com.javier.moguija.domain.Venta;
import java.util.List;


public interface VentaService {
    
    Venta guardar(Venta venta);
    
    List<Venta> buscarPorFechaDeProximaDeuda();
}
