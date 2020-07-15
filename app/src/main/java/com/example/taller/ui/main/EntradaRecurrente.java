package com.example.taller.ui.main;

import java.sql.Date;

public class EntradaRecurrente extends Entrada {

    private  long id;
    private  long id_operacion;

    public  EntradaRecurrente(Date f, String con, String cat, int tip, double pre, int periodicidad
                             , long id_operacion, long id_cuenta){


        super(f,con,cat,tip,pre,periodicidad,id_cuenta);

        this.id_operacion=id_operacion;

    }






}
