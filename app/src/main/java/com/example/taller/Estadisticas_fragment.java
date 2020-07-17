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


public class Estadisticas_fragment extends Fragment {

    private TextView tv1;
    private Spinner spinnerMes;
    private Spinner spinnerAnyo;
    private Spinner spinnerMostrarPor;

    public static Estadisticas_fragment newInstance() {
        return new Estadisticas_fragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_estadisticas, container, false);
        spinnerMes=v.findViewById(R.id.spinnerMes);
        spinnerAnyo=v.findViewById(R.id.spinnerAnyo);
        spinnerMostrarPor=v.findViewById(R.id.spinnerMostrarPor);
        String[] meses={"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"};
        String[] anyos={"2018","2019","2020"};
        String[] mostrarPor={"Fav1","Fav2","Fav3"};
        ArrayAdapter<String> adapterMes = new ArrayAdapter<>(getActivity().getApplicationContext(), android.R.layout.simple_list_item_1, meses);
        spinnerMes.setAdapter(adapterMes);
        ArrayAdapter <String> adapterAnyo = new ArrayAdapter<>(getActivity().getApplicationContext(), android.R.layout.simple_list_item_1, anyos);
        spinnerAnyo.setAdapter(adapterAnyo);
        ArrayAdapter <String> adapterMPor = new ArrayAdapter<>(getActivity().getApplicationContext(), android.R.layout.simple_list_item_1, mostrarPor);
        spinnerMostrarPor.setAdapter(adapterMPor);

        RecyclerView recyclerTarjetas = (RecyclerView) v.findViewById(R.id.lista_entradas);

        //abrir base de datos
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(getActivity(),"Cuentas",null,1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        //       BaseDeDatos.execSQL("DELETE FROM  entradas;");

        //Arreglos donde estan guardado cada valir de la base de datos
        ArrayList<String> cantidad = new ArrayList<>();
        ArrayList<String> tipo = new ArrayList<>();
        ArrayList<String> favorito = new ArrayList<>();
        ArrayList<String> categoria  = new ArrayList<>();
        ArrayList<String> concepto = new ArrayList<>();
        ArrayList<String> fecha = new ArrayList<>();

        //consulta con todas las filas
        Cursor cursor = BaseDeDatos.rawQuery("SELECT * FROM entrada",null);

        if(cursor != null && cursor.moveToFirst()){
            while( cursor.moveToNext() ){
                //asignar los valores de la base de datos al arrayList
                cantidad.add(cursor.getString(1));
                tipo.add(cursor.getString(2));
                favorito.add(cursor.getString(3));
                categoria.add(cursor.getString(4));
                concepto.add(cursor.getString(5));
                fecha.add(cursor.getString(6));
            }
            //Traer los datos de la base de datos 
            tv1.setText(fecha.get(1)+" "+tipo.get(1)+" "+favorito.get(1)+" "+categoria.get(1)+" "+categoria.get(1)+" "+concepto.get(1));
            Tarjetas(concepto.get(1),categoria.get(1),fecha.get(1),tipo.get(1),favorito.get(1),cantidad.get(1));
        }
        else{
            Toast.makeText(getActivity(),"No hay campos",Toast.LENGTH_SHORT).show();
        }

        return  v;

    }

}
