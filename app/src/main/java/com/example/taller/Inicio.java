package com.example.taller;

import android.content.ContentValues;
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

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

public class Inicio extends Fragment {

    private InicioViewModel mViewModel;
    private Spinner spinner1;
    private Spinner spinner2;
    private Spinner spinner3;
    private EditText edt_cantidad;
    private EditText edt_concepto;
    private View view;
    //declaracion del boton
    private Button button;

    public static Inicio newInstance() {
        return new Inicio();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                              Bundle savedInstanceState) {


        View v = inflater.inflate(R.layout.inicio_fragment, container, false);
        spinner1 = v.findViewById(R.id.spinner1);
        spinner2 = v.findViewById(R.id.spinner2);
        spinner3 = v.findViewById(R.id.spinner3);
        button = v.findViewById(R.id.button);
        edt_cantidad= v.findViewById(R.id.txt_cantidad);
        edt_concepto = v.findViewById(R.id.edt2);

        String [] tipo = {"Gasto","Ingreso"};
        String [] categoria = {"Cenas","Copas","Bar","Restaurante"};
        String [] favoritoss = {"Favorito 1","Favorito 2","Favorito 3"};

        ArrayAdapter <String> adapter = new ArrayAdapter<String>(getActivity().getApplicationContext(),android.R.layout.simple_list_item_1,tipo);
        spinner1.setAdapter(adapter);

        ArrayAdapter <String> adapter2 = new ArrayAdapter<String>(getActivity().getApplicationContext(),android.R.layout.simple_list_item_1,categoria);
        spinner2.setAdapter(adapter2);

        ArrayAdapter <String> adapter3 = new ArrayAdapter<String>(getActivity().getApplicationContext(),android.R.layout.simple_list_item_1,favoritoss);
        spinner3.setAdapter(adapter3);

        //boton
        button.setOnClickListener(new View.OnClickListener(){
           @Override
           public void onClick(View v) {



                        int cantidad = Integer.parseInt(edt_cantidad.getText().toString());
                        String Concepto = edt_concepto.getText().toString();

                        String tipo = spinner1.getSelectedItem().toString();
                        String Categoria = spinner2.getSelectedItem().toString();
                        String favoritos = spinner3.getSelectedItem().toString();

                        Toast.makeText(getActivity(),tipo,Toast.LENGTH_SHORT).show();

                       AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(getActivity(),"Cuentas",null,1);
                       SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

                        if (!tipo.isEmpty() && !Categoria.isEmpty() &&  !favoritos.isEmpty()  && !favoritos.isEmpty()   ){

                            ContentValues registro = new ContentValues();
                            registro.put("cantidad",cantidad);
                            registro.put("tipo",tipo);
                            registro.put("favorito",favoritos);
                            registro.put("categoria",Categoria);
                            registro.put("concepto",Concepto);

                            Toast.makeText(getActivity(),tipo+" "+Categoria+" "+favoritos+" "+Concepto,Toast.LENGTH_SHORT).show();

                            BaseDeDatos.insert("entradas",null,registro);
                            BaseDeDatos.close();

                            Toast.makeText(getActivity(),"Registro Exitoso",Toast.LENGTH_SHORT).show();

                        }else{
                            Toast.makeText(getActivity(),"debe llenar todos los campos",Toast.LENGTH_SHORT).show();
                        }

                     /*
                        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

                            @Override
                            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                                Toast.makeText(getActivity(),,Toast.LENGTH_SHORT).show();

                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> parent) {

                            }

                        });
*/


           }
        });

        return  v;
    }



/*

 @Override
    public void onClick(View v) {

        Toast.makeText(getActivity(), "Presionaste el boton del centro", Toast.LENGTH_SHORT).show();
        switch (v.getId()) {
            case R.id.button1:
                Toast.makeText(getActivity(), "Presionaste el boton del centro", Toast.LENGTH_SHORT).show();
                view.setBackgroundColor(Color.parseColor("#FFC622BB"));//violeta
                break;

        }

    }


    public void verificar (View view){
        Toast.makeText(getActivity(), "Hola soy un Toast", Toast.LENGTH_SHORT).show();
        int cantidad = Integer.parseInt(edt_cantidad.getText().toString());


        Toast.makeText(getActivity(), "Hola soy un Toast", Toast.LENGTH_SHORT).show();
    }
*/

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(InicioViewModel.class);
        // TODO: Use the ViewModel
    }




}
