package com.example.taller;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class Inicio extends Fragment {

    private InicioViewModel mViewModel;
    private Spinner spinner1;
    private Spinner spinner2;
    private Spinner spinner3;


    public static Inicio newInstance() {
        return new Inicio();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {


        View v = inflater.inflate(R.layout.inicio_fragment, container, false);
        spinner1 = v.findViewById(R.id.spinner1);
        spinner2 = v.findViewById(R.id.spinner2);
        spinner3 = v.findViewById(R.id.spinner3);

        String [] tipo = {"Gasto","Ingreso"};
        String [] categoria = {"Cenas","Copas","Bar","Restaurante"};
        String [] favoritoss = {"Favorito 1","Favorito 2","Favorito 3"};

        ArrayAdapter <String> adapter = new ArrayAdapter<String>(getActivity().getApplicationContext(),android.R.layout.simple_list_item_1,tipo);
        spinner1.setAdapter(adapter);

        ArrayAdapter <String> adapter2 = new ArrayAdapter<String>(getActivity().getApplicationContext(),android.R.layout.simple_list_item_1,categoria);
        spinner2.setAdapter(adapter2);

        ArrayAdapter <String> adapter3 = new ArrayAdapter<String>(getActivity().getApplicationContext(),android.R.layout.simple_list_item_1,favoritoss);
        spinner3.setAdapter(adapter3);


        return  v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(InicioViewModel.class);
        // TODO: Use the ViewModel
    }

}
