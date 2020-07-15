package com.example.taller.ui.main;

import java.sql.Date;

public class Entrada {

    private Date fecha;
    private String concepto;
    private String categoria;
    private int tipo;
    private double precio;
    private long id_cuenta;
    private int periodicidad;

    public  Entrada (Date fecha,String concepto,String categoria,int tipo,
                     double precio, int periodicidad,long id_cuenta){

        this.fecha = fecha;
        this.concepto = concepto;
        this.categoria = categoria;
        this.tipo = tipo;
        this.precio = precio;
        this.periodicidad = periodicidad;
        this.id_cuenta = id_cuenta;
    }

}
