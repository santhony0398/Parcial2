package com.example.taller.ui.main;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.taller.Entrada;
import com.example.taller.Estadisticas_fragment;
import com.example.taller.Inicio;
import com.example.taller.Objetivo;
import com.example.taller.R;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.tab_text_1, R.string.tab_text_2,R.string.tab_text_3,R.string.tab_text_4,R.string.tab_text_5};
    private final Context mContext;

    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).

    switch (position){
        case 0:
            Inicio inicio = new Inicio();
            return  inicio;

        case 1:
            Entrada entradaFragment = new Entrada();
            return entradaFragment;

        case 2: Estadisticas_fragment estadisticasFragment = new Estadisticas_fragment();
            return estadisticasFragment;

        case 3: Objetivo objetivosFragment = new Objetivo();
            return objetivosFragment;

        case 4: Opciones_Fragment opciones = new Opciones_Fragment();
            return opciones;

    }

        return PlaceholderFragment.newInstance(position + 1);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        // Show 2 total pages.
        return 5;
    }
}