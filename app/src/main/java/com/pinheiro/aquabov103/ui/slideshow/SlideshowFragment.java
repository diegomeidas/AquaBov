package com.pinheiro.aquabov103.ui.slideshow;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.pinheiro.aquabov103.R;

public class SlideshowFragment extends Fragment {


    private ConstraintLayout layLeite;

    private TextView txt12, txt22, txt32, txt42, txt52, txtTotalAgua, txtTotalWh;
    private Button btnCalcularLeite;
    private int t12 = 0, t22 = 0,t32 = 0, t42 = 0, t52 = 0;
    private int totalAgua = 0, totalWh = 0;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_slideshow, container, false);

        layLeite =  root.findViewById(R.id.layLeite);
        txt12 = root.findViewById(R.id.txt12);
        txt22 = root.findViewById(R.id.txt22);
        txt32 = root.findViewById(R.id.txt32);
        txt42 = root.findViewById(R.id.txt42);
        txt52 = root.findViewById(R.id.txt52);
        txtTotalAgua = root.findViewById(R.id.txtTotAgua);
        txtTotalWh = root.findViewById(R.id.txtTotWh);
        btnCalcularLeite = root.findViewById(R.id.btnCalcularLeite);

        txt12.requestFocus();
        txt12.setText(""); txt22.setText(""); txt32.setText(""); txt42.setText(""); txt52.setText(""); txtTotalAgua.setText(""); txtTotalWh.setText("");

        btnCalcularLeite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SomarLeite();
            }
        });
        return root;
    }

    public static void hideKeyboard(Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        View view = activity.getCurrentFocus();
        if (view == null) {
            view = new View(activity);
        }
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }


    public void SomarLeite(){

        hideKeyboard(this.getActivity());
        if(txt12.getText().length() == 0){
            t12 = 0;
        }else
            t12 = Integer.parseInt(txt12.getText().toString()) * 62;
        if(txt22.getText().length() == 0){
            t22 = 0;
        }else
            t22 = Integer.parseInt(txt22.getText().toString()) * 51;

        if(txt32.getText().length() == 0){
            t32 = 0;
        }else
            t32 = Integer.parseInt(txt32.getText().toString()) * 45;

        if(txt42.getText().length() == 0){
            t42 = 0;
        }else
            t42 = Integer.parseInt(txt42.getText().toString()) * 30;

        if(txt52.getText().length() == 0){
            t52 = 0;
        }else
            t52 = Integer.parseInt(txt52.getText().toString()) * 11;

        int soma = t12 + t22 + t32 + t42 + t52;
        int wats = soma/10;

        txtTotalAgua.setText(String.valueOf(soma));
        txtTotalWh.setText(String.valueOf(wats));
    }
}