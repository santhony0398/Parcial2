package com.example.taller;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class Inicio extends Fragment {

    private InicioViewModel mViewModel;
    private View view;

    //declaracion spiner
    private Spinner spinner1;
    private Spinner spinner2;
    private Spinner spinner3;

    //declaracion de campos
    private EditText edt_cantidad;
    private EditText edt_concepto;
    private EditText edt_fecha;

    //declaracion del boton
    private Button button;
    private Button button1;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                              Bundle savedInstanceState) {


        View v = inflater.inflate(R.layout.inicio_fragment, container, false);
        //asignacion de spinners
        spinner1 = v.findViewById(R.id.spinner1);
        spinner2 = v.findViewById(R.id.spinner2);
        spinner3 = v.findViewById(R.id.spinner3);

        //declaracion de botones
        button = v.findViewById(R.id.button);
        button1 = v.findViewById(R.id.button1);

        //declaracion de campos
        edt_cantidad= v.findViewById(R.id.txt_cantidad);
        edt_concepto = v.findViewById(R.id.edt2);
        edt_fecha = v.findViewById(R.id.edt4);

        //datos para los spinners
        String [] tipo = {"Gasto","Ingreso"};
        String [] categoria = {"Cenas","Copas","Bar","Restaurante"};
        String [] favoritoss = {"Favorito 1","Favorito 2","Favorito 3"};

        //llenar los spinners
        ArrayAdapter <String> adapter = new ArrayAdapter<String>(getActivity().getApplicationContext(),android.R.layout.simple_list_item_1,tipo);
        spinner1.setAdapter(adapter);

        ArrayAdapter <String> adapter2 = new ArrayAdapter<String>(getActivity().getApplicationContext(),android.R.layout.simple_list_item_1,categoria);
        spinner2.setAdapter(adapter2);

        ArrayAdapter <String> adapter3 = new ArrayAdapter<String>(getActivity().getApplicationContext(),android.R.layout.simple_list_item_1,favoritoss);
        spinner3.setAdapter(adapter3);

        //boton de guardar
        button.setOnClickListener(new View.OnClickListener(){
           @Override
           public void onClick(View v) {

                        int cantidad = Integer.parseInt(edt_cantidad.getText().toString());
                        String Concepto = edt_concepto.getText().toString();
                        String fecha = edt_fecha.getText().toString();

                        String tipo = spinner1.getSelectedItem().toString();
                        String Categoria = spinner2.getSelectedItem().toString();
                        String favoritos = spinner3.getSelectedItem().toString();

                        Toast.makeText(getActivity(),tipo,Toast.LENGTH_SHORT).show();

                       AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(getActivity(),"Cuentas",null,1);
                       SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

                        if (!tipo.isEmpty() && !Categoria.isEmpty() &&  !favoritos.isEmpty()  && !fecha.isEmpty() && !fecha.isEmpty()  && !edt_cantidad.getText().toString().isEmpty()  ){

                            ContentValues registro = new ContentValues();
                            registro.put("cantidad",cantidad);
                            registro.put("tipo",tipo);
                            registro.put("favorito",favoritos);
                            registro.put("categoria",Categoria);
                            registro.put("concepto",Concepto);
                            registro.put("fecha",fecha);

                            Toast.makeText(getActivity(),tipo+"Cantidad "+cantidad+"Categoria "+Categoria+"Favoritos "+favoritos+"Concepto "+Concepto+"Fecha "+fecha,Toast.LENGTH_SHORT).show();

                            BaseDeDatos.insert("entrada",null,registro);
                            BaseDeDatos.close();

                            Toast.makeText(getActivity(),"Registro Exitoso",Toast.LENGTH_SHORT).show();

                        }else{
                            Toast.makeText(getActivity(),"debe llenar todos los campos",Toast.LENGTH_SHORT).show();
                        }



           }
        });


        button1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {


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
                    Toast.makeText(getActivity(),fecha.get(0),Toast.LENGTH_SHORT).show();

                }
                else{
                    Toast.makeText(getActivity(),"No hay campos",Toast.LENGTH_SHORT).show();
                }


            }
        });

        return  v;
    }







}
