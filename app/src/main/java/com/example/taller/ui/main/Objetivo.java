package com.example.taller.ui.main;

import java.sql.Date;

public class Objetivo {
    private Date fechaInicio;
    private Date fechaFin;
    private String tipo;
    private String nomDeCatOCon;
    private double cantidadLimite;
    private boolean terminadoPorFecha;
    private boolean terminadoPorGasto;
    private long id;
    private long id_cuenta;

    public Objetivo (Date fI,Date fF,String tip,String nomDeCatOCon,Double cantLim,long id_cuenta){
        this.fechaInicio = fI;
        this.fechaFin = fF;
        this.tipo=tip;
        this.nomDeCatOCon=nomDeCatOCon;
        this.cantidadLimite=cantLim;
        this.id_cuenta=id_cuenta;
        this.terminadoPorFecha=false;
        this.terminadoPorGasto=false;

    }

}
