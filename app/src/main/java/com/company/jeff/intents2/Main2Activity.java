package com.company.jeff.intents2;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    TextView nombre,contra,fecha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        nombre = (TextView)findViewById(R.id.name_to_show);
        contra = (TextView)findViewById(R.id.password_to_show);
        fecha = (TextView)findViewById(R.id.date_to_show);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Bundle bundle = getIntent().getExtras();
        if(bundle == null){
            Log.d("Imprimir","Esta vacío");
        }else {
            Toast.makeText(Main2Activity.this,bundle.getString("nombre")
                    +"\n" + bundle.getString("contra")
                    +"\n" + bundle.getString("fecha"),
                    Toast.LENGTH_SHORT).show();

            nombre.setText(bundle.getString("nombre"));
            contra.setText(bundle.getString("contra"));
            fecha.setText(bundle.getString("fecha"));
        }

    }


}
