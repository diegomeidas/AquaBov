package com.pinheiro.aquabov103.ui.gallery;

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

public class GalleryFragment extends Fragment {

    private ConstraintLayout layCorte;
    private TextView txt1, txt2, txt3, txt4, txt5, txt6, txtTotalAgua, txtTotalWh;
    private Button btnCalcularCorte;
    private int t1 = 0, t2 = 0, t3 = 0, t4 = 0, t5 = 0, t6 = 0;
    private int totalAgua = 0, totalWh = 0;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_gallery, container, false);

        layCorte =  root.findViewById(R.id.layCorte);
        txt1 = root.findViewById(R.id.txt1);

        txt2 = root.findViewById(R.id.txt2);
        txt3 = root.findViewById(R.id.txt3);
        txt4 = root.findViewById(R.id.txt4);
        txt5 = root.findViewById(R.id.txt5);
        txt6 = root.findViewById(R.id.txt6);
        txtTotalAgua = root.findViewById(R.id.txtTotalAgua);
        txtTotalWh = root.findViewById(R.id.txtTotalWh);
        btnCalcularCorte = root.findViewById(R.id.btnCalcularCorte);

        txt1.requestFocus();
        txt1.setText(""); txt2.setText(""); txt3.setText(""); txt4.setText(""); txt5.setText(""); txt6.setText(""); txtTotalAgua.setText(""); txtTotalWh.setText("");

        btnCalcularCorte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SomarCorte();
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

    public void SomarCorte(){

        hideKeyboard(this.getActivity());
        if(txt1.getText().length() == 0){
            t1 = 0;
        }else
            t1 = Integer.parseInt(txt1.getText().toString()) * 18;
        if(txt2.getText().length() == 0){
            t2 = 0;
        }else
            t2 = Integer.parseInt(txt2.getText().toString()) * 32;

        if(txt3.getText().length() == 0){
            t3 = 0;
        }else
            t3 = Integer.parseInt(txt3.getText().toString()) * 46;

        if(txt4.getText().length() == 0){
            t4 = 0;
        }else
            t4 = Integer.parseInt(txt4.getText().toString()) * 55;

        if(txt5.getText().length() == 0){
            t5 = 0;
        }else
            t5 = Integer.parseInt(txt5.getText().toString()) * 46;

        if(txt6.getText().length() == 0){
            t6 = 0;
        }else
            t6 = Integer.parseInt(txt6.getText().toString()) * 9;

        int soma = t1 + t2 + t3 + t4 + t5 + t6;
        int wats = soma/10;

        txtTotalAgua.setText(String.valueOf(soma));
        txtTotalWh.setText(String.valueOf(wats));
    }
}