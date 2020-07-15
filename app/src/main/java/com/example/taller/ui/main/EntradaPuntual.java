package com.example.taller.ui.main;

import java.sql.Date;

public class EntradaPuntual extends Entrada {

        private long id;
        private boolean automatico;
        private long id_adjunto;
        private int anyo;
        private int mes;

        public EntradaPuntual(Date f, String con, String cat, int tip, double pre, boolean automatico,
                             int periodicidad,long id_cuenta,long id_adjunto ){

            super(f,con,cat,tip,pre,periodicidad,id_cuenta);

            this.id_adjunto=id_adjunto;
            this.automatico=automatico;

        }

    }

