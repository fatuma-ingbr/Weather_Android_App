package com.fatuma.gcuweather.Fragments;
/**
 *  Name: Fatuma Ingabire
 *  Student ID: S1719023
 * */

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fatuma.gcuweather.R;

public class FragementTomorrow extends Fragment {

    View view;

    public FragementTomorrow() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.tomorrow_fragment,parent,false);
        return view;
    }
}
