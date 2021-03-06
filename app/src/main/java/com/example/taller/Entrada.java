package com.example.taller;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;


public class Entrada extends Fragment {


    private TextView tv1;
    private Button btn3;


    public static Entrada newInstance() {
        return new Entrada();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View v = inflater.inflate(R.layout.fragment_entrada, container, false);
        btn3 = v.findViewById(R.id.button1);


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



            while( cursor.moveToNext() ){

                cantidad.add(cursor.getString(1));
                tipo.add(cursor.getString(2));
                favorito.add(cursor.getString(3));
                categoria.add(cursor.getString(4));
                concepto.add(cursor.getString(5));
                fecha.add(cursor.getString(6));


            }

            tv1.setText(fecha.get(1)+" "+tipo.get(1)+" "+favorito.get(1)+" "+categoria.get(1)+" "+categoria.get(1)+" "+concepto.get(1));
        }
        else{
            Toast.makeText(getActivity(),"No hay campos",Toast.LENGTH_SHORT).show();
        }


        return  v;
        
    }





}

   