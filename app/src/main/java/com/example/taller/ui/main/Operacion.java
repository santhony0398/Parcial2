package com.example.taller.ui.main;

import java.sql.Date;

public class Operacion {

    private long id;
    private Date fechaInicio;
    private Date fechaFin;
    private String concepto;
    private String categoria;
    private int tipo;
    private double cantidad;
    private boolean activa;
    private int periodicidad;
    private String titulo;
    private long id_cuenta;
    private int identificador_antiguo;

    public Operacion (Date fechaInicio,Date fechaFin,String concepto,
                      String categoria,int tipo,double cantidad,boolean activa,
                      int periodicidad,String titulo){

        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.concepto=concepto;
        this.categoria = categoria;
        this.tipo=tipo;
        this.cantidad = cantidad;
        this.activa=activa;
        this.periodicidad = periodicidad;
        this.titulo = titulo;


    }


}
