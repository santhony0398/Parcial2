package com.example.taller.ui.main;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.taller.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Entrada_fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Entrada_fragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private Spinner spinnerMes;
    private Spinner spinnerAnyo;
    private Spinner spinnerMostrarPor;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Entrada_fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Entrada.
     */
    // TODO: Rename and change types and number of parameters
    public static Entrada_fragment newInstance(String param1, String param2) {
        Entrada_fragment fragment = new Entrada_fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_entrada, container,false);
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
        return v;
    }
}
