
package com.javier.moguija.service.impl;

import com.javier.moguija.domain.Venta;
import com.javier.moguija.repository.VentaRepository;
import com.javier.moguija.service.VentaService;
import java.time.LocalDate;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VentaServiceImpl implements VentaService {
    
    @Autowired
    private VentaRepository ventaRepository;
    
    @Override
    public Venta guardar(Venta venta) {

        if (venta.getProducto() == null) {
            throw new IllegalArgumentException("Complete el campo producto");
        }

        if (venta.getCantidadCuotas() <= 0 || venta.getCantidadCuotas() > 20) {
            throw new IllegalArgumentException("El campo cantidad de cuotas no puede ser negativo, cero o mayor a 20");
        }

        if (venta.getCliente() == null) {
            throw new IllegalArgumentException("Complete el campo cliente");
        }

        if (venta.getImei() == null || venta.getImei().equals("")) {
            throw new IllegalArgumentException("Complete el campo numero de imei");
        }

        if (venta.getPrecio() <= 0) {
            throw new IllegalArgumentException("El precio no puede estar vacio o ser menor negativo");
        }
        if (venta.getPlazoPagos() == null) {
            throw new IllegalArgumentException("Complete el campo plazo de pago");
        }
        venta.setCantidadCuotasRestantes(venta.getCantidadCuotas());

        venta.setFecha(LocalDate.now());

        return ventaRepository.save(venta);
    }

    @Override
    public List<Venta> buscarPorFechaDeProximaDeuda() {

        return null;
    }

}
