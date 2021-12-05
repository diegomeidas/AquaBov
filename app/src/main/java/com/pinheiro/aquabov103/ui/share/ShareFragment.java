package com.pinheiro.aquabov103.ui.share;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.pinheiro.aquabov103.R;

public class ShareFragment extends Fragment {

    private int[][] valor = {
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {5,6,7,8,10,11,13,14,16,18,20,22,24,28,31,35,39,40},
            {10,11,12,13,15,16,18,19,21,23,25,27,29,33,36,40,-1,-1},
            {15,15,17,18,20,21,23,24,26,28,30,32,34,40,40,-1,-1,-1},
            {20,20,22,23,25,26,28,29,31,33,35,37,40,-1,-1,-1,-1,-1},
            {25,25,25,28,30,31,33,34,36,40,40,40,-1,-1,-1,-1,-1,-1},
            {30,30,30,33,35,36,40,40,40,-1,-1,-1,-1,-1,-1,-1,-1,-1},
            {35,35,35,38,40,40,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
            {40,40,40,40,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1}
    };

    private String[] altura = {"0","5","10","15","20","25","30","35","40"};
    private String[] comp = {"0","10","20","40","60","80","100","125","150","175","200","225","250","300","350","400","450","500"};
    private int[] wp100 = {4600,3700,3000,2400,1950,1550,1200,900,650};
    private int[] wp130 = {6300,5050,4100,3300,2600,2050,1600,1200,900};
    private int[] wp170 = {8600,7000,5600,4500,3650,2900,2250,1700,1200};

    private TextView txtAgua;
    private Spinner spinner, spinner2;
    private TextView txtModelo;
    private TextView txtPotencia;
    private TextView txtAltura;
    private Button btnCalcular;
    private RadioButton rbPoco;
    private RadioButton rbReservatorio;
    private int pos=0, pos2=0, pos3=0;
    private int val = 0;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_share, container, false);

        txtAgua = root.findViewById(R.id.txtAgua);
        spinner = root.findViewById(R.id.spinner);
        spinner2 = root.findViewById(R.id.spinner2);
        txtModelo = root.findViewById(R.id.txtModelo);
        txtPotencia = root.findViewById(R.id.txtPotencia);
        txtAltura = root.findViewById(R.id.txtAltura);
        btnCalcular = root.findViewById(R.id.btnCalcular);
        rbPoco = root.findViewById(R.id.rbPoco);
        rbReservatorio = root.findViewById(R.id.rbReservatorio);


        rbPoco.setChecked(true);
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(
                getContext(),
                android.R.layout.simple_spinner_item,
                //android.R.id.text2,
                altura
        );
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adaptador);

        ArrayAdapter<String> adaptador2 = new ArrayAdapter<String>(
                getContext(),
                android.R.layout.simple_spinner_item,
                //android.R.id.text2,
                comp
        );
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adaptador2);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(getContext(), "ID: "+id+", POS: "+position , Toast.LENGTH_SHORT).show();
                pos = (int) position;

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                //Toast.makeText(getContext(), "ID2: "+id+", POS2: "+position , Toast.LENGTH_SHORT).show();
                pos2 = (int) position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Toast.makeText(getContext(),"Res "+ valor[pos][pos2], Toast.LENGTH_SHORT).show();

                //CalcularSoma();
                Calcular();

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

    public void Calcular(){


        val = valor[pos][pos2];

        if(val == 0){
            pos3 = 0;
        }else if(val > 3 && val <= 7){
            pos3 = 1;
        }else if(val > 7 && val <= 12){
            pos3 = 2;
        }else if(val > 12 && val <= 17){
            pos3 = 3;
        }else if(val > 17 && val <=22){
            pos3 = 4;
        }else if(val > 22 && val <= 27){
            pos3 = 5;
        }else if(val > 27 && val <= 32){
            pos3 = 6;
        }else if(val > 32 && val <= 37){
            pos3 = 7;
        }else if(val > 37 && val <= 40){
            pos3 = 8;
        }else{
            pos3 = -1;
        }

        CalcularSoma();

    }
    public void CalcularSoma(){

        //Toast.makeText(this.getActivity(), "POS: "+pos+", POS2: "+pos2+". VAL: "+val , Toast.LENGTH_SHORT).show();

        if(pos3 == -1){
            Toast.makeText(this.getActivity(), "Altura acima dos padrões" , Toast.LENGTH_SHORT).show();

        }else{

            String agua = txtAgua.getText().toString();
            if(agua.isEmpty() || agua == null){
                Toast.makeText(this.getActivity(), "Informe qtde de água" , Toast.LENGTH_SHORT).show();
            }else{
                String teste = String.valueOf(txtAgua.getText());

                int qtdeAgua = Integer.parseInt(txtAgua.getText().toString());

                if(qtdeAgua <= wp100[pos3]){
                    txtPotencia.setText("100 Wp");
                }else if(qtdeAgua <= wp130[pos3]){
                    txtPotencia.setText("130 Wp");
                }else if(qtdeAgua <= wp170[pos3]){
                    txtPotencia.setText("170 Wp");
                }else{
                    txtPotencia.setText("Indefinido");
                }

                if(rbPoco.isChecked()){
                    txtModelo.setText("Anauger Solar P100");
                }else if(rbReservatorio.isChecked()){
                    txtModelo.setText("Anauger Solar R100");
                }

                txtAltura.setText(String.valueOf(val));

                hideKeyboard(this.getActivity());
            }
        }



    }
}