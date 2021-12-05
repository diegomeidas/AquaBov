package com.pinheiro.aquabov103.ui.send;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.pinheiro.aquabov103.R;

public class SendFragment extends Fragment {


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_send, container, false);


        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://globalsolaratlas.info/map?c=-21.842569,-50.45993,11&s=-21.948776,-50.535461&m=site"));
        startActivity(intent);

        return root;
    }
}