package com.javier.moguija.domain;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Producto producto;
    @ManyToOne
    private Cliente cliente;
    private LocalDate fecha;
    private double precio;
    private int cantidadCuotas;
    private int plazoPagos;
    private String imei;
}
