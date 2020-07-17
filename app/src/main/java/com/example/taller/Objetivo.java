package com.example.taller;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;


public class Objetivo extends Fragment {

    private TextView tv1;
    public static Objetivo  newInstance() {
        return new Objetivo ();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_objetivos, container, false);

        tv1 = v.findViewById(R.id.tv10);


        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(getActivity(),"Cuentas",null,1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        //       BaseDeDatos.execSQL("DELETE FROM  entradas;");

        ArrayList<String> cantidad = new ArrayList<>();
        ArrayList<String> tipo = new ArrayList<>();
        ArrayList<String> favorito = new ArrayList<>();
        ArrayList<String> categoria  = new ArrayList<>();
        ArrayList<String> concepto = new ArrayList<>();
        ArrayList<String> fecha = new ArrayList<>();

        Cursor cursor = BaseDeDatos.rawQuery("SELECT * FROM entrada",null);

        if(cursor != null && cursor.moveToFirst()){



            do{

                //asignar los valores de la base de datos al arrayList
                cantidad.add(cursor.getString(1));
                tipo.add(cursor.getString(2));
                favorito.add(cursor.getString(3));
                categoria.add(cursor.getString(4));
                concepto.add(cursor.getString(5));
                fecha.add(cursor.getString(6));


            }while( cursor.moveToNext() );


            tv1.setText(fecha.get(0)+" "+tipo.get(0)+" "+favorito.get(0)+" "+categoria.get(0)+" "+categoria.get(0)+" "+concepto.get(0));

        }
        else{
            Toast.makeText(getActivity(),"No hay campos",Toast.LENGTH_SHORT).show();
        }

        return  v;

    }


}
