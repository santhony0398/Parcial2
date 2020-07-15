package com.example.taller.ui.main;

public class Adjunto {

    private long id;
    private long entrada_id;
    private String nombre;
    private String nota;

    public Adjunto (long entrada_id,String nombre,String nota){

        this.entrada_id=entrada_id;
        this.nombre = nombre;
        this.nota = nota;

    }

}
