package com.example.taller.ui.main;

public class Tarjetas {
    private final String concepto, categoria, fecha, cantidad;
    public Tarjetas(String concepto,String categoria,String fecha,String cantidad){
        this.concepto=concepto;
        this.categoria=categoria;
        this.fecha=fecha;
        this.cantidad=cantidad;
    }
    public String getConcepto(){
        return concepto;
    }

    public String getCategoria(){
        return categoria;
    }
    public String getFecha(){
        return fecha;
    }
    public String getCantidad(){
        return cantidad;
    }
}
